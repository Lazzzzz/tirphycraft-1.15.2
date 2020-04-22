package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.DIMENSIONS;

import laz.tirphycraft.world.dimension.froz.FrozModDimension;
import laz.tirphycraft.world.dimension.gosyn.GosynModDimension;
import laz.tirphycraft.world.dimension.laputa.LaputaModDimension;
import laz.tirphycraft.world.dimension.noxis.NoxisModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftDimensions {

	public static final RegistryObject<ModDimension> FROZ_DIM 	= DIMENSIONS.register("froz_dim", () -> new FrozModDimension());
	public static final RegistryObject<ModDimension> LAPUTA_DIM = DIMENSIONS.register("laputa_dim", () -> new LaputaModDimension());
	public static final RegistryObject<ModDimension> NOXIS_DIM 	= DIMENSIONS.register("noxis_dim", () -> new NoxisModDimension());
	public static final RegistryObject<ModDimension> GOSYN_DIM 	= DIMENSIONS.register("gosyn_dim", () -> new GosynModDimension());
	
}
