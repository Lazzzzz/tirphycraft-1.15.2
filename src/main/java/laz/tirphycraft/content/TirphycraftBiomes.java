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
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
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
	
	static Biome.Builder FrozBuilderBase = new Biome.Builder().precipitation(RainType.SNOW).temperature(-10f).waterColor(3093151).waterFogColor(3093151).category(Category.PLAINS).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.ICE.getDefaultState()));
	
	public static void init() {
		F_DESERT 	= addBiome("froz_desert", () -> new FrozDesertBiome(FrozBuilderBase.depth(0.125F).downfall(0.4F).scale(0.05f)));
		F_MOUNTAINS	= addBiome("froz_mountains", () -> new FrozMountainsBiome(FrozBuilderBase.depth(1.0F).scale(0.5F).downfall(0.3F)));
		
		L_CRYTAL 	= addBiome("laputa_crystal", () -> new LaputaCrystalBiome());
		L_FOREST	= addBiome("laputa_forest", () -> new LaputaForestBiome());
		L_OASIS		= addBiome("laputa_oasis", () -> new LaputaOasisBiome());
		L_MAGIC 	= addBiome("laputa_magic", () -> new LaputaMagicBiome());
		L_METEORITE = addBiome("laputa_meteorite", () -> new LaputaMeteoriteBiome());
		L_NML 		= addBiome("laputa_no_man_land", () -> new LaputaNMLBiome());
		L_PLAINS 	= addBiome("laputa_plains", () -> new LaputaPlainsBiome());
	}

}
