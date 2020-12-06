package com.tenodru.yeehawmc.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class ModBushBlock extends BushBlock{

	public ModBushBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return super.isValidGround(state, worldIn, pos);
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return super.isValidPosition(state, worldIn, pos);
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return super.propagatesSkylightDown(state, reader, pos);
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return super.allowsMovement(state, worldIn, pos, type);
	}
	
	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		return super.getPlant(world, pos);
	}
}
