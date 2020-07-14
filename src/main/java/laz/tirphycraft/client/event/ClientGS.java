package laz.tirphycraft.client.event;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.items.seed.SeedT1;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Tirphycraft.MOD_ID)
public class ClientGS {

	@SubscribeEvent
	public static void showPlantable(PlayerTickEvent event) {
		ItemStack item = event.player.getHeldItemMainhand();
		if (item.getItem() instanceof SeedT1) {
			
		}
		
	}

}
