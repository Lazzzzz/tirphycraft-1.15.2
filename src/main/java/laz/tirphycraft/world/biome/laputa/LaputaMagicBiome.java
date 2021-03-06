package laz.tirphycraft.world.biome.laputa;

import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.features.Features;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class LaputaMagicBiome extends LaputaBiome {

    public LaputaMagicBiome() {
        super();
        
		addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(TirphycraftEntities.ENTITY_DRAGON_FLY, 10, 1, 1));
		addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(TirphycraftEntities.ENTITY_BUTTERFLY, 10, 1, 1));
		addSpawn(EntityClassification.MONSTER, new SpawnListEntry(TirphycraftEntities.ENTITY_SHIELDY, 10, 1, 1));
		addSpawn(EntityClassification.MONSTER, new SpawnListEntry(TirphycraftEntities.ENTITY_BLUPPY, 10, 1, 1));
		
        addFeature(Decoration.SURFACE_STRUCTURES, Features.BOULDER_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(3))));
        addFeature(Decoration.SURFACE_STRUCTURES, Features.HOPPER_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(4))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_ROCK_PICK.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_GRASS.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LIGHT_PAD.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));   
		addStructure(StructureFeatures.LAPUTA_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		addFeature(Decoration.UNDERGROUND_STRUCTURES, StructureFeatures.LAPUTA_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
				.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    }

}
