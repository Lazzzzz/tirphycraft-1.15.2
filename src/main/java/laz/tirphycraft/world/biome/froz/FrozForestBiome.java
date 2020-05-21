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
				Features.ROOT_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(20))));
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		if (Math.abs(noise) < 1.8D) {
			for (int i = 7; i < 12; i++) {
				BlockPos pos = new BlockPos(x, startHeight + i, z);
				if (pos.getY() == 90) {
					if (chunkIn.getBlockState(new BlockPos(x, startHeight + i - 1, z))
							.getBlock() == TirphycraftBlocks.LEAVES_FROZ.get())
						chunkIn.setBlockState(new BlockPos(x, startHeight + i, z), TirphycraftBlocks.POWDER_SNOW_LAYER
								.get().getDefaultState().with(SnowBlock.LAYERS, random.nextInt(4) + 1), false);

				} else if (pos.getY() < 90) {
					if (chunkIn.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
						if (i == 11)
							chunkIn.setBlockState(new BlockPos(x, startHeight + i, z),
									TirphycraftBlocks.POWDER_SNOW_LAYER.get().getDefaultState().with(SnowBlock.LAYERS,
											random.nextInt(4) + 1),
									false);
						else
							chunkIn.setBlockState(pos, TirphycraftBlocks.LEAVES_FROZ.get().getDefaultState()
									.with(LeavesBlock.PERSISTENT, true), false);
					}
				}
			}
		} else {
			double k = startHeight;
			for (int i = 255; i > k - 10; i--) {
				BlockPos pos = new BlockPos(x, i, z);
				if (pos.getY() > k - 3) {
					chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
				}
				else {
					if (random.nextInt(5) > 0) chunkIn.setBlockState(pos, Blocks.ICE.getDefaultState(), false);
					else chunkIn.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState(), false);
				}
			}
		}
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
	}

}
