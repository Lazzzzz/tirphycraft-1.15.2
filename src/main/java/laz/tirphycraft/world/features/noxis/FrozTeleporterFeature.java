package laz.tirphycraft.world.features.noxis;

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

public class FrozTeleporterFeature extends Feature<NoFeatureConfig> {

	public FrozTeleporterFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		for (int i = 255; i > 0; i--) {
			BlockPos p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p) == Blocks.STONE.getDefaultState()) {
				pos = p;
				break;
			}
		}
		
		for (int i = -4; i < 5; i++) {
			for (int j = -4; j < 5; j++) {
				for (int k = 1; k < pos.getY() + 10; k++) {
					BlockPos p = new BlockPos(pos.getX() + i, k, pos.getZ() + j);
					setBlockState(worldIn, p, Blocks.STONE_BRICKS.getDefaultState());
				}
			}
		}

		return true;
	}

}
