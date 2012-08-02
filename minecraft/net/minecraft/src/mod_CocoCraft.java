package net.minecraft.src;

import net.minecraft.src.cococraft.CC_Item;
import net.minecraft.src.cococraft.CC_ItemAxe;
import net.minecraft.src.cococraft.CC_ItemHoe;
import net.minecraft.src.cococraft.CC_ItemPickaxe;
import net.minecraft.src.cococraft.CC_ItemShovel;
import net.minecraft.src.cococraft.CC_ItemSword;
import net.minecraft.src.cococraft.CC_Ore;
import net.minecraft.src.forge.*;

public class mod_CocoCraft extends NetworkMod{

	public static final String ItemPNG = "/CC/Items.png";
	public static final String BlockPNG = "/CC/Blocks.png";
	
	
	static EnumToolMaterial toolCOCO = EnumHelper.addToolMaterial("COCO", 2, 2500, 15F, 13, 8);
	static EnumToolMaterial toolMithril = EnumHelper.addToolMaterial("MITHRIL", 2, 432, 9F, 7, 4);
	static EnumToolMaterial toolSilver = EnumHelper.addToolMaterial("SILVER", 2, 561, 7F, 7, 4);
	static EnumToolMaterial toolAmethyst = EnumHelper.addToolMaterial("AMETHYST", 2, 2201, 13F, 11, 8);
	
	
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
	/** Coco Tools **/
	public static final Item CocoPickaxe = (new CC_ItemPickaxe(16004, toolCOCO)).setIconCoord(0,1).setItemName("CocoPick");
	public static final Item CocoAxe = (new CC_ItemAxe(16005, toolCOCO)).setIconCoord(1,1).setItemName("CocoAxe");
	public static final Item CocoShovel = (new CC_ItemShovel(16006, toolCOCO)).setIconCoord(2,1).setItemName("CocoShovel");
	public static final Item CocoSword = (new CC_ItemSword(16007, toolCOCO)).setIconCoord(3,1).setItemName("CocoSword");
	public static final Item CocoHoe = (new CC_ItemHoe(16008, toolCOCO)).setIconCoord(4,1).setItemName("CocoHoe");
	/** Mithril Tools **/
	public static final Item MithrilPickaxe = (new CC_ItemPickaxe(16009, toolMithril)).setIconCoord(5,1).setItemName("MithrilPick");
	public static final Item MithrilAxe = (new CC_ItemAxe(16010, toolMithril)).setIconCoord(6,1).setItemName("MithrilAxe");
	public static final Item MithrilShovel = (new CC_ItemShovel(16011, toolMithril)).setIconCoord(7,1).setItemName("MithrilShovel");
	public static final Item MithrilSword = (new CC_ItemSword(16012, toolMithril)).setIconCoord(8,1).setItemName("MithrilSword");
	public static final Item MithrilHoe = (new CC_ItemHoe(16013, toolMithril)).setIconCoord(9,1).setItemName("MithrilHoe");
	/** Silver Tools**/
	public static final Item SilverPickaxe = (new CC_ItemPickaxe(16014, toolSilver)).setIconCoord(10,1).setItemName("SilverPick");
	public static final Item SilverAxe = (new CC_ItemAxe(16015, toolSilver)).setIconCoord(11,1).setItemName("SilverAxe");
	public static final Item SilverShovel = (new CC_ItemShovel(16016, toolSilver)).setIconCoord(12,1).setItemName("SilverShovel");
	public static final Item SilverSword = (new CC_ItemSword(16017, toolSilver)).setIconCoord(13,1).setItemName("SilverSword");
	public static final Item SilverHoe = (new CC_ItemHoe(16018, toolSilver)).setIconCoord(14,1).setItemName("SilverHoe");
	/** Amethyst Tools**/
	public static final Item AmethystPickaxe = (new CC_ItemPickaxe(16019, toolAmethyst)).setIconCoord(15,1).setItemName("AmethystPick");
	public static final Item AmethystAxe = (new CC_ItemAxe(16020, toolAmethyst)).setIconCoord(0,2).setItemName("AmethystAxe");
	public static final Item AmethystShovel = (new CC_ItemShovel(16021, toolAmethyst)).setIconCoord(1,2).setItemName("AmethystShovel");
	public static final Item AmethystSword = (new CC_ItemSword(16022, toolAmethyst)).setIconCoord(2,2).setItemName("AmethystSword");
	public static final Item AmethystHoe = (new CC_ItemHoe(16023, toolAmethyst)).setIconCoord(3,2).setItemName("AmethystHoe");
	
	@Override
	public String getVersion() {return "CocoCraft2";}

	@Override
	public void load() 
	{
		MinecraftForgeClient.preloadTexture(this.ItemPNG);
		MinecraftForgeClient.preloadTexture(this.BlockPNG);
		
		MinecraftForge.setToolClass(CocoPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(CocoAxe, "axe", 3);
		MinecraftForge.setToolClass(CocoShovel, "shovel", 3);
		MinecraftForge.setToolClass(CocoSword, "sword", 3);
		MinecraftForge.setToolClass(CocoHoe, "hoe", 3);
		
		MinecraftForge.setToolClass(MithrilPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(MithrilAxe, "axe", 3);
		MinecraftForge.setToolClass(MithrilShovel, "shovel", 3);
		MinecraftForge.setToolClass(MithrilSword, "sword", 3);
		MinecraftForge.setToolClass(MithrilHoe, "hoe", 3);
		
		MinecraftForge.setToolClass(SilverPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(SilverAxe, "axe", 3);
		MinecraftForge.setToolClass(SilverShovel, "shovel", 3);
		MinecraftForge.setToolClass(SilverSword, "sword", 3);
		MinecraftForge.setToolClass(SilverHoe, "hoe", 3);
		
		MinecraftForge.setToolClass(AmethystPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(AmethystAxe, "axe", 3);
		MinecraftForge.setToolClass(AmethystShovel, "shovel", 3);
		MinecraftForge.setToolClass(AmethystSword, "sword", 3);
		MinecraftForge.setToolClass(AmethystHoe, "hoe", 3);
		
		this.registerBlocks();
		this.addNames();
		this.addRecipes();
		this.addSmelting();
	}
	/** Registers the Blocks so that they exist **/
	private void registerBlocks()
	{
		ModLoader.registerBlock(CocoStone);
		ModLoader.registerBlock(MithrilOre);
		ModLoader.registerBlock(SilverOre);
		ModLoader.registerBlock(Amethyst);
	}
	/** Adds the Names to Blocks and Items**/
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
		
		ModLoader.addName(CocoPickaxe, "Coco Pickaxe");
		ModLoader.addName(CocoAxe, "Coco Axe");
		ModLoader.addName(CocoShovel, "Coco Shovel");
		ModLoader.addName(CocoSword, "Coco Sword");
		ModLoader.addName(CocoHoe, "Coco Hoe");
		
		ModLoader.addName(MithrilPickaxe, "Mithril Pickaxe");
		ModLoader.addName(MithrilAxe, "Mithril Axe");
		ModLoader.addName(MithrilShovel, "Mithril Shovel");
		ModLoader.addName(MithrilSword, "Mithril Sword");
		ModLoader.addName(MithrilHoe, "Mithril Hoe");
		
		ModLoader.addName(SilverPickaxe, "Silver Pickaxe");
		ModLoader.addName(SilverAxe, "Silver Axe");
		ModLoader.addName(SilverShovel, "Silver Shovel");
		ModLoader.addName(SilverSword, "Silver Sword");
		ModLoader.addName(SilverHoe, "Silver Hoe");
		
		ModLoader.addName(AmethystPickaxe, "Amethyst Pickaxe");
		ModLoader.addName(AmethystAxe, "Amethyst Axe");
		ModLoader.addName(AmethystShovel, "Amethyst Shovel");
		ModLoader.addName(AmethystSword, "Amethyst Sword");
		ModLoader.addName(AmethystHoe, "Amethyst Hoe");
	}
	/** Adds Recipes **/
	private void addRecipes()
	{
		ModLoader.addRecipe(new ItemStack(CocoPickaxe, 1), new Object[] {"XXX", " C ", " C ", 'X', CocoIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(CocoAxe, 1), new Object[] {"XX ", " CX", " C ", 'X', CocoIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(CocoShovel, 1), new Object[] {" X ", " C ", " C ", 'X', CocoIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(CocoSword, 1), new Object[] {" X ", " X ", " C ", 'X', CocoIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(CocoHoe, 1), new Object[] {"XX ", " C ", " C ", 'X', CocoIngot, 'C', Item.stick});
		
		ModLoader.addRecipe(new ItemStack(MithrilPickaxe, 1), new Object[] {"XXX", " C ", " C ", 'X', MithrilIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(MithrilAxe, 1), new Object[] {"XX ", " CX", " C ", 'X', MithrilIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(MithrilShovel, 1), new Object[] {" X ", " C ", " C ", 'X', MithrilIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(MithrilSword, 1), new Object[] {" X ", " X ", " C ", 'X', MithrilIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(MithrilHoe, 1), new Object[] {"XX ", " C ", " C ", 'X', MithrilIngot, 'C', Item.stick});
		
		ModLoader.addRecipe(new ItemStack(SilverPickaxe, 1), new Object[] {"XXX", " C ", " C ", 'X', SilverIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(SilverAxe, 1), new Object[] {"XX ", " CX", " C ", 'X', SilverIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(SilverShovel, 1), new Object[] {" X ", " C ", " C ", 'X', SilverIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(SilverSword, 1), new Object[] {" X ", " X ", " C ", 'X', SilverIngot, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(SilverHoe, 1), new Object[] {"XX ", " C ", " C ", 'X', SilverIngot, 'C', Item.stick});
		
		ModLoader.addRecipe(new ItemStack(AmethystPickaxe, 1), new Object[] {"XXX", " C ", " C ", 'X', AmethystGem, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(AmethystAxe, 1), new Object[] {"XX ", " CX", " C ", 'X', AmethystGem, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(AmethystShovel, 1), new Object[] {" X ", " C ", " C ", 'X', AmethystGem, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(AmethystSword, 1), new Object[] {" X ", " X ", " C ", 'X', AmethystGem, 'C', Item.stick});
		ModLoader.addRecipe(new ItemStack(AmethystHoe, 1), new Object[] {"XX ", " C ", " C ", 'X', AmethystGem, 'C', Item.stick});
		
	}
	/** Adds Smelting Recipes**/
	private void addSmelting()
	{
		ModLoader.addSmelting(CocoStone.blockID, new ItemStack(CocoIngot,1));
		ModLoader.addSmelting(MithrilOre.blockID, new ItemStack(MithrilIngot, 1));
		ModLoader.addSmelting(SilverOre.blockID, new ItemStack(SilverIngot, 1));
	}
}
