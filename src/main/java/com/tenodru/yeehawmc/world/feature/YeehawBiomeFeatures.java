package com.tenodru.yeehawmc.world.feature;

import com.tenodru.yeehawmc.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class YeehawBiomeFeatures {
	public static final BlockState LIMESTONE = BlockInit.limestone.getDefaultState();
	
	/** Generates limestone at the same rate and count as granite, andesite, and diorite. */
	public static void addStoneVariants(Biome biomeIn) {
	      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LIMESTONE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
	      
	}
}