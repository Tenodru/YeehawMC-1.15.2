package com.tenodru.yeehawmc.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class ModFlowerBlock extends FlowerBlock{

	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

	public ModFlowerBlock(Effect effectIn, int effectDuration, Properties properties) {
		super(effectIn, effectDuration, properties);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public Vec3d getOffset(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return super.getOffset(state, worldIn, pos);
	}
	
	@Override
	public Effect getStewEffect() {
		return super.getStewEffect();
	}
	
	@Override
	public int getStewEffectDuration() {
		return super.getStewEffectDuration();
	}

}
