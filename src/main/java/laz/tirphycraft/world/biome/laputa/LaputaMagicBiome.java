package laz.tirphycraft.world.biome.laputa;

import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class LaputaMagicBiome extends LaputaBiome {

    public LaputaMagicBiome() {
        super();
        addFeature(Decoration.SURFACE_STRUCTURES, Features.BOULDER_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(3))));
        addFeature(Decoration.SURFACE_STRUCTURES, Features.HOPPER_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(4))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_ROCK_PICK.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_GRASS.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_FLOWER.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LIGHT_PAD.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));   
    }

}
