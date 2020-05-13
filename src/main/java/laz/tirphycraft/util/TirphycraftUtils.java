package laz.tirphycraft.util;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public class TirphycraftUtils {

	public static int getHeight(ConfiguredSurfaceBuilder<?> surfaceBuilder, IWorld worldIn, SharedSeedRandom random,
			int x, int z) {
		int y = 0;
		for (int i = 255; i > 0; i--) {
			BlockPos p = new BlockPos(x, i, z);
			if (worldIn.getBlockState(p) == surfaceBuilder.config.getTop()) {
				y = i;
				break;
			}
		}
		if (y == 0)
			return -1;
		return y;
	}

	public static void generateLeafNode(IWorld worldIn, Random rand, BlockPos position, BlockState LEAVES) {
		if (worldIn.getBlockState(position.up()) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.up(), LEAVES, 4);
		if (worldIn.getBlockState(position.add(-1, 1, 0)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(-1, 1, 0), LEAVES, 4);
		if (worldIn.getBlockState(position.add(1, 1, 0)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(1, 1, 0), LEAVES, 4);
		if (worldIn.getBlockState(position.add(0, 1, -1)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(0, 1, -1), LEAVES, 4);
		if (worldIn.getBlockState(position.add(0, 1, 1)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(0, 1, 1), LEAVES, 4);

		for (int y = 0; y > -2; --y) {
			for (int x = -2; x < 3; ++x) {
				for (int z = -1; z < 2; ++z) {
					if (x != 0 || z != 0) {
						if (worldIn.getBlockState(position.add(x, y, z)) == Blocks.AIR.getDefaultState())
							worldIn.setBlockState(position.add(x, y, z), LEAVES, 4);
					}
				}

				if (Math.abs(x) < 2) {
					if (worldIn.getBlockState(position.add(x, y, -2)) == Blocks.AIR.getDefaultState())
						worldIn.setBlockState(position.add(x, y, -2), LEAVES, 4);
					if (worldIn.getBlockState(position.add(x, y, 2)) == Blocks.AIR.getDefaultState())
						worldIn.setBlockState(position.add(x, y, 2), LEAVES, 4);

				}
			}
		}
	}
}
