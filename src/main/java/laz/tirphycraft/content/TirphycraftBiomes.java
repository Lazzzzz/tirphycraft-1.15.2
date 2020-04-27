package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addBiome;

import laz.tirphycraft.world.biome.froz.FrozPlainsBiome;
import laz.tirphycraft.world.biome.laputa.LaputaCrystalBiome;
import laz.tirphycraft.world.biome.laputa.LaputaForestBiome;
import laz.tirphycraft.world.biome.laputa.LaputaJungleBiome;
import laz.tirphycraft.world.biome.laputa.LaputaMagicBiome;
import laz.tirphycraft.world.biome.laputa.LaputaMeteoriteBiome;
import laz.tirphycraft.world.biome.laputa.LaputaNMLBiome;
import laz.tirphycraft.world.biome.laputa.LaputaRainbowBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftBiomes {
	public static RegistryObject<Biome> F_PLAINS;
	
	public static RegistryObject<Biome> L_CRYTAL;
	public static RegistryObject<Biome> L_FOREST;
	public static RegistryObject<Biome> L_JUNGLE;
	public static RegistryObject<Biome> L_MAGIC;
	public static RegistryObject<Biome> L_METEORITE;
	public static RegistryObject<Biome> L_NML;
	public static RegistryObject<Biome> L_RAINBOW;
	

	public static void init() {
		F_PLAINS 	= addBiome("froz_plains", () -> new FrozPlainsBiome());
		L_CRYTAL 	= addBiome("laputa_crystal", () -> new LaputaCrystalBiome());
		L_FOREST	= addBiome("laputa_forest", () -> new LaputaForestBiome());
		L_JUNGLE	= addBiome("laputa_jungle", () -> new LaputaJungleBiome());
		L_MAGIC 	= addBiome("laputa_magic", () -> new LaputaMagicBiome());
		L_METEORITE = addBiome("laputa_meteorite", () -> new LaputaMeteoriteBiome());
		L_NML 		= addBiome("laputa_no_man_land", () -> new LaputaNMLBiome());
		L_RAINBOW 	= addBiome("laputa_rainbow", () -> new LaputaRainbowBiome());
	}

}
