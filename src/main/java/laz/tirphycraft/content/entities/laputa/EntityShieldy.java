package laz.tirphycraft.content.entities.laputa;

import laz.tirphycraft.content.entities.goal.shieldy.AttackShieldyGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityShieldy extends MonsterEntity {

	private static final DataParameter<Integer> SHIELD = EntityDataManager.createKey(EntityTreeSpirit.class,
			DataSerializers.VARINT);

	public EntityShieldy(EntityType<? extends EntityShieldy> type, World worldIn) {
		super(type, worldIn);
		this.setShield(4);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.199F);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double) 1F);
	}

	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.addGoal(5, new AttackShieldyGoal(this));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 20, 0.8D, 1.0D));
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(SHIELD, 4);
	}

	public int getShield() {
		return this.dataManager.get(SHIELD);
	}

	public void setShield(int shields) {
		this.dataManager.set(SHIELD, shields);
	}

	@Override
	public void read(CompoundNBT compound) {
		setShield(compound.getInt("shields"));
		super.read(compound);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		compound.putInt("shields", getShield());
		super.writeAdditional(compound);
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		if (this.getShield() <= 0)
			return false;
		else {
			if (!world.isRemote)
				this.setShield(this.getShield() - 1);
			return true;
		}
	}

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		if (spawnReasonIn == SpawnReason.NATURAL) {
			AxisAlignedBB box = new AxisAlignedBB(getPosition().add(-30, -30, -30), getPosition().add(30, 30, 30));
			if (worldIn.getEntitiesWithinAABB(EntityShieldy.class, box).size() > 0)
				return false;
		}
		return worldIn.getBlockState(this.getPosition().down()).isSolid();
	}
}
