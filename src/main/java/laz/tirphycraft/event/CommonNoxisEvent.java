package laz.tirphycraft.event;

import laz.tirphycraft.content.TirphycraftBiomes;
import laz.tirphycraft.content.TirphycraftDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CommonNoxisEvent {

	@SubscribeEvent
	public static void onSetupFogDensity(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		if (!player.world.isRemote) {
			World world = player.getEntityWorld();
			if (world.getDimension().getType().getModType() == TirphycraftDimensions.NOXIS_DIM.get()
					&& world.getBiome(player.getPosition()) == TirphycraftBiomes.N_THORNS.get()) {
				if (player.ticksExisted % 20 == 0) {
					player.addPotionEffect(new EffectInstance(Effects.WITHER, 5 * 20, 1));
				}
			}
		}
	}

}
