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

public class SummonHeavyGuardGoal extends Goal {

	EntityNecromancer attacker;
	private int timer = 0;
	private int max_time = 20 * 5;

	public SummonHeavyGuardGoal(EntityNecromancer creature) {
		this.attacker = creature;
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
	}

	@Override
	public boolean shouldExecute() {
		if (attacker.c1 == null || attacker.c2 == null)
			return false;
		AxisAlignedBB box = new AxisAlignedBB(attacker.c1, attacker.c2);
		List<EntityFrozenSoldier> entity = attacker.world.getEntitiesWithinAABB(EntityFrozenSoldier.class, box);
		if (attacker.getAttackTarget() != null && entity.size() < 2)
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
		
		if (timer % 10 == 0 && rand.nextInt(7) == 0) {
			EntityFrozenSoldier e = new EntityFrozenSoldier(TirphycraftEntities.ENTITY_FROZEN_SOLDIER, attacker.world, true);

			e.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(TirphycraftItems.DRAUGRIR_LEGS));
			e.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(TirphycraftItems.DRAUGRIR_FEET));
			e.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(TirphycraftItems.DRAUGRIR_CHEST));
			e.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(TirphycraftItems.DRAUGRIR_HEAD));
			e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TirphycraftItems.HISTICE_SWORD.get()));
			e.setHealth(e.getMaxHealth() / 2);			
			double x = attacker.c2.getX() - attacker.c1.getX() - 4;
			double z = attacker.c2.getZ() - attacker.c1.getZ() - 4;
			e.setPosition(attacker.c1.getX() + rand.nextInt((int) x) + 2, attacker.getPosY(), attacker.c1.getZ() + rand.nextInt((int) z) + 2);
			attacker.setSpawn(e.getPosition());
			attacker.world.addEntity(e);
		}

	}

}
