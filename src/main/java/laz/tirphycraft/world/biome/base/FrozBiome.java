package laz.tirphycraft.world.biome.base;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.world.features.Features;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.command.impl.SetBlockCommand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class FrozBiome extends Biome {

	private int caveStartY = 48;
	private int caveStopY = 6;

	protected FrozBiome(Biome.Builder builder) {
		super(builder);

		
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_STALAGMITE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_STALAGTITE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,	Features.FROZ_GIANT_PILLAR.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		
	}

	@Override
	public int getGrassColor(double posX, double posZ) {
		return 3099238;
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
		for (int i = -3; i < 0; i++) {
			if (chunkIn.getBlockState(new BlockPos(x, startHeight + i, z)) == TirphycraftBlocks.FROZ_GRASS.get().getDefaultState()) {
				chunkIn.setBlockState(new BlockPos(x, startHeight + i+1, z), 
						TirphycraftBlocks.POWDER_SNOW_LAYER.get().getDefaultState().with(SnowBlock.LAYERS, random.nextInt(4)+1), false);
				break;
			}
		}
		makeCave(chunkIn, random, x, z, startHeight);

	}

	private boolean makeCave(IChunk chunkIn, Random random, int x, int z, int startHeight) {
		int top = 0;
		for (int i = startHeight; i > this.caveStartY; i--) {
			BlockPos p = new BlockPos(x, i, z);
			if (chunkIn.getBlockState(p) == TirphycraftBlocks.FROZ_STONE.get().getDefaultState()) {
				top = i;
				
				boolean noair = true;
				
				for (int j = i; j > 0; j--) {
					p = new BlockPos(x, j, z);
					if (chunkIn.getBlockState(p) == Blocks.AIR.getDefaultState()) {
						noair = false;
						break;
					}
				}
				
				if (noair) break; 
				
			}
			
			if (i == this.caveStartY + 1)
				return false;
		}
		int decal = top - this.caveStartY;

		for (int i = this.caveStartY - decal; i > this.caveStopY + (decal / 4); i--) {
			BlockPos p = new BlockPos(x, i, z);
			chunkIn.setBlockState(p, Blocks.AIR.getDefaultState(), false);
		}
		return true;

	}

}
