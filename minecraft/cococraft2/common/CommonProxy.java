package cococraft2.common;

import cococraft2.client.machine.GuiBlastFurnace;
import cococraft2.client.machine.GuiCompressor;
import cococraft2.client.machine.GuiCrusher;
import cococraft2.common.machine.ContainerBlastFurnace;
import cococraft2.common.machine.ContainerCompressor;
import cococraft2.common.machine.ContainerCrusher;
import cococraft2.common.machine.TileEntityBlastFurnace;
import cococraft2.common.machine.TileEntityCompressor;
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
			case 6: return new ContainerCompressor(player.inventory, ((TileEntityCompressor)tileEntity));
			case 7: return new ContainerBlastFurnace(player.inventory, ((TileEntityBlastFurnace)tileEntity));

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
			case 6: return new GuiCompressor(player.inventory, ((TileEntityCompressor)tileEntity));
			case 7: return new GuiBlastFurnace(player.inventory, ((TileEntityBlastFurnace)tileEntity));

			}

		}
		return null;
	}

}
