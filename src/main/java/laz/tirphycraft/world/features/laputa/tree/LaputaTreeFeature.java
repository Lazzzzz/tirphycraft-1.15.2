package laz.tirphycraft.world.features.laputa.tree;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.TirphycraftUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class LaputaTreeFeature extends Feature<IFeatureConfig> {

	BlockState LOG = TirphycraftBlocks.LOG_SKY.get().getDefaultState();
	BlockState LEAVES = TirphycraftBlocks.LEAVES_SKY.get().getDefaultState()
			.with(LeavesBlock.DISTANCE, Integer.valueOf(7)).with(LeavesBlock.PERSISTENT, Boolean.valueOf(true));

	public LaputaTreeFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, IFeatureConfig config) {
		if (pos.getY() > 120) return false;
		if (pos.getY() == 0) return false;
		if (worldIn.getBlockState(pos.down()) != TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState()
		 && worldIn.getBlockState(pos.down()) != TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState()
		 && worldIn.getBlockState(pos.down()) != TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState())
			return false;

		int size = rand.nextInt(10) + 3;
		int size_t = rand.nextInt(size - 2) + 2;
		int offsetx = rand.nextInt(2) - 1;
		int offsetz = rand.nextInt(2) - 1;
		BlockPos p = pos;

		for (int i = 0; i < size; i++) {
			if (size_t == i) {
				this.setBlockState(worldIn, pos.up(i), LOG);
			}
			if (i < size_t) {
				this.setBlockState(worldIn, pos.up(i), LOG);
				if (rand.nextInt(8) == 0)
					TirphycraftUtils.generateLeafNode(worldIn, rand, pos.west(rand.nextInt(3)).east(rand.nextInt(3))
							.south(rand.nextInt(3)).north(rand.nextInt(3)).up(i), LEAVES);
			} else {
				p = new BlockPos(pos.getX() + offsetx, i + pos.getY(), pos.getZ() + offsetz);
				this.setBlockState(worldIn, p, LOG);
				if (rand.nextInt(4) == 0)
					TirphycraftUtils.generateLeafNode(worldIn, rand,
							p.west(rand.nextInt(3)).east(rand.nextInt(3)).south(rand.nextInt(3)).north(rand.nextInt(3)),
							LEAVES);

			}
		}

		TirphycraftUtils.generateLeafNode(worldIn, rand,
				p.up(1).west(rand.nextInt(2)).east(rand.nextInt(2)).south(rand.nextInt(2)).north(rand.nextInt(2)),
				LEAVES);
		return true;
	}

}
