package cococraft2.common;

import net.minecraft.src.ItemStack;
import cococraft2.common.blocks.CocoCraftBlocks;
import cococraft2.common.items.CocoCraftItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class CocoRecipes 
{
	public static CocoCraftItems items;
	public static CocoCraftBlocks blocks;
	
	public static GameRegistry gr;
	
	public static void init()
	{
		addArmorRecipes();
		addShaplessRecipes();
		addToolRecipes();
		addRegularRecipes();
	}

	private static void addRegularRecipes() 
	{
		
		gr.addRecipe(new ItemStack(blocks.OreBlock, 1, 0), new Object[] {"III", "III", "III", 'I', items.CocoIngot});
		gr.addRecipe(new ItemStack(blocks.OreBlock, 1, 1), new Object[] {"III", "III", "III", 'I', items.MithrilIngot});
		gr.addRecipe(new ItemStack(blocks.OreBlock, 1, 2), new Object[] {"III", "III", "III", 'I', items.SilverIngot});
		gr.addRecipe(new ItemStack(blocks.OreBlock, 1, 3), new Object[] {"III", "III", "III", 'I', items.AmethystGem});
		
	}

	private static void addToolRecipes() 
	{
		
	}

	private static void addShaplessRecipes() 
	{
		
	}

	private static void addArmorRecipes() 
	{
		
	}
}
