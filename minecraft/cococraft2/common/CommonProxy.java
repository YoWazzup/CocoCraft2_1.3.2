package cococraft2.common;

import cococraft2.client.machine.GuiCrusher;
import cococraft2.common.machine.ContainerCrusher;
import cococraft2.common.machine.TileEntityCrusher;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{

	public static String BlockTex = "/CC/Blocks.png";
	public static String ItemTex = "/CC/Items.png";

	public static String CocoArmor1 = "CC/Armor/coco_1.png";
	public static String CocoArmor2 = "CC/Armor/coco_2.png";
	
	public static int CrusherSide = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CrusherSide.png");
	public static int CrusherFront = ModLoader.addOverride("/terrain.png", "/CC/Blocks/CrusherFront.png");

	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture(BlockTex);
		MinecraftForgeClient.preloadTexture(ItemTex);
		MinecraftForgeClient.preloadTexture(CocoArmor1);
		MinecraftForgeClient.preloadTexture(CocoArmor2);
	}


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch(ID)
			{
			case 5: return new ContainerCrusher(player.inventory, ((TileEntityCrusher)tileEntity));

			}

		}
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch(ID)
			{
			case 5: return new GuiCrusher(player.inventory, ((TileEntityCrusher)tileEntity));

			}

		}
		return null;
	}

}
