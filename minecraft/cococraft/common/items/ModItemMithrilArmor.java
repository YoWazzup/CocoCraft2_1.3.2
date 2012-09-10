
package cococraft.common.items;

import cococraft.common.CocoCraft;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ModItemMithrilArmor extends ItemArmor implements IArmorTextureProvider{

	CocoCraft cc;
	
	public ModItemMithrilArmor(int i, EnumArmorMaterial material, int j, int k)
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
		if(itemstack.itemID == cc.MithrilHelmet.shiftedIndex || itemstack.itemID == cc.MithrilChest.shiftedIndex || itemstack.itemID == cc.MithrilBoots.shiftedIndex)
		{
			return "/CC/Armor/mithril_1.png";
		}
        if(itemstack.itemID == cc.MithrilLegs.shiftedIndex)
        {
                return "/CC/Armor/mithril_2.png";
        }
		return "CC/Armor/mithril_2.png";
	}
}
