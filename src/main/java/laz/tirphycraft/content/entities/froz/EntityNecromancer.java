package laz.tirphycraft.content.entities.froz;

import java.util.List;
import java.util.Random;

import laz.tirphycraft.content.entities.goal.necromancer.MissileBatGoal;
import laz.tirphycraft.content.entities.goal.necromancer.SplashPotionGoal;
import laz.tirphycraft.content.entities.goal.necromancer.SummonGuardGoal;
import laz.tirphycraft.content.entities.goal.necromancer.SummonHeavyGuardGoal;
import laz.tirphycraft.content.entities.goal.necromancer.TeleportGoal;
import laz.tirphycraft.content.tiles.spawner.TirphyBossSpawnerTE;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class EntityNecromancer extends MonsterEntity {

	// boss room corner
	public BlockPos c1;
	public BlockPos c2;
	public BlockPos spawn;

	private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE,
			BossInfo.Overlay.PROGRESS);

	private static final DataParameter<Boolean> INVOC = EntityDataManager.createKey(EntityNecromancer.class,
			DataSerializers.BOOLEAN);

	private static final DataParameter<Boolean> BAT = EntityDataManager.createKey(EntityNecromancer.class,
			DataSerializers.BOOLEAN);

	private static final DataParameter<BlockPos> SPAWN = EntityDataManager.createKey(EntityNecromancer.class,
			DataSerializers.BLOCK_POS);

	public EntityNecromancer(EntityType<? extends EntityNecromancer> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new MissileBatGoal(this));
		this.goalSelector.addGoal(1, new SplashPotionGoal(this));
		this.goalSelector.addGoal(1, new SummonHeavyGuardGoal(this));
		this.goalSelector.addGoal(1, new SummonGuardGoal(this));
		this.goalSelector.addGoal(1, new TeleportGoal(this));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 24.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.23F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(INVOC, false);
		this.dataManager.register(BAT, false);
		this.dataManager.register(SPAWN, null);
	}

	public boolean getInvoc() {
		return this.dataManager.get(INVOC);
	}

	public void setInvoc(boolean moving) {
		this.dataManager.set(INVOC, moving);
	}

	public boolean getBat() {
		return this.dataManager.get(BAT);
	}

	public void setBat(boolean moving) {
		this.dataManager.set(BAT, moving);
	}

	public BlockPos getSpawn() {
		return this.dataManager.get(SPAWN);
	}

	public void setSpawn(BlockPos moving) {
		this.dataManager.set(SPAWN, moving);
	}

	@Override
	public void livingTick() {
		if (!world.isRemote) {
			if (getAttackTarget() != null)
				this.getLookController().setLookPosition(getAttackTarget().getPosX(), getAttackTarget().getPosYEye(),
						getAttackTarget().getPosZ());

			if (c1 != null && c2 != null && spawn != null) {
				AxisAlignedBB box = new AxisAlignedBB(c1.add(-1, -1, -1), c2.add(1, 0, 1));
				List<PlayerEntity> entity = world.getEntitiesWithinAABB(PlayerEntity.class, box);

				if (entity.size() == 0) {
					world.setBlockState(spawn, TirphycraftBlocks.BOSS_SPAWNER_0.get().getDefaultState(), 2);
					deathTime = 19;
					onDeathUpdate();
				}
			}
		} else {
			if (getInvoc())
				circleParticlesX(ParticleTypes.DRAGON_BREATH);
			else if (getBat())
				circleParticlesY(ParticleTypes.END_ROD);

			if (getSpawn() != null) {
				for (float i = -1.2f; i < 1.2; i += 0.1f) {
					for (float j = -1.2f; j < 1.2; j += 0.1f) {
						if (i * i + j * j <= 1.2f * 1.2f && i * i + j * j >= 1f * 1f && getRNG().nextInt(10) == 0) {
							world.addParticle(ParticleTypes.FLAME, getSpawn().getX() + i,
									getSpawn().getY() + getRNG().nextFloat() * 2, getSpawn().getZ() + j, 0,
									getRNG().nextFloat() / 3, 0);
						}
					}
				}
			}
		}
		super.livingTick();
	}

	@Override
	public void read(CompoundNBT compound) {
		int c1x = compound.getInt("c1x");
		int c1y = compound.getInt("c1y");
		int c1z = compound.getInt("c1z");

		int c2x = compound.getInt("c2x");
		int c2y = compound.getInt("c2y");
		int c2z = compound.getInt("c2z");

		int sx = compound.getInt("sx");
		int sy = compound.getInt("sy");
		int sz = compound.getInt("sz");

		c1 = new BlockPos(c1x, c1y, c1z);
		c2 = new BlockPos(c2x, c2y, c2z);
		spawn = new BlockPos(sx, sy, sz);

		super.read(compound);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		compound.putInt("c1x", c1.getX());
		compound.putInt("c1y", c1.getY());
		compound.putInt("c1z", c1.getZ());

		compound.putInt("c2x", c2.getX());
		compound.putInt("c2y", c2.getY());
		compound.putInt("c2z", c2.getZ());

		compound.putInt("sx", spawn.getX());
		compound.putInt("sy", spawn.getY());
		compound.putInt("sz", spawn.getZ());
		super.writeAdditional(compound);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getImmediateSource() instanceof AbstractArrowEntity) {
			return false;
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		if (entityIn instanceof AbstractArrowEntity) {
			return true;
		}

		if (!world.isRemote && c1 != null && c2 != null && spawn != null) {
			Random rand = this.getRNG();
			double x = this.c2.getX() - this.c1.getX() - 2;
			double z = this.c2.getZ() - this.c1.getZ() - 2;
			this.setPositionAndUpdate(this.c1.getX() + rand.nextInt((int) x) + 1, this.getPosY(),
					this.c1.getZ() + rand.nextInt((int) z) + 1);
		} else {
			for (int i = 0; i < 20; i++) {
				world.addParticle(ParticleTypes.CLOUD, this.getPosX() + rand.nextFloat() / 2,
						this.getPosY() + rand.nextFloat() * 2, this.getPosZ() + rand.nextFloat() / 2, 0, 0, 0);
			}
		}
		return super.hitByEntity(entityIn);
	}

	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}

	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		c1 = new BlockPos(getPosition().getX() - 11, getPosition().getY(), getPosition().getZ() - 11);
		c2 = new BlockPos(getPosition().getX() + 10, getPosition().getY() + 5, getPosition().getZ() + 10);
		spawn = getPosition();
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public void circleParticlesX(IParticleData particle) {
		for (float i = -1.2f; i < 1.2; i += 0.1f) {
			for (float j = -1.2f; j < 1.2; j += 0.1f) {
				if (i * i + j * j <= 1.2f * 1.2f && i * i + j * j >= 1f * 1f && getRNG().nextInt(10) == 0) {
					world.addParticle(particle, getPosX() + i, getPosY() + 2.3, getPosZ() + j, 0, 0, 0);
				}
			}
		}
	}

	public void circleParticlesY(IParticleData particle) {
		for (float i = -2f; i < 2; i += 0.1f) {
			for (float j = -2f; j < 2; j += 0.1f) {
				if (i * i + j * j <= 2f * 2f && i * i + j * j >= 1.8f * 1.8f && getRNG().nextInt(40) == 0) {
					world.addParticle(particle, getPosX() + i, getPosY() + 0.1, getPosZ() + j, 0, 0, 0);
				}

				if (i * i + j * j <= 1.2f * 1.2f && i * i + j * j >= 1f * 1f && getRNG().nextInt(40) == 0) {
					world.addParticle(particle, getPosX() + i, getPosY() + 0.3, getPosZ() + j, 0, 0, 0);
				}

				if (i * i + j * j <= 0.4f * 0.4f && i * i + j * j >= 0.2f * 0.2f && getRNG().nextInt(40) == 0) {
					world.addParticle(particle, getPosX() + i, getPosY() + 0.5, getPosZ() + j, 0, 0, 0);
				}
			}
		}
	}

	@Override
	public boolean isNonBoss() {
		return false;
	}

	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void updateAITasks() {
		super.updateAITasks();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public void onDeath(DamageSource cause) {
		if (c1 != null && c2 != null) {
			AxisAlignedBB box = new AxisAlignedBB(c1, c2);
			List<EntityFrozenSoldier> k = world.getEntitiesWithinAABB(EntityFrozenSoldier.class, box);
			for (int i = 0; i < k.size(); i++) {
				k.get(i).remove();
			}

			List<EntityMissileBat> kk = world.getEntitiesWithinAABB(EntityMissileBat.class, box);
			for (int i = 0; i < kk.size(); i++) {
				kk.get(i).remove();
			}

			world.setBlockState(spawn, TirphycraftBlocks.BOSS_SPAWNER_0.get().getDefaultState(), 2);
			TileEntity tile = world.getTileEntity(spawn);
			if (tile instanceof TirphyBossSpawnerTE)
				((TirphyBossSpawnerTE) tile).isDone(true);

			if (!world.isRemote) {
				world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(),
						new ItemStack(TirphycraftItems.DRAUGRIR_CHEST, 1)));
				world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(),
						new ItemStack(TirphycraftItems.DRAUGRIR_FEET, 1)));
				world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(),
						new ItemStack(TirphycraftItems.DRAUGRIR_HEAD, 1)));
				world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(),
						new ItemStack(TirphycraftItems.DRAUGRIR_LEGS, 1)));
				world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(),
						new ItemStack(TirphycraftItems.LIFE_CORE.get(), world.rand.nextInt(2) + 1)));
			}

			this.world.addEntity(
					new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), 1000));
		}
		super.onDeath(cause);
	}

}
