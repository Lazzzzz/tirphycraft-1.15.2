package laz.tirphycraft.world.features;

import laz.tirphycraft.world.features.froz.GiantIcePickFeature;
import laz.tirphycraft.world.features.froz.IceCrystalFeature;
import laz.tirphycraft.world.features.froz.IcePillarFeature;
import laz.tirphycraft.world.features.froz.SmallRockPickFeature;
import laz.tirphycraft.world.features.laputa.BlackCrystalFeature;
import laz.tirphycraft.world.features.laputa.CrystalSpikeFeature;
import laz.tirphycraft.world.features.laputa.LightPadFeature;
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
}	
