package com.tenodru.yeehawmc.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class HillCountryBiome extends Biome{
	
	public HillCountryBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		
		// Add mob spawns
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 2, 4));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 5, 2, 4));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DONKEY, 5, 2, 3));
		
		// Add carvers, like caves
		//this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715f)));
		//this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02f)));
		DefaultBiomeFeatures.addCarvers(this);
	    DefaultBiomeFeatures.addStructures(this);
		
		// Add lakes
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE
				.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState()))
				.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
		
		// Add vegetation
		DefaultBiomeFeatures.addPlainsTallGrass(this);
		DefaultBiomeFeatures.addVeryDenseGrass(this);
		DefaultBiomeFeatures.addSavannaTrees(this);
		
	}
	
	
}
