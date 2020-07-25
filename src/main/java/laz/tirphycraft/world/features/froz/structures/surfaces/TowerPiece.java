package laz.tirphycraft.world.features.froz.structures.surfaces;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.structures.BasicVoxelShape;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerPiece extends ScatteredStructurePiece {

	private int floorHeight;
	private int floorNumber;

	private final int radius = 8;

	public TowerPiece(Random rand, int xIn, int yIn, int zIn) {
		super(StructureFeatures.FROZ_TOWER, rand, xIn, yIn, zIn, 20, 100, 20);
	}

	public TowerPiece(TemplateManager manager, CompoundNBT nbt) {
		super(StructureFeatures.FROZ_TOWER, nbt);

	}

	@Override
	public boolean func_225577_a_(IWorld world, ChunkGenerator<?> gen, Random rand, MutableBoundingBox box,
			ChunkPos pos) {
		int x = pos.x * 16;
		int z = pos.z * 16;
		BlockPos p = world.getHeight(Type.WORLD_SURFACE, new BlockPos(x, 0, z));

		if (!canPlace(world, p))
			return false;

		floorHeight = 10;
		floorNumber = rand.nextInt(8) + 4;

		int size = (floorNumber * floorHeight);

		generateMainTower(world, p.down(2), rand, size);

		for (int i = 0; i < size; i += floorHeight) {
			makeFloor(world, p.up(i), rand);
			makeWindows(world, p.up(i), rand);
		}

		return false;
	}

	public boolean canPlace(IWorld world, BlockPos pos) {
		for (int i = -8; i <= 8; i++) {
			for (int j = -8; j <= 8; j++) {
				if (!world.getBlockState(pos.add(i, -2, j)).isSolid())
					return false;
			}
		}
		return true;
	}

	public void generateMainTower(IWorld world, BlockPos pos, Random rand, int size) {
		BasicVoxelShape.cylinder(world, pos, radius, size, 1, TirphycraftBlocks.BRICKS_FROZ.get().getDefaultState());
	}

	public void makeFloor(IWorld world, BlockPos pos, Random rand) {
		BasicVoxelShape.circle(world, pos, radius, TirphycraftBlocks.BRICKS_FROZ.get().getDefaultState());
	}

	public void makeWindows(IWorld world, BlockPos pos, Random rand) {
		for (int i = -1; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				for (int k = -1; k < 2; k++) {
					world.removeBlock(pos.add(i + radius, j, k), false);
					world.removeBlock(pos.add(i - radius, j, k), false);
					world.removeBlock(pos.add(i, j, k + radius), false);
					world.removeBlock(pos.add(i, j, k - radius), false);
				}
			}
		}
	}

}
