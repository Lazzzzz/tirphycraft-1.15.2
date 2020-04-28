package laz.tirphycraft.world.features;

import laz.tirphycraft.world.features.laputa.BlackCrystalFeature;
import laz.tirphycraft.world.features.trees.CoppirTreeFeature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class Features {
	public static ConfiguredFeature<IFeatureConfig, ?> BLACK_SPIKE = new BlackCrystalFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
}
