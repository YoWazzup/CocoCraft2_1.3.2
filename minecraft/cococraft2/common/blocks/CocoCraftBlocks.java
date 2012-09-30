package cococraft2.common.blocks;

import java.io.File;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class CocoCraftBlocks 
{
	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "/CocoCraft2/CocoCraft2Blocks.cfg"));
	
	
	//Sets ints for the id
	public static int OresID = configProps(config);
	public static int OreBlockID;
	public static int CrusherID;
	
	//Block Instances
	public static Block Ore;
	public static Block OreBlock;
	//Machine Instance
	public static Block Crusher;
	
	//Shortened shit
	public static GameRegistry gr;
	public static LanguageRegistry lg;
	
	public static void init()
	{
		
		//Initialises the Blocks
		Ore = new BlockOre(OresID, 0).setHardness(2F).setResistance(3F).setBlockName("Ores");
		OreBlock = new BlockOreBlock(OreBlockID, 4).setHardness(3F).setResistance(4F).setBlockName("Blocks");
		Crusher = new BlockCrusher(CrusherID, false).setHardness(4F).setResistance(4F).setBlockName("Crusher");
		
		
		//Adds the Names
		lg.instance().addStringLocalization("tile.Ores.cocoStone.name", "Coco Stone");
		lg.instance().addStringLocalization("tile.Ores.mithrilOre.name", "Mithril Ore");
		lg.instance().addStringLocalization("tile.Ores.silverOre.name", "Silver Ore");
		lg.instance().addStringLocalization("tile.Ores.amethystOre.name", "Amethyst Ore");
		
		lg.instance().addStringLocalization("tile.Blocks.cocoBlock.name", "Coco Block");
		lg.instance().addStringLocalization("tile.Blocks.mithrilBlock.name", "Mithril Block");
		lg.instance().addStringLocalization("tile.Blocks.silverBlock.name", "Silver Block");
		lg.instance().addStringLocalization("tile.Blocks.amethystBlock.name", "Amethyst Block");
		lg.instance().addStringLocalization("tile.Blocks.superStone.name", "Super Stone");
		
		lg.addName(Crusher, "Crusher");
		
		//Registers the Blocks
		gr.registerBlock(Crusher);
		
		//Needed for Metadata
		Item.itemsList[OresID] = new ItemBlockOre(OresID-256, Ore).setItemName("ores");
		Item.itemsList[OreBlockID] = new ItemBlockOreBlock(OreBlockID-256, OreBlock).setItemName("oreBlocks");
	}
	public static int configProps(Configuration config)
	{
		config.load();
		
		OresID = Integer.parseInt(config.getOrCreateBlockIdProperty("OresID", 180).value);
		OreBlockID = Integer.parseInt(config.getOrCreateBlockIdProperty("OreBlockID", 181).value);
		CrusherID = Integer.parseInt(config.getOrCreateBlockIdProperty("CrusherID", 182).value);
		
		
		config.save();
		return OresID;
	}
}
