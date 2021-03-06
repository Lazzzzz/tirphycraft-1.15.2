package laz.tirphycraft.world.features.froz;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class GiantIcePickFeature extends Feature<IFeatureConfig> {
	
	private final Block ICE = Blocks.ICE;
	
	public GiantIcePickFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, IFeatureConfig config) {
		if (position.getY() == 0 || position.getY() > 100 || rand.nextInt(5) > 0)
			return false;

		int size = rand.nextInt(30) + 10;
		setPick(worldIn, rand, position, size);

		return true;
	}
	
	public void setPick(IWorld worldIn, Random rand, BlockPos position, int size) {
		for (int i = position.getY() + size; i > 0; i--) {
			BlockPos p = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK) setBlockState(worldIn, p, ICE.getDefaultState());
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
	}


}
