package laz.tirphycraft.world.features.laputa.structure.pieces;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.nbt.CompoundNBT;
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
		super(StructureFeatures.LAPUTA_DUNGEON_PIECE, rand, xIn, yIn, zIn, 64, 64, 64);
		y = yIn;
	}

	public IslandPiece(TemplateManager p_i51351_1_, CompoundNBT nbt) {
		super(StructureFeatures.LAPUTA_DUNGEON_PIECE, nbt);
		y = 180;
	}

	@Override
	public boolean create(IWorld world, ChunkGenerator<?> gen, Random rand, MutableBoundingBox box,
			ChunkPos pos) {

		int x = pos.x * 16;
		int z = pos.z * 16;
		BlockPos p = new BlockPos(x, y, z);
		
		for (int i = -size; i <= size; i++) {
			for (int j = -size; j <= 10; j++) {
				for (int k = -size; k <= size; k++) {
					if (i * i + j * j + k * k <= (size - 8) * (size - 8) && j < 0) {
						world.setBlockState(p.add(i,j,k), TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState(), 2);
					}

					else if (i * i + j * j + k * k >= (size - 3) * (size - 3) && i * i + j * j + k * k <= size * size
							&& j > -size / 8) {
						world.setBlockState(p.add(i,j,k), TirphycraftBlocks.BRICKS_LAPUTA.get().getDefaultState(), 2);
					}
				}
			}
		}

		for (int i = -size / 3; i <= size / 3; i++) {
			for (int j = -5; j <= size/2; j++) {
				for (int k = -size / 3; k <= size / 3; k++) {
					if (i * i + j * j * 3 + k * k <= (size / 3) * (size / 3)) world.setBlockState(p.add(i,j,k), TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState(), 2);
				}
			}
		}
		return false;
	}
}
