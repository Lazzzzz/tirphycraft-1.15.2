package laz.tirphycraft.world.features.froz;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class IcePillarFeature extends Feature<IFeatureConfig> {

	public IcePillarFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, IFeatureConfig config) {
		int size = rand.nextInt(5) + 2;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				base(worldIn, rand, position.add(i, 0, j));
			}
		}

		return true;
	}

	public void base(IWorld worldIn, Random rand, BlockPos pos) {
		for (int i = pos.getY() + rand.nextInt(25); i > 0; i--) {
			BlockPos p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK) {
				int r = rand.nextInt(10);
				if (r == 0)
					setBlockState(worldIn, p, Blocks.OBSIDIAN.getDefaultState());
				else if (r > 5)
					setBlockState(worldIn, p, Blocks.PACKED_ICE.getDefaultState());
				else
					setBlockState(worldIn, p, Blocks.ICE.getDefaultState());
			}
		}

	}

}