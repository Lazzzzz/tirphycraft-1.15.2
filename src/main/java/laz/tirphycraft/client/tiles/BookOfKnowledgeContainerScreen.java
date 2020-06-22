package laz.tirphycraft.client.tiles;

import laz.tirphycraft.client.draw.TirphyDrawable;
import laz.tirphycraft.content.items.other.book.BookOfKnowledgeContainer;
import laz.tirphycraft.util.book.BookItemInfo;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BookOfKnowledgeContainerScreen extends ContainerScreen<BookOfKnowledgeContainer> {

	public BookOfKnowledgeContainerScreen(BookOfKnowledgeContainer screenContainer, PlayerInventory inv,
			ITextComponent t) {
		super(screenContainer, inv, new TranslationTextComponent("book_of_knowledge"));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		TirphyDrawable.BOOK_OF_KNOWLEDGE_0.draw(guiLeft, guiTop - 8, 176, 174);
		
		BookItemInfo info = this.container.selected;
		
		if (info == null)
			this.font.drawString("shift click on item to get info", guiLeft + 6, guiTop, 000000);
		else {
			for (int i = 0; i <= info.getLines(); i++) {
				this.font.drawString(info.info[i], guiLeft + 6, guiTop + i * 9f, 000000);
			}
		}
	}

	@Override
	protected void init() {
		super.init();

	}

}
