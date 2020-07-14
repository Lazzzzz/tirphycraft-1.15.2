package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class CrystalSpikeFeature extends Feature<IFeatureConfig> {

	public CrystalSpikeFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos p, IFeatureConfig config) {
		if (p.getY() > 120) return false;
		BlockState BLOCK = randBlock(rand);
		BlockPos pos = p;
		for (int i = pos.getY() + 1; i > 0; i--) {
			pos = new BlockPos(pos.getX(), i, pos.getZ());
			if (world.getBlockState(pos) == TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState()) break;
			if (i == 1) return false;
		}
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();


		int directionX = 0;
		int directionZ = 0;
		while (directionZ == 0 && directionX == 0) {
			directionX = 1 - rand.nextInt(3);
			directionZ = 1 - rand.nextInt(3);
		}

		int length = 5 + rand.nextInt(4);
		float radius = length / 2;

		for (int j = 0; j < length; j++) {
			for (int i = (int) -radius; i < radius; i++) {
				for (int k = (int) -radius; k < radius; k++) {
					if (i * i + k * k < radius) {
						BlockState old = world.getBlockState(new BlockPos(x + i + directionX * j, y + j, z + k + directionZ * j));
						this.setBlockState(world, new BlockPos(x + i + directionX * j, y + j, z + k + directionZ * j),
								BLOCK);

						old = world.getBlockState(new BlockPos(x - i - directionX * j, y - j, z - k - directionZ * j));
						this.setBlockState(world, new BlockPos(x - i - directionX * j, y - j, z - k - directionZ * j),
								BLOCK);

					}
				}
			}
			radius -= 0.5F;
		}

		return true;
	}
	
	public BlockState randBlock(Random rand) {
		int r = rand.nextInt(5);
		if (r==0) return TirphycraftBlocks.LAPUTA_BLUE.get().getDefaultState();
		else if (r==1) return TirphycraftBlocks.LAPUTA_GREEN.get().getDefaultState();
		else if (r==2) return TirphycraftBlocks.LAPUTA_PURPLE.get().getDefaultState();
		else if (r==3) return TirphycraftBlocks.LAPUTA_YELLOW.get().getDefaultState();
		else return TirphycraftBlocks.LAPUTA_PINK.get().getDefaultState();
		
	}

}