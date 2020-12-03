package com.tenodru.yeehawmc.client.entity.render;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.client.entity.model.ArmadilloModel;
import com.tenodru.yeehawmc.entities.Armadillo;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ArmadilloRender extends MobRenderer<Armadillo, ArmadilloModel<Armadillo>>{
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(YeehawMC.MOD_ID, "textures/entity/armadillo.png");
	
	public ArmadilloRender(EntityRendererManager renderManagerIn)
	{
		super (renderManagerIn, new ArmadilloModel<Armadillo>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(Armadillo entity) {
		return TEXTURE;
	}
}
