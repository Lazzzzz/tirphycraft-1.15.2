package laz.tirphycraft.event.playertick;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class NoxisPlayerTickEvent {

	public static void update(PlayerEntity player) {
		if (!player.world.isRemote) {
			World world = player.getEntityWorld();
			if (world.getBiome(player.getPosition()) == TirphycraftBiomes.N_THORNS.get()) {
				if (player.ticksExisted % 20 == 0) {
					player.addPotionEffect(new EffectInstance(Effects.WITHER, 5 * 20, 1));
				}
			}
		}
	}
	
}
