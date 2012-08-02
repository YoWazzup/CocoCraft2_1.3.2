package net.minecraft.src;

import net.minecraft.src.cococraft.CC_Item;
import net.minecraft.src.cococraft.CC_Ore;
import net.minecraft.src.forge.MinecraftForge;
import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;

public class mod_CocoCraft extends NetworkMod{

	public static final String ItemPNG = "/CC/Items.png";
	public static final String BlockPNG = "/CC/Blocks.png";
	
	/** Adds Blocks **/
	public static final Block CocoStone = (new CC_Ore(180, 0)).setHardness(1.3F).setResistance(2F).setBlockName("CocoStone");
	public static final Block MithrilOre = (new CC_Ore(181, 1)).setHardness(1.0F).setResistance(2F).setBlockName("MithrilOre");
	public static final Block SilverOre = (new CC_Ore(182, 2)).setHardness(1.0F).setResistance(2F).setBlockName("SilverOre");
	public static final Block Amethyst = (new CC_Ore(183, 3)).setHardness(1.4F).setResistance(2F).setBlockName("Amethyst");
	
	/** Adds Items **/
	public static final Item AmethystGem = (new CC_Item(16000)).setIconCoord(0,0).setItemName("AmethystGem");
	public static final Item CocoIngot = (new CC_Item(16001)).setIconCoord(1,0).setItemName("CocoIngot");
	public static final Item MithrilIngot = (new CC_Item(16002)).setIconCoord(2,0).setItemName("MithrilIngot");
	public static final Item SilverIngot = (new CC_Item(16003)).setIconCoord(3,0).setItemName("SilverIngot");
	
	@Override
	public String getVersion() {return "CocoCraft2";}

	@Override
	public void load() 
	{
		MinecraftForgeClient.preloadTexture(this.ItemPNG);
		MinecraftForgeClient.preloadTexture(this.BlockPNG);
		
		this.registerBlocks();
		this.addNames();
		this.addRecipes();
		this.addSmelting();
	}

	private void registerBlocks()
	{
		ModLoader.registerBlock(CocoStone);
		ModLoader.registerBlock(MithrilOre);
		ModLoader.registerBlock(SilverOre);
		ModLoader.registerBlock(Amethyst);
	}
	private void addNames()
	{
		/** Adds Names for Blocks **/
		ModLoader.addName(CocoStone, "Coco Stone");
		ModLoader.addName(MithrilOre, "Mithril Ore");
		ModLoader.addName(SilverOre, "Silver Ore");
		ModLoader.addName(Amethyst, "Amethyst");
		
		/** Adds Names for Items **/
		ModLoader.addName(AmethystGem, "Amethyst Gem");
		ModLoader.addName(CocoIngot, "Coco Ingot");
		ModLoader.addName(MithrilIngot, "Mithril Ingot");
		ModLoader.addName(SilverIngot, "Silver Ingot");
	}
	private void addRecipes()
	{
		
	}
	private void addSmelting()
	{
		
	}
}
