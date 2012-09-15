package cococraft2.common.items;

import java.io.File;

import cococraft2.common.CocoCraft2;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
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
	
	
	//Instances for the items
	public static Item AmethystGem;
	public static Item CocoIngot;
	public static Item MithrilIngot;
	public static Item SilverIngot;
	
	
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
		
		//Adds the names for items
		lg.addName(AmethystGem, "Amethyst Gem");
		lg.addName(CocoIngot, "Coco Ingot");
		lg.addName(MithrilIngot, "Mithril Ingot");
		lg.addName(SilverIngot, "Silver Ingot");
		
		
	}
	public static int configProperties(Configuration config)
	{
		config.load();
		
		AmethystGemID = config.getOrCreateIntProperty("AmethystGemID", "item", 15000).getInt();
		CocoIngotID = config.getOrCreateIntProperty("CocoIngotID", "item", 15001).getInt();
		MithrilIngotID = config.getOrCreateIntProperty("MithrilIngotID", "item", 15002).getInt();
		SilverIngotID = config.getOrCreateIntProperty("SilverIngotID", "item", 15003).getInt();
		
			
		config.save();
		return AmethystGemID;
	}
	
}
