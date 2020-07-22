package laz.tirphycraft.content.entities.projectile;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class EntityBluppySplit extends MonsterEntity {

	public EntityBluppySplit(EntityType<? extends EntityBluppySplit> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public void livingTick() {
		fallDistance = 0;
		if (!world.isRemote) {
			if (onGround) {
				AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(),
						this.getPosY(), this.getPosZ());
				areaeffectcloudentity.setOwner(this);
				areaeffectcloudentity.setRadius(2.5F);
				areaeffectcloudentity.setRadiusOnUse(-0.5F);
				areaeffectcloudentity.setWaitTime(10);
				areaeffectcloudentity.setRadiusPerTick(
						-areaeffectcloudentity.getRadius() / (float) areaeffectcloudentity.getDuration());
				areaeffectcloudentity.setPotion(new Potion(new EffectInstance(Effects.POISON, 80, 2)));
				this.world.addEntity(areaeffectcloudentity);
				this.remove();
			}
		} else {
			float red = (this.world.getGameTime() % 100) / 100f;
			float green = ((this.world.getGameTime() * 2) % 100) / 100f;
			float blue = ((this.world.getGameTime() * 3) % 100) / 100f;
			RedstoneParticleData particle = new RedstoneParticleData(red, green, blue, 1);
			for (int i = 0; i < 20; i++) {
			world.addParticle(particle, getPosX() + (rand.nextFloat() / 4) - 0.125f, getPosY()+ (rand.nextFloat() / 4) - 0.125f, getPosZ()+ (rand.nextFloat() / 4) - 0.125f, 0, 0.1f, 0);
			}
		}

		super.livingTick();
	}

}
