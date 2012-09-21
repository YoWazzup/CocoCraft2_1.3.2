package cococraft2.common.blocks;

import java.util.List;
import java.util.Random;

import cococraft2.client.ClientProxy;
import cococraft2.common.items.CocoCraftItems;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockOre extends Block
{
	public static CocoCraftItems cci;
	
	public BlockOre(int i, int j)
	{
		super(i, j, Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setRequiresSelfNotify();
	}
	
	public String getTextureFile()
	{
		return ClientProxy.BlockTex;
	}
	

	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		switch(j)
		{
		case 0 : return 0;
		case 1 : return 1;
		case 2 : return 2;
		case 3 : return 3;
		
		default : return 0;
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
			return blockID;
		case 1:
			return blockID;
		case 2:
			return blockID;
		case 3:
			return cci.Ingots.shiftedIndex;
			
		default : return blockID;
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
