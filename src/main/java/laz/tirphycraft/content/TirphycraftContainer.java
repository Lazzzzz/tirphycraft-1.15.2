package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.TIRPHY_CONTAINER;

import laz.tirphycraft.content.items.other.book.BookOfKnowledgeContainer;
import laz.tirphycraft.content.tiles.frozFurnace.FrozFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftContainer {

	public static RegistryObject<ContainerType<FrozFurnaceContainer>> FROZ_FURNACE_CONTAINER;
	public static RegistryObject<ContainerType<BookOfKnowledgeContainer>> BOOK_OF_KNOWLEDGE_CONTAINER;
	
	public static void init() {

		FROZ_FURNACE_CONTAINER 		= TIRPHY_CONTAINER.register("froz_furnace", () -> IForgeContainerType.create(FrozFurnaceContainer::new));
		BOOK_OF_KNOWLEDGE_CONTAINER = TIRPHY_CONTAINER.register("book_of_knowle", () -> new ContainerType<>(BookOfKnowledgeContainer::new));
	}
	
}
