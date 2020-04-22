package laz.tirphycraft.world.dimension.laputa;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

public class LaputaBiomeProvider extends BiomeProvider {
	public LaputaBiomeProvider() {
		super(biomeList);
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(Biomes.PLAINS);

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return Biomes.PLAINS;
	}

}