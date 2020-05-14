package laz.tirphycraft.event;

import laz.tirphycraft.content.TirphycraftBiomes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CommonFrozEvent {
	
	@SubscribeEvent
	public static void onSetupFogDensity(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		if (player.getEntityWorld().getBiome(player.getPosition()) == TirphycraftBiomes.L_NML.get()) {
			player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 5*20, 1));
		}
	}
}