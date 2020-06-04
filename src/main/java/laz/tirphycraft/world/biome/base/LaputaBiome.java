package laz.tirphycraft.world.biome.base;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.TirphycraftUtils;
import laz.tirphycraft.world.features.Features;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
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

		addFeature(Decoration.SURFACE_STRUCTURES, Features.LAPUTA_ISLAND
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.01f, 1))));
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.TENIUM.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}

	@Override
	public void decorate(Decoration stage, ChunkGenerator<? extends GenerationSettings> chunkGenerator, IWorld worldIn,
			long seed, SharedSeedRandom random, BlockPos pos) {
		IChunk chunk = worldIn.getChunk(pos);

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.getPos().x * 16 + i;
				int z = chunk.getPos().z * 16 + j;
				int y = TirphycraftUtils.getHeight(this.surfaceBuilder, worldIn, random, x, z);
				if (y != -1) {
					BlockPos p = new BlockPos(x, y, z);
					if (worldIn.getBlockState(p.up()) == Blocks.AIR.getDefaultState())
						placeGround(worldIn, random, p);
				}
			}
		}

		super.decorate(stage, chunkGenerator, worldIn, seed, random, pos);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
	}
	
	private void placeGround(IWorld worldIn, SharedSeedRandom random, BlockPos pos) {
		switch (random.nextInt(80)) {
		case 0:
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState(), 4);
			break;
		case 1:
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_COBBLESTONE.get().getDefaultState(), 4);
			break;
		default:
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState(), 4);
			break;
		}
	}

}
