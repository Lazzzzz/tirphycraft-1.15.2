package laz.tirphycraft.content.tiles.frozFurnace.slots;

import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class FrozRoseSlot extends Slot {
	
	public FrozRoseSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem() == TirphycraftItems.ROSE_SHARD.get()) return true;
		return false;
	}

}
