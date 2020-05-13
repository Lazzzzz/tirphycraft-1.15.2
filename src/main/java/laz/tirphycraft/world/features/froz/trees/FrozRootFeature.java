package laz.tirphycraft.world.features.froz.trees;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.util.TirphycraftUtils;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FrozRootFeature extends Feature<NoFeatureConfig> {

	BlockState LOG = TirphycraftBlocks.LOG_FROZ.get().getDefaultState();
	BlockState LEAVES = TirphycraftBlocks.LEAVES_FROZ.get().getDefaultState();

	public FrozRootFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos p, NoFeatureConfig config) {
		BlockPos pos = getPos(worldIn, rand, p);
		if (pos == null)
			return false;
		int size = rand.nextInt(3) + 5;
		makeBrench(worldIn, rand, pos, size);
		
		return true;
	}

	BlockPos getPos(IWorld worldIn, Random rand, BlockPos pos) {
		for (int i = pos.getY(); i > 0; i--) {
			BlockPos p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p) == TirphycraftBlocks.POWDER_SNOW.get().getDefaultState())
				return p;
		}

		return null;

	}

	boolean makeBrench(IWorld world, Random rand, BlockPos pos, int size) {
		for (int i = 0; i < 110; i++) {
			if (world.getBlockState(pos.up(i)).getBlock() == LEAVES.getBlock()) break;
			if (i == 101) return false;
		}
		if (size > 2) {
			for (int i = 0; i < size; i++) {
				if (world.getBlockState(pos.up(i)).getBlock() == LEAVES.getBlock())
					return false;
				setBlockState(world, pos.up(i), LOG);
			}

			if (rand.nextBoolean())
				makeBrench(world, rand, pos.up(size - 1).east(), (int) (size / 2));
			if (rand.nextBoolean())
				makeBrench(world, rand, pos.up(size - 1).west(), (int) (size / 2));
			if (rand.nextBoolean())
				makeBrench(world, rand, pos.up(size - 1).north(), (int) (size / 2));
			if (rand.nextBoolean())
				makeBrench(world, rand, pos.up(size - 1).south(), (int) (size / 2));

			return true;
		}
		for (int i = 0; i < 130; i++) {
			if (world.getBlockState(pos.up(i)).getBlock() == LEAVES.getBlock()) {
				setBlockState(world, pos.up(i), LOG);
				return true;
			}
			setBlockState(world, pos.up(i), LOG);
		}
		
		return true;
	}

}
