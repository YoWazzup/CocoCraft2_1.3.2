
package cococraft.common.items;

import cococraft.common.CocoCraft;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ModItemAmethystArmor extends ItemArmor implements IArmorTextureProvider{

	CocoCraft cc;

	public ModItemAmethystArmor(int i, EnumArmorMaterial material, int j, int k)
	{
		super(i, material, j, k);
		this.maxStackSize = 1;
		this.setTabToDisplayOn(CreativeTabs.tabCombat);
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
	public String getArmorTextureFile(ItemStack itemstack)
	{
		if(itemstack.itemID == cc.AmethystHelmet.shiftedIndex || itemstack.itemID == cc.AmethystChest.shiftedIndex || itemstack.itemID == cc.AmethystBoots.shiftedIndex)
		{
			return "/CC/Armor/amethyst_1.png";
		}
		if(itemstack.itemID == cc.AmethystLegs.shiftedIndex)
		{
			return "/CC/Armor/amethyst_2.png";
		}
		return "CC/Armor/amethyst_2.png";
	}
}
