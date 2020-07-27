package laz.tirphycraft.content.entities.froz;

import laz.tirphycraft.content.entities.goal.phantomguardian.AttackGoal;
import laz.tirphycraft.content.entities.goal.phantomguardian.OrbitGoal;
import laz.tirphycraft.content.entities.goal.phantomguardian.PickGoal;
import laz.tirphycraft.content.entities.goal.phantomguardian.SweepGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.controller.BodyController;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityPhantomGuardian extends FlyingEntity implements IMob {

	public Vec3d orbitOffset = Vec3d.ZERO;
	public BlockPos orbitPosition = BlockPos.ZERO;
	public EntityPhantomGuardian.AttackPhase attackPhase = EntityPhantomGuardian.AttackPhase.CIRCLE;

	public EntityPhantomGuardian(EntityType<? extends EntityPhantomGuardian> type, World worldIn) {
		super(type, worldIn);

		this.moveController = new EntityPhantomGuardian.MoveHelperController(this);
		this.lookController = new EntityPhantomGuardian.LookHelperController(this);
	}

	protected BodyController createBodyController() {
		return new EntityPhantomGuardian.BodyHelperController(this);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new PickGoal(this));
		this.goalSelector.addGoal(2, new SweepGoal(this));
		this.goalSelector.addGoal(3, new OrbitGoal(this));
		this.goalSelector.addGoal(3, new AttackGoal(this));

	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}
	
	@Override
	public void livingTick() {
		super.livingTick();
	}

	static enum AttackPhase {
		CIRCLE, SWOOP;
	}

	public AttackPhase getAttackPhase(int i) {
		if (i == 0)
			return AttackPhase.CIRCLE;
		else
			return AttackPhase.SWOOP;
	}

	class LookHelperController extends LookController {
		public LookHelperController(MobEntity entityIn) {
			super(entityIn);
		}

		public void tick() {
		}
	}

	class BodyHelperController extends BodyController {
		public BodyHelperController(MobEntity mob) {
			super(mob);
		}

		public void updateRenderAngles() {
			EntityPhantomGuardian.this.rotationYawHead = EntityPhantomGuardian.this.renderYawOffset;
			EntityPhantomGuardian.this.renderYawOffset = EntityPhantomGuardian.this.rotationYaw;
		}
	}

	class MoveHelperController extends MovementController {
		private float speedFactor = 0.1F;

		public MoveHelperController(MobEntity entityIn) {
			super(entityIn);
		}

		public void tick() {
			if (EntityPhantomGuardian.this.collidedHorizontally) {
				EntityPhantomGuardian.this.rotationYaw += 180.0F;
				this.speedFactor = 0.1F;
			}
			
			float f = (float) (EntityPhantomGuardian.this.orbitOffset.x - EntityPhantomGuardian.this.getPosX());
			float f1 = (float) (EntityPhantomGuardian.this.orbitOffset.y - EntityPhantomGuardian.this.getPosY());
			float f2 = (float) (EntityPhantomGuardian.this.orbitOffset.z - EntityPhantomGuardian.this.getPosZ());
			double d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d1 = 1.0D - (double) MathHelper.abs(f1 * 0.7F) / d0;
			f = (float) ((double) f * d1);
			f2 = (float) ((double) f2 * d1);
			d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d2 = (double) MathHelper.sqrt(f * f + f2 * f2 + f1 * f1);
			float f3 = EntityPhantomGuardian.this.rotationYaw;
			float f4 = (float) MathHelper.atan2((double) f2, (double) f);
			float f5 = MathHelper.wrapDegrees(EntityPhantomGuardian.this.rotationYaw + 90.0F);
			float f6 = MathHelper.wrapDegrees(f4 * (180F / (float) Math.PI));
			EntityPhantomGuardian.this.rotationYaw = MathHelper.approachDegrees(f5, f6, 4.0F) - 90.0F;
			EntityPhantomGuardian.this.renderYawOffset = EntityPhantomGuardian.this.rotationYaw;
			if (MathHelper.degreesDifferenceAbs(f3, EntityPhantomGuardian.this.rotationYaw) < 3.0F) {
				this.speedFactor = MathHelper.approach(this.speedFactor, 1.8F, 0.005F * (1.8F / this.speedFactor));
			} else {
				this.speedFactor = MathHelper.approach(this.speedFactor, 0.2F, 0.025F);
			}

			float f7 = (float) (-(MathHelper.atan2((double) (-f1), d0) * (double) (180F / (float) Math.PI)));
			EntityPhantomGuardian.this.rotationPitch = f7;
			float f8 = EntityPhantomGuardian.this.rotationYaw + 90.0F;
			double d3 = (double) (this.speedFactor * MathHelper.cos(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f / d2);
			double d4 = (double) (this.speedFactor * MathHelper.sin(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f2 / d2);
			double d5 = (double) (this.speedFactor * MathHelper.sin(f7 * ((float) Math.PI / 180F)))
					* Math.abs((double) f1 / d2);
			Vec3d vec3d = EntityPhantomGuardian.this.getMotion();
			EntityPhantomGuardian.this.setMotion(vec3d.add((new Vec3d(d3, d5, d4)).subtract(vec3d).scale(0.2D)));
			
		}
	}

}
