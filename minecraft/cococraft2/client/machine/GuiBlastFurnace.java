package cococraft2.client.machine;

import net.minecraft.src.*;
import java.util.Random;
import org.lwjgl.opengl.GL11;

import cococraft2.common.machine.ContainerBlastFurnace;
import cococraft2.common.machine.TileEntityBlastFurnace;


public class GuiBlastFurnace extends GuiContainer
{
    private TileEntityBlastFurnace furnaceInventory;

    public GuiBlastFurnace(InventoryPlayer inventoryplayer, TileEntityBlastFurnace tile)
    {
        super(new ContainerBlastFurnace(inventoryplayer, tile));
        furnaceInventory = tile;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Blast Furnace", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int k = mc.renderEngine.getTexture(("/CC/Gui/BlastFurnace.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(k);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
        
        if (furnaceInventory.isBurning())
        {
            int j1 = furnaceInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(l + 46, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);
        }
        int k1 = furnaceInventory.getCookProgressScaled(24);
        drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
    }
}