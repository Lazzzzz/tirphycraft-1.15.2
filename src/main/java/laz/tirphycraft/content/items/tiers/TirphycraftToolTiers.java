package laz.tirphycraft.content.items.tiers;

import java.util.function.Supplier;

import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum TirphycraftToolTiers implements IItemTier {

	PYRODES_TOOL(3, 2000, 7.0f, 3.5F, 15, () -> {
		return Ingredient.fromItems(TirphycraftItems.CRYSTAL_PYRODES.get());
	}),
	HEAVY_TOOL(2, 3500, 6.0F, 3.0F, 14, () -> {
		return Ingredient.fromItems(TirphycraftItems.HEAVY_INGOT.get());
	}),

	PICITE_TOOL(2, 8000, 5, 3.0F, 20, () -> {
		return Ingredient.fromItems(TirphycraftItems.PICITE_INGOT.get());
	}),
	
	HISTICE_TOOL(2, 750, 9, 1.0F, 20, () -> {
		return Ingredient.fromItems(TirphycraftItems.HISTICE_GEM.get());
	}),
	
	NIXIUM_TOOL(3, 2800, 10, 6.0F, 20, () -> {
		return Ingredient.fromItems(TirphycraftItems.NIXIUM_INGOT.get());
	}),
	TENIUM_TOOL(4, 5000, 10, 9.0F, 30, () -> {
		return Ingredient.fromItems(TirphycraftItems.TENIUM_INGOT.get());
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private TirphycraftToolTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
			Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<>(repairMaterial);
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}
}
