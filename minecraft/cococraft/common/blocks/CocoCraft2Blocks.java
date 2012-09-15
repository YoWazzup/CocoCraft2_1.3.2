package cococraft.common.blocks;

import java.io.File;

import cococraft.common.CocoCraft;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;

public class CocoCraft2Blocks 
{

	//Ids
	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "/CocoCraft2/CocoCraft2Blocks.cfg"));

	
	static int OresID = configurationProperties(config); //180
	static int OreBlockID;// = 181;

	static int CrusherID;
	
	
	//Block Instances
	
	public static Block Ores;
	public static Block OreBlock;
	public static Block Crusher;
	
	//Shorter Names, instead of GameRegistry gr.
	
	public static GameRegistry gr;
	public static LanguageRegistry lg;
	public static CocoCraft mod;
	
	
	public static void init()
	{
		
		//addBlockRecipes();
		
		
		//inits blocks
		Ores = (new ModBlockOre(OresID, 0)).setBlockName("Ores").setResistance(3F).setHardness(3F);
		OreBlock = (new ModBlockOreBlock(OreBlockID,4)).setBlockName("OreBlock").setResistance(2F).setHardness(2F);
		Crusher = (new BlockCrusher(CrusherID, false).setBlockName("Crusher").setResistance(3F).setHardness(5F));
		
		//Adds Names.
		lg.instance().addStringLocalization("tile.Ores.cocoStone.name", "Coco Stone");
		lg.instance().addStringLocalization("tile.Ores.mithrilOre.name", "Mithril Ore");
		lg.instance().addStringLocalization("tile.Ores.silverOre.name", "Silver Ore");
		lg.instance().addStringLocalization("tile.Ores.amethystOre.name", "Amethyst Ore");

		lg.instance().addStringLocalization("tile.OreBlock.cocoBlock.name", "Coco Block");
		lg.instance().addStringLocalization("tile.OreBlock.mithrilBlock.name", "Mithril Block");
		lg.instance().addStringLocalization("tile.OreBlock.silverBlock.name", "Silver Block");
		lg.instance().addStringLocalization("tile.OreBlock.amethystBlock.name", "Amethyst Block");
		lg.instance().addStringLocalization("tile.OreBlock.superStone.name", "Super Stone");

		
		lg.addName(Crusher, "Crusher");
		
		
		//Registers Block
		

		
		//Needed for Metadata
		Item.itemsList[OreBlockID] = new ItemOreBlock(OreBlockID-256, OreBlock).setItemName("oreBlock");
		Item.itemsList[OresID] = new ModItemOre(OresID-256, Ores).setItemName("ores");
		
		
		
	}
	/**public static void addBlockRecipes()
	{
		gr.addRecipe(new ItemStack(OreBlock, 1, 0), new Object[]{"III", "III", "III", 'I', mod.CocoIngot});
		gr.addRecipe(new ItemStack(OreBlock, 1, 1), new Object[]{"III", "III", "III", 'I', mod.MithrilIngot});
		gr.addRecipe(new ItemStack(OreBlock, 1, 2), new Object[]{"III", "III", "III", 'I', mod.SilverIngot});
		gr.addRecipe(new ItemStack(OreBlock, 1, 3), new Object[]{"III", "III", "III", 'I', mod.AmethystGem});
		
		gr.addShapelessRecipe(new ItemStack(mod.CocoIngot, 9), new Object[] {new ItemStack(OreBlock, 1, 0)});
		gr.addShapelessRecipe(new ItemStack(mod.MithrilIngot, 9), new Object[] {new ItemStack(OreBlock, 1, 1)});
		gr.addShapelessRecipe(new ItemStack(mod.SilverIngot, 9), new Object[] {new ItemStack(OreBlock, 1, 2)});
		gr.addShapelessRecipe(new ItemStack(mod.AmethystGem, 9), new Object[] {new ItemStack(OreBlock, 1, 3)});

		//SuperStone Recipe!
		gr.addRecipe(new ItemStack(OreBlock, 3, 4), new Object[]{"1 1", " 2 ", "1 1", '1', Item.ingotGold, '2', Block.blockDiamond });
		
	}**/
	public void addSmelting()
	{		
		CocoCraft.addMetaSmelting(Ores.blockID, 0, new ItemStack(mod.CocoIngot, 1));
		CocoCraft.addMetaSmelting(Ores.blockID, 1, new ItemStack(mod.MithrilIngot, 1));
		CocoCraft.addMetaSmelting(Ores.blockID, 2, new ItemStack(mod.SilverIngot, 1));
	}

	
	public static int configurationProperties(Configuration config)
	{
		OresID = Integer.parseInt(config.getOrCreateBlockIdProperty("OresIds", 180).value);
		OreBlockID = Integer.parseInt(config.getOrCreateBlockIdProperty("OreBlockIds", 181).value);

		CrusherID = Integer.parseInt(config.getOrCreateBlockIdProperty("CrusherID", 182).value);
		
		config.save();
		return OresID;
		
	}
}
