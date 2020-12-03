package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.entities.Armadillo;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			YeehawMC.MOD_ID);

	public static final RegistryObject<EntityType<Armadillo>> ARMADILLO = ENTITY_TYPES.register("armadillo",
			() -> EntityType.Builder.<Armadillo>create(Armadillo::new, EntityClassification.CREATURE).size(0.9f, 1.3f)
					.build(new ResourceLocation(YeehawMC.MOD_ID, "armadillo").toString()));

	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(ARMADILLO.get(), BiomeInit.HILL_COUNTRY_BIOME.get());
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes)
	{
		for (Biome biome : biomes)
		{
			if (biome != null)
			{
				// weight, minimum amount that can spawn in a group, and the maximum amount that can spawn.
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 5));
			}
		}
	}
	
}
