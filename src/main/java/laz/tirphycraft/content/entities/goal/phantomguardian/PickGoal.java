package laz.tirphycraft.content.entities.goal.phantomguardian;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.Heightmap;

public class PickGoal extends Goal{
	private int tickDelay;
	private EntityPhantomGuardian attacker;

	public PickGoal(EntityPhantomGuardian e) {
		attacker = e;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state
	 * necessary for execution in this method as well.
	 */
	public boolean shouldExecute() {
		LivingEntity livingentity = attacker.getAttackTarget();
		return livingentity != null ? attacker.canAttack(attacker.getAttackTarget(), EntityPredicate.DEFAULT) : false;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		this.tickDelay = 10;
		attacker.attackPhase = attacker.getAttackPhase(0);
		this.func_203143_f();
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
	public void resetTask() {
		attacker.orbitPosition = attacker.world.getHeight(Heightmap.Type.MOTION_BLOCKING, attacker.orbitPosition)
				.up(10 + attacker.world.rand.nextInt(20));
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	public void tick() {
		if (attacker.attackPhase == attacker.getAttackPhase(0)) {
			--this.tickDelay;
			if (this.tickDelay <= 0) {
				attacker.attackPhase = attacker.getAttackPhase(1);
				this.func_203143_f();
				this.tickDelay = (8 + attacker.world.rand.nextInt(4)) * 20;
				attacker.playSound(SoundEvents.ENTITY_PHANTOM_SWOOP, 10.0F,
						0.95F + attacker.world.rand.nextFloat() * 0.1F);
			}
		}

	}

	private void func_203143_f() {
		attacker.orbitPosition = (new BlockPos(attacker.getAttackTarget())).up(20 + attacker.world.rand.nextInt(20));
		if (attacker.orbitPosition.getY() < attacker.world.getSeaLevel()) {
			attacker.orbitPosition = new BlockPos(attacker.orbitPosition.getX(), attacker.world.getSeaLevel() + 1,
					attacker.orbitPosition.getZ());
		}

	}

}
