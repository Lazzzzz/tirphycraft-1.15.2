package laz.tirphycraft.content.entities.froz;

import laz.tirphycraft.util.TirphycraftUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityMissileBat extends BatEntity {

	private float velocity = 0.2f;

	public EntityMissileBat(EntityType<? extends EntityMissileBat> type, World worldIn) {
		super(type, worldIn);
	}

	public EntityMissileBat(EntityType<? extends EntityMissileBat> type, World worldIn, LivingEntity target) {
		super(type, worldIn);
		this.setAttackTarget(target);
	}

	@Override
	public void livingTick() {
		if (world.isRemote) {
			world.addParticle(ParticleTypes.SMOKE, this.getPosX() + 0.25, this.getPosY() + 0.25, this.getPosZ() + 0.25,
					0, 0, 0);
		}

		if (this.getAttackTarget() != null && !this.dead) {
			double delta_x = this.getAttackTarget().getPosX() - this.getPosX();
			double delta_y = this.getAttackTarget().getPosY() + (this.getAttackTarget().getHeight() / 2)
					- this.getPosY();
			double delta_z = this.getAttackTarget().getPosZ() - this.getPosZ();

			double dist = TirphycraftUtils.hypot(delta_x, delta_y, delta_z);
			if (dist > 0.3) {
				delta_x = (delta_x / dist) * velocity;
				delta_y = (delta_y / dist) * velocity;
				delta_z = (delta_z / dist) * velocity;
			} else {
				world.createExplosion(this, this.getPosX() + 0.25, this.getPosY() + 0.25, this.getPosZ() + 0.25, 0.75f,
						Explosion.Mode.NONE);
				this.remove();
			}
			this.setMotion(delta_x, delta_y, delta_z);
		}
		if (!world.isRemote) {
			if (this.getAttackTarget() == null) {
				this.remove();
			}
		}
		super.livingTick();
	}

	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

}
