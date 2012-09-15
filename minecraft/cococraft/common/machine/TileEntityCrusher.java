package cococraft.common.machine;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityCrusher extends TileEntity implements IInventory, ISidedInventory
{
	private ItemStack[] crusherItemStacks = new ItemStack[3];
	public int crusherBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int crusherCookTime = 0;
	
	public int getSizeInventory()
	{
		return crusherItemStacks.length;
	}
	public ItemStack getStackInSlot(int i)
	{
		return crusherItemStacks[i];
	}
	public ItemStack decrStackSize(int i, int j)
	{
		if(crusherItemStacks[i] != null)
		{
			ItemStack item;
			
			if(crusherItemStacks[i].stackSize <= j)
			{
				item = crusherItemStacks[i];
				crusherItemStacks[i] = null;
				return item;
			}
			else
			{
				item = crusherItemStacks[i].splitStack(j);
				
				if(crusherItemStacks[i].stackSize == 0)
				{
					crusherItemStacks = null;
				}
				return item;
			}
		}
		else
		{
			return null;
		}
	}
	
	public void setInventorySlotContents(int i, ItemStack item)
	{
		crusherItemStacks[i] = item;
		
		if(item != null && item.stackSize > getInventoryStackLimit())
		{
			item.stackSize = getInventoryStackLimit();
		}
	}
	public String getInvName()
	{
		return "Crusher";
	}
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int i)
	{
		return crusherCookTime * i / 200;
	}
	
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int i)
	{
		if(currentItemBurnTime  == 0)
		{
			currentItemBurnTime  = 200;
		}
		return crusherBurnTime * i / currentItemBurnTime;
	}
	public boolean isBurning()
	{
		return crusherBurnTime > 0;
	}
	public void updateEntity()
	{
		boolean i = crusherBurnTime  > 0;
		boolean j = false;
		
		if(crusherBurnTime  > 0)
		{
			--crusherBurnTime;
		}
		
		if(!worldObj.isRemote)
		{
			if(crusherBurnTime == 0 && canSmelt())
			{
				currentItemBurnTime  = crusherBurnTime = getItemBurnTime(crusherItemStacks[1]);
				
				if(currentItemBurnTime > 0)
				{
					j = true;
					
					if(crusherItemStacks[1] != null)
					{
						--crusherItemStacks[1].stackSize;
						
						if(crusherItemStacks[1].stackSize == 0)
						{
							crusherItemStacks[1] = crusherItemStacks[1].getItem().getContainerItemStack(crusherItemStacks[1]);
						}
					}
				}
			}
			if(isBurning() && canSmelt())
			{
				++crusherCookTime;
				
				if(crusherCookTime == 200)
				{
					crusherCookTime  = 0;
					smeltItem();
					j = true;
				}
			}
			else
			{
				crusherCookTime  = 0;
			}
			
		}
		if(j)
		{
			onInventoryChanged();
		}
		
	}
	private boolean canSmelt()
	{
		if(crusherItemStacks[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack item = CrusherRecipes.crushing().getCrushingResult(crusherItemStacks[0]);
			if(item == null) return false;
			if(crusherItemStacks[2] == null) return true;
			if(!crusherItemStacks[2].isItemEqual(item)) return false;
			int result = crusherItemStacks[2].stackSize + item.stackSize;
			return (result <= getInventoryStackLimit() && result <= item.getMaxStackSize());
		}
		
		
	}
	public void smeltItem()
	{
		if(canSmelt())
		{
			ItemStack item = CrusherRecipes.crushing().getCrushingResult(crusherItemStacks[0]);
			
			if(crusherItemStacks[2] == null)
			{
				crusherItemStacks[2] = item.copy();
			}
			else if(crusherItemStacks[2].isItemEqual(item))
			{
				crusherItemStacks[2].stackSize += item.stackSize;
			}
			
			--crusherItemStacks[0].stackSize;
			
			if(crusherItemStacks[0].stackSize <= 0)
			{
				crusherItemStacks[0] = null;
			}
		}
	}
	public static int getItemBurnTime(ItemStack item)
	{
		if(item == null)
		{
			return 0;
		}
		else
		{
			int i = item.getItem().shiftedIndex;
			
			if(i == Item.coal.shiftedIndex) return 1800;
			
			return GameRegistry.getFuelValue(item);
		}
	}
	public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }
	public void openChest(){}
	public void closeChest(){}
	
	@Override
	public int getStartInventorySide(ForgeDirection side)
	{
		if(side == ForgeDirection.DOWN) return 1;
		if(side == ForgeDirection.UP) return 0;
		return 2;
	}
	
	@Override
    public int getSizeInventorySide(ForgeDirection side)
    {
        return 1;
    }
	
	/**
	 * 
	 * NBT Shtuff!!
	 * 
	 */
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.crusherItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.crusherItemStacks.length)
            {
                this.crusherItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.crusherBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.crusherCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.crusherItemStacks[1]);
    }
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.crusherBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.crusherCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.crusherItemStacks.length; ++var3)
        {
            if (this.crusherItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.crusherItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }
	
	public ItemStack getStackInSlotOnClosing(int i)
	{
		if(crusherItemStacks[i] != null)
		{
			ItemStack item = crusherItemStacks[i];
			crusherItemStacks[i] = null;
			return item;
		}
		else
		{
			return null;
		}
	}
	
}
