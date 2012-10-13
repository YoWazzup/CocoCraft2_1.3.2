package cococraft2.common;

import net.minecraft.src.Item;
import net.minecraft.src.Block;
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
		oreBlockRecipes();
		
		
		
	}

	private static void addRegularRecipes() 
	{	
		
		
		gr.addRecipe(new ItemStack(blocks.OreBlock, 3, 4), new Object[]{"L L", " D ", "L L", 'L', Block.blockLapis, 'D', Block.stone});
		
		gr.addRecipe(new ItemStack(blocks.Crusher, 1), new Object[]{"SMS", "SDS", "SDS", 'S', new ItemStack(blocks.OreBlock, 1, 4), 'M', new ItemStack(items.Ingots, 1, 11), 'D', Item.diamond});
		gr.addRecipe(new ItemStack(blocks.Compressor, 1), new Object[]{"SMS", "SDS", "SDS", 'S', new ItemStack(blocks.OreBlock, 1, 4), 'M', new ItemStack(items.Ingots, 1, 0), 'D', Item.diamond});
		gr.addRecipe(new ItemStack(blocks.BlastFurnace, 1), new Object[]{"SSS", "SDS", "SSS", 'S', new ItemStack(blocks.OreBlock, 1, 2), 'D', Block.blockSteel});
		
		gr.addRecipe(new ItemStack(items.Ingots, 2, 11), new Object[]{"GRG", "RSR", "GRG", 'G', Item.gunpowder, 'R', Item.redstone, 'S', Item.sugar});
		
		gr.addRecipe(new ItemStack(blocks.OreBlock, 1, 5), new Object[]{"III","III","III", 'I', new ItemStack(items.Ingots,1, 6)});
		gr.addShapelessRecipe(new ItemStack(items.Ingots, 9, 6), new Object[]{new ItemStack(blocks.OreBlock, 1, 5)});
		
		gr.addShapelessRecipe(new ItemStack(items.Ingots, 1, 15), new Object[] {new ItemStack(items.Hammer, 1, -1), new ItemStack(items.Ingots, 1, 14)});
	}
	private static void addToolRecipes() 
	{

		gr.addRecipe(new ItemStack(items.CocoPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoAxe, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.Ingots, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoShovel, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoSword, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.Ingots, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoHoe, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 0), 'S', Item.stick});

		gr.addRecipe(new ItemStack(items.MithrilPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilAxe, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.Ingots, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilShovel, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilSword, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.Ingots, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilHoe, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 1), 'S', Item.stick});

		gr.addRecipe(new ItemStack(items.SilverPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverAxe, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.Ingots, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverShovel, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverSword, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.Ingots, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverHoe, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 2), 'S', Item.stick});

		gr.addRecipe(new ItemStack(items.SteelPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 15), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SteelAxe, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.Ingots, 1, 15), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SteelShovel, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 15), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SteelSword, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.Ingots, 1, 15), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SteelHoe, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.Ingots, 1, 15), 'S', Item.stick});

	}
	private static void addShaplessRecipes() 
	{
		ItemStack[] Blocks = new ItemStack[]{new ItemStack(blocks.OreBlock, 1, 0), new ItemStack(blocks.OreBlock, 1, 1), new ItemStack(blocks.OreBlock, 1, 2), new ItemStack(blocks.OreBlock, 1, 3)};
		
		for(int j = 0; j<4;j++)
		{
			gr.addShapelessRecipe(new ItemStack(items.Ingots, 9, j), new Object[]{Blocks[j]});
		}
	}
	private static void addArmorRecipes() 
	{
		gr.addRecipe(new ItemStack(items.CocoChest, 1), new Object[] {"1 1", "111", "111", Character.valueOf('1'), new ItemStack(items.Ingots, 1, 0)});
		gr.addRecipe(new ItemStack(items.CocoLegs, 1), new Object[] {"111", "1 1", "1 1", Character.valueOf('1'), new ItemStack(items.Ingots, 1, 0)});
		gr.addRecipe(new ItemStack(items.CocoBoots, 1), new Object[] {"1 1", "1 1", Character.valueOf('1'), new ItemStack(items.Ingots, 1, 0)});
		gr.addRecipe(new ItemStack(items.CocoHelmet, 1), new Object[] {"111", "1 1", Character.valueOf('1'), new ItemStack(items.Ingots, 1, 0)});

	}
	public static void oreBlockRecipes()
	{
	ItemStack[] ingots = new ItemStack[]{new ItemStack(items.Ingots, 1, 0), new ItemStack(items.Ingots, 1, 1), new ItemStack(items.Ingots,1 ,2), new ItemStack(items.Ingots, 1, 3)};
		
		for(int i=0;i<4;i++)
		{
			gr.addRecipe(new ItemStack(blocks.OreBlock, 1, i), new Object[]{"III","III","III", 'I', ingots[i]});
		}
	}
}
