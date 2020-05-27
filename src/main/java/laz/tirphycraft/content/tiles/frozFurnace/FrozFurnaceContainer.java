package laz.tirphycraft.content.tiles.frozFurnace;

import laz.tirphycraft.content.TirphycraftContainer;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.inventory.container.FurnaceFuelSlot;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.tileentity.FurnaceTileEntity;

public class FrozFurnaceContainer extends Container {

	public FrozFurnaceContainer(int id, PlayerInventory inv) {
		super(TirphycraftContainer.FROZ_FURNACE_CONTAINER.get(), id);
	}
	
	public FrozFurnaceContainer(int id, PlayerInventory inv, Inventory inventory) {
		super(TirphycraftContainer.FROZ_FURNACE_CONTAINER.get(), id);
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

}
