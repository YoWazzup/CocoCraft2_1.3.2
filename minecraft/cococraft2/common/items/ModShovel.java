package cococraft2.common.items;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemPickaxe;
import net.minecraft.src.ItemSpade;

public class ModShovel extends ItemSpade
{
	public ModShovel(int i, EnumToolMaterial tool) 
	{
		super(i, tool);
		setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
}
