package laz.tirphycraft.registry.render;

import laz.tirphycraft.client.tiles.BookOfKnowledgeContainerScreen;
import laz.tirphycraft.client.tiles.FrozFurnaceContainerScreen;
import laz.tirphycraft.registry.init.TirphycraftContainer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class TirphycraftGuiRender {
	public static void init() {
		ScreenManager.registerFactory(TirphycraftContainer.FROZ_FURNACE_CONTAINER.get(),
				FrozFurnaceContainerScreen::new);
		ScreenManager.registerFactory(TirphycraftContainer.BOOK_OF_KNOWLEDGE_CONTAINER.get(),
				BookOfKnowledgeContainerScreen::new);
	}
}
