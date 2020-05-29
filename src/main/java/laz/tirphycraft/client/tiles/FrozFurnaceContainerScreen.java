package laz.tirphycraft.client.tiles;

import laz.tirphycraft.client.draw.TirphyDrawable;
import laz.tirphycraft.content.tiles.frozFurnace.FrozFurnaceContainer;
import laz.tirphycraft.content.tiles.frozFurnace.FrozFurnaceTE;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class FrozFurnaceContainerScreen extends ContainerScreen<FrozFurnaceContainer>{

	public FrozFurnaceContainerScreen(FrozFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent t) {
		super(screenContainer, inv, new TranslationTextComponent("froz_furnace"));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		FrozFurnaceTE te = this.container.tileEntity;
		TirphyDrawable.FROZ_FURNACE_0.draw(guiLeft, guiTop, 176, 166);
		TirphyDrawable.FROZ_FURNACE_1.drawPartial(guiLeft + 79, guiTop + 35, 24, 17, 0, 0, (float) te.currentburntime / te.getBurnTime(), 1);
		if (te.asStart) TirphyDrawable.FROZ_FURNACE_2.drawPartial(guiLeft + 56, guiTop + 36, 14, 14, 0, (float) te.currentburntime / te.getBurnTime(), 1, 1);
		this.font.drawString(this.title.getFormattedText(), guiLeft + 6, guiTop + 6, 000000);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), guiLeft + 6, guiTop + 72, 000000);
	}
	
	@Override
	protected void init() {
		super.init();
		
	}

}
