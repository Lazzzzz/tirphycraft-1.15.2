package laz.tirphycraft.world.features.trees;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class CoppirTreeFeature extends Tree {

	public static final TreeFeatureConfig COPPIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(TirphycraftBlocks.LOG_COPPIR.get().getDefaultState()),
			new SimpleBlockStateProvider(TirphycraftBlocks.LOG_COPPIR.get().getDefaultState()),
			new BlobFoliagePlacer(3, 0))
			.baseHeight(6)
			.heightRandA(3)
			.foliageHeight(4)
			.ignoreVines()
			.setSapling((IPlantable) TirphycraftBlocks.SAPLING_COPPIR.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(COPPIR_TREE_CONFIG);
	}
}