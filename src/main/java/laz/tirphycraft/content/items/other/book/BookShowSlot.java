package laz.tirphycraft.content.items.other.book;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class BookShowSlot extends Slot{

	public BookShowSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean canTakeStack(PlayerEntity playerIn) {
		return true;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	public void setStack(ItemStack stack) {
		this.inventory.setInventorySlotContents(this.slotNumber, stack);
	}
	
}
