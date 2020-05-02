package laz.tirphycraft.world.features;

import laz.tirphycraft.world.features.froz.GiantIcePickFeature;
import laz.tirphycraft.world.features.froz.IceCrystalFeature;
import laz.tirphycraft.world.features.froz.IcePillarFeature;
import laz.tirphycraft.world.features.froz.SmallRockPickFeature;
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
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class Features {
	
	public static ConfiguredFeature<IFeatureConfig, ?> ICE_PILLAR			= new IcePillarFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> ICE_CRYSTAL			= new IceCrystalFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> GIANT_ICE_PICK		= new GiantIcePickFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> SMALL_ROCK_PICK_FROZ = new SmallRockPickFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> BLACK_SPIKE 			= new BlackCrystalFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> CRYSTAL_SPIKE 		= new CrystalSpikeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<IFeatureConfig, ?> LIGHT_PAD 			= new LightPadFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> BOULDER	 			= new BoulderFeature(NoFeatureConfig::deserialize, false).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static ConfiguredFeature<NoFeatureConfig, ?> BOULDER_FLOWER		= new BoulderFeature(NoFeatureConfig::deserialize, true).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		
	
	public static ConfiguredFeature<IFeatureConfig, ?>  LAPUTA_TREE 			= new LaputaTreeFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
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
	
	
}	
