package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.YeehawMC.YeehawItemGroup;
import com.tenodru.yeehawmc.YeehawMC.YeehawMusicItemGroup;
import com.tenodru.yeehawmc.objects.items.ModMusicDiscItem;
import com.tenodru.yeehawmc.objects.items.ModSpawnEggItem;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitDef {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, YeehawMC.MOD_ID);
	
	// Music Discs
	public static final RegistryObject<Item> CREPUSCULAR_DISC = ITEMS.register("music_disc_crepuscular", 
			() -> new ModMusicDiscItem(5, SoundInit.LAZY_MUSIC_CREPUSCULAR.get(), 
					new Item.Properties().group(YeehawMusicItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	
	public static final RegistryObject<Item> SUNSET_DISC = ITEMS.register("music_disc_sunset", 
			() -> new ModMusicDiscItem(5, SoundInit.LAZY_MUSIC_SUNSET.get(), 
					new Item.Properties().group(YeehawMusicItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	
	public static final RegistryObject<Item> NO_REST_DISC = ITEMS.register("music_disc_stillnorest", 
			() -> new ModMusicDiscItem(5, SoundInit.LAZY_MUSIC_STILLNOREST.get(), 
					new Item.Properties().group(YeehawMusicItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	
	// Spawn Eggs
	public static final RegistryObject<Item> ARMADILLO_SPAWN_EGG = ITEMS.register("armadillo_spawn_egg", 
			() -> new ModSpawnEggItem(ModEntityTypes.ARMADILLO, 0x683C33, 0xAF6C63,
					new Item.Properties().group(YeehawItemGroup.instance).maxStackSize(16)));
}
