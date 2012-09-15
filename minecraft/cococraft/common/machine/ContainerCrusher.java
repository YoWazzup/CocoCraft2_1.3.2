package cococraft.common.machine;

import java.util.Iterator;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotFurnace;

public class ContainerCrusher extends Container
{
	
	private TileEntityCrusher crusher;
	private int lastCookTime  = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;
	
	public ContainerCrusher(InventoryPlayer inv, TileEntityCrusher tile)
	{
		crusher = tile;
		addSlotToContainer(new Slot(tile, 0, 56, 17));
		addSlotToContainer(new Slot(tile, 1, 56, 53));
		addSlotToContainer(new SlotFurnace(inv.player, tile, 2, 116, 35));
		int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(inv, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(inv, var3, 8 + var3 * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return false;
	}
	public void updateCraftingResults()
    {
        super.updateCraftingResults();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext())
        {
            ICrafting var2 = (ICrafting)var1.next();

            if (this.lastCookTime != crusher.crusherCookTime)
            {
                var2.updateCraftingInventoryInfo(this, 0, this.crusher.crusherCookTime);
            }

            if (this.lastBurnTime != this.crusher.crusherBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 1, this.crusher.crusherBurnTime);
            }

            if (this.lastItemBurnTime != this.crusher.currentItemBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 2, this.crusher.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.crusher.crusherCookTime;
        this.lastBurnTime = this.crusher.crusherBurnTime;
        this.lastItemBurnTime = this.crusher.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.crusher.crusherCookTime = par2;
        }

        if (par1 == 1)
        {
            this.crusher.crusherBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.crusher.currentItemBurnTime = par2;
        }
    }



}
