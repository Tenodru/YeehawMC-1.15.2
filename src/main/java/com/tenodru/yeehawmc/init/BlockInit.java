package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.objects.blocks.CedarSaplingBlock;
import com.tenodru.yeehawmc.world.feature.CedarTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(YeehawMC.MOD_ID)
@Mod.EventBusSubscriber(modid = YeehawMC.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	//public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, YeehawMC.MOD_ID);
	
	public static final Block cedar_planks = null;
	public static final Block blue_topaz_ore = null;
	public static final Block pyrite_ore = null;
	public static final Block limestone = null;
	public static final Block cedar_log = null;
	public static final Block cedar_leaves = null;
	public static final Block cedar_sapling = null;
			
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry()
		.register(new Block(Block.Properties
				.create(Material.WOOD)
				.hardnessAndResistance(2.0f, 3.0f)
				.sound(SoundType.WOOD))
				.setRegistryName("cedar_planks"));
		
		event.getRegistry()
		.register(new Block(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(3.0f, 6.0f)
				.sound(SoundType.STONE)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE))
				.setRegistryName("blue_topaz_ore"));
		
		event.getRegistry()
		.register(new Block(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(3.0f, 6.0f)
				.sound(SoundType.STONE)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE))
				.setRegistryName("pyrite_ore"));
		
		event.getRegistry()
		.register(new Block(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(1.5f, 6.0f)
				.sound(SoundType.STONE)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE))
				.setRegistryName("limestone"));
		
		event.getRegistry()
		.register(new LogBlock(MaterialColor.WOOD, Block.Properties
				.from(Blocks.OAK_LOG))
				.setRegistryName("cedar_log"));
		
		event.getRegistry()
		.register(new LeavesBlock(Block.Properties
				.from(Blocks.OAK_LEAVES))
				.setRegistryName("cedar_leaves"));
		
		event.getRegistry()
		.register(new CedarSaplingBlock(() -> new CedarTree(), Block.Properties
				.from(Blocks.OAK_SAPLING))
				.setRegistryName("cedar_sapling"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry()
		.register(new BlockItem(cedar_planks, new Item.Properties()
				.group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName("cedar_planks"));
		
		event.getRegistry()
		.register(new BlockItem(blue_topaz_ore, new Item.Properties()
				.group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName("blue_topaz_ore"));
		
		event.getRegistry()
		.register(new BlockItem(pyrite_ore, new Item.Properties()
				.group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName("pyrite_ore"));
		
		event.getRegistry()
		.register(new BlockItem(limestone, new Item.Properties()
				.group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName("limestone"));
		
		event.getRegistry()
		.register(new BlockItem(cedar_log, new Item.Properties()
				.group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName("cedar_log"));
		
		event.getRegistry()
		.register(new BlockItem(cedar_leaves, new Item.Properties()
				.group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName("cedar_leaves"));
		
		event.getRegistry()
		.register(new BlockItem(cedar_sapling, new Item.Properties()
				.group(ItemGroup.MATERIALS))
				.setRegistryName("cedar_sapling"));
	}
	
	// Deferred Registry Blocks
	/*
	public static final RegistryObject<Block> CEDAR_LOG = BLOCKS.register("cedar_log", 
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	
	public static final RegistryObject<Block> CEDAR_LEAVES = BLOCKS.register("cedar_leaves", 
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> CEDAR_SAPLING = BLOCKS.register("cedar_sapling", 
			() -> new SaplingBlock(null, Block.Properties.from(Blocks.OAK_SAPLING)));*/
}
