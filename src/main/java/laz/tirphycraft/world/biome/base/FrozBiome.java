package laz.tirphycraft.world.biome.base;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

public class FrozBiome extends Biome {

	private int caveStartY = 48;
	private int caveStopY = 6;

	protected FrozBiome(Biome.Builder builder) {
		super(builder);

	}

	@Override
	public int getGrassColor(double posX, double posZ) {
		return 3099238;
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
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
