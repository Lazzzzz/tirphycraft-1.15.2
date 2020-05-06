package laz.tirphycraft.world.features.froz.underground;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class StalactiteFeature extends UnderGroundFeature {

	public StalactiteFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		BlockPos p = getTopPos(worldIn, rand, pos);
		int size = rand.nextInt(8) + 3;
		float modx = 1f + rand.nextFloat();
		float modz = 1f + rand.nextFloat();

		for (int i = -size * 2; i < size * 2; i++) {
			for (int k = -size * 2; k < size * 2; k++) {
				double dx = i * modx;
				double dz = k * modz;
				if (dx * dx + dz * dz <= size * size) {
					BlockPos pp = new BlockPos(p.getX() + i, p.getY(), p.getZ() + k);
					if (worldIn.getBlockState(pp) == Blocks.AIR.getDefaultState())
						return false;
				}
			}
		}

		for (int i = 1; i < size; i++) {
			pick(worldIn, rand, p.down(i), (size) / i, modx, modz);
		}

		for (int i = size; i < size + Math.min(rand.nextInt(4), size); i++) {
			setBlockState(worldIn, p.down(i), Blocks.ICE.getDefaultState());
		}
		
		return true;
	}

	public boolean pick(IWorld worldIn, Random rand, BlockPos pos, int size, float modx, float modz) {

		for (int i = -size * 2; i < size * 2; i++) {
			for (int k = -size * 2; k < size * 2; k++) {
				double dx = i * modx;
				double dz = k * modz;
				if (dx * dx + dz * dz <= size * size) {
					BlockPos p = new BlockPos(pos.getX() + i, pos.getY(), pos.getZ() + k);
					if (i != 0 && k != 0) {
						if (rand.nextInt(5) > 0) {
							worldIn.setBlockState(p, TirphycraftBlocks.FROZ_STONE.get().getDefaultState(), 4);
						}
					} else
						worldIn.setBlockState(p, TirphycraftBlocks.FROZ_STONE.get().getDefaultState(), 4);

				}

			}
		}

		return true;

	}

}
