package cococraft2.common.items;

import java.util.List;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemIngot extends Item 
/**
 * Look at the Method publc String getItemNameIS for what the metadata id stands for.
 */
{
	public ItemIngot(int par1) {
		super(par1);
		setHasSubtypes(true);
		setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i){
		case 0: return 1;
		case 1: return 2;
		case 2: return 3;
		case 3: return 0;
		case 4: return 4;
		case 5: return 5;

		case 6: return 89;
		case 7: return 85;
		case 8: return 86;
		case 9: return 88;
		case 10: return 87;
		case 11: return 80;

		case 12: return 6;
		case 13: return 7;
		case 14: return 8;
		case 15: return 9;

		default:return 0;
		}
	}
	public String getItemNameIS(ItemStack i)
	{
		switch(i.getItemDamage()){
		case 0: return "CocoIngot";
		case 1: return "MithrilIngot";
		case 2: return "SilverIngot";
		case 3: return "AmethystGem";
		case 4: return "DragonstoneShard";
		case 5: return "DiamondStick";

		case 6: return "CoalDust";
		case 7: return "IronDust";
		case 8: return "GoldDust";
		case 9: return "Mithrildust";
		case 10: return "SilverDust";
		case 11: return "MagicDust";
		case 12: return "ObisidanDust";
		case 13: return "ObsidianIngot";
		case 14: return "UnworkedSteel";
		case 15: return "SteelIngot";

		default:return "CocoIngot";
		}
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack item)
	{
		switch(item.getItemDamage())
		{
		case 4: return true;

		default: return false;

		}
	}
	@SideOnly(Side.CLIENT)
	public void getSubItems(int i, CreativeTabs tab, List list)
	{
		for(int j=0;j < 16; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}		
	}

}
