package cococraft.common.items;

import cpw.mods.fml.client.ITextureFX;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAxe;


public class ModItemAxe extends ItemAxe
{

	public ModItemAxe(int i, EnumToolMaterial enumt)
	{
		super(i, enumt);
		this.setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
}
