package laz.tirphycraft.world.features.trees;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class SilvirTreeFeature extends Tree {

	public static final TreeFeatureConfig SILVIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(TirphycraftBlocks.LOG_SILVIR.get().getDefaultState()),
			new SimpleBlockStateProvider(TirphycraftBlocks.LEAVES_SILVIR.get().getDefaultState()
					.with(LeavesBlock.DISTANCE, Integer.valueOf(7))
					.with(LeavesBlock.PERSISTENT, Boolean.valueOf(true))),
			new BlobFoliagePlacer(2, 0))
				.baseHeight(7).heightRandA(3)
				.foliageHeight(2)
				.ignoreVines()
				.setSapling((IPlantable) TirphycraftBlocks.SAPLING_SILVIR.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(SILVIR_TREE_CONFIG);

	}

}