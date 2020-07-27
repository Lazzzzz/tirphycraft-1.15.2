package laz.tirphycraft.world.features.froz.underground;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class BasaltPatchFeature extends UnderGroundFeature {

	public BasaltPatchFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (rand.nextInt(10) > 0) return false;
		pos = pos.down(50);
		if (pos.getY() <= 0) return false;
		
		int size = rand.nextInt(6) + 3;
		float modx = 1f + rand.nextFloat();
		float modz = 1f + rand.nextFloat();
		float mody = .2f + rand.nextFloat();
		
		for (int i = -size * 2; i < size * 2; i++) {
			for (int j = -size / 2; j < size; j++) {
				for (int k = -size * 2; k < size * 2; k++) {
					double dx = i * modx;
					double dz = k * modz;
					double dy = j * mody;
					BlockPos p = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
					if (dx * dx + dy * dy + dz * dz <= size * size && p.getY() > 0) {
						if (worldIn.getBlockState(p) == TirphycraftBlocks.FROZ_STONE.get().getDefaultState()) {
							setBlockState(worldIn, p, TirphycraftBlocks.BASALT.get().getDefaultState(), true);
						}
					}
				}
			}
		}
		
		return true;
	}

}
