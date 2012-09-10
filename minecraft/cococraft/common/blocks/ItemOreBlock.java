package cococraft.common.blocks;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemOreBlock extends ItemBlock
{

	public ItemOreBlock(int i, Block block)
	{
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
			name = "cocoBlock";
			break;
		}
		case 1:
		{
			name = "mithrilBlock";
			break;
		}
		case 2:
		{
			name = "silverBlock";
			break;
		}
		case 3:
		{
			name = "amethystBlock";
			break;
		}
		case 4:
		{
			name = "superStone";
			break;
		}
		default : name = "cocoBlock";
		}
		return getItemName() + "." + name;
	}
	
}
