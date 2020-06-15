package laz.tirphycraft.content.entities.goal.necromancer;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import laz.tirphycraft.content.entities.froz.EntityNecromancer;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class SummonGuardGoal extends Goal {

	EntityNecromancer attacker;
	private int timer = 0;
	private int max_time = 20 * 5;

	public SummonGuardGoal(EntityNecromancer creature) {
		this.attacker = creature;
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
	}

	@Override
	public boolean shouldExecute() {

		if (attacker.c1 == null || attacker.c2 == null)
			return false;

		AxisAlignedBB box = new AxisAlignedBB(attacker.c1, attacker.c2);
		List<EntityFrozenSoldier> entity = attacker.world.getEntitiesWithinAABB(EntityFrozenSoldier.class, box);
		if (attacker.getAttackTarget() != null && entity.size() < 5)
			return attacker.getRNG().nextInt(100) == 0;

		return false;
	}

	public boolean shouldContinueExecuting() {
		if (timer == max_time) {
			timer = 0;
			attacker.setInvoc(false);
			attacker.setSpawn(null);
			return false;
		}
		return true;
	}

	@Override
	public void tick() {
		attacker.setInvoc(true);
		Random rand = attacker.getRNG();
		BlockPos pos = attacker.getPosition();
		timer ++;
		
		if (timer % 10 == 0 && rand.nextInt(3) == 0) {
			EntityFrozenSoldier e = new EntityFrozenSoldier(TirphycraftEntities.ENTITY_FROZEN_SOLDIER, attacker.world, true);
			e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TirphycraftItems.FROZ_STONE_SWORD.get()));
			double x = attacker.c2.getX() - attacker.c1.getX() - 4;
			double z = attacker.c2.getZ() - attacker.c1.getZ() - 4;
			e.setPosition(attacker.c1.getX() + rand.nextInt((int) x) + 2, attacker.getPosY(), attacker.c1.getZ() + rand.nextInt((int) z) + 2);
			attacker.setSpawn(e.getPosition());
			attacker.world.addEntity(e);
		}
	}

}
