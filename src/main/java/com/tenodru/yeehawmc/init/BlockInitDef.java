package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.objects.blocks.CedarButtonBlock;
import com.tenodru.yeehawmc.objects.blocks.CedarPressurePlateBlock;
//import com.tenodru.yeehawmc.objects.blocks.CedarButtonBlock;
//import com.tenodru.yeehawmc.objects.blocks.CedarPressurePlateBlock;
import com.tenodru.yeehawmc.objects.blocks.CedarSaplingBlock;
import com.tenodru.yeehawmc.objects.blocks.ModBushBlock;
import com.tenodru.yeehawmc.world.feature.CedarTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitDef {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, YeehawMC.MOD_ID);
	
	public static final RegistryObject<Block> CEDAR_LOG = BLOCKS.register("cedar_log", 
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	
	public static final RegistryObject<Block> CEDAR_LEAVES = BLOCKS.register("cedar_leaves", 
			() -> new LeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.FOLIAGE)
					.hardnessAndResistance(0.2f)
					.tickRandomly()
					.sound(SoundType.PLANT)
					.notSolid()));
	
	public static final RegistryObject<Block> CEDAR_SAPLING = BLOCKS.register("cedar_sapling", 
			() -> new CedarSaplingBlock(() -> new CedarTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	
	public static final RegistryObject<Block> CEDAR_PLANKS = BLOCKS.register("cedar_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> CEDAR_SLAB = BLOCKS.register("cedar_slab",
			() -> new SlabBlock(Block.Properties.from(CEDAR_PLANKS.get())));
	
	public static final RegistryObject<Block> CEDAR_STAIRS = BLOCKS.register("cedar_stairs",
			() -> new StairsBlock(() -> CEDAR_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
	
	public static final RegistryObject<Block> CEDAR_FENCE = BLOCKS.register("cedar_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	public static final RegistryObject<Block> CEDAR_BUTTON = BLOCKS.register("cedar_button",
			() -> new CedarButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
	
	public static final RegistryObject<Block> CEDAR_PRESSURE_PLATE = BLOCKS.register("cedar_pressure_plate",
			() -> new CedarPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
	
	public static final RegistryObject<Block> BLUEBONNET = BLOCKS.register("bluebonnet", 
			() -> new FlowerBlock(Effects.SATURATION, 7, Block.Properties.from(Blocks.BLUE_ORCHID)));
	
	public static final RegistryObject<Block> PAINTBRUSH_FLOWER = BLOCKS.register("paintbrush_flower", 
			() -> new FlowerBlock(Effects.SATURATION, 7, Block.Properties.from(Blocks.BLUE_ORCHID)));
	
	public static final RegistryObject<Block> COUNTRY_SHRUB = BLOCKS.register("country_shrub", 
			() -> new ModBushBlock(Block.Properties.from(Blocks.FERN)));
	
}
