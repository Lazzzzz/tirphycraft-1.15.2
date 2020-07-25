package laz.tirphycraft.event.soulfactor;

import laz.tirphycraft.api.SoulFactorCap;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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
		
		if (SoulFactorCap.getSoulFactor(player) > 100) SoulFactorCap.setSoulFactor(player, 100);
		else if (SoulFactorCap.getSoulFactor(player) < -100) SoulFactorCap.setSoulFactor(player, -100);
	
	}

	public static void updateBadEffect(PlayerEntity player) {
		World world = player.world;
	}

	public static void updateGoodEffect(PlayerEntity player) {
		World world = player.world;
	}

}
