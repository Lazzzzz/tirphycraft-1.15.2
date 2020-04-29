package laz.tirphycraft.world.biome.laputa;

import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class LaputaCrystalBiome extends LaputaBiome {

	public LaputaCrystalBiome() {
		super();
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.CRYSTAL_SPIKE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
	}

}
