package laz.tirphycraft.world.features.froz.trees;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBiomes;
import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FrozGiantTreeFeature extends Feature<NoFeatureConfig> {

	public FrozGiantTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		float f = (float) (rand.nextInt(3) + 5);
		BlockPos p = pos;
		int totalSize = 0;
		for (int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
			for (int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
				if (worldIn.getBlockState(pos.add(j, -1, k)) == Blocks.AIR.getDefaultState())
					return false;
			}
		}

		for (int i = 0; f > 0.5F; ++i) {
			totalSize++;
			for (int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
				for (int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
					if ((float) (j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
						p = pos.add(j, i - 1, k);
						if (rand.nextBoolean() || f < 1.5f)
							setBlockState(worldIn, p, TirphycraftBlocks.LOG_FROZ.get().getDefaultState());
					}
				}
			}

			f = (float) ((double) f - ((double) rand.nextFloat() + 0.75D));
		}

		p = new BlockPos(pos.getX(), p.getY(), pos.getZ());
		int size = rand.nextInt(5) + 5;
		totalSize += size;

		for (int i = 0; i < size; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = -1; k < 2; k++) {
					setBlockState(worldIn, p.add(j, i, k), TirphycraftBlocks.LOG_FROZ.get().getDefaultState());
				}
			}
		}
		p = p.add(0, size, 0);
		size = rand.nextInt(6) + size + 5;
		totalSize += size;
		for (int i = 0; i < size; i++) {
			if (i < size * 0.4f) {
				setBlockState(worldIn, p.add(1, i, 0), TirphycraftBlocks.LOG_FROZ.get().getDefaultState());
				setBlockState(worldIn, p.add(0, i, 1), TirphycraftBlocks.LOG_FROZ.get().getDefaultState());
				setBlockState(worldIn, p.add(-1, i, 0), TirphycraftBlocks.LOG_FROZ.get().getDefaultState());
				setBlockState(worldIn, p.add(0, i, -1), TirphycraftBlocks.LOG_FROZ.get().getDefaultState());
			}
			setBlockState(worldIn, p.add(0, i, 0), TirphycraftBlocks.LOG_FROZ.get().getDefaultState());
		}
		boolean last = true;
		int counter = 0;
		int s = 7 + rand.nextInt(3);
		for (int i = 10; i < totalSize; i += 5) {
			s -= counter;
			if (i % 10 == 0) {
				generateLeaves(worldIn, rand, pos.add(-1, i, 0), -1, 0, s);
				generateLeaves(worldIn, rand, pos.add(1, i, 0), 1, 0, s);
				generateLeaves(worldIn, rand, pos.add(0, i, -1), 0, -1, s);
				generateLeaves(worldIn, rand, pos.add(0, i, 1), 0, 1, s);
				counter++;
				last = true;
			} else if (i % 5 == 0) {
				generateLeaves(worldIn, rand, pos.add(-1, i, 1), -1, 1, s);
				generateLeaves(worldIn, rand, pos.add(1, i, 1), 1, 1, s);
				generateLeaves(worldIn, rand, pos.add(1, i, -1), 1, -1, s);
				generateLeaves(worldIn, rand, pos.add(-1, i, -1), -1, -1, s);
				counter++;
				last = false;
			}
		}
		s = Math.max(4, s - 1);
		if (last) {
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), -1, 1, s);
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), 1, 1, s);
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), 1, -1, s);
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), -1, -1, s);
		} else {
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), -1, 0, s);
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), 1, 0, s);
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), 0, -1, s);
			generateLeaves(worldIn, rand, pos.add(0, totalSize - 1, 0), 0, 1, s);
		}

		return true;
	}

	void generateLeaves(IWorld world, Random rand, BlockPos pos, int dirx, int dirz, int size) {
		BlockState BLOCK = TirphycraftBlocks.LEAVES_FROZ.get().getDefaultState()
				.with(LeavesBlock.DISTANCE, Integer.valueOf(7)).with(LeavesBlock.PERSISTENT, Boolean.valueOf(true));

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		int directionX = dirx;
		int directionZ = dirz;

		int length = size;
		float radius = length / 2;

		for (int j = 0; j < length; j++) {
			for (int i = (int) -radius; i < radius; i++) {
				for (int k = (int) -radius; k < radius; k++) {
					if (i * i + k * k < radius) {
						if (world.getBlockState(
								new BlockPos(x - i - directionX * j, y - j, z - k - directionZ * j)) == Blocks.AIR
										.getDefaultState())
							this.setBlockState(world,
									new BlockPos(x - i - directionX * j, y - j, z - k - directionZ * j), BLOCK);

					}
				}
			}
			radius -= 0.5F;
		}
	}

}
