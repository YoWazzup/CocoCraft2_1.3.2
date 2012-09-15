package cococraft2.common;

import net.minecraftforge.client.MinecraftForgeClient;

public class CommonProxy
{
	public static String BlockTex = "/CC/Blocks.png";
	public static String ItemTex = "/CC/Items.png";
	
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture(BlockTex);
		MinecraftForgeClient.preloadTexture(ItemTex);
	}
}
