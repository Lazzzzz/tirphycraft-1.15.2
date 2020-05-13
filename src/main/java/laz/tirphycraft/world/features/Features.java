package laz.tirphycraft.world.features;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.world.biome.surfaceBuilder.DeepTopLayerSurfaceBuilder;
import laz.tirphycraft.world.features.froz.GiantIcePickFeature;
import laz.tirphycraft.world.features.froz.IceCrystalFeature;
import laz.tirphycraft.world.features.froz.IcePillarFeature;
import laz.tirphycraft.world.features.froz.MountainsCrystalFeature;
import laz.tirphycraft.world.features.froz.SmallRockPickFeature;
import laz.tirphycraft.world.features.froz.trees.FrozGiantTreeFeature;
import laz.tirphycraft.world.features.froz.trees.FrozRootFeature;
import laz.tirphycraft.world.features.froz.underground.GiantPillarFeature;
import laz.tirphycraft.world.features.froz.underground.StalacmiteFeature;
import laz.tirphycraft.world.features.froz.underground.StalactiteFeature;
import laz.tirphycraft.world.features.laputa.BlackCrystalFeature;
import laz.tirphycraft.world.features.laputa.BoulderFeature;
import laz.tirphycraft.world.features.laputa.CO2LakesFeature;
import laz.tirphycraft.world.features.laputa.CrystalSpikeFeature;
import laz.tirphycraft.world.features.laputa.GianRockPickFeature;
import laz.tirphycraft.world.features.laputa.LaputaDeadPlantsFeature;
import laz.tirphycraft.world.features.laputa.LaputaFlowerPlantsFeature;
import laz.tirphycraft.world.features.laputa.LaputaGrassPlantsFeature;
import laz.tirphycraft.world.features.laputa.LaputaIslandFeature;
import laz.tirphycraft.world.features.laputa.LaputaSmallRockPickFeature;
import laz.tirphycraft.world.features.laputa.LightPadFeature;
import laz.tirphycraft.world.features.laputa.oasis.OasisBorderFeature;
import laz.tirphycraft.world.features.laputa.tree.CrystalTreeFeature;
import laz.tirphycraft.world.features.laputa.tree.DeadTreeFeature;
import laz.tirphycraft.world.features.laputa.tree.HopperFlowerFeature;
import laz.tirphycraft.world.features.laputa.tree.LaputaSmallBushTreeFeature;
import laz.tirphycraft.world.features.laputa.tree.LaputaTreeFeature;
import laz.tirphycraft.world.features.ore.OreDepositFeatures;
import laz.tirphycraft.world.features.overworld.FragmentFeature;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class Features {
	
	public static ConfiguredFeature<NoFeatureConfig, ?> ANCIENT_STONE	= new FragmentFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	
	
	public static ConfiguredFeature<NoFeatureConfig, ?> PYRODES			= new OreDepositFeatures(Blocks.STONE.getDefaultState(), TirphycraftBlocks.ORE_PYRODES.get().getDefaultState(), 15, 90, 10, 40, NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> CRYSTAL			= new OreDepositFeatures(Blocks.STONE.getDefaultState(), TirphycraftBlocks.ORE_CRYSTAL.get().getDefaultState(), 0, 25, 10, 45, NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> COAL_ON_COKE	= new OreDepositFeatures(Blocks.STONE.getDefaultState(), TirphycraftBlocks.ORE_COAL_ON_COKE.get().getDefaultState(), 0, 90, 5, 15, NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> NIXIUM			= new OreDepositFeatures(TirphycraftBlocks.FROZ_STONE.get().getDefaultState(), TirphycraftBlocks.ORE_NIXIUM.get().getDefaultState(), 0, 30, 5, 35, NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> TENIUM			= new OreDepositFeatures(TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState(), TirphycraftBlocks.ORE_TENIUM.get().getDefaultState(), 10, 48, 5, 35, NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	
	public static ConfiguredFeature<IFeatureConfig, ?> ICE_PILLAR			= new IcePillarFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> ICE_CRYSTAL			= new IceCrystalFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> GIANT_ICE_PICK		= new GiantIcePickFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> SMALL_ROCK_PICK_FROZ = new SmallRockPickFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> BLACK_SPIKE 			= new BlackCrystalFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> CRYSTAL_SPIKE 		= new CrystalSpikeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> LIGHT_PAD 			= new LightPadFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> BOULDER	 			= new BoulderFeature(NoFeatureConfig::deserialize, false).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> BOULDER_FLOWER		= new BoulderFeature(NoFeatureConfig::deserialize, true).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		
	public static ConfiguredFeature<IFeatureConfig, ?>  FROZEN_SPIKE 		= new MountainsCrystalFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> FROZ_BIG_TREE		= new FrozGiantTreeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> FROZ_STALAGMITE		= new StalacmiteFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> FROZ_STALAGTITE		= new StalactiteFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> FROZ_GIANT_PILLAR	= new GiantPillarFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> ROOT_TREE			= new FrozRootFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);


	
	public static ConfiguredFeature<IFeatureConfig, ?>  LAPUTA_TREE 		= new LaputaTreeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?>  LAPUTA_SMALL_BUSH 	= new LaputaSmallBushTreeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?>  LAPUTA_ROCK_PICK 	= new LaputaSmallRockPickFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> LAPUTA_ISLAND	 	= new LaputaIslandFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> LAPUTA_GRASS	 	= new LaputaGrassPlantsFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> LAPUTA_FLOWER	 	= new LaputaFlowerPlantsFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> HOPPER_FLOWER	 	= new HopperFlowerFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> ROCK_GIANT_PICK	 	= new GianRockPickFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> CO2_LAKES		 	= new CO2LakesFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> LAPUTA_DEAD_TREE 	= new DeadTreeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> LAPUTA_DEAD_PLANTS 	= new LaputaDeadPlantsFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> LAPUTA_CRYSTAL_TREE = new CrystalTreeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> LAPUTA_OASIS 		= new OasisBorderFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	
	//https://github.com/Glitchfiend/BiomesOPlenty/blob/801d32a4d6ab73f3fe19b89e55556cf529084214/src/main/java/biomesoplenty/common/world/gen/feature/DeepTopLayerSurfaceBuilder.java
	public static final SurfaceBuilder<SurfaceBuilderConfig> DEEP_TOP_LAYER = new DeepTopLayerSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
	public static final SurfaceBuilderConfig FROZ_SURFACE_CONFIG_DEFAULT = new SurfaceBuilderConfig(TirphycraftBlocks.FROZ_GRASS.get().getDefaultState(), TirphycraftBlocks.FROZ_DIRT.get().getDefaultState(),TirphycraftBlocks.FROZ_DIRT.get().getDefaultState());
		
	public static final Biome.Builder FROZ_BUILDER = new Biome.Builder().precipitation(Biome.RainType.SNOW).category(Biome.Category.ICY).scale(0.2F).temperature(-10F).downfall(0.3F).waterColor(4159204).waterFogColor(329011)
			.parent((String) null);

}	
