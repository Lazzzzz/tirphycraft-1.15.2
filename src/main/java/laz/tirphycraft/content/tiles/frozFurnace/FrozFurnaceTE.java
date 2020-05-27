package laz.tirphycraft.content.tiles.frozFurnace;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class FrozFurnaceTE extends TileEntity implements ITickableTileEntity {

	public Inventory inventory = new Inventory(3);
	
	public FrozFurnaceTE() {
		super(TirphycraftBlocks.FROZ_FURNACE.getTileEntityType());
	}

	@Override
	public void tick() {}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		return super.write(compound);
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}

}
