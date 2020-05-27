package laz.tirphycraft.content.tiles.frozFurnace;

import laz.tirphycraft.client.draw.TirphyDrawable;
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
		//TirphyDrawable.FROZ_FURNACE.draw(guiLeft, guiTop, 176, 166);
		TirphyDrawable.FROZ_FURNACE_UPDATE.draw(guiLeft + 176, guiLeft + 14, 24, 17);
	}
	
	@Override
	protected void init() {
		super.init();
		
	}

}
