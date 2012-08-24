package cococraft.common;

import java.io.File;

import cococraft.common.blocks.ModBlockOre;
import cococraft.common.items.ModItem;
import cococraft.common.items.ModItemAxe;
import cococraft.common.items.ModItemCocoArmor;
import cococraft.common.items.ModItemHoe;
import cococraft.common.items.ModItemPick;
import cococraft.common.items.ModItemShovel;
import cococraft.common.items.ModItemSword;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "CocoCraft2", name = "CocoCraft2", version = "2.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class CocoCraft 
{
	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "/config/CocoCraft2/CocoCraft2.cfg"));
	
	static int CocoStoneID = configurationProperties(config);
	static int MithrilOreID;
	static int SilverOreID;
	static int AmethystOreID;
	
	@SidedProxy(clientSide = "cococraft.client.ClientProxyCocoCraft", serverSide = "cococraft.common.CommonProxyCocoCraft")
	public static CommonProxyCocoCraft proxy;
	public static GameRegistry gr;
	public static LanguageRegistry lg;


	//Adds Tool Materials
	static EnumToolMaterial toolCoco = EnumHelper.addToolMaterial("COCO", 2, 2500, 15F, 13, 8);
	static EnumToolMaterial toolMithril = EnumHelper.addToolMaterial("MITHRIL", 2, 650, 9F, 7, 4);
	static EnumToolMaterial toolSilver = EnumHelper.addToolMaterial("SILVER", 2, 451, 7F, 8, 3);
	static EnumToolMaterial toolAmethyst = EnumHelper.addToolMaterial("AMETHYSY", 2, 3334, 15F, 15, 12);
	
	//Adds Armor Materials
	static EnumArmorMaterial COCO = EnumHelper.addArmorMaterial("COCO", 48, new int[]{4, 8, 6, 2}, 4);

	//Blocks
	public static final Block CocoStone = (new ModBlockOre(CocoStoneID, 0)).setBlockName("CocoStone").setResistance(2F).setHardness(2F);
	public static final Block MithrilOre = (new ModBlockOre(MithrilOreID, 1)).setBlockName("MithrilORe").setResistance(2F).setHardness(2F);
	public static final Block SilverOre = (new ModBlockOre(SilverOreID, 2)).setBlockName("SilverOre").setResistance(2F).setHardness(2F);
	public static final Block AmethystOre = (new ModBlockOre(AmethystOreID, 3)).setBlockName("Amethyst").setResistance(2F).setHardness(2F);


	//Items
	public static final Item AmethystGem = (new ModItem(5000)).setItemName("AmethystGem").setIconCoord(0,0);
	public static final Item CocoIngot = (new ModItem(5001)).setItemName("CocoIngot").setIconCoord(1,0);
	public static final Item MithrilIngot = (new ModItem(5002)).setItemName("MithrilIngot").setIconCoord(2,0);
	public static final Item SilverIngot = (new ModItem(5003)).setItemName("SilverIngot").setIconCoord(3,0);

	//Tools
	public static final Item CocoPickaxe = (new ModItemPick(5004, toolCoco)).setIconCoord(0,1).setItemName("CocoPick");
	public static final Item CocoAxe = (new ModItemAxe(5005, toolCoco)).setIconCoord(1, 1).setItemName("CocoAxe");
	public static final Item CocoShovel = (new ModItemShovel(5006, toolCoco)).setIconCoord(2,1).setItemName("CocoShovel");
	public static final Item CocoSword = (new ModItemSword(5007, toolCoco)).setIconCoord(3,1).setItemName("CocoSword");
	public static final Item CocoHoe = (new ModItemHoe(5008, toolCoco)).setIconCoord(4,1).setItemName("CocoHoe");

	public static final Item MithrilPickaxe = (new ModItemPick(5009, toolMithril)).setIconCoord(5,1).setItemName("MithrilPick");
	public static final Item MithrilAxe = (new ModItemAxe(5010, toolMithril)).setIconCoord(6, 1).setItemName("MithrilAxe");
	public static final Item MithrilShovel = (new ModItemShovel(5011, toolMithril)).setIconCoord(7,1).setItemName("MithrilShovel");
	public static final Item MithrilSword = (new ModItemSword(5012, toolMithril)).setIconCoord(8,1).setItemName("MithrilSword");
	public static final Item MithrilHoe = (new ModItemHoe(5013, toolMithril)).setIconCoord(9,1).setItemName("MithrilHoe");

	public static final Item SilverPickaxe = (new ModItemPick(5014, toolSilver)).setIconCoord(10,1).setItemName("SilverPick");
	public static final Item SilverAxe = (new ModItemAxe(5015, toolSilver)).setIconCoord(11, 1).setItemName("SilverAxe");
	public static final Item SilverShovel = (new ModItemShovel(5016, toolSilver)).setIconCoord(12,1).setItemName("SilverShovel");
	public static final Item SilverSword = (new ModItemSword(5017, toolSilver)).setIconCoord(13,1).setItemName("SilverSword");
	public static final Item SilverHoe = (new ModItemHoe(5018, toolSilver)).setIconCoord(14,1).setItemName("SilverHoe");

	public static final Item AmethystPickaxe = (new ModItemPick(5019, toolAmethyst)).setIconCoord(15,1).setItemName("AmethystPick");
	public static final Item AmethystAxe = (new ModItemAxe(5020, toolAmethyst)).setIconCoord(0, 2).setItemName("AmethystAxe");
	public static final Item AmethystShovel = (new ModItemShovel(5021, toolAmethyst)).setIconCoord(1,2).setItemName("AmethystShovel");
	public static final Item AmethystSword = (new ModItemSword(5022, toolAmethyst)).setIconCoord(2,2).setItemName("AmethystSword");
	public static final Item AmethystHoe = (new ModItemHoe(5023, toolAmethyst)).setIconCoord(3,2).setItemName("AmethystHoe");
	
	//Armor
	public static final Item CocoHelmet = (new ModItemCocoArmor(5024, COCO, 6, 0)).setIconCoord(0,3).setItemName("CocoHelmet");
	public static final Item CocoChest = (new ModItemCocoArmor(5025, COCO, 6, 1)).setIconCoord(1,3).setItemName("CocoChest");
	public static final Item CocoLegs = (new ModItemCocoArmor(5026, COCO, 6, 2)).setIconCoord(2,3).setItemName("CocoLegs");
	public static final Item CocoBoots = (new ModItemCocoArmor(5027, COCO, 6, 3)).setIconCoord(3,3).setItemName("CocoBoots");

	@Init
	public void load(FMLInitializationEvent event)
	{

		addSmelting();
		addNames();
		registerBlocks();
		setToolClass();
		addRecipes();

		//Other Shit
		proxy.registerRenderThings();

		gr.registerWorldGenerator(new WorldGeneratorCoco());

	}
	public void addRecipes()
	{
		ToolRecipes();
		ArmorRecipes();


	}

	public void ToolRecipes()
	{
		gr.addRecipe(new ItemStack(CocoPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(CocoAxe, 1), new Object[] {" II", "IS ", " S ", 'I', CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(CocoShovel, 1), new Object[] {" I ", " S ", " S ", 'I', CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(CocoSword, 1), new Object[] {" I ", " I ", " S ", 'I', CocoIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(CocoHoe, 1), new Object[] {"II ", " S ", " S ", 'I', CocoIngot, 'S', Item.stick});

		gr.addRecipe(new ItemStack(MithrilPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(MithrilAxe, 1), new Object[] {" II", "IS ", " S ", 'I', MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(MithrilShovel, 1), new Object[] {" I ", " S ", " S ", 'I', MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(MithrilSword, 1), new Object[] {" I ", " I ", " S ", 'I', MithrilIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(MithrilHoe, 1), new Object[] {"II ", " S ", " S ", 'I', MithrilIngot, 'S', Item.stick});

		gr.addRecipe(new ItemStack(SilverPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(SilverAxe, 1), new Object[] {" II", "IS ", " S ", 'I', SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(SilverShovel, 1), new Object[] {" I ", " S ", " S ", 'I', SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(SilverSword, 1), new Object[] {" I ", " I ", " S ", 'I', SilverIngot, 'S', Item.stick});
		gr.addRecipe(new ItemStack(SilverHoe, 1), new Object[] {"II ", " S ", " S ", 'I', SilverIngot, 'S', Item.stick});

		gr.addRecipe(new ItemStack(AmethystPickaxe, 1), new Object[] {"III", " S ", " S ", 'I', AmethystGem, 'S', Item.stick});
		gr.addRecipe(new ItemStack(AmethystAxe, 1), new Object[] {" II", "IS ", " S ", 'I', AmethystGem, 'S', Item.stick});
		gr.addRecipe(new ItemStack(AmethystShovel, 1), new Object[] {" I ", " S ", " S ", 'I', AmethystGem, 'S', Item.stick});
		gr.addRecipe(new ItemStack(AmethystSword, 1), new Object[] {" I ", " I ", " S ", 'I', AmethystGem, 'S', Item.stick});
		gr.addRecipe(new ItemStack(AmethystHoe, 1), new Object[] {"II ", " S ", " S ", 'I', AmethystGem, 'S', Item.stick});
	}
	public void ArmorRecipes()
	{

	}



	public void addSmelting()
	{
		gr.addSmelting(CocoStone.blockID, new ItemStack(CocoIngot, 1), 0.2F);
		gr.addSmelting(MithrilOre.blockID, new ItemStack(MithrilIngot, 1), 0.1F);
		gr.addSmelting(SilverOre.blockID, new ItemStack(SilverIngot, 1), 0.1F);
	}
	public void registerBlocks()
	{
		//Registers Blocks
		gr.registerBlock(CocoStone);
		gr.registerBlock(MithrilOre);
		gr.registerBlock(SilverOre);
		gr.registerBlock(AmethystOre);
	}
	public void addNames()
	{
		//Adds Names To Blocks
		lg.addName(CocoStone, "Coco Stone");
		lg.addName(MithrilOre, "Mithril Ore");
		lg.addName(SilverOre, "Silver Ore");
		lg.addName(AmethystOre, "Amethyst");


		//Adds Names To Items
		lg.addName(AmethystGem, "Amethyst Gem");
		lg.addName(CocoIngot, "Coco Ingot");
		lg.addName(MithrilIngot, "Mithril Ingot");
		lg.addName(SilverIngot, "Silver Ingot");

		lg.addName(CocoPickaxe, "Coco Pickaxe");
		lg.addName(CocoAxe, "Coco Axe");
		lg.addName(CocoShovel, "Coco Shovel");
		lg.addName(CocoSword, "Coco Sword");
		lg.addName(CocoHoe, "Coco Hoe");

		lg.addName(MithrilPickaxe, "Mithril Pickaxe");
		lg.addName(MithrilAxe, "Mithril Axe");
		lg.addName(MithrilShovel, "Mithril Shovel");
		lg.addName(MithrilSword, "Mithril Sword");
		lg.addName(MithrilHoe, "Mithril Hoe");

		lg.addName(SilverPickaxe, "Silver Pickaxe");
		lg.addName(SilverAxe, "Silver Axe");
		lg.addName(SilverShovel, "Silver Shovel");
		lg.addName(SilverSword, "Silver Sword");
		lg.addName(SilverHoe, "Silver Hoe");

		lg.addName(AmethystPickaxe, "Amethyst Pickaxe");
		lg.addName(AmethystAxe, "Amethyst Axe");
		lg.addName(AmethystShovel, "Amethyst Shovel");
		lg.addName(AmethystSword, "Amethyst Sword");
		lg.addName(AmethystHoe, "Amethyst Hoe");
		
		lg.addName(CocoHelmet, "Coco Helmet");
		lg.addName(CocoChest, "Coco Chestplate");
		lg.addName(CocoLegs, "Coco Legs");
		lg.addName(CocoBoots, "Coco Boots");
	}
	public void setToolClass()
	{
		MinecraftForge.setToolClass(CocoPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(CocoAxe, "axe", 3);
		MinecraftForge.setToolClass(CocoShovel, "shovel", 3);
		MinecraftForge.setToolClass(CocoSword, "sword", 3);
		MinecraftForge.setToolClass(CocoHoe, "hoe", 3);

		MinecraftForge.setToolClass(MithrilPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(MithrilAxe, "axe", 2);
		MinecraftForge.setToolClass(MithrilShovel, "shovel", 2);
		MinecraftForge.setToolClass(MithrilSword, "sword", 2);
		MinecraftForge.setToolClass(MithrilHoe, "hoe", 2);

		MinecraftForge.setToolClass(SilverPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(SilverAxe, "axe", 2);
		MinecraftForge.setToolClass(SilverShovel, "shovel", 2);
		MinecraftForge.setToolClass(SilverSword, "sword", 2);
		MinecraftForge.setToolClass(SilverHoe, "hoe", 2);

		MinecraftForge.setToolClass(AmethystPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(AmethystAxe, "axe", 3);
		MinecraftForge.setToolClass(AmethystShovel, "shovel", 3);
		MinecraftForge.setToolClass(AmethystSword, "sword", 3);
		MinecraftForge.setToolClass(AmethystHoe, "hoe", 3);
	}

	

	public static int configurationProperties(Configuration config)
	{
		CocoStoneID = Integer.parseInt(config.getOrCreateBlockIdProperty("CocoStoneID", 180).value);
		MithrilOreID = Integer.parseInt(config.getOrCreateBlockIdProperty("MithrilOreID", 181).value);
		SilverOreID = Integer.parseInt(config.getOrCreateBlockIdProperty("SilverOreID", 182).value);
		AmethystOreID = Integer.parseInt(config.getOrCreateBlockIdProperty("AmethystOreID", 183).value);
		
		
		config.save();
		return CocoStoneID;
		
	}
	
}








