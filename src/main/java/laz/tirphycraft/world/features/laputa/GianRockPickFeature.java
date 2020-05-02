package laz.tirphycraft.world.features.laputa;

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
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class GianRockPickFeature extends Feature<NoFeatureConfig> {
	
	public GianRockPickFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, NoFeatureConfig config) {
		if (position.getY() == 0 || position.getY() > 100)
			return false;

		int size = rand.nextInt(20) + 5;
		setPick(worldIn, rand, position, size);

		return true;
	}
	
	public boolean setPick(IWorld worldIn, Random rand, BlockPos position, int size) {
		
		for (int i = position.getY() + size; i >= 30; i--) {
			if (i == 30) return false;
			BlockPos p = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(p).getMaterial() == Material.ROCK) break;
		}
		
		for (int i = position.getY() + size; i > 0; i--) {
			BlockPos p = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK) placeBlock(worldIn, rand, p);
			else break;
		}

		if (size > 5) {
			for (int i = 0; i < 2; i++) {

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				setPick(worldIn, rand, position.add(Math.pow((-1), 2 + rand.nextInt(2)), 0, 0), size);

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				setPick(worldIn, rand, position.add(0, 0, Math.pow((-1), 2 + rand.nextInt(2))), size);
			}
		}
		return true;
	}

	private void placeBlock(IWorld worldIn, Random rand, BlockPos position) {
		if (rand.nextBoolean()) setBlockState(worldIn, position, TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState());
		else setBlockState(worldIn, position, TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState());
	}

}
