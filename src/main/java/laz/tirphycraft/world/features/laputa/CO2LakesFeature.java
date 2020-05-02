package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.TirphycraftRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class CO2LakesFeature extends Feature<NoFeatureConfig>{

	public CO2LakesFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		int size = rand.nextInt(3)+2;
		for (int i = -size; i < size; i++) {
			for (int j= -size; j < size; j++) {
				BlockPos p = pos.add(i, 0, j);
				if (worldIn.getBlockState(p.down()) == Blocks.AIR.getDefaultState()) return false;
				if (worldIn.getBlockState(p.down(3)) == Blocks.AIR.getDefaultState()) return false;
			}
		}
		
		float modx = 1f + rand.nextFloat();
		float modz = 1f + rand.nextFloat();
		for (int i = -size; i < size; i++) {
			for (int j = -3; j < 0; j++) {
				for (int k = -size; k < size; k++) {
					double dx = i * modx;
					double dz = k * modz;
					if (dx * dx + j * j + dz * dz <= size * size) {
						BlockPos p = pos.add(i,j,k);
						setBlockState(worldIn, p, TirphycraftRegistries.CO2.getBlock().getDefaultState());
					}
				}
			}
		}
		
		return true;
	}

}
