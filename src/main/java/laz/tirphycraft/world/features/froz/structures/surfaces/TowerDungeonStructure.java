package laz.tirphycraft.world.features.froz.structures.surfaces;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.Tirphycraft;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerDungeonStructure extends Structure<NoFeatureConfig> {
	public TowerDungeonStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int x, int z,
			int spacingOffsetsX, int spacingOffsetsZ) {

		int maxDistance = 20;
		int minDistance = 10;

		int xTemp = x + maxDistance * spacingOffsetsX;
		int ztemp = z + maxDistance * spacingOffsetsZ;
		int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
		int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
		int validChunkX = xTemp2 / maxDistance;
		int validChunkZ = zTemp2 / maxDistance;

		((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ,
				this.getSeedModifier());
		validChunkX = validChunkX * maxDistance;
		validChunkZ = validChunkZ * maxDistance;
		validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
		validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);

		return new ChunkPos(validChunkX, validChunkZ);
	}

	@Override
	public String getStructureName() {
		return Tirphycraft.MOD_ID + ":froz_dungeon_tower";
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public Structure.IStartFactory getStartFactory() {
		return TowerDungeonStructure.Start::new;
	}

	protected int getSeedModifier() {
		return 123456789;
	}

	@Override
	public boolean func_225558_a_(BiomeManager p_225558_1_, ChunkGenerator<?> chunkGen, Random rand, int chunkPosX,
			int chunkPosZ, Biome biome) {
		ChunkPos chunkpos = this.getStartPositionForPosition(chunkGen, rand, chunkPosX, chunkPosZ, 0, 0);

		if (chunkPosX == chunkpos.x && chunkPosZ == chunkpos.z) {
			if (chunkGen.hasStructure(biome, this)) {
				return true;
			}
		}

		return false;
	}

	public static class Start extends StructureStart {

		public Start(Structure<?> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox,
				int referenceIn, long seedIn) {
			super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
		}

		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ,
				Biome biomeIn) {
			int x = chunkX * 16 + 8;
			int z = chunkZ * 16 + 8;
			int i = generator.func_222531_c(x, z, Heightmap.Type.WORLD_SURFACE_WG);

			Object[] biomes = generator.getBiomeProvider().getBiomes(x, i, z, 2).toArray();
			Boolean CanPlace = true;
			for (int ii = 1; ii < biomes.length; ii++) {
				if (biomes[ii - 1] != biomes[ii])
					CanPlace = false;
			}
			if (CanPlace) {
				int i1 = generator.func_222531_c(x - 8, z, Heightmap.Type.WORLD_SURFACE_WG);
				int i2 = generator.func_222531_c(x + 8, z, Heightmap.Type.WORLD_SURFACE_WG);
				int i3 = generator.func_222531_c(x, z - 8, Heightmap.Type.WORLD_SURFACE_WG);
				int i4 = generator.func_222531_c(x, z + 8, Heightmap.Type.WORLD_SURFACE_WG);

				int delta = Math.abs((i1 + i2 + i3 + i4) / 4) - i;
				if (delta < 3)
					TowerPiece.start(templateManagerIn, new BlockPos(x, i, z).up(3), Rotation.NONE, this.components,
							this.rand);
			}
			this.recalculateStructureSize();
		}

		@Override
		public void func_225565_a_(IWorld p_225565_1_, ChunkGenerator<?> p_225565_2_, Random p_225565_3_,
				MutableBoundingBox p_225565_4_, ChunkPos p_225565_5_) {
			// TODO Auto-generated method stub
			super.func_225565_a_(p_225565_1_, p_225565_2_, p_225565_3_, p_225565_4_, p_225565_5_);
		}

	}

}