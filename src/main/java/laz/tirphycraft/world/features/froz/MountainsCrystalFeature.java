package laz.tirphycraft.world.features.froz;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class MountainsCrystalFeature extends Feature<IFeatureConfig> {

	public MountainsCrystalFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos p, IFeatureConfig config) {
		
		if (p.getY() > 145 || p.getY() < 90) return false;
		
		BlockState BLOCK = TirphycraftBlocks.FROZEN_CRYSTAL.get().getDefaultState();
		BlockPos pos = p;
		for (int i = pos.getY() + 1; i > 0; i--) {
			pos = new BlockPos(pos.getX(), i, pos.getZ());
			if (world.getBlockState(pos) == TirphycraftBlocks.FROZ_DIRT.get().getDefaultState()) break;
			if (i == 1) return false;
		}
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();


		int directionX = 0;
		int directionZ = 0;
		
		if (world.getBiome(pos.add(16, 0, 0)) != TirphycraftBiomes.F_MOUNTAINS.get() 
		 && world.getBiome(pos.add(-16, 0, 0)) != TirphycraftBiomes.F_MOUNTAINS.get()) {
			while (directionX == 0) {
				directionX = rand.nextInt(3) - 1;
			}
		}else {
			if (world.getBiome(pos.add(16, 0, 0)) != TirphycraftBiomes.F_MOUNTAINS.get()) directionX = 1;
			else directionX = -1;
		}
		
		if (world.getBiome(pos.add(0, 0, 16)) != TirphycraftBiomes.F_MOUNTAINS.get() 
		 && world.getBiome(pos.add(0, 0, -16)) != TirphycraftBiomes.F_MOUNTAINS.get()) {
			while (directionX == 0) {
				directionZ = rand.nextInt(3) - 1;
			}
		} else {
			if (world.getBiome(pos.add(0, 0, 16)) != TirphycraftBiomes.F_MOUNTAINS.get()) directionZ = 1;
			else directionZ = -1;
		}
		
		int length = 10 + rand.nextInt(5);
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

}