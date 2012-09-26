package cococraft2.common.items;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

//Item that is experimental.

public class ItemCatalyst extends Item
{

	private static ItemStack item;

	public ItemCatalyst(int i)
	{
		super(i);
		setTabToDisplayOn(CreativeTabs.tabTools);
		this.setContainerItem(this);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
	
	//Makes sure the Item doens't leave the crafting matrix
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) 
	{
		return false;
	}
}
