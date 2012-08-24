package cococraft.common.items;

import cpw.mods.fml.client.ITextureFX;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemPickaxe;

public class ModItemPick extends ItemPickaxe
{

	public ModItemPick(int i, EnumToolMaterial enumt)
	{
		super(i, enumt);
		this.setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
}
