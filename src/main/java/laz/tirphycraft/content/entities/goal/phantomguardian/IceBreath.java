package laz.tirphycraft.content.entities.goal.phantomguardian;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.entity.ai.goal.Goal;

public class IceBreath extends Goal{

	EntityPhantomGuardian entity;
	private int timer;
	
	public IceBreath(EntityPhantomGuardian entity) {
		this.entity = entity;
	}
	
	@Override
	public boolean shouldExecute() {
		if (entity.world.rand.nextInt(10) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		super.tick();
	}
	
}
