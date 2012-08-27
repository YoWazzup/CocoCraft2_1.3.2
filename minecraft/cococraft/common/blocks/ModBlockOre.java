package cococraft.common.blocks;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class ModBlockOre extends Block
{

	public ModBlockOre(int par1, int par2) 
	{
		super(par1, par2, Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setRequiresSelfNotify();
	}
	public String getTextureFile()
	{
		return "/CC/Blocks.png";
	}
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par2)
		{
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		default:
			return 0;
		}
	}
	protected int damageDropped(int par1)
	{
		return par1;
	}
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 4; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}