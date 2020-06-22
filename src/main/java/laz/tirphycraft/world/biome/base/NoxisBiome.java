package laz.tirphycraft.world.biome.base;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.world.features.Features;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class NoxisBiome extends Biome {

	public NoxisBiome() {
		super(new Biome.Builder().precipitation(RainType.NONE).scale(0.3f).temperature(5f).waterColor(3093151)
				.waterFogColor(3093151).category(Category.PLAINS).downfall(0).depth(0f)
				.surfaceBuilder(SurfaceBuilder.DEFAULT,
						new SurfaceBuilderConfig(TirphycraftBlocks.NOXIS_STONE.get().getDefaultState(),
								TirphycraftBlocks.NOXIS_STONE.get().getDefaultState(),
								TirphycraftBlocks.NOXIS_STONE.get().getDefaultState())));

		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.NOXIS_DEAD_BUSH.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(10))));
		
}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {

		int xx = Math.abs(chunkIn.getPos().x) + x;
		int zz = Math.abs(chunkIn.getPos().z) + z;
		BlockPos pos;

		if (xx * xx + zz * zz > 200 * 200) {
			double abs_noise = Math.abs(noise);

			if (abs_noise < 2.5) {
				for (int i = -48 + (int) (abs_noise * 50); i < 1; i++) {
					pos = new BlockPos(x, startHeight + i, z);
					if (pos.getY() <= 49)
						chunkIn.setBlockState(pos, Blocks.LAVA.getDefaultState(), false);
					else
						chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
				}

			}
		} else if (xx * xx + zz * zz >= 50 * 50 && xx * xx + zz * zz <= 55 * 55) {
			for (int i = -3; i < Math.sqrt(xx * xx + zz * zz) - 49; i++) {
				pos = new BlockPos(x, startHeight + i, z);
				chunkIn.setBlockState(pos, Blocks.STONE.getDefaultState(), false);

			}
		} else if (xx * xx + zz * zz >= 195 * 195 && xx * xx + zz * zz <= 200 * 200) {
			for (int i = -3; i < 6 - (Math.sqrt(xx * xx + zz * zz) - 195); i++) {
				pos = new BlockPos(x, startHeight + i, z);
				chunkIn.setBlockState(pos, Blocks.STONE.getDefaultState(), false);
			}

		} else if (xx * xx + zz * zz >= 55 * 55 && xx * xx + zz * zz <= 195 * 195) {
			for (int i = 0; i < 6; i++) {
				pos = new BlockPos(x, startHeight + i, z);
				chunkIn.setBlockState(pos, Blocks.STONE.getDefaultState(), false);
			}
		}
		super.buildSurface(random, chunkIn, x, z, startHeight + 6, noise, defaultBlock, defaultFluid, 1, seed);
		for (int i = 6; i > -2; i--) {
			pos = new BlockPos(x, startHeight + i, z);
			if (chunkIn.getBlockState(pos) == TirphycraftBlocks.NOXIS_STONE.get().getDefaultState()) {
				if (random.nextInt(17) == 0) chunkIn.setBlockState(pos, TirphycraftBlocks.NOXIS_ASH_LIT.get().getDefaultState(), false);
				else if (random.nextInt(17) == 0) chunkIn.setBlockState(pos, TirphycraftBlocks.NOXIS_COBBLESTONE.get().getDefaultState(), false);
				else if (random.nextInt(40) == 0) chunkIn.setBlockState(pos, TirphycraftBlocks.NOXIS_FIRE.get().getDefaultState(), false);
				
				break;
			}
		}
	}

}
