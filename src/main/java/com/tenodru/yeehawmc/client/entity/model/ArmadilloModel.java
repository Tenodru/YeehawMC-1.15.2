package com.tenodru.yeehawmc.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.tenodru.yeehawmc.entities.Armadillo;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ArmadilloModel<T extends Armadillo> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer BackRightFoot;
	private final ModelRenderer RightFrontFoot;
	private final ModelRenderer LeftFrontFoot;
	private final ModelRenderer BackLeftFoot;
	private final ModelRenderer Tail;
	private final ModelRenderer tail3_r1;

	public ArmadilloModel() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(1.0F, 18.0F, -7.0F);
		Head.setTextureOffset(22, 22).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(28, 5).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 3).addBox(-3.0F, -3.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(1.0F, -3.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(1.0F, 18.25F, 0.0F);
		Body.setTextureOffset(0, 24).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 7.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 13).addBox(-4.0F, -3.0F, 1.0F, 8.0F, 6.0F, 5.0F, 0.0F, false);

		BackRightFoot = new ModelRenderer(this);
		BackRightFoot.setRotationPoint(-1.0F, 21.0F, 3.0F);
		BackRightFoot.setTextureOffset(18, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		RightFrontFoot = new ModelRenderer(this);
		RightFrontFoot.setRotationPoint(-1.0F, 21.5F, -4.0F);
		RightFrontFoot.setTextureOffset(0, 31).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LeftFrontFoot = new ModelRenderer(this);
		LeftFrontFoot.setRotationPoint(3.0F, 21.5F, -4.0F);
		LeftFrontFoot.setTextureOffset(29, 10).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		BackLeftFoot = new ModelRenderer(this);
		BackLeftFoot.setRotationPoint(3.0F, 21.0F, 3.0F);
		BackLeftFoot.setTextureOffset(26, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(1.0F, 18.25F, 5.0F);
		setRotationAngle(Tail, -0.4363F, 0.0F, 0.0F);
		Tail.setTextureOffset(22, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Tail.setTextureOffset(21, 13).addBox(-1.0F, -0.2037F, 2.1993F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		tail3_r1 = new ModelRenderer(this);
		tail3_r1.setRotationPoint(-1.0F, 5.75F, -5.0F);
		Tail.addChild(tail3_r1);
		setRotationAngle(tail3_r1, 0.0873F, 0.0F, 0.0F);
		tail3_r1.setTextureOffset(26, 18).addBox(0.5F, -5.1265F, 10.5074F, 1.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		BackRightFoot.render(matrixStack, buffer, packedLight, packedOverlay);
		RightFrontFoot.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftFrontFoot.render(matrixStack, buffer, packedLight, packedOverlay);
		BackLeftFoot.render(matrixStack, buffer, packedLight, packedOverlay);
		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(T entityIn, float f, float f1, float f3, float f4, float f5) {
		//super.setRotationAngles(entityIn, f, f1, f3, f4, f5);
		this.RightFrontFoot.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.BackLeftFoot.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LeftFrontFoot.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.BackRightFoot.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	public ModelRenderer getHead() {
		return Head;
	}

	public ModelRenderer getBody() {
		return Body;
	}

	public ModelRenderer getTail() {
		return Tail;
	}

	public ModelRenderer getTail3_r1() {
		return tail3_r1;
	}

	public ModelRenderer getLeftFrontFoot() {
		return LeftFrontFoot;
	}

	public ModelRenderer getRightFrontFoot() {
		return RightFrontFoot;
	}

	public ModelRenderer getBackLeftFoot() {
		return BackLeftFoot;
	}

	public ModelRenderer getBackRightFoot() {
		return BackRightFoot;
	}
}
