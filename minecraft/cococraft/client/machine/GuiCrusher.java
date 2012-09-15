package cococraft.client.machine;

import org.lwjgl.opengl.GL11;

import cococraft.common.machine.ContainerCrusher;
import cococraft.common.machine.TileEntityCrusher;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCrusher extends GuiContainer
{
	private TileEntityCrusher tile;
	
	public GuiCrusher(InventoryPlayer inv, TileEntityCrusher crusher)
	{
		super(new ContainerCrusher(inv, crusher));
		tile = crusher;
	}
	protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(StatCollector.translateToLocal("Crusher"), 60, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = mc.renderEngine.getTexture("/gui/furnace.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(var4);
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        int var7;

        if (tile.isBurning())
        {
            var7 = tile.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = tile.getCookProgressScaled(24);
        drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
    }
}
