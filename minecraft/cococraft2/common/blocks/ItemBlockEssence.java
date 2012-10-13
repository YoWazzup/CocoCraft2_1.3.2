package cococraft2.common.blocks;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockEssence extends ItemBlock
{

	public ItemBlockEssence(int i, Block block) {
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
			name = "fireEssence";
			break;
		}
		case 1:
		{
			name = "airEssence";
			break;
		}
		case 2:
		{
			name = "waterEssence";
			break;
		}
		case 3:
		{
			name = "earthEssence";
			break;
		}
		default: name = "fireEssence";
		}
		return getItemName() + "." + name;
	}

}
