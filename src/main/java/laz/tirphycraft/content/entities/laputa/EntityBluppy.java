package laz.tirphycraft.content.entities.laputa;

import laz.tirphycraft.content.entities.goal.bluppy.JumpGoal;
import laz.tirphycraft.content.entities.goal.bluppy.SplitGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBluppy extends MonsterEntity {

	private static final DataParameter<Float> SIZE = EntityDataManager.createKey(EntityBluppy.class,
			DataSerializers.FLOAT);
	
	private static final DataParameter<Boolean> HOVERING = EntityDataManager.createKey(EntityBluppy.class,
			DataSerializers.BOOLEAN);

	public EntityBluppy(EntityType<? extends EntityBluppy> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.0f);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double) 1F);
	}
	
	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(7, new JumpGoal(this, 10));
		this.goalSelector.addGoal(6, new SplitGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}

	@Override
	protected void registerData() {
		super.registerData();
		dataManager.register(SIZE, 1f);
		dataManager.register(HOVERING, false);
	}

	public void setSize(float s) {
		dataManager.set(SIZE, s);
	}

	public float getSize() {
		return dataManager.get(SIZE);
	}
	
	public void setHovering(boolean h) {
		dataManager.set(HOVERING, h);
	}
	
	public Boolean getHovering() {
		return dataManager.get(HOVERING);
	}

	@Override
	public void livingTick() {
		if (!world.isRemote) {
			this.fallDistance = 0;
			if (!onGround && getMotion().y < 0) {
				setHovering(true);
				this.setMotion(getMotion().x, -0.05f, getMotion().z);
			} else setHovering(false);
		}
		super.livingTick();
	}
	
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		if (spawnReasonIn == SpawnReason.NATURAL) {
			if (!worldIn.canSeeSky(this.getPosition())) return false;
			
			AxisAlignedBB box = new AxisAlignedBB(getPosition().add(-20, -20, -20), getPosition().add(20, 20, 20));
			if (worldIn.getEntitiesWithinAABB(EntityBluppy.class, box).size() > 0)
				return false;
		}
		return worldIn.getBlockState(this.getPosition().down()).isSolid();
	}
}
