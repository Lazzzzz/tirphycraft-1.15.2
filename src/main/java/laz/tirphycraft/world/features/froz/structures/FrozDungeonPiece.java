package laz.tirphycraft.world.features.froz.structures;

import java.util.List;
import java.util.Random;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.util.structures.FrozDungeonHelper;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.StructureMode;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.spawner.AbstractSpawner;

public class FrozDungeonPiece {
	private static final ResourceLocation ALL = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/froz_dungeon_all");
	private static final ResourceLocation V0 = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/froz_dungeon_0");
	private static final ResourceLocation V1 = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/froz_dungeon_1");
	private static final ResourceLocation V2 = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/froz_dungeon_2");
	private static final ResourceLocation BOSS = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/boss_room");

	private static final ResourceLocation LOOT = new ResourceLocation(Tirphycraft.MOD_ID + ":chests/froz_dungeon");

	public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation,
			List<StructurePiece> pieceList, Random random) {
		int x = pos.getX();
		int z = pos.getZ();

		int cell_size_w = 8;

		int sx = 7;
		int sy = 7;

		FrozDungeonHelper mazeBottomLEFT = new FrozDungeonHelper(sx, sy, random).generateGrid();
		FrozDungeonHelper mazeBottomRIGHT = new FrozDungeonHelper(sx, sy, random).generateGrid();
		FrozDungeonHelper mazeTopLEFT = new FrozDungeonHelper(sx, sy, random).generateGrid();
		FrozDungeonHelper mazeTopRIGHT = new FrozDungeonHelper(sx, sy, random).generateGrid();

		FrozDungeonHelper mazeMidLEFT = new FrozDungeonHelper(7, 3, random).generateGrid();
		FrozDungeonHelper mazeMidRIGHT = new FrozDungeonHelper(7, 3, random).generateGrid();
		FrozDungeonHelper mazeMidTOP = new FrozDungeonHelper(3, 7, random).generateGrid();
		FrozDungeonHelper mazeMidBOTTOM = new FrozDungeonHelper(3, 7, random).generateGrid();

		int r = random.nextInt(sx);
		mazeBottomRIGHT.getLeftCells(r).setWall(2, false);
		mazeMidTOP.getRightCells(r).setWall(0, false);

		r = random.nextInt(sx);
		mazeTopRIGHT.getLeftCells(r).setWall(2, false);
		mazeMidBOTTOM.getRightCells(r).setWall(0, false);

		r = random.nextInt(sx);
		mazeBottomLEFT.getRightCells(r).setWall(0, false);
		mazeMidTOP.getLeftCells(r).setWall(2, false);

		r = random.nextInt(sx);
		mazeTopLEFT.getRightCells(r).setWall(0, false);
		mazeMidBOTTOM.getLeftCells(r).setWall(2, false);

		r = random.nextInt(sx);
		mazeBottomRIGHT.getTopCells(r).setWall(1, false);
		mazeMidLEFT.getBottomCells(r).setWall(3, false);

		r = random.nextInt(sx);
		mazeBottomLEFT.getTopCells(r).setWall(1, false);
		mazeMidRIGHT.getBottomCells(r).setWall(3, false);

		r = random.nextInt(sx);
		mazeTopLEFT.getBottomCells(r).setWall(3, false);
		mazeMidRIGHT.getTopCells(r).setWall(1, false);

		r = random.nextInt(sx);
		mazeTopRIGHT.getBottomCells(r).setWall(3, false);
		mazeMidLEFT.getTopCells(r).setWall(1, false);

		int dir = random.nextInt(4);
		int door = random.nextInt(3);

		if (dir == 0)
			mazeMidLEFT.getLeftCells(door).setWall(2, false);
		if (dir == 1)
			mazeMidRIGHT.getRightCells(door).setWall(0, false);
		if (dir == 2)
			mazeMidBOTTOM.getBottomCells(door).setWall(3, false);
		if (dir == 3)
			mazeMidTOP.getTopCells(door).setWall(1, false);

		mazeMidLEFT.getRightCells(door).setWall(0, false);
		mazeMidRIGHT.getLeftCells(door).setWall(2, false);
		mazeMidBOTTOM.getTopCells(door).setWall(1, false);
		mazeMidTOP.getBottomCells(door).setWall(3, false);

		boolean[] wall = { false, false, false, false };
		pieceList.add(new FrozDungeonPiece.Piece(templateManager, BOSS, new BlockPos(x + 56, pos.getY(), z + 56),
				Rotation.NONE, wall, true));

		for (int i = 0; i < sx; i++) {
			for (int j = 0; j < sy; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w, 0, j * cell_size_w);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeBottomLEFT.getWalls(i, j);
				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}

		for (int i = 0; i < sx; i++) {
			for (int j = 0; j < sy; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w + 80, 0, j * cell_size_w);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeBottomRIGHT.getWalls(i, j);

				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}

		for (int i = 0; i < sx; i++) {
			for (int j = 0; j < sy; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w, 0, j * cell_size_w + 80);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeTopLEFT.getWalls(i, j);

				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}
		for (int i = 0; i < sx; i++) {
			for (int j = 0; j < sy; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w + 80, 0, j * cell_size_w + 80);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeTopRIGHT.getWalls(i, j);

				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w + 80, 0, j * cell_size_w + 56);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeMidLEFT.getWalls(i, j);
				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w, 0, j * cell_size_w + 56);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeMidRIGHT.getWalls(i, j);

				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 7; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w + 56, 0, j * cell_size_w);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeMidTOP.getWalls(i, j);

				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 7; j++) {
				BlockPos rotationOffSet = new BlockPos(i * cell_size_w + 56, 0, j * cell_size_w + 80);
				BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
				boolean[] walls = mazeMidBOTTOM.getWalls(i, j);

				pieceList.add(
						new FrozDungeonPiece.Piece(templateManager, getPiece(random), blockpos, Rotation.NONE, walls));
			}
		}
	}

	private static ResourceLocation getPiece(Random random) {
		switch (random.nextInt(15)) {
		case 0:
			return V0;
		case 1:
			return V1;
		case 2:
			return V2;
		}
		return ALL;
	}

	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;
		private boolean walls[];
		private boolean bossRoom = false;

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn, boolean walls[]) {
			super(StructureFeatures.FROZ_DUNGEON_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			this.templatePosition = pos;
			this.rotation = Rotation.NONE;
			this.walls = walls;
			this.setupPiece(templateManagerIn);
		}

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn, boolean walls[], boolean bossRoom) {
			super(StructureFeatures.FROZ_DUNGEON_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			this.templatePosition = pos;
			this.rotation = Rotation.NONE;
			this.walls = walls;
			this.setupPiece(templateManagerIn);
			this.bossRoom = bossRoom;
		}

		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
			super(StructureFeatures.FROZ_DUNGEON_PIECE, tagCompound);
			this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
			this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
			this.setupPiece(templateManagerIn);
		}

		private void setupPiece(TemplateManager templateManager) {
			Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation)
					.setMirror(Mirror.NONE);
			this.setup(template, this.templatePosition, placementsettings);
		}

		@Override
		protected void readAdditional(CompoundNBT tagCompound) {
			super.readAdditional(tagCompound);
			tagCompound.putString("Template", this.resourceLocation.toString());
			tagCompound.putString("Rot", this.rotation.name());
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand,
				MutableBoundingBox sbb) {
			if ("chest".equals(function)) {
				worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
				TileEntity tileentity = worldIn.getTileEntity(pos);

				if (tileentity instanceof ChestTileEntity) {

				}
			}
		}

		@Override
		public boolean create(IWorld worldIn, ChunkGenerator<?> p_225577_2_, Random randomIn,
				MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos) {
			this.placeSettings.setBoundingBox(structureBoundingBoxIn);
			this.boundingBox = this.template.getMutableBoundingBox(this.placeSettings, this.templatePosition);
			if (this.template.addBlocksToWorld(worldIn, this.templatePosition, this.placeSettings, 2)) {
				for (Template.BlockInfo template$blockinfo : this.template.func_215381_a(this.templatePosition,
						this.placeSettings, Blocks.STRUCTURE_BLOCK)) {
					if (template$blockinfo.nbt != null) {
						StructureMode structuremode = StructureMode.valueOf(template$blockinfo.nbt.getString("mode"));
						if (structuremode == StructureMode.DATA) {
							this.handleDataMarker(template$blockinfo.nbt.getString("metadata"), template$blockinfo.pos,
									worldIn, randomIn, structureBoundingBoxIn);
						}
					}
				}

				for (Template.BlockInfo template$blockinfo1 : this.template.func_215381_a(this.templatePosition,
						this.placeSettings, Blocks.JIGSAW)) {
					if (template$blockinfo1.nbt != null) {
						String s = template$blockinfo1.nbt.getString("final_state");
						BlockStateParser blockstateparser = new BlockStateParser(new StringReader(s), false);
						BlockState blockstate = Blocks.AIR.getDefaultState();

						try {
							blockstateparser.parse(true);
							BlockState blockstate1 = blockstateparser.getState();
							if (blockstate1 != null) {
								blockstate = blockstate1;
							} else {
								Tirphycraft.LOGGER.error("Error while parsing blockstate {} in jigsaw block @ {}", s,
										template$blockinfo1.pos);
							}
						} catch (CommandSyntaxException var14) {
							Tirphycraft.LOGGER.error("Error while parsing blockstate {} in jigsaw block @ {}", s,
									template$blockinfo1.pos);
						}

						worldIn.setBlockState(template$blockinfo1.pos, blockstate, 3);
					}
				}
			}
			if (!bossRoom) {
				for (int i = 1; i < 7; i++) {
					for (int k = 1; k < 7; k++) {
						if (randomIn.nextInt(20) == 0) {
							switch (randomIn.nextInt(3)) {
							case 0:
								worldIn.setBlockState(templatePosition.add(i, 0, k),
										TirphycraftBlocks.FROZ_DUNGEON_TRAP1.get().getDefaultState(), 3);
								break;
							case 1:
								worldIn.setBlockState(templatePosition.add(i, 0, k),
										TirphycraftBlocks.FROZ_DUNGEON_TRAP2.get().getDefaultState(), 3);
								break;
							case 2:
								worldIn.setBlockState(templatePosition.add(i, 0, k),
										TirphycraftBlocks.FROZ_DUNGEON_TRAP3.get().getDefaultState(), 3);
								break;
							}
						} else {
							switch (randomIn.nextInt(6)) {
							case 0:
								worldIn.setBlockState(templatePosition.add(i, 0, k),
										TirphycraftBlocks.FROZ_DUNGEON_VARIANT1.get().getDefaultState(), 3);
								break;
							case 1:
								worldIn.setBlockState(templatePosition.add(i, 0, k),
										TirphycraftBlocks.FROZ_DUNGEON_VARIANT2.get().getDefaultState(), 3);
								break;

							}
						}
					}
				}

				if (randomIn.nextInt(17) == 0) {
					BlockPos pos = templatePosition.add(2 + randomIn.nextInt(6), 1, 2 + randomIn.nextInt(6));
					worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState().rotate(Rotation.randomRotation(randomIn)),
							3);
					TileEntity tileentity = worldIn.getTileEntity(pos);
					if (tileentity instanceof ChestTileEntity) {
						((ChestTileEntity) tileentity).setLootTable(LOOT, randomIn.nextLong());
					}
				}

				if (randomIn.nextInt(20) == 0) {
					BlockPos pos = templatePosition.add(2 + randomIn.nextInt(6), 1, 2 + randomIn.nextInt(6));
					worldIn.setBlockState(pos, Blocks.SPAWNER.getDefaultState(), 3);
					TileEntity tileentity = worldIn.getTileEntity(pos);
					if (tileentity instanceof MobSpawnerTileEntity) {
						 AbstractSpawner abstractspawner = ((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic();
						 if (randomIn.nextBoolean()) abstractspawner.setEntityType(TirphycraftEntities.ENTITY_CROCROCASSE);
						 else abstractspawner.setEntityType(TirphycraftEntities.ENTITY_FROZEN_SOLDIER);
					}
				}

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 2; j++) {
						int k = randomIn.nextInt(7);
						if (k == 0) {
							if (j == 0) {
								switch (i) {
								case 0:
									worldIn.setBlockState(templatePosition.add(0, 1, 1),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;
								case 1:
									worldIn.setBlockState(templatePosition.add(1, 1, 0),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;
								case 2:
									worldIn.setBlockState(templatePosition.add(6, 1, 0),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;
								case 3:
									worldIn.setBlockState(templatePosition.add(0, 1, 6),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;
								case 4:
									worldIn.setBlockState(templatePosition.add(1, 1, 7),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;

								case 5:
									worldIn.setBlockState(templatePosition.add(7, 1, 1),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;

								case 6:
									worldIn.setBlockState(templatePosition.add(8, 1, 7),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;

								case 7:
									worldIn.setBlockState(templatePosition.add(7, 1, 8),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT6.get().getDefaultState(), 3);
									break;
								}
							} else {
								switch (i) {
								case 0:
									worldIn.setBlockState(templatePosition.add(0, 3, 1),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								case 1:
									worldIn.setBlockState(templatePosition.add(1, 3, 0),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								case 2:
									worldIn.setBlockState(templatePosition.add(6, 3, 0),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								case 3:
									worldIn.setBlockState(templatePosition.add(0, 3, 6),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								case 4:
									worldIn.setBlockState(templatePosition.add(1, 3, 7),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								case 5:
									worldIn.setBlockState(templatePosition.add(7, 3, 1),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								case 6:
									worldIn.setBlockState(templatePosition.add(8, 3, 7),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								case 7:
									worldIn.setBlockState(templatePosition.add(7, 3, 8),
											TirphycraftBlocks.FROZ_DUNGEON_VARIANT5.get().getDefaultState(), 3);
									break;
								}
							}
						}
					}
				}
			}

			if (walls != null) {
				if (walls[2]) {
					setWall(worldIn, 2, randomIn);
				}

				if (walls[0]) {
					setWall(worldIn, 0, randomIn);
				}

				if (walls[1]) {
					setWall(worldIn, 1, randomIn);
				}

				if (walls[3]) {
					setWall(worldIn, 3, randomIn);
				}
			}

			return true;

		}

		public void setWall(IWorld worldIn, int dir, Random rand) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					BlockState block = TirphycraftBlocks.FROZ_DUNGEON_VARIANT0.get().getDefaultState();
					switch (rand.nextInt(6)) {
					case 0:
						block = TirphycraftBlocks.FROZ_DUNGEON_VARIANT1.get().getDefaultState();
						break;
					case 1:
						block = TirphycraftBlocks.FROZ_DUNGEON_VARIANT2.get().getDefaultState();
						break;
					}

					if (dir == 0)
						worldIn.setBlockState(this.templatePosition.add(7, 1 + j, i + 2), block, 4);
					if (dir == 1)
						worldIn.setBlockState(this.templatePosition.add(i + 2, 1 + j, 7), block, 4);
					if (dir == 2)
						worldIn.setBlockState(this.templatePosition.add(0, 1 + j, i + 2), block, 4);
					if (dir == 3)
						worldIn.setBlockState(this.templatePosition.add(i + 2, 1 + j, 0), block, 4);
				}
			}

		}
	}
}