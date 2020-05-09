package laz.tirphycraft.world.biome.surfaceBuilder;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBiomes;
import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class FrozIcePlainsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	public FrozIcePlainsSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51315_1_) {
		super(p_i51315_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		this.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTop(),
				config.getUnder(), config.getUnderWaterMaterial(), seaLevel);

	}

	protected void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom,
			int sealevel) {
	}
}