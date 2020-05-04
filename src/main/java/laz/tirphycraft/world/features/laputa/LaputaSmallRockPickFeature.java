package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class LaputaSmallRockPickFeature extends Feature<IFeatureConfig> {

	BlockState ROCK = TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState();
	BlockState LEAVES = TirphycraftBlocks.LEAVES_SKY.get().getDefaultState().with(LeavesBlock.DISTANCE, Integer.valueOf(7))
			.with(LeavesBlock.PERSISTENT, Boolean.valueOf(true));

	public LaputaSmallRockPickFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);

	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, IFeatureConfig config) {

		if (worldIn.getBlockState(position.down()) != TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState()
				&& worldIn.getBlockState(position.down()) != TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState()
				&& worldIn.getBlockState(position.down()) != TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState())
			return false;

		if (position.getY() > 80 || position.getY() == 0)
			return false;
		int r1 = rand.nextInt(3) + 4;
		generatePick(worldIn, position, r1, rand);

		int r2 = rand.nextInt(3) + 1;
		int r3 = rand.nextInt(3) + 1;
		int r4 = rand.nextInt(3) + 1;
		int r5 = rand.nextInt(3) + 1;
		generatePick(worldIn, position.add(1, 0, 0), r2, rand);
		generatePick(worldIn, position.add(-1, 0, 0), r3, rand);
		generatePick(worldIn, position.add(0, 0, -1), r4, rand);
		generatePick(worldIn, position.add(0, 0, 1), r5, rand);

		return true;

	}

	public boolean generatePick(IWorld worldIn, BlockPos pos, int size, Random rand) {
		for (int i = pos.getY(); i > 0; i--) {
			BlockPos p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p).getMaterial() == Material.ROCK)
				break;
			else if (i == 1) return false;

		}

		if (rand.nextBoolean())
			setBlockState(worldIn, pos.up(size + 1), LEAVES);
		for (int i = size + pos.getY(); i > 0; i--) {
			BlockPos p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK)
				setBlockState(worldIn, p, ROCK);
			else
				return true;
		}
		return true;
	}

}
