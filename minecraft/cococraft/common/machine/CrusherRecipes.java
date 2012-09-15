package cococraft.common.machine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.ItemStack;

public class CrusherRecipes 
{

	private static final CrusherRecipes crushingBase = new CrusherRecipes();
	
	private Map crushingList = new HashMap();
	private Map metaCrushingList = new HashMap();
	
	public static final CrusherRecipes crushing()
	{
		return crushingBase;
	}
	
	private CrusherRecipes()
	{
		
	}
	/**
	 * Adds Crushing for the Crusher
	 * 
	 * @param input the input -_-
	 * @param output the output -_'
	 */
	
	public void addCrushing(int input, ItemStack output)
	{
		crushingList.put(Integer.valueOf(input), output);
	}
	/**
	 *Add Metadata sensitive crushing 
	 *
	 * @param input the input
	 * @param meta the metadata value
	 * @param output the output
	 */
	public void addMetaCrushing(int input, int meta, ItemStack output)
	{
		metaCrushingList.put(Arrays.asList(input, meta), output);
	}
	public ItemStack getCrushingResult(ItemStack item)
	{
		if(item == null)
		{
			return null;
		}
		ItemStack ret = (ItemStack)metaCrushingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
		if(ret != null)
		{
			return ret;
		}
		return (ItemStack)crushingList.get(Integer.valueOf(item.itemID));
	}
	
}
