package laz.tirphycraft.event;

import laz.tirphycraft.registry.init.TirphycraftBiomes;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CommonGSEvent {
	
	@SubscribeEvent
	public static void breakBlock(BlockEvent.BreakEvent event) {
		if (event.getPlayer().getEntityWorld().getBiome(event.getPlayer().getPosition()) == TirphycraftBiomes.SG_PLAINS.get()) {
			if (!event.getPlayer().isCreative())
				event.setCanceled(true);
		}
	}
}
