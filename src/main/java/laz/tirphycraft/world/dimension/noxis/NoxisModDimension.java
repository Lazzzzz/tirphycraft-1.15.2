package laz.tirphycraft.world.dimension.noxis;

import java.util.function.BiFunction;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

public class NoxisModDimension extends ModDimension {
	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
		return NoxisDimension::new;
	}
}