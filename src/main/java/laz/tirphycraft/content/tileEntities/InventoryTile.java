package laz.tirphycraft.content.tileEntities;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class InventoryTile extends TileEntity {

    private final int size;

    protected LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

    public InventoryTile(TileEntityType<?> tileEntityTypeIn, int size) {
        super(tileEntityTypeIn);
        this.size = size;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    private IItemHandler createHandler() {
        return new ItemStackHandler(size) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }
        };
    }

    public ItemStack getItemInSlot(int slot) {
        return handler.map(inventory -> inventory.getStackInSlot(slot)).orElse(null);
    }

    public ItemStack insertItem(int slot, ItemStack stack) {
        ItemStack itemIn = stack.copy();
        itemIn.setCount(1);
        stack.shrink(1);
        return handler.map(inventory -> inventory.insertItem(slot, itemIn, false)).orElse(null);
    }

    public ItemStack extractItem(int slot) {
        return handler.map(inventory -> inventory.extractItem(slot, 1, false)).orElse(null);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        ListNBT list = compound.getList("Items", 10);
        for (int x = 0; x < list.size(); ++x) {
            CompoundNBT nbt = list.getCompound(x);
            int r = nbt.getByte("Slot") & 255;
            handler.ifPresent(inventory -> {
                int invslots = inventory.getSlots();
                if (r >= 0 && r < invslots) {
                    inventory.insertItem(r, ItemStack.read(nbt), false);
                }
            });
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        ListNBT list = new ListNBT();
        handler.ifPresent(inventory -> {
            int slots = inventory.getSlots();
            for (int x = 0; x < slots; ++x) {
                ItemStack stack = inventory.getStackInSlot(x);
                if (!stack.isEmpty()) {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putByte("Slot", (byte) x);
                    stack.write(nbt);
                    list.add(nbt);
                }
            }
        });
        if (!list.isEmpty()) {
            compound.put("Items", list);
        }
        return compound;
    }
}
