package laz.tirphycraft.client.event.frog;

import laz.tirphycraft.registry.init.TirphycraftDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.EntityViewRenderEvent;

public class FrozFrogEvent {

	static float timer = 0f;
	static float maxFog = 0.5f;
	static float steps = 0.0001f;
	
	public static void update(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		if (Minecraft.getInstance().getRenderViewEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
			if (player.getEntityWorld().getDimension().getType().getModType() == TirphycraftDimensions.FROZ_DIM.get()
					&& player.getEntityWorld().isRaining() == true && player.world.canSeeSky(player.getPosition())) {
				if (timer < maxFog)
					timer += steps * 5;
				event.setCanceled(true);
				event.setDensity(timer);
			
			} else if (player.getEntityWorld().getDimension().getType().getModType() == TirphycraftDimensions.FROZ_DIM
					.get() && player.getPosition().getY() < 48 && timer < maxFog / 7) {
				if (timer < maxFog / 7)
					timer += steps * 2;
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
