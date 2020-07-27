package laz.tirphycraft.content.entities.goal.phantomguardian;

//import java.util.Random;
//
//import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
//import laz.tirphycraft.util.TirphycraftUtils;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.ai.goal.Goal;
//import net.minecraft.util.DamageSource;
//import net.minecraft.util.math.BlockPos;
//
//public class DashGoal extends Goal {
//
//	private EntityPhantomGuardian attacker;
//	private float lastAngle = 0f;
//	private double lastPosY = 0;
//	private Random rand;
//	private boolean isDashing = false;
//	private float velocity = 0.5f;
//	private double dist = 0f;
//	private boolean done = true;
//	private float health = 0f;
//
//	public DashGoal(EntityPhantomGuardian entity) {
//		attacker = entity;
//		rand = entity.world.rand;
//	}
//
//	@Override
//	public boolean shouldExecute() {
//		if (attacker.getAttackTarget() != null && rand.nextInt(20) == 0) {
//			lastAngle = attacker.getAngle();
//			lastPosY = attacker.getPosY();
//			isDashing = true;
//			dist = 0f;
//			attacker.setHovering(false);
//			attacker.setDashing(true);
//			done = true;
//			health = attacker.getHealth();
//
//			return true;
//		}
//		return false;
//
//	}
//
//	@Override
//	public void tick() {
//
//		double delta_x;
//		double delta_y;
//		double delta_z;
//
//		BlockPos targetPos;
//
//		LivingEntity target = attacker.getAttackTarget();
//
//		if (attacker.getHealth() != health && isDashing)
//			isDashing = false;
//
//		if (isDashing)
//			targetPos = target.getPosition();
//		else {
//			double x = attacker.getTowerPos().getX() + attacker.radius * Math.cos(lastAngle);
//			double z = attacker.getTowerPos().getZ() + attacker.radius * Math.sin(lastAngle);
//			targetPos = new BlockPos(x, lastPosY, z);
//		}
//
//		delta_x = targetPos.getX() - attacker.getPosX();
//		delta_y = targetPos.getY() - attacker.getPosY();
//		delta_z = targetPos.getZ() - attacker.getPosZ();
//
//		dist = TirphycraftUtils.hypot(delta_x, delta_y, delta_z);
//
//		delta_x = (delta_x / dist) * velocity;
//		delta_y = (delta_y / dist) * velocity;
//		delta_z = (delta_z / dist) * velocity;
//
//		if (!isDashing && dist < 1) {
//			attacker.setHovering(true);
//			done = false;
//		}
//
//		if (isDashing && dist < 2) {
//			target.attackEntityFrom(new DamageSource("Phantom guardian"), 6);
//			target.knockBack(target, 2f, -attacker.getMotion().x, -attacker.getMotion().z);
//			isDashing = false;
//		}
//
//		super.tick();
//	}
//
//	@Override
//	public boolean shouldContinueExecuting() {
//		if (!attacker.getDashing() || attacker.getAttackTarget() == null)
//			return false;
//		return done;
//	}
//}
