package cococraft2.common.items;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemHoe;
import net.minecraft.src.ItemPickaxe;

public class ModHoe extends ItemHoe
{
	public ModHoe(int i, EnumToolMaterial tool) 
	{
		super(i, tool);
		setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
}
