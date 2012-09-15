package cococraft2.common.blocks;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockOreBlock extends ItemBlock
{
	public ItemBlockOreBlock(int i, Block block)
	{
		super(i);
		setHasSubtypes(true);
	}
	
	public int getMetadata(int i)
	{
		return i;
	}
	
	public String getItemNameIS(ItemStack item)
	{
		String name  = "";

		switch(item.getItemDamage())
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
		default: name = "cocoBlock";
		}
		return getItemName() + "." + name;
	}
}
