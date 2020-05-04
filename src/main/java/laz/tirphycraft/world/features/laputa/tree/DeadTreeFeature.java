package laz.tirphycraft.world.features.laputa.tree;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class DeadTreeFeature extends Feature<NoFeatureConfig> {

	BlockState LOG = TirphycraftBlocks.LOG_SKY.get().getDefaultState();

	public DeadTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos p, NoFeatureConfig config) {

		if (p.getY() == 0 || worldIn.getBlockState(p.down()) == TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState() || worldIn.getBlockState(p.down()) == TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState())
			return false;

		int size = rand.nextInt(6) + 1;
		for (int i = p.getY() + size; i > 0; i--) {
			BlockPos pos = new BlockPos(p.getX(), i, p.getZ());
			if (worldIn.getBlockState(pos).getMaterial() == Material.ROCK) {
				break;
			}
			if (i < 2) return false;
		}
		
		for (int i = p.getY() + size; i > 0; i--) {

			BlockPos pos = new BlockPos(p.getX(), i, p.getZ());
			if (worldIn.getBlockState(pos).getMaterial() == Material.ROCK) {
				return true;
			}

			setBlockState(worldIn, pos, LOG);
			if (i > p.getY() + 1 && i < p.getY() + size && rand.nextInt(2) == 0) {
				if (rand.nextBoolean()) {
					if (rand.nextBoolean()) {
						setBlockState(worldIn, pos.north(), TirphycraftBlocks.LOG_SKY.get().getDefaultState()
								.with(LogBlock.AXIS, Direction.Axis.X));

					} else {
						setBlockState(worldIn, pos.south(), TirphycraftBlocks.LOG_SKY.get().getDefaultState()
								.with(LogBlock.AXIS, Direction.Axis.X));

					}
				} else {
					if (rand.nextBoolean()) {
						setBlockState(worldIn, pos.east(), TirphycraftBlocks.LOG_SKY.get().getDefaultState()
								.with(LogBlock.AXIS, Direction.Axis.Z));

					} else {
						setBlockState(worldIn, pos.west(), TirphycraftBlocks.LOG_SKY.get().getDefaultState()
								.with(LogBlock.AXIS, Direction.Axis.Z));

					}
				}

			}
		}
		return true;
	}
}