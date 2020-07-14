package laz.tirphycraft.world.features.laputa.structure;

import java.util.ArrayList;
import java.util.Random;

import laz.tirphycraft.content.tiles.laputaActivator.LaputaActivatorDownTE;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.structures.BasicVoxelShape;
import laz.tirphycraft.util.structures.CastleHelper;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class IslandPiece extends ScatteredStructurePiece {

	private int size = 64;
	private int y;

	public IslandPiece(Random rand, int xIn, int yIn, int zIn) {
		super(StructureFeatures.LAPUTA_DUNGEON_ISLAND, rand, xIn, yIn, zIn, 64, 64, 64);
		y = yIn;
	}

	public IslandPiece(TemplateManager p_i51351_1_, CompoundNBT nbt) {
		super(StructureFeatures.LAPUTA_DUNGEON_ISLAND, nbt);
		y = 180;
	}

	@Override
	public boolean func_225577_a_(IWorld world, ChunkGenerator<?> gen, Random rand, MutableBoundingBox box,
			ChunkPos pos) {

		int x = pos.x * 16;
		int z = pos.z * 16;
		BlockPos p = new BlockPos(x, y, z);
		generateIsland(world, p, rand);
		generateTree(world, p.up(11), rand);
		setActivator(world, p.up(10), rand, p);
		generateSurface(world, p, rand);
		generateRoot(world, p, rand);
		makeCastle(world, p, rand);
		return false;
	}

	private void generateIsland(IWorld world, BlockPos p, Random rand) {
		for (int i = -size; i <= size; i++) {
			for (int j = -size; j <= 10; j++) {
				for (int k = -size; k <= size; k++) {
					if (i * i + j * j + k * k <= (size - 8) * (size - 8) && j < 0) {
						if (j == -1)
							placeBrick(world, p.add(i, j, k), rand);
						else
							world.setBlockState(p.add(i, j, k), TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState(),
									2);
					}

					else if (i * i + j * j + k * k >= (size - 3) * (size - 3) && i * i + j * j + k * k <= size * size
							&& j > -size / 8) {
						placeBrick(world, p.add(i, j, k), rand);
						if (j < -3 && j > -size + 6 && i % 4 == 0 && k % 4 == 0)
							BasicVoxelShape.line(world, p.down(6), p.add(i, j, k), 1,
									TirphycraftBlocks.BRICKS_LAPUTA.get().getDefaultState());
					}
				}
			}
		}

		for (int i = -size / 3; i <= size / 3; i++) {
			for (int j = -5; j <= size / 2; j++) {
				for (int k = -size / 3; k <= size / 3; k++) {
					if (i * i + j * j * 3 + k * k <= (size / 3) * (size / 3))
						if (rand.nextBoolean())
							world.setBlockState(p.add(i, j, k), TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState(),
									2);
						else
							world.setBlockState(p.add(i, j, k), TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState(),
									2);
				}
			}
		}

	}

	private void generateSurface(IWorld world, BlockPos pos, Random rand) {
		for (int i = -size; i <= size; i++) {
			for (int j = -size; j <= 10; j++) {
				for (int k = -size; k <= size; k++) {
					if (i * i + j * j + k * k <= (size - 8) * (size - 8) && j < 0) {
						if (rand.nextInt(10) == 0)
							generateGrava(world, pos.add(i, j, k), rand);
					}
				}
			}
		}
	}

	private void generateGrava(IWorld world, BlockPos pos, Random rand) {
		for (int i = 0; i < rand.nextInt(5); i++) {
			placeBrick(world, pos.up(i), rand);
			if (rand.nextInt(5) == 0)
				world.setBlockState(pos.up(i), Blocks.BRICKS.getDefaultState(), 2);
		}
	}

	private void generateTree(IWorld world, BlockPos pos, Random rand) {
		BlockState LOG = TirphycraftBlocks.LOG_SKY.get().getDefaultState();
		BlockState LEAVES = TirphycraftBlocks.LEAVES_SKY.get().getDefaultState().with(LeavesBlock.PERSISTENT, true);
		BasicVoxelShape.cone(world, pos, 30, .3f, LOG);
		BasicVoxelShape.cone(world, pos, 26, .3f, Blocks.AIR.getDefaultState());
		BasicVoxelShape.sphere(world, pos.west(9).up(1), 2, Blocks.AIR.getDefaultState());

		for (int i = -40; i <= 40; i++) {
			for (int j = 0; j <= 40; j++) {
				for (int k = -40; k <= 40; k++) {
					float dy = j * 2f;
					if (i * i + dy * dy + k * k <= 40 * 40 && i * i + dy * dy + k * k >= 30 * 30) {
						BlockPos p = pos.add(i, 15 + j, k);
						if (world.getBlockState(p) == Blocks.AIR.getDefaultState())
							world.setBlockState(p, LEAVES, 2);
						if (rand.nextInt(100) == 0 && i * i + dy * dy + k * k <= 35 * 35)
							BasicVoxelShape.line(world, pos.up(rand.nextInt(5)).up(10), p, 1, LOG);
						if (rand.nextInt(7) == 0 && j == 0)
							makeBrench(world, p, rand);
						if (rand.nextInt(50) == 0)
							BasicVoxelShape.sphere(world, p, rand.nextInt(3) + 3, LEAVES);
					}
				}
			}
		}

	}

	private void makeBrench(IWorld world, BlockPos pos, Random rand) {
		for (int i = 0; i < rand.nextInt(20) + 10; i++) {
			world.setBlockState(pos.down(i),
					TirphycraftBlocks.LEAVES_SKY.get().getDefaultState().with(LeavesBlock.PERSISTENT, true), 2);
		}
	}

	private void makeTower(IWorld world, BlockPos pos, Random rand, int radius, int height) {
		BasicVoxelShape.TowerCylinder(world, pos, radius, height, 1, rand);
		BasicVoxelShape.cone(world, pos.up(height), radius + 1, 1.1f, Blocks.BRICKS.getDefaultState());
	}

	private void makeCastle(IWorld world, BlockPos pos, Random rand) {
		BasicVoxelShape.TowerCylinder(world, pos, 56, 18, 3, rand);
		BasicVoxelShape.cylinder(world, pos.up(16), 55, 2, 1, Blocks.AIR.getDefaultState());

		CastleHelper helper = new CastleHelper(world.getWorld(), pos, rand, size - 16);
		helper.generateTowerArea();
		ArrayList<AxisAlignedBB> areas = helper.getAreas();
		for (int i = 0; i < areas.size(); i++) {
			AxisAlignedBB area = areas.get(i);
			makeTower(world, new BlockPos(area.getCenter()), rand, (int) area.getXSize() - 1, rand.nextInt(10) + 20);
		}
	}

	public static void placeBrick(IWorld world, BlockPos p, Random rand) {
		switch (rand.nextInt(4)) {
		case 0:
			world.setBlockState(p, TirphycraftBlocks.BRICKS_LAPUTA.get().getDefaultState(), 2);
			break;
		case 1:
			world.setBlockState(p, TirphycraftBlocks.LAPUTA_DUNGEON_VARIANT0.get().getDefaultState(), 2);
			break;
		case 2:
			world.setBlockState(p, TirphycraftBlocks.LAPUTA_DUNGEON_VARIANT1.get().getDefaultState(), 2);
			break;
		case 3:
			world.setBlockState(p, TirphycraftBlocks.LAPUTA_DUNGEON_VARIANT2.get().getDefaultState(), 2);
			break;
		}
	}

	private void generateRoot(IWorld world, BlockPos p, Random rand) {
		for (int i = 0; i < rand.nextInt(20) + 40; i++) {
			BlockPos pos1 = p.add(rand.nextInt(40) - 20, -90 - rand.nextInt(10), rand.nextInt(40) - 20);
			for (int j = 0; j < 4; j++) {
				BlockPos pos2 = p.add(rand.nextInt(20) - 10, 0, rand.nextInt(20) - 10);
				BasicVoxelShape.line(world, pos1, pos2, 1, TirphycraftBlocks.LOG_SKY.get().getDefaultState());
			}
		}
	}

	public static void setActivator(IWorld world, BlockPos p, Random rand, BlockPos center) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				placeBrick(world, p.add(i, 1, j), rand);
			}
		}
		placeBrick(world, p.up(2), rand);
		world.setBlockState(p.up(3), TirphycraftBlocks.LAPUTA_ACTIVATOR_DOWN.get().getDefaultState(), 2);
		TileEntity tile = world.getTileEntity(p.up(3));
		if (tile instanceof LaputaActivatorDownTE) {
			((LaputaActivatorDownTE) tile).setCenter(center);
		}
	}
}
