package laz.tirphycraft.world.features.overworld;

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

public class FragmentFeature extends Feature<NoFeatureConfig> {

	public FragmentFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (rand.nextInt(40) > 0) return false;
		switch (rand.nextInt(5)) {
		case 0:
			setBlockState(worldIn, pos, TirphycraftBlocks.ANCIENT_BLUE.get().getDefaultState());
			break;
		case 1:
			setBlockState(worldIn, pos, TirphycraftBlocks.ANCIENT_RED.get().getDefaultState());
			break;
		case 2:
			setBlockState(worldIn, pos, TirphycraftBlocks.ANCIENT_GREEN.get().getDefaultState());
			break;
		case 3:
			setBlockState(worldIn, pos, TirphycraftBlocks.ANCIENT_YELLOW.get().getDefaultState());
			break;
		case 4:
			setBlockState(worldIn, pos, TirphycraftBlocks.ANCIENT_WHITE.get().getDefaultState());
			break;
		}
		return true;
	}

}
