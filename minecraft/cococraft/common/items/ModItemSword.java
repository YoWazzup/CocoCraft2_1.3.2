package cococraft.common.items;

import cpw.mods.fml.client.ITextureFX;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class ModItemSword extends ItemSword
{

	public ModItemSword(int i, EnumToolMaterial enumt)
	{
		super(i, enumt);
		this.setTabToDisplayOn(CreativeTabs.tabCombat);
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
}
