package laz.tirphycraft.client.event.frog;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.EntityViewRenderEvent;

public class LaputaFrogEvent {

	static float timer = 0f;
	static float maxFog = 0.05f;
	static float steps = 0.0001f;
	
	public static void update(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		if (Minecraft.getInstance().getRenderViewEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
			if (player.getEntityWorld().getBiome(player.getPosition()) == TirphycraftBiomes.L_NML.get() && player.getPosY() < 120) {
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
