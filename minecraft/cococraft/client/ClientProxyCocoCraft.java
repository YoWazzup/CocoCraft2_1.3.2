package cococraft.client;

import cococraft.common.CommonProxyCocoCraft;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyCocoCraft extends CommonProxyCocoCraft{

	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/CC/Blocks.png");
		MinecraftForgeClient.preloadTexture("/CC/Items.png");
		
	}
}
