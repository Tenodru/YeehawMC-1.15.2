package com.tenodru.yeehawmc.init;


import java.util.function.Supplier;

import com.tenodru.yeehawmc.YeehawMC;
import com.tenodru.yeehawmc.YeehawMC.YeehawItemGroup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(YeehawMC.MOD_ID)
@Mod.EventBusSubscriber(modid = YeehawMC.MOD_ID, bus = Bus.MOD)
public class ItemInit 
{
	public static final Item blue_topaz = null;
	public static final Item opal_gem = null;
	public static final Item pyrite_ingot = null;
	public static final Item cowboy_hat = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry()
		.register(new Item(new Item.Properties()
				.group(YeehawItemGroup.instance)).setRegistryName("blue_topaz"));
		
		event.getRegistry()
		.register(new Item(new Item.Properties()
				.group(YeehawItemGroup.instance)).setRegistryName("opal"));
		
		event.getRegistry()
		.register(new Item(new Item.Properties()
				.group(YeehawItemGroup.instance)).setRegistryName("pyrite_ingot"));
		
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(YeehawItemGroup.instance)).setRegistryName("cowboy_hat"));
	}

	public enum ModArmorMaterial implements IArmorMaterial {
		TEST(YeehawMC.MOD_ID + ":test", 5, new int[] {7, 9, 11, 7}, 420, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 6.9F, () -> {
			return Ingredient.fromItems(ItemInit.blue_topaz);
		});

		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;

		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
				Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			// TODO Auto-generated method stub
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			// TODO Auto-generated method stub
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			// TODO Auto-generated method stub
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}

		@Override
		public float getToughness() {
			// TODO Auto-generated method stub
			return this.toughness;
		}
	}
}
