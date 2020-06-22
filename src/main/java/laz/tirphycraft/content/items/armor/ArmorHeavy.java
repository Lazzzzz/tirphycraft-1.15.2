package laz.tirphycraft.content.items.armor;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

<<<<<<< HEAD
import laz.tirphycraft.registry.init.TirphycraftItems;
=======
import laz.tirphycraft.content.TirphycraftItems;
>>>>>>> parent of 2669fca... structure
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ArmorHeavy extends ArmorItem {

	public ArmorHeavy(IArmorMaterial material, EquipmentSlotType slot) {
		super(material, slot, new Item.Properties().group(ITEM_GROUP));
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == TirphycraftItems.HEAVY_FEET
			&& player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == TirphycraftItems.HEAVY_LEGS
			&& player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == TirphycraftItems.HEAVY_CHEST
			&& player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == TirphycraftItems.HEAVY_HEAD) {
			if (player.isCreative() != true) {
				if (player.getMotion().y < 0) {
						player.addVelocity(0, -0.02, 0);
					}
				}
		
			player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 1, false, false));
			player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 1, false, false)); 
		
		}
	}

	
}
