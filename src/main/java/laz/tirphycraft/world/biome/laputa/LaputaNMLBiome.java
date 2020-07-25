package laz.tirphycraft.world.biome.laputa;

import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class LaputaNMLBiome extends LaputaBiome {

    public LaputaNMLBiome() {
        super();
        
		addFeature(Decoration.SURFACE_STRUCTURES, Features.CO2_LAKES.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(20))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.ROCK_GIANT_PICK.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(4))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_DEAD_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(4))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_DEAD_PLANTS.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(45))));
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LIGHT_PAD.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
    }

}
