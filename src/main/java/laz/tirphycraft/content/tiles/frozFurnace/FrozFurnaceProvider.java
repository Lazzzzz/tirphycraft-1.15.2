package laz.tirphycraft.content.tiles.frozFurnace;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class FrozFurnaceProvider implements INamedContainerProvider {
	
	private Inventory inventory;
	
	@Override
	public Container createMenu(int id, PlayerInventory inv, PlayerEntity p_createMenu_3) {
		return new FrozFurnaceContainer(id, inv, this.inventory);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent("froz furnace");
	}
	
	public void setInventory(Inventory inv) {
		this.inventory = inv;
	}

}
