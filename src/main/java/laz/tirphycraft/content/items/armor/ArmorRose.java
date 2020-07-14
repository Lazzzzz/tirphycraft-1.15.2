package laz.tirphycraft.content.items.armor;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ArmorRose extends ArmorItem {

	public ArmorRose(IArmorMaterial material, EquipmentSlotType slot) {
		super(material, slot, new Item.Properties().group(ITEM_GROUP));
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == TirphycraftItems.ROSE_FEET
			&& player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == TirphycraftItems.ROSE_LEGS
			&& player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == TirphycraftItems.ROSE_CHEST
			&& player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == TirphycraftItems.ROSE_HEAD) {
		
			player.extinguish();
			player.addPotionEffect(new EffectInstance(Effects.SPEED, 20, 1, false, false));
		
		}
	}

	
}
