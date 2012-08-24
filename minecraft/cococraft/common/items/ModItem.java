package cococraft.common.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ModItem extends Item{

	public ModItem(int i) {
		super(i);
		//Displays the items on the Material Tab in creative mode.
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
	{
		return "/CC/Items.png";
	}

}
