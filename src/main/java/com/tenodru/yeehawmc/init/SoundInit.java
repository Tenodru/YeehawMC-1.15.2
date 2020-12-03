package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
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
	
	// Music
	public static final Lazy<SoundEvent> LAZY_MUSIC_CREPUSCULAR = Lazy.of(
			() -> new SoundEvent(new ResourceLocation(YeehawMC.MOD_ID, "disc.crepuscular")));
	
	public static final RegistryObject<SoundEvent> MUSIC_CREPUSCULAR = SOUNDS.register("music_crepuscular", 
			LAZY_MUSIC_CREPUSCULAR);
	// ---
	public static final Lazy<SoundEvent> LAZY_MUSIC_SUNSET = Lazy.of(
			() -> new SoundEvent(new ResourceLocation(YeehawMC.MOD_ID, "disc.sunset")));
	
	public static final RegistryObject<SoundEvent> MUSIC_SUNSET = SOUNDS.register("music_sunset", 
			LAZY_MUSIC_SUNSET);
	// ---
	public static final Lazy<SoundEvent> LAZY_MUSIC_STILLNOREST = Lazy.of(
			() -> new SoundEvent(new ResourceLocation(YeehawMC.MOD_ID, "disc.stillnorest")));
	
	public static final RegistryObject<SoundEvent> MUSIC_STILLNOREST = SOUNDS.register("music_stillnorest", 
			LAZY_MUSIC_STILLNOREST);
}
