package laz.tirphycraft.registry.init;

import laz.tirphycraft.world.biome.base.FrozBiome;
import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.biome.base.NoxisBiome;
import laz.tirphycraft.world.biome.base.SacredGardenBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TirphycraftOverworldFeature {

	public static void init() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (!(biome instanceof FrozBiome) && !(biome instanceof LaputaBiome) && !(biome instanceof NoxisBiome) && !(biome instanceof SacredGardenBiome))
				biome.addFeature(Decoration.SURFACE_STRUCTURES, Features.ANCIENT_STONE
						.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));

			biome.addFeature(Decoration.SURFACE_STRUCTURES,
					Features.COAL_ON_COKE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
			biome.addFeature(Decoration.SURFACE_STRUCTURES,
					Features.PYRODES.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
			biome.addFeature(Decoration.SURFACE_STRUCTURES,
					Features.CRYSTAL.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		}
	}
	
}
