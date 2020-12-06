package com.tenodru.yeehawmc.objects.blocks;

import net.minecraft.block.PressurePlateBlock;

public class CedarPressurePlateBlock extends PressurePlateBlock {

	public CedarPressurePlateBlock(Sensitivity sensitivityIn, Properties propertiesIn) {
		// Sensitivity.EVERYTHING = Wood
		// Sensitivity.MOBS = Stone
		super(sensitivityIn, propertiesIn);
	}

}