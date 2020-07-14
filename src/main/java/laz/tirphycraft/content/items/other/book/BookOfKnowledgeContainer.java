package laz.tirphycraft.content.items.other.book;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftContainer;
import laz.tirphycraft.util.book.BookItemInfo;
import net.minecraft.block.Blocks;
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

		for (int k = 0; k < 8; k++) {
			for (int i = 0; i < 5; i++) {
				int pos = i + (k*5);
				if (pos < 36) this.addSlot(new Slot(inv, pos, -38 + (i*25), 15 + (k * 18)));
			}
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
		
		return new BookItemInfo(Blocks.AIR,	"No info");
	}

}
