package cococraft2.common;

import cococraft2.common.blocks.CocoCraftBlocks;
import cococraft2.common.items.CocoCraftItems;
import net.minecraft.src.Achievement;
import net.minecraft.src.AchievementList;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class AchievementHandler implements ICraftingHandler
{
	public static CocoCraftItems cci;
	public static CocoCraftBlocks ccb;
	public static LanguageRegistry lg;

	//static final Achievement TimeAchieve = new Achievement(2001, "TimeAchieve", 1, -2, TimeMachine, AchievementLib.blazeRod).registerAchievement();

	static final Achievement SmeltedCoco = new Achievement(1700, "SmeltedCoco", 1, -2,  new ItemStack(cci.Ingots, 0), AchievementList.buildPickaxe).registerAchievement();

	
	@Init
	public static void init()
	{
		
	}

	private static void addAchievementName(String ach, String name)
	{
		lg.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}

	private static void addAchievementDesc(String ach, String desc)
	{
		lg.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}
	static void addAchievementLocalizations()
	{
		addAchievementName("SmeltedCoco", "Smelted Coco");
		addAchievementDesc("SmeltedCoco", "You Finally Got The Good Shit!");
	}

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(item.itemID == cci.CocoPickaxe.shiftedIndex)
		{
			player.addStat(SmeltedCoco, 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		if(item.itemID == cci.Ingots.shiftedIndex && item.getItemDamage() == 0)
		{
			player.addStat(SmeltedCoco, 1);
		}
	}

}
