package laz.tirphycraft.world.features.froz.structures.surfaces;

import java.util.List;
import java.util.Random;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.structures.BasicVoxelShape;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.nbt.CompoundNBT;
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

public class TowerPiece {

	private static final ResourceLocation BASE = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/tower_base");
	private static final ResourceLocation CENTER = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/tower");
	private static final ResourceLocation TOP = new ResourceLocation(Tirphycraft.MOD_ID + ":froz/tower_top");

	public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation,
			List<StructurePiece> pieceList, Random random) {

		int size = random.nextInt(4) + 1;

		pieceList.add(new Piece(templateManager, BASE, pos, Rotation.NONE, true));

		for (int i = 0; i < size; i++) {
			pieceList.add(new Piece(templateManager, CENTER, pos.up(9 + i * 8), Rotation.NONE));
		}

		pieceList.add(new Piece(templateManager, TOP, pos.add(-1, 9 + size * 8, -1), Rotation.NONE));
	}

	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;
		private Boolean isBase;

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn, boolean isBase) {
			super(StructureFeatures.FROZ_TOWER, 0);
			this.resourceLocation = resourceLocationIn;
			this.templatePosition = pos;
			this.rotation = Rotation.NONE;
			this.setupPiece(templateManagerIn);
			this.isBase = isBase;
		}

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn) {
			super(StructureFeatures.FROZ_TOWER, 0);
			this.resourceLocation = resourceLocationIn;
			this.templatePosition = pos;
			this.rotation = Rotation.NONE;
			this.setupPiece(templateManagerIn);
			this.isBase = false;
		}

		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
			super(StructureFeatures.FROZ_TOWER, tagCompound);
			this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
			this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
			this.setupPiece(templateManagerIn);
			this.isBase = false;
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
		}

		@Override
		public boolean func_225577_a_(IWorld world, ChunkGenerator<?> gen, Random rand, MutableBoundingBox box,
				ChunkPos chunkPos) {
			if (isBase) {
				BasicVoxelShape.cylinder(world, this.templatePosition.add(7, -10, 7), 7, 10, 7,
						TirphycraftBlocks.BRICKS_FROZ.get().getDefaultState(), false);
			}
			return super.func_225577_a_(world, gen, rand, box, chunkPos);
		}
	}
}