package laz.tirphycraft.util.structures;

import java.util.Random;

import laz.tirphycraft.world.features.laputa.structure.IslandPiece;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class BasicVoxelShape {

	public static void sphere(IWorld world, BlockPos pos, int size, BlockState block) {
		for (int i = -size; i <= size; i++) {
			for (int j = -size; j <= size; j++) {
				for (int k = -size; k <= size; k++) {
					if (i * i + j * j + k * k <= size * size)
						world.setBlockState(pos.add(i, j, k), block, 2);
				}
			}
		}
	}

	public static void hsphere(IWorld world, BlockPos pos, int size, BlockState block) {
		for (int i = -size; i <= size; i++) {
			for (int j = -size; j <= size; j++) {
				for (int k = -size; k <= size; k++) {
					if (i * i + j * j + k * k <= size * size && i * i + j * j + k * k >= (size - 1) * (size - 1))
						setBlockState(world, pos.add(i, j, k), block);
				}
			}
		}
	}

	public static void TowerCylinder(IWorld world, BlockPos pos, int size, int height, int ep, Random rand) {
		for (int i = -size; i <= size; i++) {
			for (int j = 0; j <= height; j++) {
				for (int k = -size; k <= size; k++) {
					if (i * i + k * k <= size * size && i * i + k * k >= (size - ep) * (size - ep))
						IslandPiece.placeBrick(world, pos.add(i, j, k), rand);
				}
			}
		}
	}
	
	public static void cylinder(IWorld world, BlockPos pos, int size, int height, int ep, BlockState block) {
		for (int i = -size; i <= size; i++) {
			for (int j = 0; j <= height; j++) {
				for (int k = -size; k <= size; k++) {
					if (i * i + k * k <= size * size && i * i + k * k >= (size - ep) * (size - ep))
						world.setBlockState(pos.add(i, j, k), block, 2);
				}
			}
		}
	}

	public static void Castleline(IWorld world, BlockPos pos1, BlockPos pos2, int thic, Random rand) {
		int x0 = pos1.getX();
		int y0 = pos1.getY();
		int z0 = pos1.getZ();

		int x1 = pos2.getX();
		int y1 = pos2.getY();
		int z1 = pos2.getZ();

		int dx = Math.abs(x1 - x0);
		int dy = Math.abs(y1 - y0);
		int dz = Math.abs(z1 - z0);

		int stepX = x0 < x1 ? 1 : -1;
		int stepY = y0 < y1 ? 1 : -1;
		int stepZ = z0 < z1 ? 1 : -1;

		double hypotenuse = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
		double tMaxX = hypotenuse * 0.5 / dx;
		double tMaxY = hypotenuse * 0.5 / dy;
		double tMaxZ = hypotenuse * 0.5 / dz;
		double tDeltaX = hypotenuse / dx;
		double tDeltaY = hypotenuse / dy;
		double tDeltaZ = hypotenuse / dz;
		while (x0 != x1 || y0 != y1 || z0 != z1) {
			if (tMaxX < tMaxY) {
				if (tMaxX < tMaxZ) {
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
				} else if (tMaxX > tMaxZ) {
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				} else {
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				}
			} else if (tMaxX > tMaxY) {
				if (tMaxY < tMaxZ) {
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
				} else if (tMaxY > tMaxZ) {
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				} else {
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;

				}
			} else {
				if (tMaxY < tMaxZ) {
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
				} else if (tMaxY > tMaxZ) {
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				} else {
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;

				}
			}
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					IslandPiece.placeBrick(world, new BlockPos(x0 + i, y0, z0 + j), rand);					
				}
			}
		}
	}

	public static void cone(IWorld world, BlockPos pos, int size, float d, BlockState block) {
		for (int i = -size; i <= size; i++) {
			for (int j = -size; j <= -3; j++) {
				for (int k = -size; k <= size; k++) {
					double dy = j * d;
					if (i * i + k * k <= dy * dy) {
						world.setBlockState(pos.add(i, j + size, k), block, 2);
					}
				}
			}
		}

	}

	public static void line(IWorld world, BlockPos pos1, BlockPos pos2, int thic, BlockState block) {
		int x0 = pos1.getX();
		int y0 = pos1.getY();
		int z0 = pos1.getZ();

		int x1 = pos2.getX();
		int y1 = pos2.getY();
		int z1 = pos2.getZ();

		int dx = Math.abs(x1 - x0);
		int dy = Math.abs(y1 - y0);
		int dz = Math.abs(z1 - z0);

		int stepX = x0 < x1 ? 1 : -1;
		int stepY = y0 < y1 ? 1 : -1;
		int stepZ = z0 < z1 ? 1 : -1;

		double hypotenuse = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
		double tMaxX = hypotenuse * 0.5 / dx;
		double tMaxY = hypotenuse * 0.5 / dy;
		double tMaxZ = hypotenuse * 0.5 / dz;
		double tDeltaX = hypotenuse / dx;
		double tDeltaY = hypotenuse / dy;
		double tDeltaZ = hypotenuse / dz;
		while (x0 != x1 || y0 != y1 || z0 != z1) {
			if (tMaxX < tMaxY) {
				if (tMaxX < tMaxZ) {
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
				} else if (tMaxX > tMaxZ) {
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				} else {
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				}
			} else if (tMaxX > tMaxY) {
				if (tMaxY < tMaxZ) {
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
				} else if (tMaxY > tMaxZ) {
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				} else {
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;

				}
			} else {
				if (tMaxY < tMaxZ) {
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
				} else if (tMaxY > tMaxZ) {
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;
				} else {
					x0 = x0 + stepX;
					tMaxX = tMaxX + tDeltaX;
					y0 = y0 + stepY;
					tMaxY = tMaxY + tDeltaY;
					z0 = z0 + stepZ;
					tMaxZ = tMaxZ + tDeltaZ;

				}
			}
			if (thic != 1) {
				for (int i = -thic; i < thic; i++) {
					for (int j = -thic; j < thic; j++) {
						for (int k = -thic; k < thic; k++) {
							setBlockState(world, new BlockPos(x0 + i, y0 + j, z0 + k), block);
						}
					}
				}
			} else {
				setBlockState(world, new BlockPos(x0, y0, z0), block);
			}
		}
	}

	private static void setBlockState(IWorld world, BlockPos pos, BlockState block) {
		if (pos.getY() < 256 && pos.getY() > 0)
			if (world.getBlockState(pos) == Blocks.AIR.getDefaultState())
				world.setBlockState(pos, block, 2);
	}
}
