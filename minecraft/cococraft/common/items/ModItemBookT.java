package cococraft.common.items;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

public class ModItemBookT extends Item
{
	
	public int switcher = 0;
	public String changed = "Changed";

	public ModItemBookT(int i)
	{
		super(i);
		maxStackSize = 1;
		setMaxDamage(20);
		this.setTabToDisplayOn(CreativeTabs.tabTools);
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		world.getWorldTime();
		
		
		if(switcher == 0)
		{
			ModLoader.getMinecraftInstance().theWorld.setWorldTime(0);
			
			changed = "Day";
			switcher = 1;
			itemstack.damageItem(1, entityplayer);
		}
		if(switcher == 1)
		{
			ModLoader.getMinecraftInstance().theWorld.setWorldTime(10000);
			changed = "Night";
			switcher = 0;
			itemstack.damageItem(1, entityplayer);
		}
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("The Time has been changed to " + changed + " !");
		return itemstack;
	}
	
	public void addInformation(ItemStack item, List list)
	{
		list.add("Changes The Time");
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}
	
	
	
}
