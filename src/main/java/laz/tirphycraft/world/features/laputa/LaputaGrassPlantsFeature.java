package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class LaputaGrassPlantsFeature extends Feature<NoFeatureConfig> {

	public LaputaGrassPlantsFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos p, NoFeatureConfig config) {

		BlockPos pos = p;
		for (int i = pos.getY() + 1; i > 0; i--) {
			pos = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(pos) == TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState())
				break;
			if (i == 1)
				return false;
		}
		if (worldIn.getBlockState(pos.up(2)) != Blocks.AIR.getDefaultState()) return false;
		switch (rand.nextInt(2)) {
		case 0:
			setBlockState(worldIn, pos.up(), TirphycraftBlocks.LAPUTA_FLOWER1.get().getDefaultState());
			break;
		default:
			setBlockState(worldIn, pos.up(), TirphycraftBlocks.LAPUTA_FLOWER2.get().getDefaultState());
			break;
		}
		return true;
	}

}
