package com.tenodru.yeehawmc.entities;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.init.ModEntityTypes;
import com.tenodru.yeehawmc.init.SoundInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Armadillo extends AnimalEntity {

	private EatGrassGoal eatGrassGoal;
	private int goalTimer;

	public Armadillo(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);

	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		Armadillo entity = new Armadillo(ModEntityTypes.ARMADILLO.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return entity;
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.eatGrassGoal = new EatGrassGoal(this);
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, this.eatGrassGoal);
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void updateAITasks() {
		this.goalTimer = this.eatGrassGoal.getEatingGrassTimer();
		super.updateAITasks();
	}
	
	@Override
	public void livingTick() {
		if(this.world.isRemote)
		{
			this.goalTimer = Math.max(0, this.goalTimer - 1);
		}
		super.livingTick();
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.goalTimer = 40;
		} else {
			super.handleStatusUpdate(id);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationPointY(float p_70894_1_) {
		if (this.goalTimer <= 0) {
			return 0.0F;
		} else if (this.goalTimer >= 4 && this.goalTimer <= 36) {
			return 1.0F;
		} else {
			return this.goalTimer < 4 ? ((float) this.goalTimer - p_70894_1_) / 4.0F
					: -((float) (this.goalTimer - 40) - p_70894_1_) / 4.0F;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationAngleX(float p_70890_1_) {
		if (this.goalTimer > 4 && this.goalTimer <= 36) {
			float f = ((float) (this.goalTimer - 4) - p_70890_1_) / 32.0F;
			return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
		} else {
			return this.goalTimer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
		}
	}

	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
		this.setGlowing(true);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.HURT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.DEATH.get();
	}

}
