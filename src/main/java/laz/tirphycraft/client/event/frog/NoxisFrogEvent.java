package laz.tirphycraft.client.event.frog;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent;

public class NoxisFrogEvent {

	static float timer = 0f;
	static float maxFog = 0.5f;
	static float steps = 0.0001f;
	
	public static void update(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		if (Minecraft.getInstance().getRenderViewEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
			World world = player.getEntityWorld();
			if (world.getBiome(player.getPosition()) == TirphycraftBiomes.N_THORNS.get()) {
				if (timer < maxFog)
					timer += steps * 10;
				event.setCanceled(true);
				event.setDensity(timer);
			} else {
				if (timer > 0)
					timer -= steps * 5;
				if (timer != 0) {
					event.setCanceled(true);
					event.setDensity(timer);
				}
			}
		}
	}
	
}
