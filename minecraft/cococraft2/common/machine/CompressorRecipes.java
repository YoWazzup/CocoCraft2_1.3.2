package cococraft2.common.machine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.ItemStack;

public class CompressorRecipes 
{
	private static final CompressorRecipes smeltingBase = new CompressorRecipes();

	private Map compressingList = new HashMap();
	private Map metaCompressingList = new HashMap();
	
	
	
	public static final CompressorRecipes compressing()
    {
        return smeltingBase;
    }
	
	public CompressorRecipes()
	{
		
	}
	public void addCompressing(int input, ItemStack output)
    {
        this.compressingList.put(Integer.valueOf(input), output);
    }
	public void addMetaCompressing(int input, int meta, ItemStack output)
	{
		metaCompressingList.put(Arrays.asList(input, meta), output);
	}
	public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaCompressingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)compressingList.get(Integer.valueOf(item.itemID));
    }
}
