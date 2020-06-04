package laz.tirphycraft.content.tiles.frozFurnace.slots;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class FrozFuelSlot extends Slot {

	public FrozFuelSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem() == TirphycraftBlocks.BLACK_CRYSTAL.getItem() || stack.getItem() == TirphycraftBlocks.FROZEN_CRYSTAL.getItem()) return true;
		return false;
	}

}
