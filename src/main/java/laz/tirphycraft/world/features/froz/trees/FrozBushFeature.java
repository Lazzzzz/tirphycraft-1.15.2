package laz.tirphycraft.world.features.froz.trees;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FrozBushFeature extends Feature<NoFeatureConfig> {

	BlockState LOG = TirphycraftBlocks.LOG_FROZ.get().getDefaultState();
	BlockState LEAVES = TirphycraftBlocks.LEAVES_FROZ.get().getDefaultState().with(LeavesBlock.PERSISTENT, true);

	public FrozBushFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (worldIn.getBlockState(pos.down(2)) != TirphycraftBlocks.POWDER_SNOW.get().getDefaultState()) return false; 
		
		int size = rand.nextInt(4) + 3;
		
		for (int i = pos.getY() + size; i > 0; i--) {
			BlockPos p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p) == TirphycraftBlocks.POWDER_SNOW.get().getDefaultState()) break;
			else setBlockState(worldIn, p, LOG);
		}
			
		float modx = 1f + rand.nextFloat();
		float mody = 1f + rand.nextFloat();
		float modz = 1f + rand.nextFloat();
		
		int s = Math.min(size, 4);
		for (int i = -s; i <= s; i++) {
			for (int j = -s; j <= s; j++) {
				for (int k = -s; k <= s; k++) {
					float dx = i * modx;
					float dy = j * mody;
					float dz = k * modz;
					if ((dx * dx) + (dy * dy) + (dz * dz) <= (s * s)) {
						BlockPos p = new BlockPos(pos.getX() + i, pos.getY() + size + j, pos.getZ() + k);
						if (worldIn.getBlockState(p) == Blocks.AIR.getDefaultState()) setBlockState(worldIn, p, LEAVES);
					}
					
				}
			}
		}
		
		return true;
	}

}
