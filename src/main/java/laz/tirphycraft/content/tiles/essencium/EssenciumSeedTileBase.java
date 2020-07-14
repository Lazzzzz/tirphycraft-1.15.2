package laz.tirphycraft.content.tiles.essencium;

import javax.annotation.Nullable;

import laz.tirphycraft.particle.GlintData;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.TirphyColor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class EssenciumSeedTileBase extends TileEntity implements ITickableTileEntity {

	private int cycle = 0;
	private int max_cycle = 0;
	private int tier = 1;

	public EssenciumSeedTileBase(int max_cyle, int tier, TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
		this.max_cycle = max_cyle;
		this.tier = tier;
	}

	@Override
	public void tick() {
		if (!world.isRemote) {
			if (world.getDayTime() % 24000 == 0 && cycle < max_cycle) {
				if (getExtractor())
					cycle++;
				else if (world.rand.nextInt(150) == 0)
					world.setBlockState(pos, TirphycraftBlocks.SACRED_DIRT.get().getDefaultState(), 3);
			}

			if (cycle == max_cycle) {
				if (getExtractor())
					world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
				else if (world.rand.nextInt(150) == 0)
					world.setBlockState(pos, TirphycraftBlocks.SACRED_DIRT.get().getDefaultState(), 3);
			}
		} else {
			if (cycle == max_cycle) {
				spawnParticles();
			}
		}

	}

	private void spawnParticles() {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		if (world.rand.nextInt(50) == 0) {
			double d0 = (double) ((float) i + world.rand.nextFloat());
			double d1 = (double) ((float) j + world.rand.nextFloat());
			double d2 = (double) ((float) k + world.rand.nextFloat());
			switch (tier) {
			case 1:
				world.addParticle(GlintData.glintParticle(TirphyColor.PURPLE, world.rand.nextInt(50) + 50),
						false, d0, d1, d2, 0.0D, 0.08D, 0.0D);
				break;
			case 2:
				world.addParticle(GlintData.glintParticle(TirphyColor.YELLOW, world.rand.nextInt(50) + 50),
						false, d0, d1, d2, 0.0D, 0.08D, 0.0D);
				break;
			case 3:
				world.addParticle(GlintData.glintParticle(TirphyColor.BLUE, world.rand.nextInt(50) + 50), false,
						d0, d1, d2, 0.0D, 0.08D, 0.0D);
			}
		}
		
	}

	public boolean getExtractor() {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				BlockPos p = pos.add(i, 1, j);
				switch (this.tier) {
				case 1:
					if (world.getBlockState(p) == TirphycraftBlocks.EXTRACTOR1.get().getDefaultState())
						return true;
				case 2:
					if (world.getBlockState(p) == TirphycraftBlocks.EXTRACTOR1.get().getDefaultState())
						return true;
				case 3:
					if (world.getBlockState(p) == TirphycraftBlocks.EXTRACTOR1.get().getDefaultState())
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public void read(CompoundNBT compound) {
		this.cycle = compound.getInt("cycle");
		this.max_cycle = compound.getInt("max_cycle");
		this.tier = compound.getInt("tier");
		super.read(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("cycle", this.cycle);
		compound.putInt("max_cycle", this.max_cycle);
		compound.putInt("tier", this.tier);
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
