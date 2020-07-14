package laz.tirphycraft.content.tiles.frozFurnace;

import java.util.Objects;

import laz.tirphycraft.content.tiles.frozFurnace.slots.FrozFuelSlot;
import laz.tirphycraft.content.tiles.frozFurnace.slots.FrozOutputSLot;
import laz.tirphycraft.content.tiles.frozFurnace.slots.FrozRoseSlot;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftContainer;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class FrozFurnaceContainer extends Container {

	public FrozFurnaceTE tileEntity;
	public IWorldPosCallable canInteractWithCallable;

	public FrozFurnaceContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	public FrozFurnaceContainer(int id, PlayerInventory inv, final FrozFurnaceTE tile) {
		super(TirphycraftContainer.FROZ_FURNACE_CONTAINER.get(), id);

		this.tileEntity = tile;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
		
		this.addSlot(new FrozRoseSlot(tile, 0, 14, 35));  	// rose petal
		this.addSlot(new FrozFuelSlot(tile, 1, 44, 53));  	// black crystal
		this.addSlot(new FrozFuelSlot(tile, 2, 68, 53));  	// green crystal
		this.addSlot(new Slot(tile, 3, 56, 17));  		   	// input
		this.addSlot(new FrozOutputSLot(tile, 4, 116, 35)); // output

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

	private static FrozFurnaceTE getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof FrozFurnaceTE) {
			return (FrozFurnaceTE) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && index >= 5 && index <= 40) {
			ItemStack current = slot.getStack();
			
			if (current.getItem() == TirphycraftItems.ROSE_SHARD.get()) {
				Slot roseSlot = this.inventorySlots.get(0);
				if (roseSlot.getSlotStackLimit() - roseSlot.getStack().getCount() > 0) {
					if (roseSlot.getStack().getItem() != Blocks.AIR.asItem()) {
						int amount = Math.min(current.getCount(), roseSlot.getSlotStackLimit() - roseSlot.getStack().getCount());
						current.setCount(current.getCount() - amount);
						roseSlot.getStack().setCount(roseSlot.getStack().getCount() + amount);
					}else {
						roseSlot.putStack(current.copy());
						current.setCount(0);
					}
				}
			}
			else if (current.getItem() == TirphycraftBlocks.FROZEN_CRYSTAL.getItem()) {
				Slot fuelSlot = null;
				
				if (this.inventorySlots.get(2).getStack().getItem() == TirphycraftBlocks.FROZEN_CRYSTAL.getItem() || this.inventorySlots.get(2).getStack().getItem() == Blocks.AIR.asItem()) {
					fuelSlot = this.inventorySlots.get(2);
				}
				if (this.inventorySlots.get(1).getStack().getItem() == TirphycraftBlocks.FROZEN_CRYSTAL.getItem() || this.inventorySlots.get(1).getStack().getItem() == Blocks.AIR.asItem()) {
					fuelSlot = this.inventorySlots.get(1);
				}
				if (fuelSlot != null) {
					if (fuelSlot.getStack().getItem() != Blocks.AIR.asItem()) {
						if (fuelSlot.getSlotStackLimit() - fuelSlot.getStack().getCount() > 0) {
							int amount = Math.min(current.getCount(), fuelSlot.getSlotStackLimit() - fuelSlot.getStack().getCount());
							current.setCount(current.getCount() - amount);
							fuelSlot.getStack().setCount(fuelSlot.getStack().getCount() + amount);
						}
					
					} else {
						fuelSlot.putStack(current.copy());
						current.setCount(0);
					}
				}
			}
			
			else if (current.getItem() == TirphycraftBlocks.BLACK_CRYSTAL.getItem()) {
				Slot fuelSlot = null;
				
				if (this.inventorySlots.get(2).getStack().getItem() == TirphycraftBlocks.BLACK_CRYSTAL.getItem() || this.inventorySlots.get(2).getStack().getItem() == Blocks.AIR.asItem()) {
					fuelSlot = this.inventorySlots.get(2);
				}
				if (this.inventorySlots.get(1).getStack().getItem() == TirphycraftBlocks.BLACK_CRYSTAL.getItem() || this.inventorySlots.get(1).getStack().getItem() == Blocks.AIR.asItem()) {
					fuelSlot = this.inventorySlots.get(1);
				}
				if (fuelSlot != null) {
					if (fuelSlot.getStack().getItem() != Blocks.AIR.asItem()) {
						if (fuelSlot.getSlotStackLimit() - fuelSlot.getStack().getCount() > 0) {
							int amount = Math.min(current.getCount(), fuelSlot.getSlotStackLimit() - fuelSlot.getStack().getCount());
							current.setCount(current.getCount() - amount);
							fuelSlot.getStack().setCount(fuelSlot.getStack().getCount() + amount);
						}
					} else {
						fuelSlot.putStack(current.copy());
						current.setCount(0);
					}
					
				}
			}
			else {
				Slot input = this.inventorySlots.get(3);
				if (input.getStack().getItem() == Blocks.AIR.asItem()) {
					input.putStack(current.copy());
					current.setCount(0);
				} else if (input.getStack().getItem() == current.getItem()) {
					if (input.getSlotStackLimit() - input.getStack().getCount() > 0 && input.getStack().getMaxStackSize() > input.getStack().getCount()) {
							int amount = Math.min(current.getCount(), input.getSlotStackLimit() - input.getStack().getCount());
							current.setCount(current.getCount() - amount);
							input.getStack().setCount(input.getStack().getCount() + amount);
					}
				}
			}
		}
		
		if (slot != null && index >= 0 && index <= 4) {
			if (!this.mergeItemStack(slot.getStack(), 5, 41, false)) {
				return itemstack;
			}
		}
		
		return itemstack;
	
	}
	
	

}
