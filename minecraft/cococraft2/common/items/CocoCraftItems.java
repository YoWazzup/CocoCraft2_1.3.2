package cococraft2.common.items;

import java.io.File;

import cococraft2.common.CocoCraft2;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CocoCraftItems 
{
	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "/CocoCraft2/CocoCraft2Items.cfg"));
	
	
	//Sets Item IDs	
	public static int AmethystGemID = configProperties(config);
	public static int CocoIngotID;
	public static int MithrilIngotID;
	public static int SilverIngotID;
	
	public static int CocoPickaxeID;
	public static int CocoAxeID;
	public static int CocoShovelID;
	public static int CocoSwordID;
	public static int CocoHoeID;
	
	public static int MithrilPickaxeID;
	public static int MithrilAxeID;
	public static int MithrilShovelID;
	public static int MithrilSwordID;
	public static int MithrilHoeID;
	
	public static int SilverPickaxeID;
	public static int SilverAxeID;
	public static int SilverShovelID;
	public static int SilverSwordID;
	public static int SilverHoeID;
	
	//Instances for the items
	public static Item AmethystGem;
	public static Item CocoIngot;
	public static Item MithrilIngot;
	public static Item SilverIngot;
	
	public static Item CocoPickaxe;
	public static Item CocoAxe;
	public static Item CocoShovel;
	public static Item CocoSword;
	public static Item CocoHoe;
	
	public static Item MithrilPickaxe;
	public static Item MithrilAxe;
	public static Item MithrilShovel;
	public static Item MithrilSword;
	public static Item MithrilHoe;
	
	public static Item SilverPickaxe;
	public static Item SilverAxe;
	public static Item SilverShovel;
	public static Item SilverSword;
	public static Item SilverHoe;
	
	static EnumToolMaterial Coco = EnumHelper.addToolMaterial("COCO", 2, 2500, 15F, 13, 8);
	static EnumToolMaterial Mithril = EnumHelper.addToolMaterial("MITHRIL", 2, 650, 9F, 7, 4);
	static EnumToolMaterial Silver = EnumHelper.addToolMaterial("SILVER", 2, 451, 7F, 8, 3);
	static EnumToolMaterial Amethyst = EnumHelper.addToolMaterial("AMETHYSY", 2, 3334, 15F, 15, 12);
	static EnumToolMaterial Steel = EnumHelper.addToolMaterial("STEEL", 2, 998, 7F, 8, 16);
	
	//Shortened shit
	public static GameRegistry gr;
	public static LanguageRegistry lg;
	

	public static void init()
	{
		//inits the items
		AmethystGem = new ModItem(AmethystGemID).setItemName("AmethystGem").setIconCoord(0,0);
		CocoIngot = new ModItem(CocoIngotID).setItemName("CocoIngot").setIconCoord(1,0);
		MithrilIngot = new ModItem(MithrilIngotID).setItemName("MithrilIngot").setIconCoord(2,0);
		SilverIngot = new ModItem(SilverIngotID).setItemName("SilverIngot").setIconCoord(3,0);	
		
		CocoPickaxe = new ModPickaxe(CocoPickaxeID, Coco).setItemName("CocoPickaxe").setIconCoord(0,1);
		CocoAxe = new ModAxe(CocoAxeID, Coco).setItemName("CocoAxe").setIconCoord(1,1);
		CocoShovel = new ModShovel(CocoShovelID, Coco).setItemName("CocoShovel").setIconCoord(2,1);
		CocoSword = new ModSword(CocoSwordID, Coco).setItemName("CocoSword").setIconCoord(3,1);
		CocoHoe = new ModHoe(CocoHoeID, Coco).setItemName("CocoHoe").setIconCoord(4,1);
		
		MithrilPickaxe = new ModPickaxe(MithrilPickaxeID, Mithril).setItemName("MithrilPickaxe").setIconCoord(5,1);
		MithrilAxe = new ModAxe(MithrilAxeID, Mithril).setItemName("MithrilAxe").setIconCoord(6,1);
		MithrilShovel = new ModShovel(MithrilShovelID, Mithril).setItemName("MithrilShovel").setIconCoord(7,1);
		MithrilSword = new ModSword(MithrilSwordID, Mithril).setItemName("MithrilSword").setIconCoord(8,1);
		MithrilHoe = new ModHoe(MithrilHoeID, Mithril).setItemName("MithrilHoe").setIconCoord(9,1);
		
		SilverPickaxe = new ModPickaxe(SilverPickaxeID, Silver).setItemName("SilverPickaxe").setIconCoord(10,1);
		SilverAxe = new ModAxe(SilverAxeID, Silver).setItemName("SilverAxe").setIconCoord(11,1);
		SilverShovel = new ModShovel(SilverShovelID, Silver).setItemName("SilverShovel").setIconCoord(12,1);
		SilverSword = new ModSword(SilverSwordID, Silver).setItemName("SilverSword").setIconCoord(13,1);
		SilverHoe = new ModHoe(SilverHoeID, Silver).setItemName("SilverHoe").setIconCoord(14,1);
		
		
		//Adds the names for items
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
		
	}
	public static int configProperties(Configuration config)
	{
		config.load();
		
		AmethystGemID = config.getOrCreateIntProperty("AmethystGemID", "item", 15000).getInt();
		CocoIngotID = config.getOrCreateIntProperty("CocoIngotID", "item", 15001).getInt();
		MithrilIngotID = config.getOrCreateIntProperty("MithrilIngotID", "item", 15002).getInt();
		SilverIngotID = config.getOrCreateIntProperty("SilverIngotID", "item", 15003).getInt();
		
		CocoPickaxeID = config.getOrCreateIntProperty("CocoPickaxeID", "item", 15004).getInt();
		CocoAxeID = config.getOrCreateIntProperty("CocoAxeID", "item", 15005).getInt();
		CocoShovelID = config.getOrCreateIntProperty("CocoShovelID", "item", 15006).getInt();
		CocoSwordID = config.getOrCreateIntProperty("CocoSwordID", "item", 15007).getInt();
		CocoHoeID = config.getOrCreateIntProperty("CocohoeID", "item", 15008).getInt();
		
		MithrilPickaxeID = config.getOrCreateIntProperty("MithrilPickaxeID", "item", 15009).getInt();
		MithrilAxeID = config.getOrCreateIntProperty("MithrilAxeID", "item", 15010).getInt();
		MithrilShovelID = config.getOrCreateIntProperty("MithrilShovelID", "item", 15011).getInt();
		MithrilSwordID = config.getOrCreateIntProperty("MithrilSwordID", "item", 15012).getInt();
		MithrilHoeID = config.getOrCreateIntProperty("MithrilhoeID", "item", 15013).getInt();
		
		SilverPickaxeID = config.getOrCreateIntProperty("SilverPickaxeID", "item", 15014).getInt();
		SilverAxeID = config.getOrCreateIntProperty("SilverAxeID", "item", 15015).getInt();
		SilverShovelID = config.getOrCreateIntProperty("SilverShovelID", "item", 15016).getInt();
		SilverSwordID = config.getOrCreateIntProperty("SilverSwordID", "item", 15017).getInt();
		SilverHoeID = config.getOrCreateIntProperty("SilverhoeID", "item", 15018).getInt();
		
		
			
		config.save();
		return AmethystGemID;
	}
	
}
