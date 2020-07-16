package laz.tirphycraft.content.entities.goal.spirittree;

import java.util.EnumSet;
import java.util.Random;

import laz.tirphycraft.content.entities.laputa.EntityTreeSpirit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BreakingBlockGoal extends Goal {
	
	private EntityTreeSpirit attacker;
	private World world;
	private Random rand;
	
	public BreakingBlockGoal(EntityTreeSpirit attacker) {
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
		this.attacker = attacker;
		this.world = attacker.world;
		this.rand = world.rand;
	}
	
	@Override
	public boolean shouldExecute() {
		if (rand.nextInt(20) == 0 && attacker.getAttackTarget() != null) return true;
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
			if (x != 0 || z != 0 || x * x + z * z <= 27 * 27) flag = false;
		}
		
		BlockPos   pos 	  = new BlockPos(attacker.getPosX() + x, attacker.getPosY() - 1, attacker.getPosZ() + z);
		BlockState block  = world.getBlockState(pos);
		
		world.removeBlock(pos, false);
		FallingBlockEntity e = new FallingBlockEntity(world, pos.getX() + 0.5f, pos.getY(), pos.getZ() + 0.5f, block);
		e.setOrigin(e.getPosition());
		e.fallTime = -100;
		world.addEntity(e);
		
	}

}
