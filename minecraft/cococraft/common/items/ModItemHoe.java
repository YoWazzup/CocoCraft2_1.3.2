package cococraft.common.items;

import cpw.mods.fml.client.ITextureFX;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemHoe;

public class ModItemHoe extends ItemHoe
{

	public ModItemHoe(int i, EnumToolMaterial enumt)
	{
		super(i, enumt);
		this.setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
}
