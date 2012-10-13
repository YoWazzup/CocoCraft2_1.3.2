package cococraft2.common.items;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

public class ItemBookTime extends Item
{
	private static int lol;
	private static int trol;

	public ItemBookTime(int i)
	{
		super(i);
		setMaxStackSize(1);
		setMaxDamage(12);
		//setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(!MinecraftServer.getServer().theWorldServer[trol].isDaytime())
		{
			MinecraftServer.getServer().theWorldServer[trol].setTime(500);
			
			
			
			itemstack.damageItem(1, entityplayer);
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("The Time has been changed to Day!!");
			
		}
		if(MinecraftServer.getServer().theWorldServer[lol].isDaytime())
		{

			MinecraftServer.getServer().theWorldServer[lol].setTime(13000);
		
			
			itemstack.damageItem(1, entityplayer);
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("The Time has been changed to Night!!");

		}
		
		
		return itemstack;
	}
}

