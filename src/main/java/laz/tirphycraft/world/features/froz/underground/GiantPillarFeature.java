package laz.tirphycraft.world.features.froz.underground;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class GiantPillarFeature extends UnderGroundFeature {

	public GiantPillarFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos p, NoFeatureConfig config) {
		BlockPos pos = getGroundPos(worldIn, rand, p);
		BlockPos pos2 = getTopPos(worldIn, rand, p);
		int size = 0;
		int hole = rand.nextInt(6);

		while (true) {
			size++;
			if (worldIn.getBlockState(pos.up(size)) == TirphycraftBlocks.FROZ_STONE.get().getDefaultState()
					|| pos.up(size).getY() > 48)
				break;
			placeBlock(worldIn, pos.up(size), rand);
		}
		if (hole > 1) {
			setBlockState(worldIn, new BlockPos(pos.getX(), (pos.getY() + size / 2) - hole / 2 - 1, pos.getZ()),
					Blocks.ICE.getDefaultState());
			setBlockState(worldIn, new BlockPos(pos.getX(), (pos.getY() + size / 2) + hole / 2, pos.getZ()),
					Blocks.ICE.getDefaultState());

			for (int i = (pos.getY() + size / 2) - hole / 2; i < (pos.getY() + size / 2) + hole / 2; i++) {
				setBlockState(worldIn, new BlockPos(pos.getX(), i, pos.getZ()), Blocks.AIR.getDefaultState());
			}
		}

		if (size < 3)
			return false;

		int s = Math.max((int) Math.min((size / (2)), size - (hole / 2) - 1), 1);

		generatePickTop(worldIn, rand, pos.add(1, 0, 0), rand.nextInt(s));
		generatePickTop(worldIn, rand, pos.add(-1, 0, 0), rand.nextInt(s));
		generatePickTop(worldIn, rand, pos.add(0, 0, 1), rand.nextInt(s));
		generatePickTop(worldIn, rand, pos.add(0, 0, -1), rand.nextInt(s));

		generatePickBottom(worldIn, rand, pos2.add(1, 0, 0), rand.nextInt(s));
		generatePickBottom(worldIn, rand, pos2.add(-1, 0, 0), rand.nextInt(s));
		generatePickBottom(worldIn, rand, pos2.add(0, 0, 1), rand.nextInt(s));
		generatePickBottom(worldIn, rand, pos2.add(0, 0, -1), rand.nextInt(s));

		return true;
	}

	public boolean generatePickTop(IWorld worldIn, Random rand, BlockPos position, int size) {
		for (int i = position.getY() + size; i > 0; i--) {
			BlockPos p = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK)
				placeBlock(worldIn, p, rand);
			else
				break;
		}

		if (size > 3) {
			for (int i = 0; i < 2; i++) {

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				generatePickTop(worldIn, rand, position.add(Math.pow((-1), 2 + rand.nextInt(2)), 0, 0), size);

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				generatePickTop(worldIn, rand, position.add(0, 0, Math.pow((-1), 2 + rand.nextInt(2))), size);
			}
		}
		return true;
	}

	public boolean generatePickBottom(IWorld worldIn, Random rand, BlockPos position, int size) {
		for (int i = position.getY() - size; i < 48; i++) {
			BlockPos p = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK)
				placeBlock(worldIn, p, rand);
			else
				break;
		}

		if (size > 3) {
			for (int i = 0; i < 2; i++) {

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				generatePickBottom(worldIn, rand, position.add(Math.pow((-1), 2 + rand.nextInt(2)), 0, 0), size);

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				generatePickBottom(worldIn, rand, position.add(0, 0, Math.pow((-1), 2 + rand.nextInt(2))), size);
			}
		}
		return true;
	}

}
