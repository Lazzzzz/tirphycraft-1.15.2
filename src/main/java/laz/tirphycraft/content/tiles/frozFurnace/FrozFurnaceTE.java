package laz.tirphycraft.content.tiles.frozFurnace;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class FrozFurnaceTE extends TileEntity implements ITickableTileEntity {

	public FrozFurnaceTE() {
		super(TirphycraftBlocks.ALTAR.getTileEntityType());
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

}
