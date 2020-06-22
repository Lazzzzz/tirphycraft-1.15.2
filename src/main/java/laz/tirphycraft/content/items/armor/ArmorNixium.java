package laz.tirphycraft.content.items.armor;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import laz.tirphycraft.content.TirphycraftItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ArmorNixium extends ArmorItem {

	public ArmorNixium(IArmorMaterial material, EquipmentSlotType slot) {
		super(material, slot, new Item.Properties().group(ITEM_GROUP));
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == TirphycraftItems.NIXIUM_FEET
			&& player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == TirphycraftItems.NIXIUM_LEGS
			&& player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == TirphycraftItems.NIXIUM_CHEST
			&& player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == TirphycraftItems.NIXIUM_HEAD) {
		
			player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 1, false, false));
			player.addPotionEffect(new EffectInstance(Effects.SPEED, 20, 0, false, false));
		
		}
	}

	
}
