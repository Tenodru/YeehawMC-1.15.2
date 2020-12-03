package com.tenodru.yeehawmc.util;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.client.entity.render.ArmadilloRender;
import com.tenodru.yeehawmc.init.BlockInitDef;
import com.tenodru.yeehawmc.init.ModEntityTypes;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = YeehawMC.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void ClientSetup(FMLClientSetupEvent event)
	{
		RenderTypeLookup.setRenderLayer(BlockInitDef.CEDAR_SAPLING.get(), RenderType.getCutout());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARMADILLO.get(), ArmadilloRender::new);
	}
	
}
