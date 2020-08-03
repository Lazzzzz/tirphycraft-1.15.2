package laz.tirphycraft.world.features.froz.underground;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class SilvirSaplingFeature extends UnderGroundFeature {

	public SilvirSaplingFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		
		BlockPos p = getGroundPos(worldIn, rand, pos);	
		if (worldIn.getBlockState(p.up()) == Blocks.AIR.getDefaultState() && rand.nextInt(10) == 0) {
			worldIn.setBlockState(p, TirphycraftBlocks.FROZ_DIRT.get().getDefaultState(), 3);
			worldIn.setBlockState(p.up(), TirphycraftBlocks.SAPLING_SILVIR.get().getDefaultState(), 3);
		}
		return true;
	}

}
