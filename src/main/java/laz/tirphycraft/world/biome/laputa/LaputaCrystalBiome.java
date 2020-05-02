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
				Features.CRYSTAL_SPIKE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(4))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.LAPUTA_CRYSTAL_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.LAPUTA_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(22))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.LAPUTA_GRASS.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(22))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LIGHT_PAD.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}

}
