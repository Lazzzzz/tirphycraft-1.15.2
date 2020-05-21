package laz.tirphycraft.world.biome.froz;

import laz.tirphycraft.world.biome.base.FrozBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class FrozIcePlains extends FrozBiome {

    public FrozIcePlains(Biome.Builder builder) {
        super(builder);
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_BIG_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.SNOW_TRAP.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.GIANT_ICE_PICK.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_BUSH.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
    }

}
