package net.minecraft.src.cococraft;

import java.util.ArrayList;

import net.minecraft.src.*;
import net.minecraft.src.forge.ITextureProvider;

public class CC_ItemHoe extends ItemPickaxe implements ITextureProvider{

	public CC_ItemHoe(int i, EnumToolMaterial Enum) {
		super(i, Enum);
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
