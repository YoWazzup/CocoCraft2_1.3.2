package cococraft2.common.machine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cococraft2.common.blocks.CocoCraftBlocks;
import cococraft2.common.items.CocoCraftItems;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class BlastFurnaceRecipes 
{

	private static final BlastFurnaceRecipes blastingBase = new BlastFurnaceRecipes();

	private Map smeltingList = new HashMap();
	private Map metaSmeltingList = new HashMap();
	
	
	
	public static final BlastFurnaceRecipes blasting()
    {
        return blastingBase;
    }
	
	public BlastFurnaceRecipes()
	{
		addBlasting(Block.oreIron.blockID, Block.oreIron.blockID, new ItemStack(Item.ingotIron, 2));
		addMetaBlasting(CocoCraftBlocks.Ore.blockID, 0 , CocoCraftBlocks.Ore.blockID, 0, new ItemStack(CocoCraftItems.Ingots, 2, 0));
	}
	public void addBlasting(int input1, int input2, ItemStack output)
	{
		smeltingList.put(Arrays.asList(input1, input2), output);
	}
	
	public void addMetaBlasting(int input1, int meta1, int input2, int meta2, ItemStack output)
	{
		metaSmeltingList.put(Arrays.asList(input1, meta1, input2, meta2), output);
	}
	public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage(), item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Arrays.asList(item.itemID, item.itemID));
    }
}
