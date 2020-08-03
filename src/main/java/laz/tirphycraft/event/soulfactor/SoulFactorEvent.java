package laz.tirphycraft.event.soulfactor;

import java.util.Random;

import laz.tirphycraft.api.SoulFactorCap;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;
import net.minecraft.world.World;

public class SoulFactorEvent {

	public static void entityKill(LivingEntity entity, PlayerEntity player) {
		if (entity.getClassification(false) == EntityClassification.AMBIENT) {
			SoulFactorCap.setSoulFactor(player, SoulFactorCap.getSoulFactor(player) - 1);
		}

		else if (entity.getClassification(false) == EntityClassification.CREATURE) {
			SoulFactorCap.setSoulFactor(player, SoulFactorCap.getSoulFactor(player) - 4);
		}

		else if (entity.getClassification(false) == EntityClassification.WATER_CREATURE) {
			SoulFactorCap.setSoulFactor(player, SoulFactorCap.getSoulFactor(player) - 1);
		}

		else if (entity.getClassification(false) == EntityClassification.MISC) {
			SoulFactorCap.setSoulFactor(player, SoulFactorCap.getSoulFactor(player) - 1);
		}

		else if (entity.getClassification(false) == EntityClassification.MONSTER) {
			SoulFactorCap.setSoulFactor(player, SoulFactorCap.getSoulFactor(player) + 2);
		}

		if (SoulFactorCap.getSoulFactor(player) > 100)
			SoulFactorCap.setSoulFactor(player, 100);
		else if (SoulFactorCap.getSoulFactor(player) < -100)
			SoulFactorCap.setSoulFactor(player, -100);
	}

	private static int[] getFactors(Random rand, int soulFactor) {
		int duration_factor = 1;
		int amplifieur_factor = 1;
		
		if (soulFactor < 0) {
			duration_factor = (int) ((-soulFactor / 10) * (1 + rand.nextFloat()));
			amplifieur_factor = (int) ((-soulFactor / 50) * (1 + rand.nextFloat()));
		} else {
			duration_factor = (int) ((soulFactor / 10) * (0.7 + rand.nextFloat()));
			amplifieur_factor = (int) ((soulFactor / 20) * rand.nextFloat());
		}
		int duration = Math.max(60, rand.nextInt(duration_factor + 1) * 500);
		int amplifieur = Math.min(rand.nextInt(amplifieur_factor + 1), 2);
		return new int[] { duration, amplifieur};
	}

	private static EffectInstance chooseRandBadEffect(Random rand, int soulFactor) {
		int[] factors = getFactors(rand, soulFactor);
		
		switch (rand.nextInt(6)) {
		case 0:
			return new EffectInstance(Effects.WEAKNESS, factors[0], factors[1]);
		case 1:
			return new EffectInstance(Effects.BLINDNESS, factors[0], factors[1]);
		case 2:
			return new EffectInstance(Effects.WITHER, factors[0], factors[1]);
		case 3:
			return new EffectInstance(Effects.HUNGER, factors[0], factors[1]);
		case 4:
			return new EffectInstance(Effects.MINING_FATIGUE, factors[0], factors[1]);
		default:
			return new EffectInstance(Effects.NAUSEA, factors[0], factors[1]);
		}
	}

	private static EffectInstance chooseRandGoodEffect(Random rand, int soulFactor) {
		int[] factors = getFactors(rand, soulFactor);
		
		switch (rand.nextInt(6)) {
		case 0:
			return new EffectInstance(Effects.FIRE_RESISTANCE, factors[0], factors[1]);
		case 1:
			return new EffectInstance(Effects.HASTE, factors[0], factors[1]);
		case 2:
			return new EffectInstance(Effects.REGENERATION, factors[0], factors[1]);
		case 3:
			return new EffectInstance(Effects.RESISTANCE, factors[0], factors[1]);
		case 4:
			return new EffectInstance(Effects.STRENGTH, factors[0], factors[1]);
		default:
			return new EffectInstance(Effects.SPEED, factors[0], factors[1]);
		}
	}

	public static void updateBadEffect(PlayerEntity player, int factor) {
		Random random = player.world.rand;
		if (random.nextInt(100 + factor + 10) == 0)
			player.addPotionEffect(new EffectInstance(chooseRandBadEffect(random, factor)));

	}

	public static void updateGoodEffect(PlayerEntity player, int factor) {
		Random random = player.world.rand;
		if (random.nextInt(100 + factor + 10) == 0)
			player.addPotionEffect(new EffectInstance(chooseRandGoodEffect(random, factor)));
	}

}
