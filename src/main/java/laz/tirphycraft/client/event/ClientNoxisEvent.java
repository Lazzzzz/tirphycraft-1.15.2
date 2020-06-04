package laz.tirphycraft.client.event;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBiomes;
import laz.tirphycraft.registry.init.TirphycraftDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Tirphycraft.MOD_ID)
public class ClientNoxisEvent {
	static float timer = 0f;
	static float maxFog = 0.5f;
	static float steps = 0.0001f;

	@SubscribeEvent
	public static void onSetupFogDensity(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		if (Minecraft.getInstance().getRenderViewEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
			World world = player.getEntityWorld();
			if (world.getDimension().getType().getModType() == TirphycraftDimensions.NOXIS_DIM.get()
					&& world.getBiome(player.getPosition()) == TirphycraftBiomes.N_THORNS.get()) {
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
