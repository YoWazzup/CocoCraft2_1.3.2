package cococraft.client;

import net.minecraftforge.client.MinecraftForgeClient;
import cococraft.common.CommonProxyCocoCraft;

public class ClientProxyCocoCraft extends CommonProxyCocoCraft
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/CC/Blocks.png");
		MinecraftForgeClient.preloadTexture("/CC/Items.png");
	}
}
