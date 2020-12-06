package com.tenodru.yeehawmc.world.gen;

import com.tenodru.yeehawmc.init.BiomeInit;
import com.tenodru.yeehawmc.world.feature.PlantFeatures;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class YeehawPlantGen {

	public static void generateFlowers()
	{
		// These flowers will only generate in Hill Country
		ForgeRegistries.BIOMES.forEach(biome -> {
			if (biome == BiomeInit.HILL_COUNTRY_BIOME.get())
			{
				// FrequencyConfig is how often these patches of flowers/plants will generate
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
						Feature.FLOWER.withConfiguration(PlantFeatures.BLUEBONNET_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
				
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
						Feature.FLOWER.withConfiguration(PlantFeatures.PAINTBRUSH_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
				
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
						Feature.RANDOM_PATCH.withConfiguration(PlantFeatures.COUNTRY_SHRUB_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(24))));
			}
		});
	}
}
