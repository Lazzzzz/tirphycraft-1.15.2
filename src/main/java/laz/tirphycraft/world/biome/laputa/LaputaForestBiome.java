package laz.tirphycraft.world.biome.laputa;

import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.features.Features;
import laz.tirphycraft.world.features.trees.CoppirTreeFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class LaputaForestBiome extends LaputaBiome {

    public LaputaForestBiome() {
        super();
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(CoppirTreeFeature.COPPIR_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));
    
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.CRYSTAL_SPIKE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
    }

}
