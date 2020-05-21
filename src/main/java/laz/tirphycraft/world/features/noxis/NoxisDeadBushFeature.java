package laz.tirphycraft.world.features.noxis;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class NoxisDeadBushFeature extends Feature<NoFeatureConfig>{

	public NoxisDeadBushFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (worldIn.getBlockState(pos.down()).getMaterial() != Material.ROCK) return false;
		else setBlockState(worldIn, pos, TirphycraftBlocks.NOXIS_FLOWER1.get().getDefaultState());
		return false;
	}

}
