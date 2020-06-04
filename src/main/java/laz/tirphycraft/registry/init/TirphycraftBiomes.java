package laz.tirphycraft.registry.init;

import static laz.tirphycraft.registry.TirphycraftRegistries.addBiome;

import laz.tirphycraft.world.biome.froz.FrozCanyon;
import laz.tirphycraft.world.biome.froz.FrozForestBiome;
import laz.tirphycraft.world.biome.froz.FrozIcePlains;
import laz.tirphycraft.world.biome.froz.FrozMountainsBiome;
import laz.tirphycraft.world.biome.laputa.LaputaCrystalBiome;
import laz.tirphycraft.world.biome.laputa.LaputaForestBiome;
import laz.tirphycraft.world.biome.laputa.LaputaMagicBiome;
import laz.tirphycraft.world.biome.laputa.LaputaMeteoriteBiome;
import laz.tirphycraft.world.biome.laputa.LaputaNMLBiome;
import laz.tirphycraft.world.biome.laputa.LaputaOasisBiome;
import laz.tirphycraft.world.biome.laputa.LaputaPlainsBiome;
import laz.tirphycraft.world.biome.noxis.NoxisMainBiome;
import laz.tirphycraft.world.biome.noxis.NoxisPlainsBiome;
import laz.tirphycraft.world.biome.noxis.NoxisThornsBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftBiomes {
	public static RegistryObject<Biome> F_MOUNTAINS;
	public static RegistryObject<Biome> F_FOREST;
	public static RegistryObject<Biome> F_ICE_PLAINS;
	public static RegistryObject<Biome> F_CANYON;

	public static RegistryObject<Biome> L_CRYTAL;
	public static RegistryObject<Biome> L_FOREST;
	public static RegistryObject<Biome> L_OASIS;
	public static RegistryObject<Biome> L_MAGIC;
	public static RegistryObject<Biome> L_METEORITE;
	public static RegistryObject<Biome> L_NML;
	public static RegistryObject<Biome> L_PLAINS;
	
	public static RegistryObject<Biome> N_MAIN;
	public static RegistryObject<Biome> N_THORNS;
	public static RegistryObject<Biome> N_PLAINS;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void init() {
		F_MOUNTAINS = addBiome("froz_mountains",
				() -> new FrozMountainsBiome(
						Features.FROZ_BUILDER.surfaceBuilder(new ConfiguredSurfaceBuilder(Features.DEEP_TOP_LAYER,
								new SurfaceBuilderConfig(TirphycraftBlocks.POWDER_SNOW.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState())))
								.depth(5.5F)));
		F_ICE_PLAINS = addBiome("froz_ice_plains",
				() -> new FrozIcePlains(
						Features.FROZ_BUILDER.surfaceBuilder(new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT,
								new SurfaceBuilderConfig(TirphycraftBlocks.POWDER_SNOW.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState())))
								.depth(0.2F)));
		
		F_FOREST = addBiome("froz_forest",
				() -> new FrozForestBiome(
						Features.FROZ_BUILDER.surfaceBuilder(new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT,
								new SurfaceBuilderConfig(TirphycraftBlocks.POWDER_SNOW.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState())))
								.depth(0.25F)));

		F_CANYON = addBiome("froz_canyon",
				() -> new FrozCanyon(
						Features.FROZ_BUILDER.surfaceBuilder(new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT,
								new SurfaceBuilderConfig(TirphycraftBlocks.POWDER_SNOW.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState(),
										TirphycraftBlocks.FROZ_DIRT.get().getDefaultState())))
								.depth(0.4F)));
		
		L_CRYTAL = addBiome("laputa_crystal", () -> new LaputaCrystalBiome());
		L_FOREST = addBiome("laputa_forest", () -> new LaputaForestBiome());
		L_OASIS = addBiome("laputa_oasis", () -> new LaputaOasisBiome());
		L_MAGIC = addBiome("laputa_magic", () -> new LaputaMagicBiome());
		L_METEORITE = addBiome("laputa_meteorite", () -> new LaputaMeteoriteBiome());
		L_NML = addBiome("laputa_no_man_land", () -> new LaputaNMLBiome());
		L_PLAINS = addBiome("laputa_plains", () -> new LaputaPlainsBiome());
		
		N_MAIN = addBiome("noxis", () -> new NoxisMainBiome());
		N_THORNS = addBiome("noxis_thorns", () -> new NoxisThornsBiome());
		N_PLAINS = addBiome("noxis_plains", () -> new NoxisPlainsBiome());

	}

}
