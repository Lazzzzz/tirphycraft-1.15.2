package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class LightPadFeature extends Feature<IFeatureConfig> {

	public LightPadFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, IFeatureConfig config) {
		int basePathWidth = 3;

		while (worldIn.isAirBlock(position) && position.getY() > 2) {
			position = position.down();
		}

		if (worldIn.getBlockState(position).getBlock() != TirphycraftBlocks.LAPUTA_GRASS.get()) {
			return false;
		} else {
			int i = rand.nextInt(basePathWidth - 1) + 2;
			int j = 1;

			for (int k = position.getX() - i; k <= position.getX() + i; ++k) {
				for (int l = position.getZ() - i; l <= position.getZ() + i; ++l) {
					int i1 = k - position.getX();
					int j1 = l - position.getZ();

					if (i1 * i1 + j1 * j1 <= i * i) {
						for (int k1 = position.getY() - 1; k1 <= position.getY() + 1; ++k1) {
							BlockPos blockpos = new BlockPos(k, k1, l);
							BlockState block = worldIn.getBlockState(blockpos);

							if (block == TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState()
									|| block == TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState()
									|| block == TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState()) {
								if (worldIn.getBlockState(blockpos.up()).isSolid()
										|| worldIn.getBlockState(blockpos.up()) == Blocks.AIR.getDefaultState())
									if (rand.nextBoolean())
										worldIn.setBlockState(blockpos,
												TirphycraftBlocks.SUN_STONE.get().getDefaultState(), 2);
							}
						}
					}
				}
			}

			return true;
		}
	}

}
