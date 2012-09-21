package cococraft2.common.items;

import java.util.ArrayList;

import cococraft2.common.CommonProxy;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemCocoArmor extends ItemArmor implements IArmorTextureProvider
{
	public static CocoCraftItems cci;
	public static CommonProxy proxy;
	
    public ItemCocoArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
        setTabToDisplayOn(CreativeTabs.tabCombat);
    }
    
    public String getTextureFile()
    {
        return "/CC/Items.png";
    }
    public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == cci.CocoHelmet.shiftedIndex || itemstack.itemID == cci.CocoChest.shiftedIndex || itemstack.itemID == cci.CocoBoots.shiftedIndex)
        {
                return proxy.CocoArmor1;
        }
        if(itemstack.itemID == cci.CocoLegs.shiftedIndex)
        {
                return proxy.CocoArmor2;
        }
        return  proxy.CocoArmor2;
    }
    
    public void addCreativeItems(ArrayList itemList)
    {
    	itemList.add(new ItemStack(this));
    }
}