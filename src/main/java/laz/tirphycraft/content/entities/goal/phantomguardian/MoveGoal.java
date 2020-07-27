package laz.tirphycraft.content.entities.goal.phantomguardian;

import java.util.EnumSet;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.entity.ai.goal.Goal;

public abstract class MoveGoal extends Goal {
	
	public EntityPhantomGuardian entity;
	
	public MoveGoal(EntityPhantomGuardian e) {
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		entity = e;
	}

	public boolean func_203146_f() {
		return entity.orbitOffset.squareDistanceTo(entity.getPosX(),
				entity.getPosY(), entity.getPosZ()) < 4.0D;
	}

}