package cococraft2.common.items;

import cococraft2.client.ClientProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;


public class ModItem extends Item{

	protected ModItem(int par1) {
		super(par1);
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	public String getTextureFile()
	{
		return ClientProxy.ItemTex;
	}

}
