package laz.tirphycraft.content.tiles.laputaActivator;

import javax.annotation.Nullable;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class LaputaActivatorTE extends TileEntity implements ITickableTileEntity {

	private BlockPos center;
	private boolean isWave = true;

	public LaputaActivatorTE() {
		super(TirphycraftBlocks.LAPUTA_ACTIVATOR.getTileEntityType());
	}

	@Override
	public void tick() {
	}

	public void setCenter(BlockPos pos) {
		this.center = pos;
	}
	
	public BlockPos getCenter() {
		return this.center;
	}
	@Override
	public void read(CompoundNBT compound) {
		int x = compound.getInt("cx");
		int y = compound.getInt("cy");
		int z = compound.getInt("cz");

		center = new BlockPos(x,y,z);
		
		isWave = compound.getBoolean("wave");
		super.read(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("cx", center.getX());
		compound.putInt("cy", center.getY());
		compound.putInt("cz", center.getZ());

		compound.putBoolean("wave", isWave);

		return super.write(compound);
	}

	@Override
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbtTagCompound = new CompoundNBT();
		write(nbtTagCompound);
		int tileEntityType = 42;
		return new SUpdateTileEntityPacket(this.pos, tileEntityType, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		read(pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbtTagCompound = new CompoundNBT();
		write(nbtTagCompound);
		return nbtTagCompound;
	}

	@Override
	public void handleUpdateTag(CompoundNBT tag) {
		this.read(tag);
	}

}
