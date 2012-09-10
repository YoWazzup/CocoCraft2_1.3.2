
package cococraft.common.items;

import cococraft.common.CocoCraft;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ModItemSilverArmor extends ItemArmor implements IArmorTextureProvider{

	CocoCraft cc;

	public ModItemSilverArmor(int i, EnumArmorMaterial material, int j, int k)
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
		if(itemstack.itemID == cc.SilverHelmet.shiftedIndex || itemstack.itemID == cc.SilverChest.shiftedIndex || itemstack.itemID == cc.SilverBoots.shiftedIndex)
		{
			return "/CC/Armor/silver_1.png";
		}
		if(itemstack.itemID == cc.SilverLegs.shiftedIndex)
		{
			return "/CC/Armor/silver_2.png";
		}
		return "CC/Armor/silver_2.png";
	}
}
