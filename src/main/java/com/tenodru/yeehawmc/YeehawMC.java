package com.tenodru.yeehawmc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tenodru.yeehawmc.init.BiomeInit;
import com.tenodru.yeehawmc.init.BlockInitDef;
import com.tenodru.yeehawmc.init.ItemInit;
import com.tenodru.yeehawmc.world.gen.YeehawOreGen;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("yeehawmc")
@Mod.EventBusSubscriber(modid = YeehawMC.MOD_ID, bus = Bus.MOD)
public class YeehawMC
{
	public static final String MOD_ID = "yeehawmc";
	public static YeehawMC instance;
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public YeehawMC() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
        
    	BlockInitDef.BLOCKS.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);
        
        instance = this;

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	
    	BlockInitDef.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(YeehawItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	LOGGER.debug("Registered BlockItems.");
    }
    
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
    	BiomeInit.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
        
    }
    
    public static class YeehawItemGroup extends ItemGroup
    {
    	public static final YeehawItemGroup instance = new YeehawItemGroup(ItemGroup.GROUPS.length, "yeehawtab");
    	private YeehawItemGroup(int index, String label)
    	{
    		super (index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(ItemInit.blue_topaz);
    	}
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	YeehawOreGen.generateOre();
    }
}
