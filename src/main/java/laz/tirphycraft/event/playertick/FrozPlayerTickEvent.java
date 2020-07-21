package laz.tirphycraft.event.playertick;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import laz.tirphycraft.registry.init.TirphycraftDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrozPlayerTickEvent {

	private static int maxRadius = 3;
	private static int maxRadiusY = 2;
	
	public static void update(PlayerEntity player) {
		if (!player.world.isRemote) {
			if (player.getEntityWorld().getDimension().getType().getModType() == TirphycraftDimensions.FROZ_DIM.get()
					&& player.getEntityWorld().isRaining() == true) {
				if (player.ticksExisted % 20 == 0) {
					if (checkForHeat(player) == false) {
						player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 5 * 20, 1));
					}
				}
			}
		}
	}

	public static boolean checkForHeat(PlayerEntity entity) {

		for (int i = -maxRadius; i <= maxRadius; i++) {
			for (int j = -maxRadius; j <= maxRadius; j++) {
				for (int k = -maxRadiusY; k <= maxRadiusY; k++) {
					BlockPos pos = new BlockPos(entity.getPosition().add(i, k, j));
					if (entity.getEntityWorld().getBlockState(pos).getLightValue() > 0)
						return true;
				}
			}
		}

		return false;
	}
	
}
