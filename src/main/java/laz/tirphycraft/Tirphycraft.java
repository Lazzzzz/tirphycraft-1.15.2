package laz.tirphycraft;

import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.particle.Particles.GLINT_PARTICLE;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.TirphycraftDimensions;
import laz.tirphycraft.content.TirphycraftRegistries;
import laz.tirphycraft.particle.GlintParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MOD_ID)
public class Tirphycraft {
	public static final String MOD_ID = "tirphycraft";

	public static final TirphycraftGroup ITEM_GROUP = new TirphycraftGroup(MOD_ID + "_group");

	public Tirphycraft() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverStartup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		TirphycraftRegistries.init(bus);
	}

	private void serverStartup(FMLServerStartedEvent event) {
		DimensionManager.registerOrGetDimension(new ResourceLocation(MOD_ID, "froz_dim"),
				TirphycraftDimensions.FROZ_DIM.get(), null, true);
	}

	private void clientSetup(FMLClientSetupEvent event) {
		RenderType cutout = RenderType.getCutout();
		RenderType opaque = RenderType.getTranslucent();
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_COPPIR.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_SILVIR.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_GOLDIR.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_FROZ.get(), cutout);
        
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_BLUE.get(), opaque);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_GREEN.get(), opaque);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_YELLOW.get(), opaque);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_PURPLE.get(), opaque);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_PINK.get(), opaque);

        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER1.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER2.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER3.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER4.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER5.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER6.get(), cutout);
        RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER7.get(), cutout);
        
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Registry {

		@SubscribeEvent
		public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(GLINT_PARTICLE, GlintParticle.Factory::new);
		}

		@SubscribeEvent
		public static void registerParticleTypes(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(GLINT_PARTICLE.setRegistryName(MOD_ID, "glint"));
		}

	}
}
