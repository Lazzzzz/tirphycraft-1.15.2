package laz.tirphycraft.client.event;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Tirphycraft.MOD_ID)
public class ClientLaputaEvent {
	
	static float timer = 0f;
	static float maxFog = 0.05f;
	static float steps = 0.0001f;	
	
	@SubscribeEvent
	public static void onSetupFogDensity(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		if (Minecraft.getInstance().getRenderViewEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
			if (player.getEntityWorld().getBiome(player.getPosition()) == TirphycraftBiomes.L_NML.get()) {
				if (timer < maxFog)
					timer += steps;
				event.setCanceled(true);
				event.setDensity(timer);
			} else {
				if (timer > 0)
					timer -= steps * 10;
				if (timer != 0) {
					event.setCanceled(true);
					event.setDensity(timer);
				}
			}
		}
	}
	
	

}
