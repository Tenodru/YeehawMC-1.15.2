package com.tenodru.yeehawmc.world.gen;

import com.tenodru.yeehawmc.init.BiomeInit;
import com.tenodru.yeehawmc.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class YeehawOreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			// Pyrite Ore
			ConfiguredPlacement customConfigPyrite = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 0, 0, 53));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.pyrite_ore.getDefaultState(), 9)).withPlacement(customConfigPyrite));
			
			// These ores will only spawn in Hill Country
			if (biome == BiomeInit.HILL_COUNTRY_BIOME.get())
			{
				// Blue Topaz Ore
				ConfiguredPlacement customConfigBlueTopaz = Placement.COUNT_RANGE.configure(new CountRangeConfig(11, 0, 0, 32));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BlockInit.blue_topaz_ore.getDefaultState(), 3)).withPlacement(customConfigBlueTopaz));
				
				// Opal Ore
				ConfiguredPlacement customConfigOpal = Placement.COUNT_RANGE.configure(new CountRangeConfig(11, 0, 0, 32));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
								BlockInit.opal_ore.getDefaultState(), 3)).withPlacement(customConfigPyrite));
			}
		}
	}
}
