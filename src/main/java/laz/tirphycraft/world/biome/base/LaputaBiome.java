package laz.tirphycraft.world.biome.base;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.world.features.Features;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class LaputaBiome extends Biome {

	protected LaputaBiome() {
		super(new Biome.Builder().precipitation(RainType.NONE).scale(0.01f).temperature(5f).waterColor(3093151)
				.waterFogColor(3093151).category(Category.PLAINS).downfall(0).depth(1.2f)
				.surfaceBuilder(SurfaceBuilder.DEFAULT,
						new SurfaceBuilderConfig(TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState(),
								TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState(),
								TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState())));

		addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(TirphycraftEntities.ENTITY_BUTTERFLY, 10, 1, 1));
		
		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_ISLAND
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.01f, 1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.TENIUM.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		
		
		
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
		for (int i = 6; i > -2; i--) {
			BlockPos pos = new BlockPos(x, startHeight + i, z);
			if (chunkIn.getBlockState(pos) == TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState()) {
				placeGround(chunkIn, random, pos);
				break;
			}
		}
	}
	
	private void placeGround(IChunk worldIn, Random random, BlockPos pos) {
		switch (random.nextInt(12)) {
		case 0:
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState(), false);
			break;
		case 1:
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState(), false);
			break;
		default:
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState(), false);
			break;
		}
	}

}
