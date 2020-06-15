package laz.tirphycraft.content.entities.goal.necromancer;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.BlockPos;

public class SplashPotionGoal extends Goal {

	CreatureEntity attacker;
	boolean done;

	public SplashPotionGoal(CreatureEntity creature) {
		this.attacker = creature;
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
		this.done = false;
	}

	@Override
	public boolean shouldExecute() {
		if (attacker.getAttackTarget() != null)	return attacker.getRNG().nextInt(100) == 0;
		else return false;
	}

	public boolean shouldContinueExecuting() {
		return false;
	}

	@Override
	public void tick() {
		Random rand = attacker.getRNG();
		for (int i = 0; i < rand.nextInt(4)+1; i++) {
		      AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(attacker.world, attacker.getPosX() + rand.nextInt(20) - 10, attacker.getPosY(), attacker.getPosZ() + rand.nextInt(20) - 10);
		      areaeffectcloudentity.setOwner(attacker);
		      areaeffectcloudentity.setRadius(2.5F);
		      areaeffectcloudentity.setRadiusOnUse(-0.5F);
		      areaeffectcloudentity.setWaitTime(10);
		      areaeffectcloudentity.setRadiusPerTick(-areaeffectcloudentity.getRadius() / (float)areaeffectcloudentity.getDuration());
		      areaeffectcloudentity.setPotion(new Potion(new EffectInstance(Effects.POISON, 100)));
		      attacker.world.addEntity(areaeffectcloudentity);
		}
		
	}

}
