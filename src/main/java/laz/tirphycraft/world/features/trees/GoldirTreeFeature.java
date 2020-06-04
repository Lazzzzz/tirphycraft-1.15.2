package laz.tirphycraft.world.features.trees;

import java.util.Random;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class GoldirTreeFeature extends Tree {

	public static final TreeFeatureConfig GOLDIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(TirphycraftBlocks.LOG_GOLDIR.get().getDefaultState()),
			new SimpleBlockStateProvider(TirphycraftBlocks.LEAVES_GOLDIR.get().getDefaultState()
					.with(LeavesBlock.DISTANCE, Integer.valueOf(7))
					.with(LeavesBlock.PERSISTENT, Boolean.valueOf(true))),
			new BlobFoliagePlacer(1, 0))
				.baseHeight(2).heightRandA(1)
				.foliageHeight(2)
				.ignoreVines()
				.setSapling((IPlantable) TirphycraftBlocks.SAPLING_GOLDIR.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(GOLDIR_TREE_CONFIG);

	}

}