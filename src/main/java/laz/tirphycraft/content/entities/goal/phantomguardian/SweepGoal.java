package laz.tirphycraft.content.entities.goal.phantomguardian;

import java.util.List;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SweepGoal extends MoveGoal {

	public SweepGoal(EntityPhantomGuardian e) {
		super(e);
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state
	 * necessary for execution in this method as well.
	 */
	public boolean shouldExecute() {
		return entity.getAttackTarget() != null && entity.attackPhase == entity.getAttackPhase(1);
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean shouldContinueExecuting() {
		LivingEntity livingentity = entity.getAttackTarget();
		if (livingentity == null) {
			return false;
		} else if (!livingentity.isAlive()) {
			return false;
		} else if (!(livingentity instanceof PlayerEntity)
				|| !((PlayerEntity) livingentity).isSpectator() && !((PlayerEntity) livingentity).isCreative()) {
			if (!this.shouldExecute()) {
				return false;
			} else {
				if (entity.ticksExisted % 20 == 0) {
					List<CatEntity> list = entity.world.getEntitiesWithinAABB(CatEntity.class,
							entity.getBoundingBox().grow(16.0D), EntityPredicates.IS_ALIVE);
					if (!list.isEmpty()) {
						for (CatEntity catentity : list) {
							catentity.func_213420_ej();
						}

						return false;
					}
				}

				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
	public void resetTask() {
		entity.setAttackTarget((LivingEntity) null);
		entity.attackPhase = entity.getAttackPhase(0);
	}

	public void tick() {
		if (entity.getAttackTarget() != null) {
			LivingEntity livingentity = entity.getAttackTarget();
			entity.orbitOffset = new Vec3d(livingentity.getPosX(), livingentity.getPosYHeight(0.5D),
					livingentity.getPosZ());
			if (entity.getBoundingBox().grow((double) 0.2F).intersects(livingentity.getBoundingBox())) {
				livingentity.attackEntityFrom(new DamageSource("Phantom Guardian"), 20);
				entity.attackPhase = entity.getAttackPhase(0);
				entity.world.playEvent(1039, new BlockPos(entity), 0);
			} else if (entity.collidedHorizontally || entity.hurtTime > 0) {
				entity.attackPhase = entity.getAttackPhase(0);
			}
		}
	}
}
