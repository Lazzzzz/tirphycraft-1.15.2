package laz.tirphycraft.world.biome.noxis;

import java.util.Random;

import laz.tirphycraft.world.biome.base.NoxisBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.block.BlockState;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class NoxisThornsBiome extends NoxisBiome {

    public NoxisThornsBiome() {
        super();
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.NOXIS_DEAD_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(10))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.NOXIS_DEAD_BUSH.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(25))));	
    }
    
    @Override
    public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
    		BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
    	super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
    }

}
