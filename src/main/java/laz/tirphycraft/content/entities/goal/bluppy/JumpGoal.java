package laz.tirphycraft.content.entities.goal.bluppy;

import java.util.Random;

import laz.tirphycraft.content.entities.laputa.EntityBluppy;
import net.minecraft.entity.ai.goal.Goal;

public class JumpGoal extends Goal{

	EntityBluppy entity;
	int timer = 0;
	int JumpTime;
	Random rand;
	
	public JumpGoal(EntityBluppy entity, int jumpTime) {
		this.entity   = entity;
		this.JumpTime = jumpTime;
		this.rand = entity.world.rand;
	}
	
	@Override
	public boolean shouldExecute() {
		if (entity.onGround) {
			timer = -JumpTime;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		if (timer == JumpTime) return false;
		return true;
	}
	
	@Override
	public void tick() {
		updateTimer();
		if (timer < 0) {
			float size = Math.max((float) -timer / JumpTime, 0.5f);
			if (size == 0.5f) timer = 0;
			entity.setSize(size);
		}
		else entity.setSize((float) timer / JumpTime);
		if (timer == (int) JumpTime / 2) {
			entity.setMotion(0, 1f + rand.nextFloat(), 0);
		}
	}

	private void updateTimer() {
		if (timer > 0) this.timer += 4;
		else this.timer ++;
		if (timer > JumpTime) timer = JumpTime;
	}

}
