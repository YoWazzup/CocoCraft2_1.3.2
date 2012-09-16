package cococraft2.common.items;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemPickaxe;
import net.minecraft.src.ItemSword;

public class ModSword extends ItemSword
{
	public ModSword(int i, EnumToolMaterial tool) 
	{
		super(i, tool);
		setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
}
