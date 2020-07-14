package laz.tirphycraft.world.features.laputa.oasis;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class OasisBorderFeature extends Feature<NoFeatureConfig> {

	public OasisBorderFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, NoFeatureConfig config) {
		if (position.getY() == 0 || position.getY() > 100)
			return false;

		Biome south = worldIn.getBiome(position.add(16, 0, 0));
		Biome north = worldIn.getBiome(position.add(-16, 0, 0));
		Biome east = worldIn.getBiome(position.add(0, 0, 16));
		Biome west = worldIn.getBiome(position.add(0, 0, -16));

		if (south == TirphycraftBiomes.L_OASIS.get() && north == TirphycraftBiomes.L_OASIS.get()
				&& east == TirphycraftBiomes.L_OASIS.get() && west == TirphycraftBiomes.L_OASIS.get())
			return false;

		int size = rand.nextInt(6) + 7;
		setPick(worldIn, rand, position, size);

		return true;
	}

	public boolean setPick(IWorld worldIn, Random rand, BlockPos position, int size) {

		for (int i = position.getY() + size; i > 0; i--) {
			if (i == 1)
				return false;
			BlockPos p = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(p).getMaterial() == Material.ROCK)
				break;
		}

		for (int i = position.getY() + size; i > 0; i--) {
			BlockPos p = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK) {
				if (i == position.getY() + size && worldIn.getBlockState(p.up()) == Blocks.AIR.getDefaultState())
					setBlockState(worldIn, p, TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState());
				else if (i > position.getY() + size - 3)
					setBlockState(worldIn, p, TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState());
				else
					placeBlock(worldIn, rand, p, size);
			} else
				break;
		}

		if (size > 4) {
			for (int i = 0; i < 2; i++) {

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				setPick(worldIn, rand, position.add(Math.pow((-1), 2 + rand.nextInt(2)), 0, 0), size);

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				setPick(worldIn, rand, position.add(0, 0, Math.pow((-1), 2 + rand.nextInt(2))), size);
			}
		}
		return true;
	}

	private void placeBlock(IWorld worldIn, Random rand, BlockPos position, int size) {
		switch (rand.nextInt(2)) {
		case 0:
			setBlockState(worldIn, position, TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState());
			break;
		case 1:
			setBlockState(worldIn, position, TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState());
			break;

		}
	}

}
