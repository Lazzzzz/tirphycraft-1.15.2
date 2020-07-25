package laz.tirphycraft.content.entities.goal.spirittree;

import java.util.EnumSet;
import java.util.Random;

import laz.tirphycraft.content.entities.laputa.EntitySpiritHeart;
import laz.tirphycraft.content.entities.laputa.EntityTreeSpirit;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SumonHeartGoal extends Goal {
	
	private EntityTreeSpirit attacker;
	private World world;
	private Random rand;
	
	public SumonHeartGoal(EntityTreeSpirit attacker) {
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
		this.attacker = attacker;
		this.world = attacker.world;
		this.rand = world.rand;
	}
	
	@Override
	public boolean shouldExecute() {
		if (rand.nextInt(40) == 0 && attacker.getAttackTarget() != null) return true;
		return false;
	}
	
	public boolean shouldContinueExecuting() {
		return false;
	}

	@Override
	public void tick() {
		double x = 0;
		double z = 0;
		boolean flag = true;
		while (flag) {
			x = rand.nextInt(60) - 30;
			z = rand.nextInt(60) - 30;
			if (x != 0 || z != 0 || x * x + z * z <= 15 * 15) flag = false;
		}
		if (world.getBlockState(new BlockPos(attacker.getPosX() + x, attacker.getPosY() - 1, attacker.getPosZ() + z)) != null) {
			EntitySpiritHeart e = new EntitySpiritHeart(TirphycraftEntities.ENTITY_SPIRIT_HEART, world, attacker);
			e.setPositionAndUpdate(attacker.getPosX() + x, attacker.getPosY(), attacker.getPosZ() + z);
			world.addEntity(e);			
		}
	}
}
