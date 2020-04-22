package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.DIMENSIONS;

import laz.tirphycraft.world.dimension.froz.FrozModDimension;
import laz.tirphycraft.world.dimension.gosyn.GosynModDimension;
import laz.tirphycraft.world.dimension.laputa.LaputaModDimension;
import laz.tirphycraft.world.dimension.noxis.NoxisModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class TirphycraftDimensions {

	public static RegistryObject<ModDimension> FROZ_DIM;
	public static RegistryObject<ModDimension> LAPUTA_DIM;
	public static RegistryObject<ModDimension> NOXIS_DIM;
	public static RegistryObject<ModDimension> GOSYN_DIM;


	public static void init(){
		FROZ_DIM 	= addDimension("froz_dim", FrozModDimension::new);
		LAPUTA_DIM	= addDimension("laputa_dim", LaputaModDimension::new);
		GOSYN_DIM 	= addDimension("gosyn_dim", GosynModDimension::new);
		NOXIS_DIM 	= addDimension("noxis_dim", NoxisModDimension::new);

	}

	public static RegistryObject<ModDimension> addDimension(String name, Supplier<ModDimension> dimSupplier){
		return DIMENSIONS.register(name, dimSupplier);
	}
}
