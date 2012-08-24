package cococraft.common.blocks;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class ModBlockOre extends Block{

	public ModBlockOre(int i, int j)
	{
		super(i, j, Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	public String getTextureFile()
	{
		return "/CC/Blocks.png";
	}
}
