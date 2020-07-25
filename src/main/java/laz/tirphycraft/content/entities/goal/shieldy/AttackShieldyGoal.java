package laz.tirphycraft.content.entities.goal.shieldy;

import java.util.EnumSet;
import java.util.Random;

import laz.tirphycraft.content.entities.laputa.EntityShieldy;
import laz.tirphycraft.util.TirphycraftUtils;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AttackShieldyGoal extends Goal {

	private EntityShieldy attacker;
	private World world;
	private Random rand;

	public AttackShieldyGoal(EntityShieldy attacker) {
		this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.TARGET));
		this.attacker = attacker;
		this.world = attacker.world;
		this.rand = world.rand;
	}

	@Override
	public boolean shouldExecute() {
		if (rand.nextInt(70) == 0 && attacker.getAttackTarget() != null)
			return true;
		return false;
	}

	public boolean shouldContinueExecuting() {
		return false;
	}

	@Override
	public void tick() {
		BlockPos pos = attacker.getAttackTarget().getPosition();
		BlockPos pos2 = attacker.getPosition();
		if (TirphycraftUtils.hypot(pos.getX() - pos.getX(), pos.getY() - pos.getY(), pos.getZ() - pos.getZ()) < 15) {
			PotionEntity potionentity = new PotionEntity(world, attacker);
			Potion potion = Potions.HARMING;
			switch (world.rand.nextInt(6)) {
			case 0:
				potion = Potions.HARMING;
				break;
			case 1:
				potion = Potions.HEALING;
				break;
			case 2:
				potion = Potions.POISON;
				break;
			case 3:
				potion = Potions.STRONG_SLOWNESS;
				break;
			case 4:
				potion = Potions.AWKWARD;
				break;
			case 5:
				potion = Potions.SLOW_FALLING;
				break;
			}
			potionentity.setItem(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potion));
			potionentity.setPositionAndUpdate(pos.getX(), pos.getY() + rand.nextInt(4) + 4, pos.getZ());
			world.addEntity(potionentity);
		}
	}

}
