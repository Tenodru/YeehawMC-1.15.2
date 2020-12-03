package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, YeehawMC.MOD_ID);
	
	
	public static final RegistryObject<SoundEvent> AMBIENT = SOUNDS.register("entity.armadillo.ambient", 
			() -> new SoundEvent(new ResourceLocation(YeehawMC.MOD_ID, "entity.armadillo.ambient")));
	
	public static final RegistryObject<SoundEvent> HURT = SOUNDS.register("entity.armadillo.hurt", 
			() -> new SoundEvent(new ResourceLocation(YeehawMC.MOD_ID, "entity.armadillo.hurt")));
	
	public static final RegistryObject<SoundEvent> DEATH = SOUNDS.register("entity.armadillo.death", 
			() -> new SoundEvent(new ResourceLocation(YeehawMC.MOD_ID, "entity.armadillo.death")));
}
