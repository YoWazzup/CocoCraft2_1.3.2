package cococraft2.common.machine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.ItemStack;

public class CrusherRecipes 
{
	private static final CrusherRecipes smeltingBase = new CrusherRecipes();

	private Map crushingList = new HashMap();
	private Map metaCrushingList = new HashMap();
	
	
	
	public static final CrusherRecipes crushing()
    {
        return smeltingBase;
    }
	
	public CrusherRecipes()
	{
		
	}
	public void addCrushing(int input, ItemStack output)
    {
        this.crushingList.put(Integer.valueOf(input), output);
    }
	public void addMetaCrushing(int input, int meta, ItemStack output)
	{
		metaCrushingList.put(Arrays.asList(input, meta), output);
	}
	public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaCrushingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)crushingList.get(Integer.valueOf(item.itemID));
    }
}
