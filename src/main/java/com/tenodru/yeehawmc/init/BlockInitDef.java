package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.objects.blocks.CedarSaplingBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitDef {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, YeehawMC.MOD_ID);
	
	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_item", 
			() -> new Block( Block.Properties.create(Material.EARTH)));
	
	public static final RegistryObject<Block> CEDAR_LOG = BLOCKS.register("cedar_log", 
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	
	public static final RegistryObject<Block> CEDAR_LEAVES = BLOCKS.register("cedar_leaves", 
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> CEDAR_SAPLING = BLOCKS.register("cedar_sapling", 
			() -> new CedarSaplingBlock(null, Block.Properties.from(Blocks.OAK_SAPLING)));
}
