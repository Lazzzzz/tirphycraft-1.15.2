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
		TirphyDrawable.BOOK_OF_KNOWLEDGE_0.draw(guiLeft - 62, guiTop - 20, 300, 200);

		BookItemInfo info = this.container.selected;
		this.font.drawString("Shift click on a item to", guiLeft - 38, guiTop - 7, 000000);
		this.font.drawString("get info", guiLeft, guiTop + 2, 000000);
		if (info != null) {
			for (int i = 0; i <= info.getLines(); i++) {
				this.font.drawString(info.info[i], guiLeft + 98, guiTop + 10 + (i * 10), 000000);
			}
		}

	}

	@Override
	protected void init() {
		super.init();

	}

}
