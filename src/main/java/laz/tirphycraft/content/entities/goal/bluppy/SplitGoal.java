package laz.tirphycraft.content.entities.goal.bluppy;

import java.util.Random;

import laz.tirphycraft.content.entities.laputa.EntityBluppy;
import laz.tirphycraft.content.entities.projectile.EntityBluppySplit;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

public class SplitGoal extends Goal{
	
	EntityBluppy entity;
	World world;
	Random rand;
	
	public SplitGoal(EntityBluppy bluppy) {
		this.entity = bluppy;
		this.world  = bluppy.world;
		this.rand 	= world.rand;
	}
	
	@Override
	public boolean shouldExecute() {
		if (entity.getAttackTarget() != null && rand.nextInt(40) == 0) return true;
		return false;
	}

	@Override
	public void tick() {
		EntityBluppySplit split = new EntityBluppySplit(TirphycraftEntities.ENTITY_BLUPPY_SPLIT, world);
		float vx = (float) ((entity.getAttackTarget().getPosX() - entity.getPosX()) / 10);
		float vy = 0.7f;
		float vz = (float) ((entity.getAttackTarget().getPosZ() - entity.getPosZ()) / 10);
		split.setMotion(vx,vy,vz);
		split.setPositionAndUpdate(entity.getPosX(), entity.getPosY() + 1, entity.getPosZ());
		world.addEntity(split);
		super.tick();
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		return false;
	}
	
}
