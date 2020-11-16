package com.tenodru.yeehawmc.init;

import com.tenodru.yeehawmc.YeehawMC;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitDef {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, YeehawMC.MOD_ID);
	
	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_item", 
			() -> new Block( Block.Properties.create(Material.EARTH)));
}
