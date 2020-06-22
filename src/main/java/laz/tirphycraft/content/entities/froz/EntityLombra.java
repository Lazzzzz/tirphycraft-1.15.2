package laz.tirphycraft.content.entities.froz;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityLombra extends MonsterEntity {

	private static final DataParameter<Boolean> ON_ROOF = EntityDataManager.createKey(EntityLombra.class,
			DataSerializers.BOOLEAN);
	
	
	public EntityLombra(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(18.0);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.2F);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double) 0.5F);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.9f, true));
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(ON_ROOF, true);
	}
	
	public boolean getRoof() {
		return this.dataManager.get(ON_ROOF);
	}

	public void setRoof(boolean flag) {
		this.dataManager.set(ON_ROOF, flag);
	}
	
	@Override
	public void livingTick() {
		if (getRoof() && !world.isRemote) {
			this.setMotion(0,0,0);
			if (this.getAttackTarget() != null) {
				double x = this.getAttackTarget().getPosX();
				double z = this.getAttackTarget().getPosZ();
				if (x > this.getPosX() - 1 && x < this.getPosX() + 1) {
					if (z > this.getPosZ() - 1 && z < this.getPosZ() + 1) {
						this.setRoof(false);
					}
				}
			}
		}
		this.fallDistance = 0;
		super.livingTick();
	}
	

	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		if (this.getPosY() >= 120) this.remove();
		for (double i = this.getPosY(); i < 120; i++) {
			if (i == 119) this.remove();
			BlockPos pos = new BlockPos(this.getPosX(), i, this.getPosZ());
			if (worldIn.getBlockState(pos).isSolid()) {
				this.setPositionAndUpdate(pos.getX(), pos.getY() - 1.4, pos.getZ());
				break;
			}
		}
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
}
