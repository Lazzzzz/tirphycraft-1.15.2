package laz.tirphycraft.content.entities.goal.spirittree;

import java.util.Random;

import laz.tirphycraft.content.entities.laputa.EntityTreeSpirit;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ThunderLineGoal extends Goal {
	private EntityTreeSpirit attacker;
	private Random rand;
	private World world;
	private boolean done;
	private BlockPos target;
	private int timer = 5;
	private int counter = 0;
	private BlockPos curPos;
	private double stepX = 0;
	private double stepZ = 0;

	public ThunderLineGoal(EntityTreeSpirit attacker) {
		this.attacker = attacker;
		this.world = attacker.world;
		this.rand = world.rand;
		done = false;
	}

	@Override
	public boolean shouldExecute() {
		if (rand.nextInt(40) == 0 && attacker.getAttackTarget() != null) {
			target = attacker.getAttackTarget().getPosition();
			System.out.println("yo");
			done 	= false;
			counter = 0;
			
			stepX = (target.getX() - attacker.getPosX()) / 2;
			stepZ = (target.getZ() - attacker.getPosZ()) / 2;
			
			curPos = attacker.getPosition();
			
			return true;
		}
		return false;
	}

	public boolean shouldContinueExecuting() {
		return done;
	}

	@Override
	public void tick() {
		updateTimer();
		
		if (counter == timer) {
			curPos.add(stepX * 2, 0, stepZ * 2);
			LightningBoltEntity m = new LightningBoltEntity(world, curPos.getX(), curPos.getY(), curPos.getZ(), false);
			world.addEntity(m);		
			if (rand.nextInt(20) == 0) done = true;	
		}
		
		super.tick();
	}

	private void updateTimer() {
		counter ++; 
		if (counter > timer) counter = 0;
	}
	
}
