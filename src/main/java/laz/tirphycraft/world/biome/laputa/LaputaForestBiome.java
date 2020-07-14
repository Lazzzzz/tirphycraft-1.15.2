package laz.tirphycraft.world.biome.laputa;

import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.features.Features;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class LaputaForestBiome extends LaputaBiome {

    public LaputaForestBiome() {
        super();
        
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(10))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_SMALL_BUSH.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(8))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_ROCK_PICK.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_GRASS.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LIGHT_PAD.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
		addStructure(StructureFeatures.LAPUTA_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		addFeature(Decoration.UNDERGROUND_STRUCTURES, StructureFeatures.LAPUTA_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
				.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    }

}
