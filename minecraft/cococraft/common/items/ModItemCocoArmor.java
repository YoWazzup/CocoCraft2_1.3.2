/**
package cococraft.common.items;

import cococraft.common.CocoCraft;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ModItemCocoArmor extends ItemArmor implements IArmorTextureProvider{

	CocoCraft cc;
	
	public ModItemCocoArmor(int i, EnumArmorMaterial material, int j, int k)
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
		if(itemstack.itemID == cc.CocoHelmet.shiftedIndex || itemstack.itemID == cc.CocoChest.shiftedIndex || itemstack.itemID == cc.CocoBoots.shiftedIndex)
		{
			return "/CC/Armor/coco_1.png";
		}
        if(itemstack.itemID == cc.CocoLegs.shiftedIndex)
        {
                return "/CC/Armor/coco_2.png";
        }
		return "CC/Armor/coco_2.png";
	}
}
**/