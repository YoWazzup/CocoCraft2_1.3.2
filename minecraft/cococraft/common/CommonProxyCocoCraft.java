package cococraft.common;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cococraft.client.ClientProxyCocoCraft;
import cococraft.client.machine.GuiCrusher;
import cococraft.common.machine.ContainerCrusher;
import cococraft.common.machine.TileEntityCrusher;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxyCocoCraft implements IGuiHandler
{
	
	
	public void registerRenderThings()
	{
	
	}
	public void initTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityCrusher.class, "Crusher");
	}
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		
		if(ID == 0)
		{
			return new ContainerCrusher(player.inventory, ((TileEntityCrusher)tile));
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		
		if(ID == 0)
		{
			return new GuiCrusher(player.inventory, ((TileEntityCrusher)tile));
		}
		return null;
	}
}
