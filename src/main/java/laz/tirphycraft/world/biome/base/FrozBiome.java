package laz.tirphycraft.world.biome.base;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.world.features.Features;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ForestBiome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class FrozBiome extends Biome {

	private int caveStartY = 48;
	private int caveStopY = 6;

	protected FrozBiome(Biome.Builder builder) {
		super(builder);

		addSpawn(EntityClassification.MONSTER, new SpawnListEntry(TirphycraftEntities.ENTITY_KRETUN, 10, 1, 1));
		addSpawn(EntityClassification.MONSTER, new SpawnListEntry(TirphycraftEntities.ENTITY_FROZEN_SOLDIER, 10, 1, 1));
		addSpawn(EntityClassification.MONSTER, new SpawnListEntry(TirphycraftEntities.ENTITY_CROCROCASSE, 10, 1, 1));
		addSpawn(EntityClassification.MONSTER, new SpawnListEntry(TirphycraftEntities.ENTITY_LOMBRA, 10, 1, 1));
		
		addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 10, 1, 4));
		
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_STALAGMITE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_STALAGTITE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_GIANT_PILLAR.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.NIXIUM.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.PICITE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.HISTICE_ICE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES, 
				Features.SMALL_ROCK_PICK_FROZ.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.ICE_CRYSTAL.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.MAJESTIC_ROSE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		addFeature(Decoration.UNDERGROUND_DECORATION,
				Features.BASALT_PATCH.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	    
		addStructure(StructureFeatures.FROZ_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		addFeature(Decoration.UNDERGROUND_STRUCTURES, StructureFeatures.FROZ_DUNGEON.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
				.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	
	}

	@Override
	public int getGrassColor(double posX, double posZ) {
		return 3099238;
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, 0, seed);
		for (int i = -3; i < 0; i++) {
			if (chunkIn.getBlockState(new BlockPos(x, startHeight + i, z)) == TirphycraftBlocks.POWDER_SNOW.get()
					.getDefaultState()) {
				chunkIn.setBlockState(new BlockPos(x, startHeight + i + 1, z), TirphycraftBlocks.POWDER_SNOW_LAYER.get()
						.getDefaultState().with(SnowBlock.LAYERS, random.nextInt(4) + 1), false);
				break;
			}
		}
		makeCave(chunkIn, random, x, z, startHeight);

	}

	public boolean makeCave(IChunk chunkIn, Random random, int x, int z, int startHeight) {
		int top = 0;
		for (int i = startHeight; i > this.caveStartY; i--) {
			BlockPos p = new BlockPos(x, i, z);
			if (chunkIn.getBlockState(p) == TirphycraftBlocks.FROZ_STONE.get().getDefaultState()
					|| chunkIn.getBlockState(p) == Blocks.ICE.getDefaultState()
					|| chunkIn.getBlockState(p) == Blocks.PACKED_ICE.getDefaultState()) {
				top = i;
				boolean noair = true;
				for (int j = i; j > 0; j--) {
					p = new BlockPos(x, j, z);
					if (chunkIn.getBlockState(p) == Blocks.AIR.getDefaultState()) {
						noair = false;
						break;
					}
				}
				if (noair)
					break;
			}

			if (i == this.caveStartY + 1)
				return false;
		}
		int decal = top - this.caveStartY;

		for (int i = this.caveStartY - decal; i > this.caveStopY + (decal / 4); i--) {
			BlockPos p = new BlockPos(x, i, z);
			chunkIn.setBlockState(p, Blocks.AIR.getDefaultState(), false);
		}
		return true;

	}

}
