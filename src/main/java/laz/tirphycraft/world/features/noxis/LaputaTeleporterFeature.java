package laz.tirphycraft.world.features.noxis;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class LaputaTeleporterFeature extends Feature<NoFeatureConfig> {

	private final BlockState FRAME = TirphycraftBlocks.BRICKS_LAPUTA.get().getDefaultState();

	public LaputaTeleporterFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		BlockState PORTAL = TirphycraftBlocks.LAPUTA_TELEPORTER.get().getDefaultState();
		BlockState PORTAL_ = TirphycraftBlocks.__LAPUTA_TELEPORTER.get().getDefaultState();
		
		pos = worldIn.getHeight(Type.WORLD_SURFACE, pos).down();
		System.out.println(worldIn.getBlockState(pos.down(2)));
		if (worldIn.getBlockState(pos.down(2)) == PORTAL || worldIn.getBlockState(pos.down(2)) == PORTAL_) return false;

		int radius = 8;
		for (int i = -radius; i <= radius; i++) {
			for (int j = -radius; j <= radius; j++) {
				if (i * i + j * j <= radius * radius) {
					BlockPos p = new BlockPos(pos.getX() + i, pos.getY(), pos.getZ() + j);
					if (rand.nextInt((int) (Math.sqrt(i * i + j * j) / 3)+ 1) == 0) {
						p = worldIn.getHeight(Type.WORLD_SURFACE, p).down();
						if (worldIn.getBlockState(p).isSolid()) {
							if (rand.nextBoolean()) setBlockState(worldIn, p, TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState());
							else setBlockState(worldIn, p, TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState());
						}
					}
				}
			}
		}
		
		for (int i = -3; i <= 3; i++) {
			for (int j = -3; j <= 3; j++) {
				if (i * i + j * j <= 3 * 3) {
					BlockPos p = new BlockPos(pos.getX() + i, pos.getY(), pos.getZ() + j);
					p = worldIn.getHeight(Type.WORLD_SURFACE, p);
					int dif = p.getY() - pos.getY();
					if (dif > 0) {
						for (int k = p.getY() + dif; k > pos.getY(); k--) {
							p = new BlockPos(p.getX(), k, p.getZ());
							setBlockState(worldIn, p, Blocks.AIR.getDefaultState());
						}
					}
				}
			}
		}
		
		for (int i = -2; i < 3; i++) {
			setBlockState(worldIn, pos.add(i, 0, 0), FRAME);
			setBlockState(worldIn, pos.add(i, 4, 0), FRAME);
			setBlockState(worldIn, pos.add(-2, i + 2, 0), FRAME);
			setBlockState(worldIn, pos.add(2, i + 2, 0), FRAME);
		}

		setBlockState(worldIn, pos.up(2), PORTAL);
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!(i == 0 && j == 0))
					setBlockState(worldIn, pos.add(i, j+2, 0), PORTAL_);

			}
		}

		for (int i = -radius; i <= radius; i++) {
			for (int j = -radius; j <= radius; j++) {
				if (i * i + j * j <= radius * radius) {
					BlockPos p = new BlockPos(pos.getX() + i, pos.getY(), pos.getZ() + j);
					if (i * i + j * j >= (radius - 1) * (radius - 1) && i % 2 == 0 && j % 2 == 0)
						makePillar(worldIn, p, rand);
				}

			}
		}

		return true;
	}

	public void makePillar(IWorld worldIn, BlockPos pos, Random rand) {
		int max_size = 4;
		int y = worldIn.getHeight(Type.WORLD_SURFACE, pos).getY();
		for (int k = y + rand.nextInt(max_size) + 1; k >= y - 1; k--) {
			setBlockState(worldIn, new BlockPos(pos.getX(), k, pos.getZ()), FRAME);
		}

	}

}
