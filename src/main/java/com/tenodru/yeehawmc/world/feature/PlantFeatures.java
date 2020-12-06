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
	public static final BlockState DANDELION = Blocks.DANDELION.getDefaultState();
	public static final BlockState ALLIUM = Blocks.ALLIUM.getDefaultState();
	public static final BlockState OXEYE = Blocks.OXEYE_DAISY.getDefaultState();
	public static final BlockState PEONY = Blocks.PEONY.getDefaultState();

	public static final BlockClusterFeatureConfig BLUEBONNET_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(BLUEBONNET), new SimpleBlockPlacer())
			.tries(32)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(), Blocks.COARSE_DIRT.getBlock(), Blocks.PODZOL.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig PAINTBRUSH_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(PAINTBRUSH), new SimpleBlockPlacer())
			.tries(32)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(), Blocks.COARSE_DIRT.getBlock(), Blocks.PODZOL.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig DANDELION_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(DANDELION), new SimpleBlockPlacer())
			.tries(32)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(), Blocks.COARSE_DIRT.getBlock(), Blocks.PODZOL.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig ALLIUM_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(ALLIUM), new SimpleBlockPlacer())
			.tries(32)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(), Blocks.COARSE_DIRT.getBlock(), Blocks.PODZOL.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig OXEYE_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(OXEYE), new SimpleBlockPlacer())
			.tries(32)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(), Blocks.COARSE_DIRT.getBlock(), Blocks.PODZOL.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig PEONY_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(PEONY), new SimpleBlockPlacer())
			.tries(32)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(), Blocks.COARSE_DIRT.getBlock(), Blocks.PODZOL.getBlock()))).func_227317_b_()
			.build();
	
	public static final BlockClusterFeatureConfig COUNTRY_SHRUB_CONFIG = (new BlockClusterFeatureConfig
			.Builder(new SimpleBlockStateProvider(COUNTRY_SHRUB), new SimpleBlockPlacer())
			.tries(64)
			.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock(), Blocks.COARSE_DIRT.getBlock(), Blocks.PODZOL.getBlock()))).func_227317_b_()
			.build();
}
