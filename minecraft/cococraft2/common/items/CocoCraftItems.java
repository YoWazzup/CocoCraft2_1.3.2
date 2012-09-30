package cococraft2.common.items;

import java.io.File;

import cococraft2.common.CocoCraft2;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CocoCraftItems 
{
	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "/CocoCraft2/CocoCraft2Items.cfg"));


	//Sets Item IDs	
	public static int IngotsID;
	public static int CocoPickaxeID, CocoAxeID, CocoShovelID, CocoSwordID, CocoHoeID = configProperties(config);
	public static int MithrilPickaxeID, MithrilAxeID, MithrilShovelID, MithrilSwordID, MithrilHoeID;
	public static int SilverPickaxeID, SilverAxeID, SilverShovelID, SilverSwordID,SilverHoeID;
	public static int CocoHelmetID ,CocoChestID, CocoLegsID, CocoBootsID;
	public static int CatalystID;

	//Instances for the items
	public static Item CocoPickaxe, CocoAxe, CocoShovel, CocoSword, CocoHoe;
	public static Item MithrilPickaxe, MithrilAxe, MithrilShovel, MithrilSword, MithrilHoe;
	public static Item SilverPickaxe, SilverAxe, SilverShovel, SilverSword, SilverHoe;
	public static Item CocoHelmet, CocoChest, CocoLegs, CocoBoots;

	public static Item Ingots;

	
	//Shortened shit
	public static GameRegistry gr;
	public static LanguageRegistry lg;
	public static CocoCraft2 cc2;


	public static void init()
	{
		//inits the items
		Ingots = new ItemIngot(IngotsID).setItemName("Ingots");

		CocoPickaxe = new ModPickaxe(CocoPickaxeID, cc2.Coco).setItemName("CocoPickaxe").setIconCoord(0,1);
		CocoAxe = new ModAxe(CocoAxeID, cc2.Coco).setItemName("CocoAxe").setIconCoord(1,1);
		CocoShovel = new ModShovel(CocoShovelID, cc2.Coco).setItemName("CocoShovel").setIconCoord(2,1);
		CocoSword = new ModSword(CocoSwordID, cc2.Coco).setItemName("CocoSword").setIconCoord(3,1);
		CocoHoe = new ModHoe(CocoHoeID, cc2.Coco).setItemName("CocoHoe").setIconCoord(4,1);

		MithrilPickaxe = new ModPickaxe(MithrilPickaxeID, cc2.Mithril).setItemName("MithrilPickaxe").setIconCoord(5,1);
		MithrilAxe = new ModAxe(MithrilAxeID, cc2.Mithril).setItemName("MithrilAxe").setIconCoord(6,1);
		MithrilShovel = new ModShovel(MithrilShovelID, cc2.Mithril).setItemName("MithrilShovel").setIconCoord(7,1);
		MithrilSword = new ModSword(MithrilSwordID, cc2.Mithril).setItemName("MithrilSword").setIconCoord(8,1);
		MithrilHoe = new ModHoe(MithrilHoeID, cc2.Mithril).setItemName("MithrilHoe").setIconCoord(9,1);

		SilverPickaxe = new ModPickaxe(SilverPickaxeID, cc2.Silver).setItemName("SilverPickaxe").setIconCoord(10,1);
		SilverAxe = new ModAxe(SilverAxeID, cc2.Silver).setItemName("SilverAxe").setIconCoord(11,1);
		SilverShovel = new ModShovel(SilverShovelID, cc2.Silver).setItemName("SilverShovel").setIconCoord(12,1);
		SilverSword = new ModSword(SilverSwordID, cc2.Silver).setItemName("SilverSword").setIconCoord(13,1);
		SilverHoe = new ModHoe(SilverHoeID, cc2.Silver).setItemName("SilverHoe").setIconCoord(14,1);

		CocoHelmet = new ItemCocoArmor(CocoHelmetID, cc2.COCO, ModLoader.addArmor("Coco"), 0).setIconCoord(0,3).setItemName("CocoHelmet");
		CocoChest = new ItemCocoArmor(CocoChestID, cc2.COCO,  ModLoader.addArmor("Coco"), 1).setIconCoord(1,3).setItemName("CocoChest");
		CocoLegs = new ItemCocoArmor(CocoLegsID, cc2.COCO,  ModLoader.addArmor("Coco"), 2).setIconCoord(2,3).setItemName("CocoLegs");
		CocoBoots = new ItemCocoArmor(CocoBootsID, cc2.COCO,  ModLoader.addArmor("Coco"), 3).setIconCoord(3,3).setItemName("CocoBoots");

		
		//Adds the names for items

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

		lg.addName(CocoHelmet, "Coco Helmet");
		lg.addName(CocoChest, "Coco Chest");
		lg.addName(CocoLegs, "Coco Legs");
		lg.addName(CocoBoots, "Coco Boots");

		lg.addName(new ItemStack(Ingots,1,0), "Coco Ingot");
		lg.addName(new ItemStack(Ingots,1,1), "Mithril Ingot");
		lg.addName(new ItemStack(Ingots,1,2), "Silver Ingot");
		lg.addName(new ItemStack(Ingots,1,3), "Amethyst Gem");
		lg.addName(new ItemStack(Ingots,1,4), "Dragonstone Shard");
		lg.addName(new ItemStack(Ingots,1,5), "Diamond Stick");
		lg.addName(new ItemStack(Ingots,1,6), "Coal Dust");
		lg.addName(new ItemStack(Ingots,1,7), "Iron Dust");
		lg.addName(new ItemStack(Ingots,1,8), "Gold Dust");
		lg.addName(new ItemStack(Ingots,1,9), "Mithril Dust");
		lg.addName(new ItemStack(Ingots,1,10), "Silver Dust");
		lg.addName(new ItemStack(Ingots,1,11), "Magic Dust");
		lg.addName(new ItemStack(Ingots,1,12), "Obsidian Dust");
		lg.addName(new ItemStack(Ingots,1,13), "Obsidian Ingot");
		lg.addName(new ItemStack(Ingots,1,14), "Unworked Steel");
		lg.addName(new ItemStack(Ingots,1,15), "Steel Ingot");
		
		
		



	}
	public static int configProperties(Configuration config)
	{
		config.load();

		IngotsID = config.getOrCreateIntProperty("IngotsAndStufIDs", "item", 15000).getInt();

		CocoPickaxeID = config.getOrCreateIntProperty("CocoPickaxeID", "item", 15004).getInt();
		CocoAxeID = config.getOrCreateIntProperty("CocoAxeID", "item", 15005).getInt();
		CocoShovelID = config.getOrCreateIntProperty("CocoShovelID", "item", 15006).getInt();
		CocoSwordID = config.getOrCreateIntProperty("CocoSwordID", "item", 15007).getInt();
		CocoHoeID = config.getOrCreateIntProperty("CocoHoeID", "item", 15008).getInt();

		MithrilPickaxeID = config.getOrCreateIntProperty("MithrilPickaxeID", "item", 15009).getInt();
		MithrilAxeID = config.getOrCreateIntProperty("MithrilAxeID", "item", 15010).getInt();
		MithrilShovelID = config.getOrCreateIntProperty("MithrilShovelID", "item", 15011).getInt();
		MithrilSwordID = config.getOrCreateIntProperty("MithrilSwordID", "item", 15012).getInt();
		MithrilHoeID = config.getOrCreateIntProperty("MithrilHoeID", "item", 15013).getInt();

		SilverPickaxeID = config.getOrCreateIntProperty("SilverPickaxeID", "item", 15014).getInt();
		SilverAxeID = config.getOrCreateIntProperty("SilverAxeID", "item", 15015).getInt();
		SilverShovelID = config.getOrCreateIntProperty("SilverShovelID", "item", 15016).getInt();
		SilverSwordID = config.getOrCreateIntProperty("SilverSwordID", "item", 15017).getInt();
		SilverHoeID = config.getOrCreateIntProperty("SilverHoeID", "item", 15018).getInt();

		CocoHelmetID = config.getOrCreateIntProperty("CocoHelmetID", "item", 15019).getInt();
		CocoChestID = config.getOrCreateIntProperty("CocoChestID", "item", 15020).getInt();
		CocoLegsID = config.getOrCreateIntProperty("CocoLegsID", "item", 15021).getInt();
		CocoBootsID = config.getOrCreateIntProperty("CocoBootsID", "item", 15022).getInt();
		
		

		config.save();
		return CocoHoeID;
	}

}
