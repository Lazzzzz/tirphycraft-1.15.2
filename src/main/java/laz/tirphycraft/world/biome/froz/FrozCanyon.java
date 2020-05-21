package laz.tirphycraft.world.biome.froz;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.world.biome.base.FrozBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class FrozCanyon extends FrozBiome {

	public FrozCanyon(Biome.Builder builder) {
		super(builder);
		
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_BIG_TREE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		
		addFeature(Decoration.SURFACE_STRUCTURES,
				Features.FROZ_BUSH.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
		
		double abs_noise = Math.abs(noise);
		BlockPos pos;
		
		if (abs_noise > 0 && abs_noise < 1) {
			for (int i = -48 + (int) (abs_noise * 50); i < 1; i++) {
				pos = new BlockPos(x, startHeight + i, z);
				if (pos.getY() <= 49 && pos.getY() >= 47) {
					if (random.nextInt(5) > 0) chunkIn.setBlockState(pos, Blocks.ICE.getDefaultState(), false);
					else chunkIn.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState(), false);
				}
				else chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
			}
			
			pos = new BlockPos(x, startHeight - 48 + (int) (abs_noise * 50), z);
			if (pos.getY() < startHeight && pos.getY() > 50	&& chunkIn.getBlockState(pos.down()) == TirphycraftBlocks.FROZ_STONE.get().getDefaultState()) {
				for (int i = 0; i < 3; i++) {
					chunkIn.setBlockState(pos.down(i), TirphycraftBlocks.FROZ_DIRT.get().getDefaultState(), false);
				}
				chunkIn.setBlockState(pos, TirphycraftBlocks.POWDER_SNOW.get().getDefaultState(), false);				
			}
			

		}     
		for (int i = -3; i < 0; i++) {
			if (chunkIn.getBlockState(new BlockPos(x, startHeight + i, z)) == TirphycraftBlocks.POWDER_SNOW.get()
					.getDefaultState()) {
				chunkIn.setBlockState(new BlockPos(x, startHeight + i + 1, z), TirphycraftBlocks.POWDER_SNOW_LAYER.get()
						.getDefaultState().with(SnowBlock.LAYERS, random.nextInt(4) + 1), false);
				break;
			}
		}
		
	}

	// for (int i = 0; i < 15; i++) {
	//
	// if (abs_noise > i * 0.3f && abs_noise < i+1 * 0.3f) {
	// BlockState b;
	// switch (i) {
	// case 0:
	// b = Blocks.BLACK_WOOL.getDefaultState();
	// break;
	// case 1:
	// b = Blocks.BLUE_WOOL.getDefaultState();
	// break;
	// case 2:
	// b = Blocks.BROWN_WOOL.getDefaultState();
	// break;
	// case 3:
	// b = Blocks.CYAN_WOOL.getDefaultState();
	// break;
	// case 4:
	// b = Blocks.GRAY_WOOL.getDefaultState();
	// break;
	// case 5:
	// b = Blocks.GREEN_WOOL.getDefaultState();
	// break;
	// case 6:
	// b = Blocks.LIGHT_BLUE_WOOL.getDefaultState();
	// break;
	// case 7:
	// b = Blocks.LIGHT_GRAY_WOOL.getDefaultState();
	// break;
	// case 8:
	// b = Blocks.LIME_WOOL.getDefaultState();
	// break;
	// case 9:
	// b = Blocks.MAGENTA_WOOL.getDefaultState();
	// break;
	// case 10:
	// b = Blocks.ORANGE_WOOL.getDefaultState();
	// break;
	// case 11:
	// b = Blocks.PINK_WOOL.getDefaultState();
	// break;
	// case 12:
	// b = Blocks.PURPLE_WOOL.getDefaultState();
	// break;
	// case 13:
	// b = Blocks.RED_WOOL.getDefaultState();
	// break;
	// case 15:
	// b = Blocks.YELLOW_WOOL.getDefaultState();
	// break;
	// default:
	// b = Blocks.WHITE_WOOL.getDefaultState();
	// break;
	// }
	// chunkIn.setBlockState(pos, b, false);
	// }
	// }

}
