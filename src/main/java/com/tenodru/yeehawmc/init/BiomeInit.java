package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.world.biomes.HillCountryBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, YeehawMC.MOD_ID);
	
	public static final RegistryObject<Biome> HILL_COUNTRY_BIOME = BIOMES.register("hill_country", 
			() -> new HillCountryBiome(new Biome.Builder()
					.precipitation(RainType.RAIN)
					.scale(.1f)
					.temperature(0.7f)
					.waterColor(0x3F76E4)
					.waterFogColor(0x050533)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig
							(Blocks.GRASS_BLOCK.getDefaultState(), 
									BlockInit.limestone.getDefaultState(), 
									Blocks.DIRT.getDefaultState()))
					.category(Category.PLAINS)
					.downfall(0.3f)
					.depth(0.125f)
					.parent(null)));
	
	public static void registerBiomes() {
		registerBiome(HILL_COUNTRY_BIOME.get(), Type.OVERWORLD, Type.HOT, Type.SAVANNA);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

}
