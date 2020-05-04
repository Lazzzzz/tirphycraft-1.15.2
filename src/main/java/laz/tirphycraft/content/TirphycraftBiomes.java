package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addBiome;

import laz.tirphycraft.world.biome.froz.FrozDesertBiome;
import laz.tirphycraft.world.biome.froz.FrozMountainsBiome;
import laz.tirphycraft.world.biome.laputa.LaputaCrystalBiome;
import laz.tirphycraft.world.biome.laputa.LaputaForestBiome;
import laz.tirphycraft.world.biome.laputa.LaputaMagicBiome;
import laz.tirphycraft.world.biome.laputa.LaputaMeteoriteBiome;
import laz.tirphycraft.world.biome.laputa.LaputaNMLBiome;
import laz.tirphycraft.world.biome.laputa.LaputaOasisBiome;
import laz.tirphycraft.world.biome.laputa.LaputaPlainsBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftBiomes {
	public static RegistryObject<Biome> F_DESERT;
	public static RegistryObject<Biome> F_MOUNTAINS;

	public static RegistryObject<Biome> L_CRYTAL;
	public static RegistryObject<Biome> L_FOREST;
	public static RegistryObject<Biome> L_OASIS;
	public static RegistryObject<Biome> L_MAGIC;
	public static RegistryObject<Biome> L_METEORITE;
	public static RegistryObject<Biome> L_NML;
	public static RegistryObject<Biome> L_PLAINS;

	public static void init() {
		F_DESERT 	= addBiome("froz_desert",	 () -> new FrozDesertBiome(Features.FROZ_BUILDER.depth(0.2F)));
		F_MOUNTAINS = addBiome("froz_mountains", () -> new FrozMountainsBiome(Features.FROZ_BUILDER.depth(5.5F)));
		
		L_CRYTAL = addBiome("laputa_crystal", 	   () -> new LaputaCrystalBiome());
		L_FOREST = addBiome("laputa_forest", 	   () -> new LaputaForestBiome());
		L_OASIS = addBiome("laputa_oasis", 		   () -> new LaputaOasisBiome());
		L_MAGIC = addBiome("laputa_magic", 		   () -> new LaputaMagicBiome());
		L_METEORITE = addBiome("laputa_meteorite", () -> new LaputaMeteoriteBiome());
		L_NML = addBiome("laputa_no_man_land", 	   () -> new LaputaNMLBiome());
		L_PLAINS = addBiome("laputa_plains", 	   () -> new LaputaPlainsBiome());
	}

}
