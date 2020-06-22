package laz.tirphycraft.world.features.laputa.tree;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class LaputaSmallBushTreeFeature extends Feature<IFeatureConfig>{

	BlockState LOG = TirphycraftBlocks.LOG_SKY.get().getDefaultState();
	BlockState LEAVES =  TirphycraftBlocks.LEAVES_SKY.get().getDefaultState()
						.with(LeavesBlock.DISTANCE, Integer.valueOf(7))
						.with(LeavesBlock.PERSISTENT, Boolean.valueOf(true));
	
	public LaputaSmallBushTreeFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, IFeatureConfig config) {
		
			if (!(worldIn.getBlockState(position.down()).isSolid())) return false;
			
			int size = rand.nextInt(2) + 1;
			for (int i = 0; i < size; i++) {
				setBlockState(worldIn, position.up(i), LOG);
			}
			if (worldIn.getBlockState(position.up(size)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.up(size), LEAVES, 4);
			if (worldIn.getBlockState(position.add(-1, size-1, 0)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(-1, size-1, 0), LEAVES, 4);
			if (worldIn.getBlockState(position.add(1, size-1, 0)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(1, size-1, 0), LEAVES, 4);
			if (worldIn.getBlockState(position.add(0, size-1, -1)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(0, size-1, -1), LEAVES, 4);
			if (worldIn.getBlockState(position.add(0, size-1, 1)) == Blocks.AIR.getDefaultState()) worldIn.setBlockState(position.add(0, size-1, 1), LEAVES, 4);
			return true;
	}

}
