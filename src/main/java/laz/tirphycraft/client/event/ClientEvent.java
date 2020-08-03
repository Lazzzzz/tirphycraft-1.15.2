package laz.tirphycraft.client.event;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.event.frog.FrozFrogEvent;
import laz.tirphycraft.client.event.frog.LaputaFrogEvent;
import laz.tirphycraft.client.event.frog.NoxisFrogEvent;
import laz.tirphycraft.client.overlay.TirphycraftMainOverlay;
import laz.tirphycraft.content.blocks.froz.PowderSnowBlock;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.TickEvent.RenderTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Tirphycraft.MOD_ID)
public class ClientEvent {

	@SubscribeEvent
	public static void Fog(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		NoxisFrogEvent.update(event);
		LaputaFrogEvent.update(event);
		FrozFrogEvent.update(event);
	}

	@SubscribeEvent
	public static void onRenderHud(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			TirphycraftMainOverlay.INSTANCE.buildOverlay();
		}
	}
		
}
