package laz.tirphycraft.world.features.laputa.structure;

import java.util.List;
import java.util.Random;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.util.structures.FrozDungeonHelper;
import laz.tirphycraft.world.features.StructureFeatures;
import laz.tirphycraft.world.features.froz.structures.FrozDungeonPiece;
import laz.tirphycraft.world.features.laputa.structure.pieces.IslandPiece;
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

public class LaputaDungeonPiece {
	
	private static final ResourceLocation ALL = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/froz_dungeon_all");
	
	public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation,
			List<StructurePiece> pieceList, Random random) {
		pieceList.add(new IslandPiece(random, 0, 0, 0));
	}

	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn) {
			super(StructureFeatures.LAPUTA_DUNGEON_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			this.templatePosition = pos;
			this.rotation = Rotation.NONE;
			this.setupPiece(templateManagerIn);
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
			return super.create(worldIn, p_225577_2_, randomIn, structureBoundingBoxIn, chunkPos);
		}
	}

}