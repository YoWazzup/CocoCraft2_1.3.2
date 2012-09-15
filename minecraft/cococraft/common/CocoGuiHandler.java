/**
package cococraft.common;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cococraft.client.machine.GuiCrusher;
import cococraft.common.machine.ContainerCrusher;
import cococraft.common.machine.TileEntityCrusher;
import cpw.mods.fml.common.network.IGuiHandler;

public class CocoGuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);

		if(tile instanceof TileEntityCrusher)
		{
			return new ContainerCrusher(player.inventory, (TileEntityCrusher) tile);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);

		if(tile instanceof TileEntityCrusher)
		{
			return new GuiCrusher(player.inventory, (TileEntityCrusher) tile);
		}
		return null;
	}
}
**/