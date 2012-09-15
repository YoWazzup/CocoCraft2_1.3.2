package cococraft2.common;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
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
		
	}
	public void addSmelting()
	{
		addMetaSmelting(blocks.Ore.blockID, 0, new ItemStack(items.CocoIngot));
		addMetaSmelting(blocks.Ore.blockID, 1, new ItemStack(items.MithrilIngot));
		addMetaSmelting(blocks.Ore.blockID, 2, new ItemStack(items.SilverIngot));
		
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
