package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class BoulderFeature extends Feature<NoFeatureConfig> {
	public boolean flower;
	
	public BoulderFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean flower) {
		super(configFactoryIn);
		this.flower = flower;
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (pos.getY() < 1) return false;
		int size = rand.nextInt(8) + 1;
		
		for (int i = -size; i < size; i++) {
			for (int j = -size; j < size; j++) {
				BlockPos p = new BlockPos(pos.getX() + i, pos.getY() - 2, pos.getZ() + j);
				if (worldIn.getBlockState(p) == Blocks.AIR.getDefaultState()) return false;
			}
		}
		generate(worldIn, rand, pos, size);
		for (int i = 0; i < rand.nextInt(5); i++) {
			generate(worldIn, rand, pos.add((rand.nextFloat() - 0.5) * 10, 0, (rand.nextFloat() - 0.5) * 10), size - rand.nextInt(size));
		}
		return true;
	}

	private void generate(IWorld worldIn, Random rand, BlockPos pos, int size) {
		
		float modx = 1f + rand.nextFloat();
		float modz = 1f + rand.nextFloat();
		for (int i = -size; i < size; i++) {
			for (int j = -2; j < size; j++) {
				for (int k = -size; k < size; k++) {
					double dx = i * modx;
					double dz = k * modz;
					if (dx * dx + j * j + dz * dz <= size * size) {
						BlockPos p = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
						if (dx * dx + j * j + dz * dz < (size * size) / 64) {
							setBlockState(worldIn, p, TirphycraftBlocks.ORE_TENIUM.get().getDefaultState());
						} else setBlockState(worldIn, p, TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState());
					}
				}
			}
		}

		for (int i = -size* 2; i < size* 2; i++) {
			for (int j = -size/2; j < size; j++) {
				for (int k = -size* 2; k < size* 2; k++) {
					double dx = i * modx;
					double dz = k * modz;
					BlockPos p = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
					if (dx * dx + j * j + dz * dz <= size * size) {
						buildSurface(worldIn, p, rand);
					}
					
					if (dx * dx + j * j + dz * dz <= size * size* 4) {
						if (worldIn.getBlockState(p.down()) == TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState()) {
							if (rand.nextInt(16) == 0 && this.flower) {
								for (int ii = 0; ii < rand.nextInt(6); ii++) {
									if (worldIn.getBlockState(p.up(ii)) != Blocks.AIR.getDefaultState()) break;
									setBlockState(worldIn, p.up(ii),
											TirphycraftBlocks.LAPUTA_FLOWER6.get().getDefaultState());
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void buildSurface(IWorld worldIn, BlockPos p, Random rand) {
		if (worldIn.getBlockState(p.up()) == Blocks.AIR.getDefaultState()) {
			for (int i = 0; i < rand.nextInt(2) + 2; i++) {
				setBlockState(worldIn, p.down(i), TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState());
			}
			setBlockState(worldIn, p, TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState());
			if (rand.nextInt(8) == 0 && this.flower) {
				for (int i = 1; i < rand.nextInt(4) + 3; i++) {
					if (worldIn.getBlockState(p.up(i)) != Blocks.AIR.getDefaultState()) break;
					setBlockState(worldIn, p.up(i), TirphycraftBlocks.LAPUTA_FLOWER6.get().getDefaultState());
				}
			}
		}
	}

}
