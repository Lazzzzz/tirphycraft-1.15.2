package laz.tirphycraft.registry.init;

import static laz.tirphycraft.registry.TirphycraftRegistries.DIMENSIONS;

import java.util.function.Supplier;

import laz.tirphycraft.world.dimension.froz.FrozModDimension;
import laz.tirphycraft.world.dimension.laputa.LaputaModDimension;
import laz.tirphycraft.world.dimension.lymbe.LymbeModDimension;
import laz.tirphycraft.world.dimension.noxis.NoxisModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftDimensions {

	public static RegistryObject<ModDimension> FROZ_DIM;
	public static RegistryObject<ModDimension> LAPUTA_DIM;
	public static RegistryObject<ModDimension> NOXIS_DIM;
	public static RegistryObject<ModDimension> LYMBE_DIM;
	


	public static void init(){
		FROZ_DIM 	= addDimension("froz_dim", FrozModDimension::new);
		LAPUTA_DIM	= addDimension("laputa_dim", LaputaModDimension::new);
		LYMBE_DIM 	= addDimension("lymbe_dim", LymbeModDimension::new);
		NOXIS_DIM 	= addDimension("noxis_dim", NoxisModDimension::new);

	}

	public static RegistryObject<ModDimension> addDimension(String name, Supplier<ModDimension> dimSupplier){
		return DIMENSIONS.register(name, dimSupplier);
	}
}
