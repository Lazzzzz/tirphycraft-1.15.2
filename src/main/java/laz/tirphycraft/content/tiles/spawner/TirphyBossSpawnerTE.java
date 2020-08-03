package laz.tirphycraft.content.tiles.spawner;

import java.util.List;

import javax.annotation.Nullable;

import laz.tirphycraft.content.entities.froz.EntityNecromancer;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.gen.Heightmap.Type;

public class TirphyBossSpawnerTE extends TileEntity implements ITickableTileEntity {
	// boss room corner
	public BlockPos c1;
	public BlockPos c2;

	public boolean done = false;

	public TirphyBossSpawnerTE() {
		super(TirphycraftBlocks.BOSS_SPAWNER_0.getTileEntityType());
	}

	@Override
	public void tick() {
		if (!this.done) {
			if (c1 == null)
				c1 = new BlockPos(this.getPos().getX() - 12, this.getPos().getY(), this.getPos().getZ() - 12);
			if (c2 == null)
				c2 = new BlockPos(this.getPos().getX() + 11, this.getPos().getY() + 5, this.getPos().getZ() + 11);

			if (!world.isRemote && world.getDifficulty() != Difficulty.PEACEFUL) {
				AxisAlignedBB box = new AxisAlignedBB(c1.add(-1, -1, -1), c2.add(1, 0, 1));
				List<PlayerEntity> entity = world.getEntitiesWithinAABB(PlayerEntity.class, box);

				if (entity.size() > 0) {
					for (int i = c1.getX() + 1; i < c2.getX() - 1; i++) {
						for (int j = c1.getY(); j < c2.getY() + 2; j++) {
							for (int k = c1.getZ() + 1; k < c2.getZ() - 1; k++) {
								world.removeBlock(new BlockPos(i,j,k), false);
							}
						}
					}

					EntityNecromancer n = new EntityNecromancer(TirphycraftEntities.ENTITY_NECROMANCER, world);
					n.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
					n.c1 = new BlockPos(n.getPosition().getX() - 11, n.getPosition().getY(),
							n.getPosition().getZ() - 11);
					n.c2 = new BlockPos(n.getPosition().getX() + 10, n.getPosition().getY() + 5,
							n.getPosition().getZ() + 10);
					n.spawn = n.getPosition();
					world.addEntity(n);
				}
			}
		} else {
			if (!world.isRemote) {
				AxisAlignedBB box = new AxisAlignedBB(pos.add(1, 0, 1), pos.add(-1, 1, -1));
				List<PlayerEntity> entity = world.getEntitiesWithinAABB(PlayerEntity.class, box);
				BlockPos top = world.getHeight(Type.WORLD_SURFACE, getPos());
				for (int i = 0; i < entity.size(); i++) {
					entity.get(i).setPositionAndUpdate(top.getX(), top.getY(), top.getZ());
				}

			} else {
				for (float i = -2f; i < 2; i += 0.1f) {
					for (float j = -2f; j < 2; j += 0.1f) {
						if (i * i + j * j <= 1.5f * 1.5f && i * i + j * j >= 1.4f * 1.4f
								&& world.rand.nextInt(3) == 0) {
							world.addParticle(ParticleTypes.FLAME, pos.getX() + i + 0.5, pos.getY(),
									pos.getZ() + j + 0.5, 0, 0.3, 0);
						}

					}

				}

			}
		}
	}

	@Override
	public void read(CompoundNBT compound) {
		this.done = compound.getBoolean("done");
		super.read(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putBoolean("done", this.done);
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

	public void isDone(boolean done) {
		this.done = done;
	}

}
