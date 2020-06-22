package laz.tirphycraft.content.items.armor;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.armor.DraugrirChestModel;
import laz.tirphycraft.client.model.entity.armor.DraugrirFeetModel;
import laz.tirphycraft.client.model.entity.armor.DraugrirHelmetModel;
import laz.tirphycraft.client.model.entity.armor.DraugrirLegsModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ArmorDraugrir extends ArmorItem {

	public ArmorDraugrir(IArmorMaterial material, EquipmentSlotType slot) {
		super(material, slot, new Item.Properties().group(ITEM_GROUP));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
	{
		if (armorSlot == EquipmentSlotType.HEAD) {
			DraugrirHelmetModel model = new DraugrirHelmetModel();
	        model.isChild = _default.isChild;
	        model.isSneak = _default.isSneak;
	        model.isSitting = _default.isSitting;
	        model.rightArmPose = _default.rightArmPose;
	        model.leftArmPose = _default.leftArmPose;

	        return (A) model;
		}
		if (armorSlot == EquipmentSlotType.CHEST) {
			DraugrirChestModel model = new DraugrirChestModel();
	        model.isChild = _default.isChild;
	        model.isSneak = _default.isSneak;
	        model.isSitting = _default.isSitting;
	        model.rightArmPose = _default.rightArmPose;
	        model.leftArmPose = _default.leftArmPose;

	        return (A) model;
		}
		
		if (armorSlot == EquipmentSlotType.LEGS) {
			DraugrirLegsModel model = new DraugrirLegsModel();
	        model.isChild = _default.isChild;
	        model.isSneak = _default.isSneak;
	        model.isSitting = _default.isSitting;
	        model.rightArmPose = _default.rightArmPose;
	        model.leftArmPose = _default.leftArmPose;

	        return (A) model;
		}
		
		if (armorSlot == EquipmentSlotType.FEET) {
			DraugrirFeetModel model = new DraugrirFeetModel();
	        model.isChild = _default.isChild;
	        model.isSneak = _default.isSneak;
	        model.isSitting = _default.isSitting;
	        model.rightArmPose = _default.rightArmPose;
	        model.leftArmPose = _default.leftArmPose;

	        return (A) model;
		}
		return null;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
	{
		return new ResourceLocation(Tirphycraft.MOD_ID + ":models/armor/draugrir_amor.png").toString();
	}
}
