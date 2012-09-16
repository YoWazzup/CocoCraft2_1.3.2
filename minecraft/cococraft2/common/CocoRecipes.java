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
		gr.addRecipe(new ItemStack(items.CocoPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', items.CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoAxe, 1), new Object[] {" II", "IS ", " S ", 'I', items.CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoShovel, 1), new Object[] {" I ", " S ", " S ", 'I', items.CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoSword, 1), new Object[] {" I ", " I ", " S ", 'I', items.CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.CocoHoe, 1), new Object[] {"II ", " S ", " S ", 'I', items.CocoIngot, 'S', Item.stick});

		gr.addRecipe(new ItemStack(items.MithrilPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', items.MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilAxe, 1), new Object[] {" II", "IS ", " S ", 'I', items.MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilShovel, 1), new Object[] {" I ", " S ", " S ", 'I', items.MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilSword, 1), new Object[] {" I ", " I ", " S ", 'I', items.MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.MithrilHoe, 1), new Object[] {"II ", " S ", " S ", 'I', items.MithrilIngot, 'S', Item.stick});

		gr.addRecipe(new ItemStack(items.SilverPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', items.SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverAxe, 1), new Object[] {" II", "IS ", " S ", 'I', items.SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverShovel, 1), new Object[] {" I ", " S ", " S ", 'I', items.SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverSword, 1), new Object[] {" I ", " I ", " S ", 'I', items.SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.SilverHoe, 1), new Object[] {"II ", " S ", " S ", 'I', items.SilverIngot, 'S', Item.stick});

	}

	private static void addShaplessRecipes() 
	{
		gr.addShapelessRecipe(new ItemStack(items.CocoIngot, 9), new Object[] {blocks.OreBlock, 1, 0});
		gr.addShapelessRecipe(new ItemStack(items.MithrilIngot, 9), new Object[] {blocks.OreBlock, 1, 1});
		gr.addShapelessRecipe(new ItemStack(items.SilverIngot, 9), new Object[] {blocks.OreBlock, 1, 2});
		gr.addShapelessRecipe(new ItemStack(items.AmethystGem, 9), new Object[] {blocks.OreBlock, 1, 3});
		
	}

	private static void addArmorRecipes() 
	{
		
	}
}
