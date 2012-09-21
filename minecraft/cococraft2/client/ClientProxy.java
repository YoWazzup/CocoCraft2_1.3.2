package cococraft2.client;

import net.minecraftforge.client.MinecraftForgeClient;
import cococraft2.common.CommonProxy;

public class ClientProxy extends CommonProxy 
{
	//public static String BlockTex = "/CC/Blocks.png";
	//public static String ItemTex = "/CC/Items.png";
	public static String CocoArmor1 = "CC/Armor/coco_1.png";
	public static String CocoArmor2 = "CC/Armor/coco_2.png";
	
	
	public void registerRenderThing()
	{
		//MinecraftForgeClient.preloadTexture(BlockTex);
		//MinecraftForgeClient.preloadTexture(ItemTex);
		MinecraftForgeClient.preloadTexture(CocoArmor1);
		MinecraftForgeClient.preloadTexture(CocoArmor2);
	}

	
}
