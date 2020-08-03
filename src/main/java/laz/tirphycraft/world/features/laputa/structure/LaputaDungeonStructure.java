package laz.tirphycraft.world.features.laputa.structure;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.Tirphycraft;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class LaputaDungeonStructure extends Structure<NoFeatureConfig> {
	public LaputaDungeonStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int x, int z,
			int spacingOffsetsX, int spacingOffsetsZ) {

		int maxDistance = 40;
		int minDistance = 20;

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

	/*
	 * The structure name to show in the /locate command.
	 * 
	 * Make sure this matches what the resourcelocation of your structure will be
	 * because if you don't add the MODID: part, Minecraft will put minecraft: in
	 * front of the name instead and we don't want that. We want our structure to
	 * have our mod's ID rather than Minecraft so people don't get confused.
	 */
	@Override
	public String getStructureName() {
		return Tirphycraft.MOD_ID + ":laputa_dungeon";
	}

	/*
	 * This seems to be unused but cannot be removed. Just return 0 is all you need
	 * to do.
	 */
	@Override
	public int getSize() {
		return 0;
	}

	/*
	 * This is how the worldgen code will start the generation of our structure when
	 * it passes the checks.
	 */
	@Override
	public Structure.IStartFactory getStartFactory() {
		return LaputaDungeonStructure.Start::new;
	}

	protected int getSeedModifier() {
		return 123456789;
	}

	@Override
	public boolean func_225558_a_(BiomeManager p_225558_1_, ChunkGenerator<?> chunkGen, Random rand, int chunkPosX,
			int chunkPosZ, Biome biome) {
		ChunkPos chunkpos = this.getStartPositionForPosition(chunkGen, rand, chunkPosX, chunkPosZ, 0, 0);

		// Checks to see if current chunk is valid to spawn in.
		if (chunkPosX == chunkpos.x && chunkPosZ == chunkpos.z) {
			// Checks if the biome can spawn this structure.
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

			int surfaceY = 180;
			Object[] biomes = generator.getBiomeProvider().getBiomes(x, surfaceY, z, 64).toArray();
			Boolean CanPlace = true;
			for (int i = 1; i < biomes.length; i++) {
				if (biomes[i - 1] != biomes[i])
					CanPlace = false;
			}
			if (CanPlace) {
				IslandPiece MainIslandPiece = new IslandPiece(this.rand, x, surfaceY, z);
				this.components.add(MainIslandPiece);
			}
			this.recalculateStructureSize();
		}

	}

}