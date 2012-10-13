package cococraft2.common.items;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemEssence extends Item
{
	public ItemEssence(int i) 
	{
		super(i);
		setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
}
