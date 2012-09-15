package cococraft2.client;

import net.minecraftforge.client.MinecraftForgeClient;
import cococraft2.common.*;

public class ClientProxy extends CommonProxy
{
	public static String BlockTex = "/CC/Blocks.png";
	public static String ItemTex = "/CC/Items.png";
	
	public void registerRenderThing()
	{
		MinecraftForgeClient.preloadTexture(BlockTex);
		MinecraftForgeClient.preloadTexture(ItemTex);
	}
}
