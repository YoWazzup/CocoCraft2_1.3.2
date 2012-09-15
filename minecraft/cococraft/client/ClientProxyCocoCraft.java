package cococraft.client;

import cococraft.client.machine.GuiCrusher;
import cococraft.common.CocoCraft;
import cococraft.common.CommonProxyCocoCraft;
import cococraft.common.machine.ContainerCrusher;
import cococraft.common.machine.TileEntityCrusher;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyCocoCraft extends CommonProxyCocoCraft
{

	public static int CrusherSide = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CrusherSide.png");
	public static int CrusherFront = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CrusherFront.png");

	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/CC/Blocks.png");
		MinecraftForgeClient.preloadTexture("/CC/Items.png");


	}

	
}
