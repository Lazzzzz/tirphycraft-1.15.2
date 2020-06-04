package laz.tirphycraft.world.features.laputa.tree;

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
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class HopperFlowerFeature extends Feature<NoFeatureConfig> {

	BlockState LOG = TirphycraftBlocks.LOG_STEM.get().getDefaultState();
	BlockState LEAVES;
	
	public HopperFlowerFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		if (!(worldIn.getBlockState(pos.down()).isSolid() 
				&& worldIn.getBlockState(pos.down().west()).isSolid()
				&& worldIn.getBlockState(pos.down().south()).isSolid()
				&& worldIn.getBlockState(pos.down().south().west()).isSolid())) {
			return false;
		}
		
		if (worldIn.getBlockState(pos.down()) == LEAVES 
				|| worldIn.getBlockState(pos.down().west()) == LEAVES
				|| worldIn.getBlockState(pos.down().south()) == LEAVES
				|| worldIn.getBlockState(pos.down().south().west()) == LEAVES) {
			return false;
		}
		selectPetal(rand);
		int size = rand.nextInt(7)+5;
		int head_size = rand.nextInt(3)+4;
		float offsetx = (rand.nextInt(5)) / 10f - 0.25f;
		float offsetz = (rand.nextInt(5)) / 10f - 0.25f;
		float addx = 0;
		float addz = 0;
		BlockPos p = pos;
	
		for (int i = 0; i <= size; i++) {
			setBlockState(worldIn, p.up(i), LOG);
			setBlockState(worldIn, p.west().up(i), LOG);
			setBlockState(worldIn, p.south().up(i), LOG);
			setBlockState(worldIn, p.south().up(i).west(), LOG);
			addx += offsetx;
			addz += offsetz;
			p = new BlockPos(pos.getX() + (int) addx, pos.getY(), pos.getZ() + addz);
		}
		
		makeHead(worldIn, p.up(size), head_size, rand);
		
		return true;
	}

	private void makeHead(IWorld worldIn, BlockPos pos, int head_size, Random rand) {
		float modx = 1f + rand.nextFloat();
		float modz = 1f + rand.nextFloat();
		
		for (int i = 2; i <= head_size; i++) {
			for (int j = (int) (-i*1.5); j <= i*1.5; j++) {
				for (int k = (int) (-i*1.5); k <= i*1.5; k++) {
					double dx = j * modx;
					double dz = k * modz;					
					if (dx * dx + dz * dz <= i*i*1.5*1.5) {
						BlockPos p = new BlockPos(pos.getX() + j, pos.getY() + i - 2, pos.getZ() + k);
						if (i == 2) setBlockState(worldIn, p, LOG);
						else if (dx * dx + dz * dz >= i*i) {
							if (worldIn.getBlockState(p) == Blocks.AIR.getDefaultState()) setBlockState(worldIn, p, LEAVES);
						}
					}
				}
			}
		}
	}
	
	void selectPetal(Random rand) {
		switch (rand.nextInt(5)) {
		case 0:
			LEAVES = TirphycraftBlocks.PETAL_BLUE.get().getDefaultState();
			break;
		case 1:
			LEAVES = TirphycraftBlocks.PETAL_RED.get().getDefaultState();
			break;
		case 2:
			LEAVES = TirphycraftBlocks.PETAL_YELLOW.get().getDefaultState();
			break;
		case 3:
			LEAVES = TirphycraftBlocks.PETAL_GREEN.get().getDefaultState();
			break;
		case 4:
			LEAVES = TirphycraftBlocks.PETAL_PURPLE.get().getDefaultState();
			break;
		}
	}
	
}
