package com.tenodru.yeehawmc.world.feature;

import com.google.common.collect.ImmutableSet;
import com.tenodru.yeehawmc.init.BlockInitDef;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class PlantFeatures {
	public static final BlockState BLUEBONNET = BlockInitDef.BLUEBONNET.get().getDefaultState();
	public static final BlockState PAINTBRUSH = BlockInitDef.PAINTBRUSH_FLOWER.get().getDefaultState();
	public static final BlockState COUNTRY_SHRUB = BlockInitDef.COUNTRY_SHRUB.get().getDefaultState();

	public static final BlockClusterFeatureConfig BLUEBONNET_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(BLUEBONNET), new SimpleBlockPlacer())
			.tries(8)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig PAINTBRUSH_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(PAINTBRUSH), new SimpleBlockPlacer())
			.tries(10)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig COUNTRY_SHRUB_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(COUNTRY_SHRUB), new SimpleBlockPlacer())
			.tries(16)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock()))).func_227317_b_()
			.build();
}
