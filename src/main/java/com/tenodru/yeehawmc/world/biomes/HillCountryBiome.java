package com.tenodru.yeehawmc.world.biomes;

import com.tenodru.yeehawmc.world.feature.CedarTree;
import com.tenodru.yeehawmc.world.feature.PlantFeatures;
import com.tenodru.yeehawmc.world.feature.YeehawBiomeFeatures;

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
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class HillCountryBiome extends Biome{
	
	public HillCountryBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		
		// Add mob spawns
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 2, 4));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 5, 2, 4));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DONKEY, 5, 2, 3));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(ModEntityTypes.ARMADILLO.get(), 5, 2, 3));
		
		// Add carvers, like caves
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715f)));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02f)));
		DefaultBiomeFeatures.addCarvers(this);
	    DefaultBiomeFeatures.addStructures(this);
		
		// Add lakes
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE
				.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState()))
				.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(2))));
		
		// Add vegetation
		DefaultBiomeFeatures.addPlainsTallGrass(this);
		DefaultBiomeFeatures.addVeryDenseGrass(this);
		DefaultBiomeFeatures.addSavannaTrees(this);
		DefaultBiomeFeatures.addDeadBushes(this);
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.FLOWER.withConfiguration(PlantFeatures.BLUEBONNET_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.FLOWER.withConfiguration(PlantFeatures.PAINTBRUSH_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(7))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.RANDOM_PATCH.withConfiguration(PlantFeatures.COUNTRY_SHRUB_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(24))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.FLOWER.withConfiguration(PlantFeatures.DANDELION_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.FLOWER.withConfiguration(PlantFeatures.ALLIUM_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.FLOWER.withConfiguration(PlantFeatures.OXEYE_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.FLOWER.withConfiguration(PlantFeatures.PEONY_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.FLOWER.withConfiguration(PlantFeatures.PRICKLY_PEAR_CACTUS_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE
				.withConfiguration(CedarTree.CEDAR_TREE_CONFIG)
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
						.configure(new AtSurfaceWithExtraConfig(8, 0.1f, 1))));
		
		DefaultBiomeFeatures.addReedsAndPumpkins(this);
		
		// Add underground stuff
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		YeehawBiomeFeatures.addStoneVariants(this);
		
		// Add structures
		DefaultBiomeFeatures.addMonsterRooms(this);
		
		
	}
	
	
}
