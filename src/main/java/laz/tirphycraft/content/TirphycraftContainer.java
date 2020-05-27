package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.TIRPHY_CONTAINER;

import laz.tirphycraft.content.tiles.frozFurnace.FrozFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftContainer {

	public static RegistryObject<ContainerType<FrozFurnaceContainer>> FROZ_FURNACE_CONTAINER;
	
	public static void init() {
		FROZ_FURNACE_CONTAINER = TIRPHY_CONTAINER.register("froz_furnace", () -> new ContainerType<>(FrozFurnaceContainer::new));
	}
	
}
