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
	public static int CompressorID;
	public static int BlastFurnaceID;
	public static int EssenceID;

	//Block Instances
	public static Block Ore;
	public static Block OreBlock;
	public static Block Essence;
	//Machine Instance
	public static Block Crusher;
	public static Block Compressor;
	public static Block BlastFurnace;

	//Shortened shit
	public static GameRegistry gr;
	public static LanguageRegistry lg;

	public static void init()
	{

		//Initialises the Blocks
		Ore = new BlockOre(OresID, 0).setHardness(2F).setResistance(3F).setBlockName("Ores");
		OreBlock = new BlockOreBlock(OreBlockID, 4).setHardness(3F).setResistance(4F).setBlockName("Blocks");
		Crusher = new BlockCrusher(CrusherID, false).setHardness(4F).setResistance(4F).setBlockName("Crusher");
		Compressor = new BlockCompressor(CompressorID, false).setHardness(4F).setResistance(4F).setBlockName("Compressor");
		BlastFurnace = new BlockBlastFurnace(BlastFurnaceID, false).setHardness(4F).setResistance(4F).setBlockName("BlastFurnace");

		Essence = new BlockEssence(EssenceID, 9).setHardness(2F).setResistance(3F).setBlockName("Essence");
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
		lg.instance().addStringLocalization("tile.Blocks.coalBlock.name", "Coal Block");

		lg.instance().addStringLocalization("tile.Essence.fireEssence.name", "Fire Essence");
		lg.instance().addStringLocalization("tile.Essence.airEssence.name", "Air Essence");
		lg.instance().addStringLocalization("tile.Essence.waterEssence.name", "Water Essence");
		lg.instance().addStringLocalization("tile.Essence.earthEssence.name", "Earth Essence");


		lg.addName(Crusher, "Crusher");
		lg.addName(Compressor, "Compressor");
		lg.addName(BlastFurnace, "Blast Furnace");

		lg.addName(Essence, "Essence");

		//Registers the Blocks
		gr.registerBlock(Crusher);
		gr.registerBlock(Compressor);
		gr.registerBlock(BlastFurnace);

		//Needed for Metadata
		Item.itemsList[OresID] = new ItemBlockOre(OresID-256, Ore).setItemName("ores");
		Item.itemsList[OreBlockID] = new ItemBlockOreBlock(OreBlockID-256, OreBlock).setItemName("oreBlocks");
		Item.itemsList[EssenceID] = new ItemBlockEssence(EssenceID-256, Essence).setItemName("essences");
			
	}
	public static int configProps(Configuration config)
	{
		config.load();

		OresID = Integer.parseInt(config.getOrCreateBlockIdProperty("OresID", 180).value);
		OreBlockID = Integer.parseInt(config.getOrCreateBlockIdProperty("OreBlockID", 181).value);
		CrusherID = Integer.parseInt(config.getOrCreateBlockIdProperty("CrusherID", 182).value);
		CompressorID = Integer.parseInt(config.getOrCreateBlockIdProperty("CompressorID", 183).value);
		BlastFurnaceID = Integer.parseInt(config.getOrCreateBlockIdProperty("BlastFurnaceID", 184).value);
		EssenceID = Integer.parseInt(config.getOrCreateBlockIdProperty("EssenceID", 185).value);


		config.save();
		return OresID;
	}
}
