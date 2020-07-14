package laz.tirphycraft.world.dimension.froz;

import java.util.Set;
import java.util.function.LongFunction;

import com.google.common.collect.ImmutableSet;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.registries.ForgeRegistries;

public class FrozBiomeProvider extends BiomeProvider {

	public static Biome[] dimensionBiomes = new Biome[]{
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":froz_mountains")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":froz_ice_plains")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":froz_forest")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":froz_canyon")),
		};
	
	private static final Set<Biome> biomeList = ImmutableSet.of(
			TirphycraftBiomes.F_ICE_PLAINS.get(),
			TirphycraftBiomes.F_FOREST.get(),
			TirphycraftBiomes.F_CANYON.get(),
			TirphycraftBiomes.F_MOUNTAINS.get());
	
	private final Layer genBiomes;
	private final Biome[] biomes;

	public FrozBiomeProvider(World world) {
		super(biomeList);
		Layer[] aLayer = makeTheWorld(world.getSeed());
		this.genBiomes = aLayer[0];
		this.biomes = dimensionBiomes;
	}

	private Layer[] makeTheWorld(long seed) {
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);
		IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
		IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerUtils()).apply(contextFactory.apply(200), parentLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), biomeLayer);
		return new Layer[]{new Layer(biomeLayer), new Layer(voronoizoom)};
	}

	@Override
	public boolean hasStructure(Structure<?> structureIn) {
		return this.hasStructureCache.computeIfAbsent(structureIn, (p_205006_1_) -> {
			for (Biome biome : this.biomes) {
				if (biome.hasStructure(p_205006_1_)) {
					return true;
				}
			}
			return false;
		});
	}

	@Override
	public Set<BlockState> getSurfaceBlocks() {
		if (this.topBlocksCache.isEmpty()) {
			for (Biome biome : this.biomes) {
				this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
			}
		}
		return this.topBlocksCache;
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.genBiomes.func_215738_a(x, z);
	}

	class BiomeLayerUtils implements IC0Transformer {
		@Override
		public int apply(INoiseRandom context, int value) {
			return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
		}
	
	}
}
