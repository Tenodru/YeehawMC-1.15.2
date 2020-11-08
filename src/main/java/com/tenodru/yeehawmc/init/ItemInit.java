package com.tenodru.yeehawmc.init;


import com.tenodru.yeehawmc.YeehawMC;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(YeehawMC.MOD_ID)
@Mod.EventBusSubscriber(modid = YeehawMC.MOD_ID, bus = Bus.MOD)
public class ItemInit 
{
	//public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, YeehawMC.MOD_ID);

	public static final Item blue_topaz = null;
	public static final Item pyrite_ingot = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry()
		.register(new Item(new Item.Properties()
				.group(ItemGroup.MISC)).setRegistryName("blue_topaz"));
		
		event.getRegistry()
		.register(new Item(new Item.Properties()
				.group(ItemGroup.MISC)).setRegistryName("pyrite_ingot"));
		
		//HERE!
	}
}
