package laz.tirphycraft.content.tileEntities.altar;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.tileEntities.InventoryTile;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.Heightmap.Type;

public class AltarTE extends InventoryTile implements ITickableTileEntity {
	boolean activate = false;
	int timer = 20 * 10;
	Random rand = new Random();

	public AltarTE() {
		super(TirphycraftBlocks.ALTAR.getTileEntityType(), 5);
	}

	@Override
	public void tick() {
		if (!activate)
			checkForFragment();
		else {
			if (timer > 0) {
				if (timer % 20 == 0) {
					for (int i = 0; i < 3; i++) {
						BlockPos p = pos.add(rand.nextInt(11) - 5, -1, rand.nextInt(11) - 5);
						if (p.getX() != pos.getX() && p.getZ() != pos.getZ())
							spawnBlock(p);
					}
				}

				if (rand.nextInt(20) == 0)
					spawnLightning(pos.add(rand.nextInt(11) - 5, -1, rand.nextInt(11) - 5));

				timer--;
			} else {
				world.setBlockState(pos.down(), Blocks.STONE_BRICKS.getDefaultState());
				world.destroyBlock(pos, false);
			}
		}
	}

	public void checkForFragment() {
		if (this.getItemInSlot(0).getItem() != Items.AIR && this.getItemInSlot(1).getItem() != Items.AIR
				&& this.getItemInSlot(2).getItem() != Items.AIR && this.getItemInSlot(3).getItem() != Items.AIR
				&& this.getItemInSlot(4).getItem() != Items.AIR) {
			activate = true;
			spawnLightning(pos);

		}
	}

	public void spawnLightning(BlockPos pos) {
		LightningBoltEntity m = new LightningBoltEntity(world, pos.getX() + 0.5f,
				world.getHeight(Type.WORLD_SURFACE, pos.getX(), pos.getZ()) - 1, pos.getZ() + 0.5f, false);

		world.addEntity(m);
		if (world.isRemote()) {
			ClientWorld c = (ClientWorld) world;
			c.addLightning(m);
		}
	}

	public boolean spawnBlock(BlockPos p) {
		if (world.isRemote)
			return false;
		BlockPos pos = new BlockPos(p.getX(), world.getHeight(Type.WORLD_SURFACE, p.getX(), p.getZ()) - 1, p.getZ());
		BlockState block = world.getBlockState(pos);
		if (block == Blocks.AIR.getDefaultState())
			return false;
		world.removeBlock(pos, false);
		FallingBlockEntity e = new FallingBlockEntity(world, pos.getX() + 0.5f, pos.getY(), pos.getZ() + 0.5f, block);
		e.fallTime = -10 * 20;
		e.setOrigin(e.getPosition());
		e.setNoGravity(true);
		e.setVelocity(0, Math.min(Math.max(rand.nextFloat(), 0.04f), 0.5), 0);
		world.addEntity(e);

		return true;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putBoolean("activate", this.activate);
		return super.write(compound);
	}
	
	@Override
	public void read(CompoundNBT compound) {
		this.activate = compound.getBoolean("activate");
		super.read(compound);
	}
	
}
