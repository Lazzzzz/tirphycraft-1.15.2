package laz.tirphycraft.content.items.tiers;

import java.util.function.Supplier;

import laz.tirphycraft.content.TirphycraftItems;
import laz.tirphycraft.Tirphycraft;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.LazyValue;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.util.SoundEvents;

public enum TirphycraftArmorTiers implements IArmorMaterial {
	PYRODES(Tirphycraft.MOD_ID + ":pyrodes", 30, new int[] {4, 7, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f, () -> {
	return Ingredient.fromItems(TirphycraftItems.CRYSTAL_PYRODES.get());
	}),
	HEAVY(Tirphycraft.MOD_ID + ":heavy", 50, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f, () -> {
	return Ingredient.fromItems(TirphycraftItems.HEAVY_INGOT.get());
	}),
	NIXIUM(Tirphycraft.MOD_ID + ":nixium", 40, new int[]{5, 8, 9, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F, () -> {
	return Ingredient.fromItems(TirphycraftItems.NIXIUM_INGOT.get());
	}),
	TENIUM(Tirphycraft.MOD_ID + ":tenium", 60, new int[]{7, 10, 11, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6.0F, () -> {
	return Ingredient.fromItems(TirphycraftItems.TENIUM_INGOT.get());
	}),
	ROSE(Tirphycraft.MOD_ID + ":rose", 30, new int[] {4, 7, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f, () -> {
	return Ingredient.fromItems(TirphycraftItems.ROSE_SHARD.get());
	}),
	ORIGIN(Tirphycraft.MOD_ID + ":origin", 70, new int[] {8, 11, 12, 8}, 40, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 7.0F, () -> {
	return Ingredient.fromItems(TirphycraftItems.ORIGIN_INGOT.get());
	});

	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;

	private TirphycraftArmorTiers(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
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
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}
}

