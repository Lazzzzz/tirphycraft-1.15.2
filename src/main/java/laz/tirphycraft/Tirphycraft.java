package laz.tirphycraft;

import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.particle.Particles.GLINT_PARTICLE;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import laz.tirphycraft.network.PacketHandler;
import laz.tirphycraft.particle.GlintParticle;
import laz.tirphycraft.recipes.RecipeInit;
import laz.tirphycraft.recipes.froz.FrozFurnaceRecipe;
import laz.tirphycraft.registry.TirphycraftRegistries;
import laz.tirphycraft.registry.init.TirphycraftOverworldFeature;
import laz.tirphycraft.registry.render.TirphycraftBlockRender;
import laz.tirphycraft.registry.render.TirphycraftEntitiesRender;
import laz.tirphycraft.registry.render.TirphycraftGuiRender;
import laz.tirphycraft.util.CapHandler;
import laz.tirphycraft.util.book.BookItemInfo;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod(MOD_ID)
public class Tirphycraft {
	public static final String MOD_ID = "tirphycraft";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final TirphycraftGroup ITEM_GROUP = new TirphycraftGroup(MOD_ID + "_group");

	public static final ArrayList<FrozFurnaceRecipe> FROZ_RECIPES = new ArrayList<FrozFurnaceRecipe>();
	public static final ArrayList<BookItemInfo> BOOK_OF_KNOWLEDGE = new ArrayList<BookItemInfo>();

	public Tirphycraft() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverStartup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		TirphycraftRegistries.init(bus);

	}

	private void serverStartup(FMLServerStartedEvent event) {
	}

	private void setup(final FMLCommonSetupEvent event) {
		
//		MinecraftForge.EVENT_BUS.register(new LymbeFog());
				
		TirphycraftOverworldFeature.init();
		PacketHandler.registerMessages();
		CapHandler.init();
		RecipeInit.init();
	}

	private void clientSetup(FMLClientSetupEvent event) {
		TirphycraftBlockRender.init();
		TirphycraftEntitiesRender.init();
		TirphycraftGuiRender.init();
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

		@SubscribeEvent
		public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event) {
			StructureFeatures.registerFeatures(event);

			LOGGER.log(Level.INFO, "features/structures registered.");
		}

	}

	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry,
			String registryKey) {
		entry.setRegistryName(new ResourceLocation(Tirphycraft.MOD_ID, registryKey));
		registry.register(entry);
		return entry;
	}
}
