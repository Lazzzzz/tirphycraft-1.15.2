package laz.tirphycraft.world.biome.froz;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.world.biome.base.FrozBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class FrozForestBiome extends FrozBiome {

    public FrozForestBiome(Biome.Builder builder) {
        super(builder);
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.ROOT_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(12))));
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
    		BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
    	
    	for (int i = 7; i < 12; i ++) {
    		BlockPos pos = new BlockPos(x, startHeight + i, z);
    		if (pos.getY() == 100) {
				chunkIn.setBlockState(new BlockPos(x, startHeight + i, z), TirphycraftBlocks.POWDER_SNOW_LAYER.get()
						.getDefaultState().with(SnowBlock.LAYERS, random.nextInt(4) + 1), false);
    		}
    		else if (pos.getY() < 100){
    			if (chunkIn.getBlockState(pos) == Blocks.AIR.getDefaultState())	{
    				if (i == 11) chunkIn.setBlockState(new BlockPos(x, startHeight + i, z), TirphycraftBlocks.POWDER_SNOW_LAYER.get()
    						.getDefaultState().with(SnowBlock.LAYERS, random.nextInt(4) + 1), false);
    				else chunkIn.setBlockState(pos, TirphycraftBlocks.LEAVES_FROZ.get().getDefaultState().with(LeavesBlock.PERSISTENT, true), false);
    			}
    		}
    	}
    	super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
    }
    
}

