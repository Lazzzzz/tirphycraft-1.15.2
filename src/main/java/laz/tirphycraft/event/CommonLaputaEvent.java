package laz.tirphycraft.event;

import static laz.tirphycraft.api.SoulFactorCap.activateBadEffect;
import static laz.tirphycraft.api.SoulFactorCap.activateGoodEffect;
import static laz.tirphycraft.api.SoulFactorCap.badSoulEffect;
import static laz.tirphycraft.api.SoulFactorCap.goodSoulEffect;

import laz.tirphycraft.api.SoulFactorCap;
import laz.tirphycraft.network.PacketHandler;
import laz.tirphycraft.network.PacketSoulFactor;
import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.NetworkDirection;

@EventBusSubscriber
public class CommonLaputaEvent {

	@SubscribeEvent
	public static void playerTick(PlayerTickEvent event) {
		PlayerEntity player = event.player;
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
		if (!player.world.isRemote()) {
			if (player.world.getGameTime() % 20 == 0)
				PacketHandler.INSTANCE.sendTo(new PacketSoulFactor(SoulFactorCap.getSoulFactor(player)), Minecraft.getInstance().getConnection().getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);

			if (activateBadEffect(player)) {
				badSoulEffect(player);
			} else if (activateGoodEffect(player)) {
				goodSoulEffect(player);
			}
		} 
		
	}
}
