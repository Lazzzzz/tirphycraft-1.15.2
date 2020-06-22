package laz.tirphycraft;

import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.particle.Particles.GLINT_PARTICLE;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

<<<<<<< HEAD
import laz.tirphycraft.particle.GlintParticle;
import laz.tirphycraft.recipes.RecipeInit;
import laz.tirphycraft.recipes.froz.FrozFurnaceRecipe;
import laz.tirphycraft.registry.TirphycraftRegistries;
import laz.tirphycraft.registry.init.TirphycraftDimensions;
import laz.tirphycraft.registry.render.TirphycraftBlockRender;
import laz.tirphycraft.registry.render.TirphycraftEntitiesRender;
import laz.tirphycraft.registry.render.TirphycraftGuiRender;
=======
import laz.tirphycraft.client.render.entities.froz.EntityKretunRender;
import laz.tirphycraft.client.tiles.BookOfKnowledgeContainerScreen;
import laz.tirphycraft.client.tiles.FrozFurnaceContainerScreen;
import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.TirphycraftContainer;
import laz.tirphycraft.content.TirphycraftDimensions;
import laz.tirphycraft.content.TirphycraftEntities;
import laz.tirphycraft.content.TirphycraftRegistries;
import laz.tirphycraft.particle.GlintParticle;
import laz.tirphycraft.recipes.book.BookOfKnowledgeRecipe;
import laz.tirphycraft.recipes.froz.FrozFurnaceRecipe;
import laz.tirphycraft.recipes.froz.FrozFurnaceRecipeInit;
>>>>>>> parent of 2669fca... structure
import laz.tirphycraft.util.book.BookItemInfo;
import laz.tirphycraft.world.biome.base.FrozBiome;
import laz.tirphycraft.world.biome.base.LaputaBiome;
import laz.tirphycraft.world.biome.base.NoxisBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

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
		DimensionManager.registerOrGetDimension(new ResourceLocation(MOD_ID, "froz_dim"), TirphycraftDimensions.FROZ_DIM.get(), null, true);
	}	

	private void setup(final FMLCommonSetupEvent event) {
	for (Biome biome : ForgeRegistries.BIOMES) {
			if (!(biome instanceof FrozBiome) && !(biome instanceof LaputaBiome) && !(biome instanceof NoxisBiome))
				biome.addFeature(Decoration.SURFACE_STRUCTURES, Features.ANCIENT_STONE
						.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));

			biome.addFeature(Decoration.SURFACE_STRUCTURES,
					Features.COAL_ON_COKE.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
			biome.addFeature(Decoration.SURFACE_STRUCTURES,
					Features.PYRODES.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
			biome.addFeature(Decoration.SURFACE_STRUCTURES,
					Features.CRYSTAL.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		}
<<<<<<< HEAD
		RecipeInit.init();		
}
=======

		FrozFurnaceRecipeInit.init();
		BookOfKnowledgeRecipe.init();
		
	}
>>>>>>> parent of 2669fca... structure

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

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_COPPIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_SILVIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_GOLDIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_FROZ.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_SKY.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER1.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER2.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER3.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER4.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER5.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER6.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.NOXIS_FLOWER1.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.FROZ_FLOWER1.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_BLUE.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_GREEN.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_WHITE.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_RED.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_YELLOW.get(), cutout);

		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_KRETUN, EntityKretunRender::new);

		ScreenManager.registerFactory(TirphycraftContainer.FROZ_FURNACE_CONTAINER.get(),
				FrozFurnaceContainerScreen::new);
		ScreenManager.registerFactory(TirphycraftContainer.BOOK_OF_KNOWLEDGE_CONTAINER.get(),
				BookOfKnowledgeContainerScreen::new);
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
<<<<<<< HEAD
		
		@SubscribeEvent
		public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event)
		{
			StructureFeatures.registerFeatures(event);
		}

	}
	
	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey)
	{
		entry.setRegistryName(new ResourceLocation(Tirphycraft.MOD_ID, registryKey));
		registry.register(entry);
		return entry;
=======

>>>>>>> parent of 2669fca... structure
	}
}
