package laz.tirphycraft.world.dimension.laputa;

import laz.tirphycraft.content.TirphycraftBiomes;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

@SuppressWarnings("deprecation")
public enum LaputaLayer implements IAreaTransformer0
{
	INSTANCE;

	private static final int L_CRYTAL = Registry.BIOME.getId(TirphycraftBiomes.L_CRYTAL.get());
	private static final int L_FOREST = Registry.BIOME.getId(TirphycraftBiomes.L_FOREST.get());
	private static final int L_JUNGLE = Registry.BIOME.getId(TirphycraftBiomes.L_JUNGLE.get());
	private static final int L_MAGIC = Registry.BIOME.getId(TirphycraftBiomes.L_MAGIC.get());
	private static final int L_NML = Registry.BIOME.getId(TirphycraftBiomes.L_NML.get());
	private static final int L_RAINBOW = Registry.BIOME.getId(TirphycraftBiomes.L_RAINBOW.get());


	private static PerlinNoiseGenerator perlinGen;
	private double max = 0;
	private double min = 1;
	

	@Override
	public int apply(INoiseRandom noise, int x, int z)
	{
		double perlinNoise = perlinGen.noiseAt(x * 0.1D, z * 0.00001D, false) * 0.5D + 0.5D;
		
		max = Math.max(max, perlinNoise);
		min = Math.min(min, perlinNoise);
		System.out.println("Max: " + max +", Min: "+min + ", perlin: "+perlinNoise);
		switch (noise.random(5)) {
		case 0:
			return L_CRYTAL;
		case 1:
			return L_FOREST;
		case 2:
			return L_JUNGLE;
		case 3:
			return L_MAGIC;
		case 4:
			return L_NML;
		}

		return -1;
	}


	public static void setSeed(long seed)
	{
		if (perlinGen == null)
		{
			SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
			perlinGen = new PerlinNoiseGenerator(sharedseedrandom, 0, 0);
		}
	}
}
