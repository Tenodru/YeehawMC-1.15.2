package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(YeehawMC.MOD_ID)
@Mod.EventBusSubscriber(modid = YeehawMC.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block cedar_planks = null;
			
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry()
		.register(new Block(Block.Properties
				.create(Material.WOOD)
				.hardnessAndResistance(2.0f, 3.0f)
				.sound(SoundType.WOOD))
				.setRegistryName("cedar_planks"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry()
		.register(new BlockItem(cedar_planks, new Item.Properties()
				.group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName("cedar_planks"));
	}	
}
