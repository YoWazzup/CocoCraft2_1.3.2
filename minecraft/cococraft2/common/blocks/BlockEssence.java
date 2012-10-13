package cococraft2.common.blocks;

import java.util.List;
import java.util.Random;

import cococraft2.common.CommonProxy;
import cococraft2.common.items.CocoCraftItems;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockEssence extends Block
{
	private static CocoCraftItems cci;

	public BlockEssence(int i, int j)
	{
		super(i, j, Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		setRequiresSelfNotify();
	}
	public String getTextureFile()
	{
		return CommonProxy.BlockTex;
	}
	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		switch(j)
		{
		case 0 : return 9;
		case 1 : return 9;
		case 2 : return 9;
		case 3 : return 9;
		default : return 9;
		}
	}
	protected int damageDropped(int i)
	{
		return i;
	}
	public int idDropped(int i, Random rand, int j)
	{
		switch(i)
		{
		case 0:
			return cci.FireEssence.shiftedIndex;
		case 1:
			return cci.AirEssence.shiftedIndex;
		case 2:
			return cci.WaterEssence.shiftedIndex;
		case 3:
			return cci.EarthEssence.shiftedIndex;
			
		default : return cci.FireEssence.shiftedIndex;
		}
	}
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs tabs, List list)
	{
		for(int j = 0; j < 4; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
	}
	
}
