package laz.tirphycraft.content.items.artefacts;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArtefactFeatherOfLight extends Item {

	public ArtefactFeatherOfLight() {
		super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
	}
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void inventoryTick(ItemStack stack, net.minecraft.world.World worldIn, Entity living, int itemSlot,
			boolean isSelected) {
		living.fallDistance = 0;
	}
}
