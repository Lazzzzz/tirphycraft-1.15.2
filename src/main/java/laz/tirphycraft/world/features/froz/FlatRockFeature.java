package laz.tirphycraft.world.features.froz;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FlatRockFeature extends Feature<NoFeatureConfig>{

	public FlatRockFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		int size = 5;
		int ry = rand.nextInt(4);
		for (int i = -size - rand.nextInt(3); i <= size + rand.nextInt(3); i++ ) {
			for (int j = -size - rand.nextInt(3); j <= size + rand.nextInt(3); j++ ) {
				for (int k = -size - rand.nextInt(3); k <= size + rand.nextInt(3); k++ ) {
					if (i * i + j+ k * k <= size * size) {
						BlockPos p = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
						setBlockState(worldIn, p, Blocks.STONE.getDefaultState());
					}
				}
			}
		}
		
		return false;
	}

}
