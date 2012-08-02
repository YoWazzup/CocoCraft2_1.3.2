package net.minecraft.src.cococraft;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_Item extends Item implements ITextureProvider{

	public CC_Item(int i) 
	{
		super(i);
	}
	public String getTextureFile()
	{
		return mod_CocoCraft.ItemPNG;
	}
	public void addCreativeItems(ArrayList itemList)
	{
		itemList.add(new ItemStack(this));
	}
}
