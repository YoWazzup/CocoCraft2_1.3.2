package cococraft.common;

import cococraft.common.blocks.ModBlockOre;
import cococraft.common.items.ModItem;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
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

	@SidedProxy(clientSide = "cococraft.client.ClientProxyCocoCraft", serverSide = "cococraft.common.CommonProxyCocoCraft")
	public static CommonProxyCocoCraft proxy;
	public static GameRegistry gr;
	public static LanguageRegistry lg;

	//Blocks
	public static final Block CocoStone = (new ModBlockOre(230, 0)).setBlockName("CocoStone").setResistance(2F).setHardness(2F);
	public static final Block MithrilOre = (new ModBlockOre(231, 1)).setBlockName("MithrilORe").setResistance(2F).setHardness(2F);
	public static final Block SilverOre = (new ModBlockOre(232, 2)).setBlockName("SilverOre").setResistance(2F).setHardness(2F);
	public static final Block AmethystOre = (new ModBlockOre(233, 3)).setBlockName("Amethyst").setResistance(2F).setHardness(2F);

	
	//Items
	public static final Item AmethystGem = (new ModItem(5000)).setItemName("AmethystGem").setIconCoord(0,0);
	public static final Item CocoIngot = (new ModItem(5001)).setItemName("CocoIngot").setIconCoord(0, 1);
	public static final Item MithrilIngot = (new ModItem(5002)).setItemName("MithrilIngot").setIconCoord(0, 2);
	public static final Item SilverIngot = (new ModItem(5003)).setItemName("SilverIngot").setIconCoord(0, 3);
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		//Registers Blocks
		gr.registerBlock(CocoStone);
		gr.registerBlock(MithrilOre);
		gr.registerBlock(SilverOre);
		gr.registerBlock(AmethystOre);

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
		
		
		//Other Shit
		proxy.registerRenderThings();
		gr.registerWorldGenerator(new WorldGeneratorCoco());
	}
}