package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.DIMENSIONS;

import laz.tirphycraft.world.dimension.froz.FrozModDimension;
import laz.tirphycraft.world.dimension.laputa.LaputaModDimension;
import laz.tirphycraft.world.dimension.noxis.NoxisModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class TirphycraftDimensions {

	public static RegistryObject<ModDimension> FROZ_DIM;
	public static final RegistryObject<ModDimension> LAPUTA_DIM = DIMENSIONS.register("laputa_dim", () -> new LaputaModDimension());
	public static final RegistryObject<ModDimension> NOXIS_DIM 	= DIMENSIONS.register("noxis_dim", () -> new NoxisModDimension());

	public static void init(){
		FROZ_DIM = addDimension("froz_dim", FrozModDimension::new);

	}

	public static RegistryObject<ModDimension> addDimension(String name, Supplier<ModDimension> dimSupplier){
		return DIMENSIONS.register(name,dimSupplier);
	}

}
