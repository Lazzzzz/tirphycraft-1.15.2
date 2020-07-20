package laz.tirphycraft.content.entities.laputa;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class EntitySpiritHeart extends MonsterEntity {

	private EntityTreeSpirit spirit = null;
	private int life;

	public EntitySpiritHeart(EntityType<? extends EntitySpiritHeart> type, World worldIn) {
		super(type, worldIn);
		life = Math.max(rand.nextInt(15) * 20, 5);
	}

	public EntitySpiritHeart(EntityType<? extends EntitySpiritHeart> type, World worldIn, EntityTreeSpirit spirit) {
		super(type, worldIn);
		this.spirit = spirit;
		life = Math.max(rand.nextInt(15) * 20, 5);
	}

	@Override
	public void livingTick() {
		if (!world.isRemote) {
			if (life == 0 || this.spirit == null || world.getBlockState(getPosition().down()) == Blocks.AIR.getDefaultState())
				this.remove();
			life--;
			this.setMotion(0, 0, 0);
		}
		super.livingTick();
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		this.remove();
		if (!world.isRemote)
			spirit.damageIt();
		else {
			for (int i = 0; i < 60; i++) {
				world.addParticle(ParticleTypes.END_ROD, this.getPosX(), this.getPosY(),
						this.getPosZ(), rand.nextFloat() - 0.5f, rand.nextFloat() - 0.5f,
						rand.nextFloat() - 0.5f);
			}
		}
		return false;
	}
}
