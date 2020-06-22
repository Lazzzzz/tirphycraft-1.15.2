package laz.tirphycraft.client.event;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.TirphycraftDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Tirphycraft.MOD_ID)
public class ClientFrozEvent {
	static float timer = 0f;
	static float maxFog = 0.5f;
	static float steps = 0.0001f;

	@SubscribeEvent
	public static void onSetupFogDensity(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		if (Minecraft.getInstance().getRenderViewEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
			if (player.getEntityWorld().getDimension().getType().getModType() == TirphycraftDimensions.FROZ_DIM.get()
					&& player.getEntityWorld().isRaining() == true && player.world.canSeeSky(player.getPosition())) {
				if (timer < maxFog)
					timer += steps * 5;
				event.setCanceled(true);
				event.setDensity(timer);
<<<<<<< HEAD
<<<<<<< HEAD
			
			} else if (player.getEntityWorld().getDimension().getType().getModType() == TirphycraftDimensions.FROZ_DIM
					.get() && player.getPosition().getY() < 48 && timer < maxFog / 7) {
				if (timer < maxFog / 7)
					timer += steps * 2;
				event.setCanceled(true);
				event.setDensity(timer);
			
=======
>>>>>>> parent of 2669fca... structure
=======
>>>>>>> parent of 2669fca... structure
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
