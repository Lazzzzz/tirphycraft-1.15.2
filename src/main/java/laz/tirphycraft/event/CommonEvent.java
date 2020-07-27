package laz.tirphycraft.event;

import laz.tirphycraft.api.SoulFactorCap;
import laz.tirphycraft.event.playertick.FrozPlayerTickEvent;
import laz.tirphycraft.event.playertick.LaputaPlayerTickEvent;
import laz.tirphycraft.event.playertick.NoxisPlayerTickEvent;
import laz.tirphycraft.event.soulfactor.SoulFactorEvent;
import laz.tirphycraft.network.PacketHandler;
import laz.tirphycraft.network.PacketSoulFactor;
import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.NetworkDirection;

@EventBusSubscriber
public class CommonEvent {

	@SubscribeEvent
	public static void playerTick(PlayerTickEvent event) {
		PlayerEntity player = event.player;

		FrozPlayerTickEvent.update(player);
		LaputaPlayerTickEvent.update(player);
		NoxisPlayerTickEvent.update(player);

		if (!player.world.isRemote()) {
			if (player.world.getGameTime() % 20 == 0) {
				PacketHandler.INSTANCE.sendTo(
						new PacketSoulFactor(player.getUniqueID(), SoulFactorCap.getSoulFactor(player)),
						((ServerPlayerEntity) player).connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
			}

			if (SoulFactorCap.getSoulFactor(player) > 0) {
				SoulFactorEvent.updateBadEffect(player);
			} else if (SoulFactorCap.getSoulFactor(player) < 0) {
				SoulFactorEvent.updateGoodEffect(player);
			}
		}
	}

	@SubscribeEvent
	public static void soulCapMobKill(LivingDeathEvent event) {
		World world = event.getEntity().world;
		if (event.getSource().getTrueSource() instanceof PlayerEntity && !world.isRemote
				&& event.getEntity() instanceof LivingEntity) {
			LivingEntity mob = (LivingEntity) event.getEntity();
			PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
			SoulFactorEvent.entityKill(mob, player);
		}
	}

}
