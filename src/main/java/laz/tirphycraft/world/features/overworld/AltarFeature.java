package laz.tirphycraft.world.features.overworld;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class AltarFeature extends Feature<NoFeatureConfig>{

	public AltarFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (rand.nextInt(100) > 0) return false;
		if (worldIn.getBlockState(pos) != Blocks.AIR.getDefaultState()) return false;
		BlockState block = TirphycraftBlocks.ALTAR.get().getDefaultState();
		block.createTileEntity(worldIn);
		worldIn.setBlockState(pos, block, 2);
		return true;
	}

}
