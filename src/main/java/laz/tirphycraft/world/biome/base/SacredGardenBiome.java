package laz.tirphycraft.world.biome.base;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SacredGardenBiome extends Biome {

	public SacredGardenBiome() {
		super(new Biome.Builder()
				.surfaceBuilder(SurfaceBuilder.DEFAULT,
						new SurfaceBuilderConfig(TirphycraftBlocks.SACRED_DIRT.get().getDefaultState(),
								TirphycraftBlocks.SACRED_DIRT.get().getDefaultState(),
								TirphycraftBlocks.SACRED_DIRT.get().getDefaultState()))
				.precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0).scale(0.05F)
				.temperature(0.8F).downfall(0F).waterColor(4159204).waterFogColor(329011).parent((String) null));
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		for (int i = 0; i < 100; i++) {
			BlockPos pos = new BlockPos(x,i,z);
			if (i == 0) chunkIn.setBlockState(pos, Blocks.BEDROCK.getDefaultState(), false);
			else chunkIn.setBlockState(pos, defaultBlock, false);
		}
	}
}