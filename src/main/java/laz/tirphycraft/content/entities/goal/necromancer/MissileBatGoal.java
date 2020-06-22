package laz.tirphycraft.content.entities.goal.necromancer;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import laz.tirphycraft.content.entities.froz.EntityMissileBat;
import laz.tirphycraft.content.entities.froz.EntityNecromancer;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class MissileBatGoal extends Goal {

	EntityNecromancer attacker;
	private int timer = 0;
	private int max_time = 20 * 5;
	
	public MissileBatGoal(EntityNecromancer creature) {
		this.attacker = creature;
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
	}

	@Override
	public boolean shouldExecute() {
		if (attacker.c1 == null || attacker.c2 == null) return false;
		AxisAlignedBB box = new AxisAlignedBB(attacker.c1, attacker.c2);
		List<EntityMissileBat> entity = attacker.world.getEntitiesWithinAABB(EntityMissileBat.class, box);
		if (attacker.getAttackTarget() != null && entity.size() < 5) return attacker.getRNG().nextInt(100) == 0;
		else return false;
	}

	public boolean shouldContinueExecuting() {
		if (timer == max_time) {
			timer = 0;
			attacker.setBat(false);
			return false;
		}
		return true;
	}

	@Override
	public void tick() {
		Random rand = attacker.getRNG();
		BlockPos pos = attacker.getPosition();
		LivingEntity entity = attacker.getAttackTarget();
		attacker.setBat(true);
		timer ++;
		if (timer % 10 == 0 && rand.nextBoolean()) {
			EntityMissileBat bat = new EntityMissileBat(TirphycraftEntities.ENTITY_MISSILE_BAT, attacker.world, entity);
			bat.setPosition(attacker.getPosX() + 0.5 + (rand.nextFloat() * 4) - 2, attacker.getPosY() + 2,
					attacker.getPosZ() + 0.5 + (rand.nextFloat() * 4) - 2);
			attacker.world.addEntity(bat);
		}
	}

}
