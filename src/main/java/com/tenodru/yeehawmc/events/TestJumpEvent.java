package com.tenodru.yeehawmc.events;

import com.tenodru.yeehawmc.YeehawMC;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = YeehawMC.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent 
{
	@SubscribeEvent
	// Fires when an entity jumps.
	public static void testJumpEvent(LivingJumpEvent event)
	{
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
	}
}
