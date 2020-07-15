package laz.tirphycraft.content.entities.laputa;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class EntityTreeSpirit extends MonsterEntity{

	private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN,
			BossInfo.Overlay.PROGRESS);
	private static final DataParameter<Integer> SHIELD = EntityDataManager.createKey(EntityTreeSpirit.class,
			DataSerializers.VARINT);


	public EntityTreeSpirit(EntityType<? extends EntityTreeSpirit> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.0F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(SHIELD, 12);
	}
	
	public int getShield() {
		return this.dataManager.get(SHIELD);
	}
	
	public void hitShield() {
		if (getShield() > 0) this.dataManager.set(SHIELD, getShield() - 1);
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
	public void livingTick() {
		this.setMotion(0, getMotion().y ,0);
		super.livingTick();
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

		if (this.getShield() > 0) {
			hitShield();
			return true;
		}
		return super.hitByEntity(entityIn);
	}

}
