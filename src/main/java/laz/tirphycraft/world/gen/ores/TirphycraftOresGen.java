package laz.tirphycraft.world.gen.ores;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.world.biome.base.FrozBiome;
import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.biome.noxis.NoxisBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TirphycraftOresGen {
	private static ConfiguredPlacement<CountRangeConfig> coal_on_coke_config 	= Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 8, 100));
	private static ConfiguredPlacement<CountRangeConfig> pyrodes_config 		= Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 4, 50));
	private static ConfiguredPlacement<CountRangeConfig> crystal_config 		= Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 4, 255));
	
	private static ConfiguredPlacement<CountRangeConfig> nixium_config 			= Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 4, 40));
	private static ConfiguredPlacement<CountRangeConfig> tenium_config 			= Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 2, 40));

	public static void genOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome instanceof LaputaBiome) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, TirphycraftBlocks.ORE_CRYSTAL.get().getDefaultState(), 10)).withPlacement(tenium_config));	
			} else if (biome instanceof FrozBiome) {

			} else if (biome instanceof NoxisBiome) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, TirphycraftBlocks.ORE_CRYSTAL.get().getDefaultState(), 10)).withPlacement(nixium_config));
			} else {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, TirphycraftBlocks.ORE_COAL_ON_COKE.get().getDefaultState(), 10)).withPlacement(coal_on_coke_config));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, TirphycraftBlocks.ORE_PYRODES.get().getDefaultState(), 10)).withPlacement(pyrodes_config));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, TirphycraftBlocks.ORE_CRYSTAL.get().getDefaultState(), 10)).withPlacement(crystal_config));
			}						
		}

	}
}
