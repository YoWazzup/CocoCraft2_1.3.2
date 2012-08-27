package cococraft.common.blocks;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ModItemOre extends ItemBlock{

	public ModItemOre(int i, Block block) {
		super(i);
		setHasSubtypes(true);
	}
	public int getMetadata(int par1)
	{
		return par1;
	}
	public String getItemNameIS(ItemStack itemstack)
	{
		String name = "";
		switch(itemstack.getItemDamage())
		{
		case 0:
		{
			name = "cocoStone";
			break;
		}
		case 1:
		{
			name = "mithrilOre";
			break;
		}
		case 2:
		{
			name = "silverOre";
			break;
		}
		case 3:
		{
			name = "amethystOre";
			break;
		}
		default: name = "cocoStone";
		}
		return getItemName() + "." + name;
	}

}
