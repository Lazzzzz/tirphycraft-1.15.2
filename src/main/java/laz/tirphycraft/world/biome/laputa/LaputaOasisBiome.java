package laz.tirphycraft.world.biome.laputa;

import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.features.Features;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class LaputaOasisBiome extends LaputaBiome {

	public LaputaOasisBiome() {
		super();
		
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_OASIS.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(40))));
		addFeature(Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
        addFeature(Decoration.SURFACE_STRUCTURES, Features.BOULDER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LIGHT_PAD.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
        addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_ROCK_PICK.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_GRASS.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addStructure(StructureFeatures.LAPUTA_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		addFeature(Decoration.UNDERGROUND_STRUCTURES, StructureFeatures.LAPUTA_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
				.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
}