package laz.tirphycraft.world.features.froz.structures.surfaces;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.Tirphycraft;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
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

			int x = chunkX * 16;
			int z = chunkZ * 16;

	        TowerPiece Tower = new TowerPiece(rand, x,0,z);
			this.components.add(Tower);

			this.recalculateStructureSize();
		}

	}

}