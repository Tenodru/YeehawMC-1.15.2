package com.tenodru.yeehawmc.world.feature;

import java.util.Random;

import com.tenodru.yeehawmc.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class CedarTree extends Tree{
	public static final TreeFeatureConfig CEDAR_TREE_CONFIG = (new TreeFeatureConfig
			.Builder(new SimpleBlockStateProvider(BlockInit.cedar_log.getDefaultState()), 
					new SimpleBlockStateProvider(BlockInit.cedar_leaves.getDefaultState()), 
					new BlobFoliagePlacer(2, 1)))
			.baseHeight(14)
			.heightRandA(5)
			.foliageHeight(3)
			.foliageHeightRandom(1)
			.trunkTopOffset(2)
			.ignoreVines()
			.setSapling((IPlantable)BlockInit.cedar_sapling)
			.build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(CEDAR_TREE_CONFIG);
	}
}
