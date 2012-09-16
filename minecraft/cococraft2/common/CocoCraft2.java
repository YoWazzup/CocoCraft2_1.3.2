package cococraft2.common;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cococraft2.common.blocks.CocoCraftBlocks;
import cococraft2.common.items.CocoCraftItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

	

@Mod(modid = "CocoCraft2", name = "CocoCraft2", version = "1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class CocoCraft2 
{
	public static CocoCraftItems items;
	public static CocoCraftBlocks blocks;
	
	
	
	
	@SidedProxy(clientSide = "cococraft2.client.ClientProxy", serverSide = "cococraft2.common.ClientProxy")
	public static CommonProxy proxy;
	
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		CocoCraftBlocks.init();
		CocoCraftItems.init();
		CocoRecipes.init();
		
		GameRegistry.registerWorldGenerator(new WorldGenerator());
		
		addSmelting();
		setToolClass();
		
	}
	public void addSmelting()
	{
		addMetaSmelting(blocks.Ore.blockID, 0, new ItemStack(items.CocoIngot));
		addMetaSmelting(blocks.Ore.blockID, 1, new ItemStack(items.MithrilIngot));
		addMetaSmelting(blocks.Ore.blockID, 2, new ItemStack(items.SilverIngot));
		
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
	
}
