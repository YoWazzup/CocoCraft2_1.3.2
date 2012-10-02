package cococraft2.common.machine;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Iterator;

import net.minecraft.src.*;

public class ContainerBlastFurnace extends Container
{
	private TileEntityBlastFurnace blastFurnace;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerBlastFurnace(InventoryPlayer par1InventoryPlayer, TileEntityBlastFurnace par2TileEntityBlastFurnace)
	{
		blastFurnace = par2TileEntityBlastFurnace;
		addSlotToContainer(new Slot(par2TileEntityBlastFurnace, 0, 33, 17));
		addSlotToContainer(new Slot(par2TileEntityBlastFurnace, 1, 45, 53));
		addSlotToContainer(new Slot(par2TileEntityBlastFurnace, 3, 56, 17));

		addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, par2TileEntityBlastFurnace, 2, 116, 35));
		int var3;

		for (var3 = 0; var3 < 3; ++var3)
		{
			for (int var4 = 0; var4 < 9; ++var4)
			{
				addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3)
		{
			addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.updateCraftingInventoryInfo(this, 0, this.blastFurnace.blastFurnaceCookTime);
		par1ICrafting.updateCraftingInventoryInfo(this, 1, this.blastFurnace.blastFurnaceBurnTime);
		par1ICrafting.updateCraftingInventoryInfo(this, 2, this.blastFurnace.currentItemBurnTime);
	}

	/**
	 * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
	 */
	 public void updateCraftingResults()
	{
		super.updateCraftingResults();
		Iterator var1 = this.crafters.iterator();

		while (var1.hasNext())
		{
			ICrafting var2 = (ICrafting)var1.next();

			if (this.lastCookTime != this.blastFurnace.blastFurnaceCookTime)
			{
				var2.updateCraftingInventoryInfo(this, 0, this.blastFurnace.blastFurnaceCookTime);
			}

			if (this.lastBurnTime != this.blastFurnace.blastFurnaceBurnTime)
			{
				var2.updateCraftingInventoryInfo(this, 1, this.blastFurnace.blastFurnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.blastFurnace.currentItemBurnTime)
			{
				var2.updateCraftingInventoryInfo(this, 2, this.blastFurnace.currentItemBurnTime);
			}
		}

		this.lastCookTime = this.blastFurnace.blastFurnaceCookTime;
		this.lastBurnTime = this.blastFurnace.blastFurnaceBurnTime;
		this.lastItemBurnTime = this.blastFurnace.currentItemBurnTime;
	}

	 @SideOnly(Side.CLIENT)
	 public void updateProgressBar(int par1, int par2)
	 {
		 if (par1 == 0)
		 {
			 this.blastFurnace.blastFurnaceCookTime = par2;
		 }

		 if (par1 == 1)
		 {
			 this.blastFurnace.blastFurnaceBurnTime = par2;
		 }

		 if (par1 == 2)
		 {
			 this.blastFurnace.currentItemBurnTime = par2;
		 }
	 }

	 public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	 {
		 return this.blastFurnace.isUseableByPlayer(par1EntityPlayer);
	 }

	 /**
	  * Called to transfer a stack from one inventory to the other eg. when shift clicking.
	  */
	 public ItemStack transferStackInSlot(int i)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)inventorySlots.get(i);
	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();
	            if (i == 2)
	            {
	                if (!mergeItemStack(itemstack1, 3, 39, true))
	                {
	                    return null;
	                }
	            }
	            else if (i >= 3 && i < 30)
	            {
	                if (!mergeItemStack(itemstack1, 30, 39, false))
	                {
	                    return null;
	                }
	            }
	            else if (i >= 30 && i < 39)
	            {
	                if (!mergeItemStack(itemstack1, 3, 30, false))
	                {
	                    return null;
	                }
	            }
	            else if (!mergeItemStack(itemstack1, 3, 39, false))
	            {
	                return null;
	            }
	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack(null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }
	            if (itemstack1.stackSize != itemstack.stackSize)
	            {
	                slot.onPickupFromSlot(itemstack1);
	            }
	            else
	            {
	                return null;
	            }
	        }
	        return itemstack;
	    }
}
