package cococraft2.common.machine;

import cococraft2.common.blocks.BlockBlastFurnace;
import cococraft2.common.blocks.CocoCraftBlocks;
import cococraft2.common.items.CocoCraftItems;
import net.minecraft.src.*;
import net.minecraftforge.common.ISidedInventory;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class TileEntityBlastFurnace extends TileEntity implements IInventory, ISidedInventory
{
	/**
	 * The ItemStacks that hold the items currently being used in the blastFurnace
	 */
	private ItemStack[] blastFurnaceItemStacks = new ItemStack[4];

	/** The number of ticks that the blastFurnace will keep burning */
	public int blastFurnaceBurnTime = 0;

	/**
	 * The number of ticks that a fresh copy of the currently-burning item would keep the blastFurnace burning for
	 */
	public int currentItemBurnTime = 0;

	/** The number of ticks that the current item has been cooking for */
	public int blastFurnaceCookTime = 0;

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory()
	{
		return this.blastFurnaceItemStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int par1)
	{
		return this.blastFurnaceItemStacks[par1];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.blastFurnaceItemStacks[par1] != null)
		{
			ItemStack var3;

			if (this.blastFurnaceItemStacks[par1].stackSize <= par2)
			{
				var3 = this.blastFurnaceItemStacks[par1];
				this.blastFurnaceItemStacks[par1] = null;
				return var3;
			}
			else
			{
				var3 = this.blastFurnaceItemStacks[par1].splitStack(par2);

				if (this.blastFurnaceItemStacks[par1].stackSize == 0)
				{
					this.blastFurnaceItemStacks[par1] = null;
				}

				return var3;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.blastFurnaceItemStacks[par1] != null)
		{
			ItemStack var2 = this.blastFurnaceItemStacks[par1];
			this.blastFurnaceItemStacks[par1] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
		this.blastFurnaceItemStacks[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName()
	{
		return "BlastFurnace";
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readFromNBT(nbttagcompound);
		NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
		blastFurnaceItemStacks = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
			byte byte0 = nbttagcompound1.getByte("Slot");
			if (byte0 >= 0 && byte0 < blastFurnaceItemStacks.length)
			{
				blastFurnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		blastFurnaceBurnTime = nbttagcompound.getShort("BurnTime");
		blastFurnaceCookTime = nbttagcompound.getShort("CookTime");
		currentItemBurnTime = getItemBurnTime(blastFurnaceItemStacks[1]);
	}

	public void writeToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setShort("BurnTime", (short)blastFurnaceBurnTime);
		nbttagcompound.setShort("CookTime", (short)blastFurnaceCookTime);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < blastFurnaceItemStacks.length; i++)
		{
			if (blastFurnaceItemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				blastFurnaceItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbttagcompound.setTag("Items", nbttaglist);
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
	 * this more of a set than a get?*
	 */
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns an integer between 0 and the passed value representing how close the current item is to being completely
	 * cooked
	 */
	public int getCookProgressScaled(int par1)
	{
		return this.blastFurnaceCookTime * par1 / 300;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
	 * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
	 */
	public int getBurnTimeRemainingScaled(int par1)
	{
		if (this.currentItemBurnTime == 0)
		{
			this.currentItemBurnTime = 300;
		}

		return this.blastFurnaceBurnTime * par1 / this.currentItemBurnTime;
	}

	/**
	 * Returns true if the blastFurnace is currently burning
	 */
	public boolean isBurning()
	{
		return this.blastFurnaceBurnTime > 0;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
	 * ticks and creates a new spawn inside its implementation.
	 */
	public void updateEntity()
	{
		boolean var1 = this.blastFurnaceBurnTime > 0;
		boolean var2 = false;

		if (this.blastFurnaceBurnTime > 0)
		{
			--this.blastFurnaceBurnTime;
		}

		if (!this.worldObj.isRemote)
		{
			if (this.blastFurnaceBurnTime == 0 && this.canSmelt())
			{
				this.currentItemBurnTime = this.blastFurnaceBurnTime = getItemBurnTime(this.blastFurnaceItemStacks[1]);

				if (this.blastFurnaceBurnTime > 0)
				{
					var2 = true;

					if (this.blastFurnaceItemStacks[1] != null)
					{
						--this.blastFurnaceItemStacks[1].stackSize;

						if (this.blastFurnaceItemStacks[1].stackSize == 0)
						{
							this.blastFurnaceItemStacks[1] = this.blastFurnaceItemStacks[1].getItem().getContainerItemStack(blastFurnaceItemStacks[1]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt())
			{
				++this.blastFurnaceCookTime;

				if (this.blastFurnaceCookTime == 300)
				{
					this.blastFurnaceCookTime = 0;
					this.smeltItem();
					var2 = true;
				}
			}
			else
			{
				this.blastFurnaceCookTime = 0;
			}

			if (var1 != this.blastFurnaceBurnTime > 0)
			{
				var2 = true;

			}
		}

		if (var2)
		{
			this.onInventoryChanged();
		}
	}

	/**
	 * Returns true if the blastFurnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
	 */
	private boolean canSmelt()
	{
		ItemStack result = getRecipe(blastFurnaceItemStacks[0], blastFurnaceItemStacks[3]);
		if(result == null) return false;
		if(blastFurnaceItemStacks[2] == null)
			return true;
		if(blastFurnaceItemStacks[2] != null && blastFurnaceItemStacks[2].itemID == result.itemID&& blastFurnaceItemStacks[2].stackSize < (blastFurnaceItemStacks[2].getMaxStackSize() - (result.stackSize-1))) 
			return true;

		return false;
	}

	private static CocoCraftBlocks ccb;
	private static CocoCraftItems cci;

	public void smeltItem()
	{
		if (!canSmelt())
		{
			return;
		}
		ItemStack itemstack = getRecipe(blastFurnaceItemStacks[0], blastFurnaceItemStacks[3]);
		if (blastFurnaceItemStacks[2] == null)
		{
			blastFurnaceItemStacks[2] = itemstack.copy();
		}
		else if (blastFurnaceItemStacks[2].itemID == itemstack.itemID)
		{
			blastFurnaceItemStacks[2].stackSize+= itemstack.stackSize;
		}
		if(blastFurnaceItemStacks[0] != null){
			blastFurnaceItemStacks[0].stackSize--;
			if (blastFurnaceItemStacks[0].stackSize <= 0)
			{
				blastFurnaceItemStacks[0] = null;
			}
		}
		if(blastFurnaceItemStacks[3] != null){
			blastFurnaceItemStacks[3].stackSize--;
			if (blastFurnaceItemStacks[3].stackSize <= 0)
			{
				blastFurnaceItemStacks[3] = null;
			}
		}
	}



	private ItemStack getRecipe(ItemStack itemStack, ItemStack itemStack0) {
		int i1;
		int i2;


		if(itemStack == null) i1 = 0; else i1 = itemStack.itemID;
		if(itemStack0 == null) i2 = 0; else i2 = itemStack0.itemID;



		if(i1 == 0 && i2 == Block.oreIron.blockID) return new ItemStack(Item.ingotIron);
		if(i2 == 0 && i1 == Block.oreIron.blockID) return new ItemStack(Item.ingotIron);
		if(i1 == i2 && i2 == Block.oreIron.blockID) return new ItemStack(Item.ingotIron, 2);
		
		if(i1 == 0 && i2 == Block.oreGold.blockID) return new ItemStack(Item.ingotGold);
		if(i2 == 0 && i1 == Block.oreGold.blockID) return new ItemStack(Item.ingotGold);
		if(i1 == i2 && i2 == Block.oreGold.blockID) return new ItemStack(Item.ingotGold, 2);
		
		if(i1 == ccb.Ore.blockID && itemStack.getItemDamage() == 0 && i2 == 0) return new ItemStack(cci.Ingots, 1, 0);
		if(i2 == i1 && i1 == ccb.Ore.blockID && itemStack.getItemDamage() == 0) return new ItemStack(cci.Ingots, 2, 0);
		
		if(i1 == ccb.Ore.blockID && itemStack.getItemDamage() == 1 && i2 == 0) return new ItemStack(cci.Ingots, 1, 1);
		if(i2 == i1 && i1 == ccb.Ore.blockID && itemStack.getItemDamage() == 1) return new ItemStack(cci.Ingots, 2, 1);
	
		if(i1 == ccb.Ore.blockID && itemStack.getItemDamage() == 2 && i2 == 0) return new ItemStack(cci.Ingots, 1, 2);
		if(i2 == i1 && i1 == ccb.Ore.blockID && itemStack.getItemDamage() == 2) return new ItemStack(cci.Ingots, 2, 2);
		
		return null;

	}

	/**
	 * Returns the number of ticks that the supplied fuel item will keep the blastFurnace burning, or 0 if the item isn't
	 * fuel
	 */
	private static int getItemBurnTime(ItemStack itemstack)
	{
		if (itemstack == null)
		{
			return 0;
		}
		int i = itemstack.getItem().shiftedIndex;
		if(i == CocoCraftItems.Ingots.shiftedIndex && itemstack.getItemDamage() == 11)
		{
			return 600;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Return true if item is a fuel source (getItemBurnTime() > 0).
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack)
	{
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	public void openChest() {}

	public void closeChest() {}

	@Override
	public int getStartInventorySide(ForgeDirection side)
	{
		if (side == ForgeDirection.DOWN) return 1;
		if (side == ForgeDirection.UP) return 0; 
		return 2;
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side)
	{
		return 1;
	}

	@Override
	public void onInventoryChanged() {
		// TODO Auto-generated method stub

	}
}
