package laz.tirphycraft.content.items.other.book;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;

public class BookOfKnowledgeProvider implements INamedContainerProvider {

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		return new BookOfKnowledgeContainer(p_createMenu_1_,p_createMenu_2_);
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
	}

}
