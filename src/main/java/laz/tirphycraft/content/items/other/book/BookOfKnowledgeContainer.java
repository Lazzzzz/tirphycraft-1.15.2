package laz.tirphycraft.content.items.other.book;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.TirphycraftContainer;
import laz.tirphycraft.util.book.BookItemInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class BookOfKnowledgeContainer extends Container implements INamedContainerProvider {

	public BookItemInfo selected = null;

	public BookOfKnowledgeContainer(int id, PlayerInventory inv) {
		super(TirphycraftContainer.BOOK_OF_KNOWLEDGE_CONTAINER.get(), id);

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(inv, k, 8 + k * 18, 142));
		}

	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}

	@Override
	public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
		return null;
	}

	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent("Book of Knowledge");
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		this.selected = findInfo(index);
		return itemstack;
	}
	
	public BookItemInfo findInfo(int index) {
		Item item = this.inventorySlots.get(index).getStack().getItem();
		for (int i = 0; i < Tirphycraft.BOOK_OF_KNOWLEDGE.size(); i++) {
			BookItemInfo info = Tirphycraft.BOOK_OF_KNOWLEDGE.get(i);
			if (info.getItem() == item) {
				return info;
			}
		}
		
		return null;
	}

}
