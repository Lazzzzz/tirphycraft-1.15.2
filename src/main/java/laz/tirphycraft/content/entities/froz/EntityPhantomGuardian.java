package laz.tirphycraft.content.entities.froz;

import laz.tirphycraft.content.entities.goal.phantomguardian.DashGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityPhantomGuardian extends MonsterEntity {

	private static final DataParameter<BlockPos> TOWER = EntityDataManager.createKey(EntityPhantomGuardian.class,
			DataSerializers.BLOCK_POS);
	private static final DataParameter<Float> ANGLE = EntityDataManager.createKey(EntityPhantomGuardian.class,
			DataSerializers.FLOAT);
	private static final DataParameter<Float> ATTACK_ANGLE = EntityDataManager.createKey(EntityPhantomGuardian.class,
			DataSerializers.FLOAT);
	private static final DataParameter<Boolean> HOVERING = EntityDataManager.createKey(EntityPhantomGuardian.class,
			DataSerializers.BOOLEAN);

	private static final DataParameter<Boolean> DASHING = EntityDataManager.createKey(EntityPhantomGuardian.class,
			DataSerializers.BOOLEAN);

	public int radius = 15;

	public EntityPhantomGuardian(EntityType<? extends EntityPhantomGuardian> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerGoals() {
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.addGoal(0, new DashGoal(this));
		super.registerGoals();
	}

	protected void registerData() {
		super.registerData();
		dataManager.register(TOWER, null);
		dataManager.register(ANGLE, 0f);
		dataManager.register(ATTACK_ANGLE, 0f);
		dataManager.register(HOVERING, true);
		dataManager.register(DASHING, false);
	}

	public BlockPos getTowerPos() {
		return dataManager.get(TOWER);
	}

	public void setTowerPos(BlockPos pos) {
		dataManager.set(TOWER, pos);
	}

	public float getAngle() {
		return dataManager.get(ANGLE);
	}

	public void setAngle(float angle) {
		dataManager.set(ANGLE, angle);
	}

	public float getAttackAngle() {
		return dataManager.get(ATTACK_ANGLE);
	}

	public void setAttackAngle(float angle) {
		dataManager.set(ATTACK_ANGLE, angle);
	}
	
	public boolean isHovering() {
		return dataManager.get(HOVERING);
	}

	public void setHovering(boolean b) {
		dataManager.set(HOVERING, b);
	}

	private void addAngle() {
		dataManager.set(ANGLE, getAngle() + 0.04f);
	}

	public void setDashing(boolean b) {
		dataManager.set(DASHING, b);
	}

	public boolean getDashing() {
		return dataManager.get(DASHING);
	}

	@Override
	public void livingTick() {
		if (!world.isRemote) {
			setMotion(getMotion().x, 0, getMotion().z);
			if (getTowerPos() == null) remove();
			else if (isHovering()) hover();
		}
		super.livingTick();
	}

	private void hover() {
		addAngle();
		double posX = getTowerPos().getX() + radius * Math.cos(getAngle());
		double posZ = getTowerPos().getZ() + radius * Math.sin(getAngle());

		setMotion(getMotion().x, 0, getMotion().z);

		setPosition(posX, getPosY(), posZ);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		compound.putFloat("angle", getAngle());

		compound.putInt("tx", getTowerPos().getX());
		compound.putInt("ty", getTowerPos().getY());
		compound.putInt("tz", getTowerPos().getZ());

		super.writeAdditional(compound);
	}

	@Override
	public void read(CompoundNBT compound) {
		setAngle(compound.getFloat("angle"));

		int x = compound.getInt("tx");
		int y = compound.getInt("ty");
		int z = compound.getInt("tz");

		setTowerPos(new BlockPos(x, y, z));

		super.read(compound);
	}

}
