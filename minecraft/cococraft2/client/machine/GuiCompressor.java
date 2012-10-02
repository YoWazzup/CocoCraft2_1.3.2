package cococraft2.client.machine;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

import org.lwjgl.opengl.GL11;

import cococraft2.common.machine.ContainerCompressor;
import cococraft2.common.machine.TileEntityCompressor;

@SideOnly(Side.CLIENT)
public class GuiCompressor extends GuiContainer
{
	private TileEntityCompressor compressorInventory;

	public GuiCompressor(InventoryPlayer par1InventoryPlayer, TileEntityCompressor par2TileEntityCompressor)
	{
		super(new ContainerCompressor(par1InventoryPlayer, par2TileEntityCompressor));
		this.compressorInventory = par2TileEntityCompressor;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer()
	{
		this.fontRenderer.drawString(StatCollector.translateToLocal("Compressor"), 100, 6, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		int var4 = this.mc.renderEngine.getTexture("/CC/Gui/Compressor.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(var4);
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
		int var7;

		if (this.compressorInventory.isBurning())
		{
			var7 = this.compressorInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(var5 + 32, var6 + 54 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
		}

		var7 = this.compressorInventory.getCookProgressScaled(24);
		this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
	}
}
