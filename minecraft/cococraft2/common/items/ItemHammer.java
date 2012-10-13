package cococraft2.common.items;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemHammer extends Item
{
	public ItemHammer(int id)
	{
		super(id);
		this.setMaxDamage(32);
		maxStackSize = 1;
		setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack item)
	{
		return false;
	}
}
