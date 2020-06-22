package laz.tirphycraft.world.features.froz;

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

public class MajesticRoseFeature extends Feature<NoFeatureConfig>{

	public MajesticRoseFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (worldIn.getBlockState(pos.down(2)) != TirphycraftBlocks.POWDER_SNOW.get().getDefaultState() || rand.nextInt(10) > 0) return false;
		else setBlockState(worldIn, pos.down(), TirphycraftBlocks.FROZ_FLOWER1.get().getDefaultState());
		return true;
	}

}
