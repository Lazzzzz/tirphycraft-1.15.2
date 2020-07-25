package laz.tirphycraft.event.playertick;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class LaputaPlayerTickEvent {

	public static void update(PlayerEntity player) {
		if (player.getEntityWorld().getBiome(player.getPosition()) == TirphycraftBiomes.L_NML.get()
				&& player.getPosition().getY() < 120) {
			player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 5 * 20, 1));
		}
		if (!player.world.isRemote()) {
			if (player.getPosY() < -10) {
				ServerPlayerEntity playerEntity = (ServerPlayerEntity) player;
				@SuppressWarnings("deprecation")
				DimensionType dimensionType = DimensionManager.getRegistry().getByValue(1);
				ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
				playerEntity.teleport(targetWorld, player.getPosX(), 255, player.getPosZ(), player.rotationYaw,
						player.rotationPitch);
			}
		}
	}
	
}
