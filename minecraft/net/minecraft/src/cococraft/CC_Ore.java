package net.minecraft.src.cococraft;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_Ore extends Block implements ITextureProvider{

	
	public CC_Ore(int i, int j)
	{
		super(i, j ,Material.iron);
	}
	@Override
	public String getTextureFile()
	{
		return mod_CocoCraft.BlockPNG;
	}
	public int idDropped(int i, Random rand, int j, mod_CocoCraft mod)
	{
		return this.blockID == mod.CocoStone.blockID ? mod.CocoStone.blockID : (this.blockID == mod.MithrilOre.blockID ? mod.MithrilOre.blockID : (this.blockID == mod.SilverOre.blockID ? mod.SilverOre.blockID : (this.blockID == mod.Amethyst.blockID ? mod.AmethystGem.shiftedIndex : this.blockID)));										
	}
	public int quantityDropped()
	{
		return 1;
	}
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}
}
