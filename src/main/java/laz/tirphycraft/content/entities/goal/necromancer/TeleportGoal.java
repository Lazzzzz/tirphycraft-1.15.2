package laz.tirphycraft.content.entities.goal.necromancer;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import laz.tirphycraft.content.entities.froz.EntityNecromancer;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.registry.init.TirphycraftItems;
import laz.tirphycraft.util.TirphycraftUtils;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TeleportGoal extends Goal {

	EntityNecromancer attacker;
	boolean done;

	public TeleportGoal(EntityNecromancer creature) {
		this.attacker = creature;
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
		this.done = false;
	}

	@Override
	public boolean shouldExecute() {
		if (attacker.c1 == null || attacker.c2 == null) return false;
		
		if (attacker.getAttackTarget() != null) {
			BlockPos pos1 = attacker.getPosition();
			BlockPos pos2 = attacker.getAttackTarget().getPosition();
			double dist = TirphycraftUtils.hypot(pos1.getX() - pos2.getX(), pos1.getY() - pos2.getY(),
					pos1.getZ() - pos2.getZ());
			if (dist < 6) {
				return attacker.getRNG().nextInt((int) (dist +1)) == 0;
			}
			return false;
		}
		return false;
	}

	public boolean shouldContinueExecuting() {
		return false;
	}

	@Override
	public void tick() {
		Random rand = attacker.getRNG();
		double x = attacker.c2.getX() - attacker.c1.getX() - 2;
		double z = attacker.c2.getZ() - attacker.c1.getZ() - 2;
		attacker.setPositionAndUpdate(attacker.c1.getX() + rand.nextInt((int) x) + 1, attacker.getPosY(),
				attacker.c1.getZ() + rand.nextInt((int) z) + 1);
	}
}
