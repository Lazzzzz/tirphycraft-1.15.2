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

public class CrystalTreeFeature extends Feature<NoFeatureConfig> {

	public CrystalTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		if (pos.getY() > 120) return false;
		
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				BlockState block = worldIn.getBlockState(pos.add(j, -1, k));
				if (block != TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState()
				 && block != TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState()
				 && block != TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState()) {
					return false;
				}

			}
		}

		int size = rand.nextInt(10) + 5;
		float offsetx;
		float offsetz;
		while (true) {
			offsetx = rand.nextFloat() - 0.5f;
			offsetz = rand.nextFloat() - 0.5f;
			if (offsetx != 0 && offsetz != 0)
				break;
		}
		float addx = 0;
		float addz = 0;
		BlockPos p = pos;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					setBlockState(worldIn, p.add(j, i, k), TirphycraftBlocks.LOG_STEM.get().getDefaultState());
					setBlockState(worldIn, p.add(j, i, k), TirphycraftBlocks.LOG_STEM.get().getDefaultState());
					setBlockState(worldIn, p.add(j, i, k), TirphycraftBlocks.LOG_STEM.get().getDefaultState());
					setBlockState(worldIn, p.add(j, i, k), TirphycraftBlocks.LOG_STEM.get().getDefaultState());

				}
			}
			addx += offsetx;
			addz += offsetz;
			p = new BlockPos(pos.getX() + (int) addx, pos.getY(), pos.getZ() + (int) addz);
		}
		p = new BlockPos(pos.getX() + (int) addx, pos.getY() + size - 1, pos.getZ() + (int) addz);
		for (int i = 0; i < 100; i++) {
			makeBrench(worldIn, rand, p);
		}
		return false;
	}

	public void makeBrench(IWorld worldIn, Random rand, BlockPos pos) {
		int size = rand.nextInt(7)+10;
		float addx = 0;
		float addz = 0;
		float addy = 0;
		float offsetx;
		float offsetz;
		while (true) {
			offsetx = rand.nextFloat();
			offsetz = rand.nextFloat();
			if (offsetx > 0.5f || offsetz > 0.5f) {
				break;
			}
		}
		int multx = 0;
		int multz = 0;

		while (true) {
			multx = rand.nextInt(3) - 1;
			multz = rand.nextInt(3) - 1;
			if (multx != 0 && multz != 0) {
				break;
			}
		}

		offsetx *= multx;
		offsetz *= multz;

		BlockPos p = pos;
		for (float i = 0; i < size; i += 1) {
			for (int j = 0; j < 1; j++) {
				if (i > 4) {
					placeBlock(worldIn, p.up(j), rand);
					placeBlock(worldIn, p.west().up(j), rand);
					placeBlock(worldIn, p.south().up(j), rand);
					placeBlock(worldIn, p.south().up(j).west(), rand);
				} else {
					if (rand.nextInt(5) == 0)
						setBlockState(worldIn, p.up(j), TirphycraftBlocks.LOG_STEM.get().getDefaultState());
					if (rand.nextInt(5) == 0)
						setBlockState(worldIn, p.west().up(j), TirphycraftBlocks.LOG_STEM.get().getDefaultState());
					if (rand.nextInt(5) == 0)
						setBlockState(worldIn, p.south().up(j), TirphycraftBlocks.LOG_STEM.get().getDefaultState());
					if (rand.nextInt(5) == 0)
						setBlockState(worldIn, p.south().up(j).west(),
								TirphycraftBlocks.LOG_STEM.get().getDefaultState());
				}
			}
			addx += offsetx;
			addz += offsetz;
			if (i < size / 2)
				addy = (int) i;
			else
				addy = -i + size;
			p = new BlockPos(pos.getX() + (int) addx, pos.getY() + (int) addy, pos.getZ() + (int) addz);
		}
	}

	public void placeBlock(IWorld worldIn, BlockPos pos, Random rand) {

		if (rand.nextInt(5) > 0 && worldIn.getBlockState(pos) == Blocks.AIR.getDefaultState())
			switch (rand.nextInt(5)) {
			case 0:
				setBlockState(worldIn, pos, TirphycraftBlocks.LAPUTA_BLUE.get().getDefaultState());
				break;
			case 1:
				setBlockState(worldIn, pos, TirphycraftBlocks.LAPUTA_PURPLE.get().getDefaultState());
				break;
			case 2:
				setBlockState(worldIn, pos, TirphycraftBlocks.LAPUTA_YELLOW.get().getDefaultState());
				break;
			case 3:
				setBlockState(worldIn, pos, TirphycraftBlocks.LAPUTA_PINK.get().getDefaultState());
				break;
			default:
				setBlockState(worldIn, pos, TirphycraftBlocks.LAPUTA_GREEN.get().getDefaultState());
				break;
			}

	}

}
