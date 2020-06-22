package laz.tirphycraft.content.tiles.altar;

import static laz.tirphycraft.Tirphycraft.MOD_ID;
<<<<<<< HEAD
import static laz.tirphycraft.registry.init.TirphycraftDimensions.NOXIS_DIM;
=======
import static laz.tirphycraft.content.TirphycraftDimensions.FROZ_DIM;
>>>>>>> parent of 2669fca... structure

import java.util.List;
import java.util.Random;

<<<<<<< HEAD
=======
import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.tiles.InventoryTile;
>>>>>>> parent of 2669fca... structure
import laz.tirphycraft.particle.GlintData;
import laz.tirphycraft.util.TirphyColor;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class AltarTE extends InventoryTile implements ITickableTileEntity {
	boolean activate = false;
	int maxtimer = 300;
	int timer = maxtimer;
	Random rand = new Random();

	BlockPos blue_p;
	BlockPos red_p;
	BlockPos yellow_p;
	BlockPos green_p;
	BlockPos white_p;

	public AltarTE() {
		super(TirphycraftBlocks.ALTAR.getTileEntityType(), 5);
	}

	@Override
	public void tick() {
		checkForFragment();
		if (activate) {
			if (timer > 0) {
				if (timer % 20 == 0) {
					for (int i = 0; i < 3; i++) {
						BlockPos p = pos.add(rand.nextInt(11) - 5, -1, rand.nextInt(11) - 5);
						if (p.getX() != pos.getX() && p.getZ() != pos.getZ()) {
						}
						spawnBlock(p);
					}
				}
				if (timer % 13 == 0)
					spawnLightning(pos.add(rand.nextInt(11) - 5, -1, rand.nextInt(11) - 5));

				if (timer % 8 == 0)
					particles();
				timer--;
			} else {
				timer = maxtimer;
				activate = false;
				world.destroyBlock(blue_p, false);
				world.destroyBlock(red_p, false);
				world.destroyBlock(green_p, false);
				world.destroyBlock(white_p, false);
				world.destroyBlock(yellow_p, false);
				if (!world.isRemote()) {
					List<PlayerEntity> l = world.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(pos.getX() - 10, pos.getY() - 10, pos.getZ() - 10, pos.getX() + 10,
									pos.getY() + 10, pos.getZ() + 10));
					for (int i = 0; i < l.size(); i++) {
						PlayerEntity player = l.get(i);
						if (player != null) {
							ServerPlayerEntity playerEntity = (ServerPlayerEntity) player;
							DimensionType dimensionType = DimensionManager.registerOrGetDimension(
									new ResourceLocation(MOD_ID, "noxis_dim"), NOXIS_DIM.get(), null, true);
							ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
							playerEntity.teleport(targetWorld, 0, 255, 0, player.rotationYaw,
									player.rotationPitch);
							BlockPos p = player.world.getHeight(Type.WORLD_SURFACE, player.getPosition());
							player.setPositionAndUpdate(p.getX(), p.getY(), p.getZ());
						}
					}
				}
			}
		}
	}

	public void checkForFragment() {
		boolean blue = false;
		boolean red = false;
		boolean white = false;
		boolean yellow = false;
		boolean green = false;

		for (int i = -4; i <= 4; i++) {
			for (int j = -4; j <= 4; j++) {
				for (int k = -4; k <= 4; k++) {
					if (world.getBlockState(pos.add(i, j, k)) == TirphycraftBlocks.ANCIENT_BLUE.get()
							.getDefaultState()) {
						blue = true;
						blue_p = pos.add(i, j, k);
					}
					if (world.getBlockState(pos.add(i, j, k)) == TirphycraftBlocks.ANCIENT_RED.get()
							.getDefaultState()) {
						red = true;
						red_p = pos.add(i, j, k);
					}
					if (world.getBlockState(pos.add(i, j, k)) == TirphycraftBlocks.ANCIENT_GREEN.get()
							.getDefaultState()) {
						white = true;
						white_p = pos.add(i, j, k);
					}
					if (world.getBlockState(pos.add(i, j, k)) == TirphycraftBlocks.ANCIENT_YELLOW.get()
							.getDefaultState()) {
						yellow = true;
						yellow_p = pos.add(i, j, k);
					}
					if (world.getBlockState(pos.add(i, j, k)) == TirphycraftBlocks.ANCIENT_WHITE.get()
							.getDefaultState()) {
						green = true;
						green_p = pos.add(i, j, k);
					}
				}
			}
		}
		if (blue && red && white && yellow && green) {
			activate = true;
		} else {
			timer = maxtimer;
			activate = false;
		}
		if (!(world.getDimension() instanceof OverworldDimension))
			activate = false;
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
		if (!block.isSolid())
			return false;
		if (block == Blocks.AIR.getDefaultState() || block == TirphycraftBlocks.ANCIENT_BLUE.get().getDefaultState()
				|| block == TirphycraftBlocks.ANCIENT_RED.get().getDefaultState()
				|| block == TirphycraftBlocks.ANCIENT_GREEN.get().getDefaultState()
				|| block == TirphycraftBlocks.ANCIENT_YELLOW.get().getDefaultState()
				|| block == TirphycraftBlocks.ANCIENT_WHITE.get().getDefaultState()
				|| block == TirphycraftBlocks.ALTAR.get().getDefaultState())
			return false;

		world.removeBlock(pos, false);
		FallingBlockEntity e = new FallingBlockEntity(world, pos.getX() + 0.5f, pos.getY(), pos.getZ() + 0.5f, block);
		e.fallTime = -(timer / 2);
		e.setOrigin(e.getPosition());
		e.setNoGravity(true);
		e.setVelocity(0, Math.min(Math.max(rand.nextFloat(), 0.04f), 0.5), 0);
		world.addEntity(e);

		return true;
	}

	void particles() {
		if (world.isRemote) {
			world.addParticle(GlintData.glintParticle(TirphyColor.BLUE, 60), blue_p.getX() + 0.5, blue_p.getY() + 0.875,
					blue_p.getZ() + 0.5, 0, 0.2, 0);
			world.addParticle(GlintData.glintParticle(TirphyColor.RED, 60), red_p.getX() + 0.5, red_p.getY() + 0.875,
					red_p.getZ() + 0.5, 0, 0.2, 0);
			world.addParticle(GlintData.glintParticle(TirphyColor.WHITE, 60), green_p.getX() + 0.5,
					green_p.getY() + 0.875, green_p.getZ() + 0.5, 0, 0.2, 0);
			world.addParticle(GlintData.glintParticle(TirphyColor.YELLOW, 60), yellow_p.getX() + 0.5,
					yellow_p.getY() + 0.875, yellow_p.getZ() + 0.5, 0, 0.2, 0);
			world.addParticle(GlintData.glintParticle(TirphyColor.GREEN, 60), white_p.getX() + 0.5,
					white_p.getY() + 0.875, white_p.getZ() + 0.5, 0, 0.2, 0);
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("timer", this.timer);
		return super.write(compound);
	}

	@Override
	public void read(CompoundNBT compound) {
		this.timer = compound.getInt("timer");
		super.read(compound);
	}

}
