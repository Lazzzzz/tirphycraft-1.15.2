package laz.tirphycraft.world.dimension.laputa;

import java.util.Set;
import java.util.function.LongFunction;

import com.google.common.collect.ImmutableSet;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.TirphycraftBiomes;
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

public class LaputaBiomeProvider extends BiomeProvider {

	public static Biome[] dimensionBiomes = new Biome[]{
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":laputa_crystal")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":laputa_forest")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":laputa_jungle")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":laputa_magic")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":laputa_no_man_land")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Tirphycraft.MOD_ID + ":laputa_rainbow")),
		};

	
	private static final Set<Biome> biomeList = ImmutableSet.of(
			TirphycraftBiomes.L_CRYTAL.get(),
			TirphycraftBiomes.L_FOREST.get(),
			TirphycraftBiomes.L_JUNGLE.get(),
			TirphycraftBiomes.L_MAGIC.get(), 
			TirphycraftBiomes.L_NML.get(),
			TirphycraftBiomes.L_RAINBOW.get());
	private final Layer genBiomes;
	private final Biome[] biomes;

	public LaputaBiomeProvider(World world) {
		super(biomeList);
		Layer[] aLayer = makeTheWorld(world.getSeed());
		this.genBiomes = aLayer[0];
		this.biomes = dimensionBiomes;
	}

	private Layer[] makeTheWorld(long seed) {
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(25, seed, l);
		IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
		IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerUtils()).apply(contextFactory.apply(200), parentLayer);
		biomeLayer = ZoomLayer.FUZZY.apply(contextFactory.apply(1000), biomeLayer);
		biomeLayer = ZoomLayer.FUZZY.apply(contextFactory.apply(1001), biomeLayer);
		biomeLayer = ZoomLayer.FUZZY.apply(contextFactory.apply(1002), biomeLayer);
		biomeLayer = ZoomLayer.FUZZY.apply(contextFactory.apply(1003), biomeLayer);
		biomeLayer = ZoomLayer.FUZZY.apply(contextFactory.apply(1004), biomeLayer);
		biomeLayer = ZoomLayer.FUZZY.apply(contextFactory.apply(1005), biomeLayer);
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
