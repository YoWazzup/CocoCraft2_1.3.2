package cococraft2.common;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cococraft2.common.blocks.CocoCraftBlocks;
import cococraft2.common.items.CocoCraftItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

	

@Mod(modid = "CocoCraft2", name = "CocoCraft2", version = "1.0 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class CocoCraft2 
{
	public static CocoCraftItems items;
	public static CocoCraftBlocks blocks;
	
	//Defines Tool Materials
	public static EnumToolMaterial Coco = EnumHelper.addToolMaterial("COCO", 2, 2500, 15F, 13, 8);
	public static EnumToolMaterial Mithril = EnumHelper.addToolMaterial("MITHRIL", 2, 650, 9F, 7, 4);
	public static EnumToolMaterial Silver = EnumHelper.addToolMaterial("SILVER", 2, 451, 7F, 8, 3);
	public static EnumToolMaterial Amethyst = EnumHelper.addToolMaterial("AMETHYSY", 2, 3334, 15F, 15, 12);
	public static EnumToolMaterial Steel = EnumHelper.addToolMaterial("STEEL", 2, 998, 7F, 8, 16);

	//Defines Armor Materials
	public static EnumArmorMaterial COCO = EnumHelper.addArmorMaterial("COCO", 48, new int[]{4, 8, 6, 2}, 4);
	public static EnumArmorMaterial MITHRIL = EnumHelper.addArmorMaterial("MITHRIL", 22, new int[] {2, 5, 4, 2}, 5);
	public static EnumArmorMaterial SILVER = EnumHelper.addArmorMaterial("SILVER", 26, new int[] {3, 6, 5, 3}, 5);
	public static EnumArmorMaterial AMETHYST = EnumHelper.addArmorMaterial("AMETHYST", 36, new int[] {3, 6, 6, 2}, 5);

	@Instance
	public static CocoCraft2 instance;
	
	@SidedProxy(clientSide = "cococraft2.client.ClientProxy", serverSide = "cococraft2.common.ClientProxy")
	public static CommonProxy proxy;
	
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		NetworkRegistry.instance().registerGuiHandler(this, this.proxy);
		
		CocoCraftBlocks.init();
		CocoCraftItems.init();
		CocoRecipes.init();
		
		GameRegistry.registerWorldGenerator(new WorldGenerator());
		
		
		addSmelting();
		setToolClass();
		
	}
	public void addSmelting()
	{
		
		addMetaSmelting(blocks.Ore.blockID, 0, new ItemStack(items.Ingots, 1, 0));
		addMetaSmelting(blocks.Ore.blockID, 1, new ItemStack(items.Ingots, 1, 1));
		addMetaSmelting(blocks.Ore.blockID, 2, new ItemStack(items.Ingots, 1, 2));
		
	}
	
	public void setToolClass()
	{
		MinecraftForge.setToolClass(items.CocoPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(items.CocoAxe, "axe", 2);
		MinecraftForge.setToolClass(items.CocoShovel, "shovel", 2);
		MinecraftForge.setToolClass(items.CocoSword, "sword", 2);
		MinecraftForge.setToolClass(items.CocoHoe, "hoe", 2);
		
		MinecraftForge.setToolClass(items.MithrilPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(items.MithrilAxe, "axe", 2);
		MinecraftForge.setToolClass(items.MithrilShovel, "shovel", 2);
		MinecraftForge.setToolClass(items.MithrilSword, "sword", 2);
		MinecraftForge.setToolClass(items.MithrilHoe, "hoe", 2);
		
		MinecraftForge.setToolClass(items.SilverPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(items.SilverAxe, "axe", 2);
		MinecraftForge.setToolClass(items.SilverShovel, "shovel", 2);
		MinecraftForge.setToolClass(items.SilverSword, "sword", 2);
		MinecraftForge.setToolClass(items.SilverHoe, "hoe", 2);
		
	}
	/**
	 * 
	 * @param input
	 * @param meta
	 * @param output
	 */
	public static void addMetaSmelting(int input, int meta, ItemStack output)
	{
		FurnaceRecipes.smelting().addSmelting(input, meta, output);
	}
	/**
	 * 
	 * @param input input
	 * @param meta the metadata 
	 * @param output output
	 */
	//public static void addMetaCrushing(int input, int meta, ItemStack output)
	//{
	//	CrusherRecipes.crushing().addMetaCrushing(input, meta, output);
	//}
	
}
