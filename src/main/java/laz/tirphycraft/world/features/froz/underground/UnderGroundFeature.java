package laz.tirphycraft.world.features.froz.underground;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBiomes;
import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class UnderGroundFeature extends Feature<NoFeatureConfig> {

	public UnderGroundFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		return false;
	}

	public BlockPos getGroundPos(IWorld worldIn, Random rand, BlockPos pos) {
		BlockPos p = pos;
		for (int i = 30; i > 0; i--) {
			p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p) == TirphycraftBlocks.FROZ_STONE.get().getDefaultState())
				return p;
		}
		return p;
	}
	
	public BlockPos getTopPos(IWorld worldIn, Random rand, BlockPos pos) {
		BlockPos p = pos;
		for (int i = 20; i < 50; i++) {
			p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p) == TirphycraftBlocks.FROZ_STONE.get().getDefaultState())
				return p;
		}
		return p;
	}

}
