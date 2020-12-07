package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.world.biomes.HillCountryBiome;
import com.tenodru.yeehawmc.world.gen.builders.HillCountrySurfaceBuilder;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, YeehawMC.MOD_ID);
	
	public static final RegistryObject<Biome> HILL_COUNTRY_BIOME = BIOMES.register("hill_country", 
			() -> new HillCountryBiome(new Biome.Builder()
					.precipitation(RainType.RAIN)
					.scale(.15f)
					.temperature(1.0f)
					.waterColor(0x3F76E4)
					.waterFogColor(0x050533)
					.surfaceBuilder(
							new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
									register("hill_country", 
											new HillCountrySurfaceBuilder(SurfaceBuilderConfig::deserialize)), 
									new SurfaceBuilderConfig (Blocks.GRASS_BLOCK.getDefaultState(), 
											Blocks.DIRT.getDefaultState(), 
											Blocks.DIRT.getDefaultState())))
					.category(Category.PLAINS)
					.downfall(0.3f)
					.depth(0.125f)
					.parent(null)));
	
	public static void registerBiomes() {
		registerBiome(HILL_COUNTRY_BIOME.get(), BiomeType.WARM, 10, Type.OVERWORLD, Type.DRY, Type.PLAINS, Type.SAVANNA, Type.HILLS, Type.FOREST);
	}
	
	private static void registerBiome(Biome biome, BiomeType biomeType, int weight, Type... types) {
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, weight));
		BiomeManager.addSpawnBiome(biome);
	}
	
	@SuppressWarnings("deprecation")
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}

}
