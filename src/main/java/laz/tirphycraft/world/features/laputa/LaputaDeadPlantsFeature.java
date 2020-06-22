package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class LaputaDeadPlantsFeature extends Feature<NoFeatureConfig> {

	public LaputaDeadPlantsFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (worldIn.getBlockState(pos.down()) == TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState()) {
			if (rand.nextInt(10) < 8) {
				setBlockState(worldIn, pos, TirphycraftBlocks.NOXIS_FLOWER1.get().getDefaultState());
			} else {
				setBlockState(worldIn, pos, TirphycraftBlocks.LAPUTA_FLOWER2.get().getDefaultState());
			}
			return true;
		}
		return false;
	}

}
