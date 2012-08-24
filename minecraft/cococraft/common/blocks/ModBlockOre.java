package cococraft.common.blocks;

import java.util.Random;

import cococraft.common.CocoCraft;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class ModBlockOre extends Block{

	private static CocoCraft cc;
	
	public ModBlockOre(int i, int j)
	{
		super(i, j, Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	public String getTextureFile()
	{
		return "/CC/Blocks.png";
	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == cc.AmethystOre.blockID ? cc.AmethystGem.shiftedIndex : (this.blockID == cc.CocoStone.blockID ? cc.CocoStone.blockID : (this.blockID == cc.MithrilOre.blockID ? cc.MithrilOre.blockID : (this.blockID == cc.SilverOre.blockID ? cc.SilverOre.blockID : this.blockID)));
    }
}
