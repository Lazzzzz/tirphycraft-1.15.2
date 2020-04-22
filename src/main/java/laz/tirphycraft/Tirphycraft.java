package laz.tirphycraft;

import laz.tirphycraft.content.TirphycraftRegistries;
import laz.tirphycraft.particle.GlintParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MOD_ID)
public class Tirphycraft
{
    public static final String MOD_ID = "tirphycraft";

    public static final TirphycraftGroup ITEM_GROUP = new TirphycraftGroup(MOD_ID + "_group");

    public Tirphycraft() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        TirphycraftRegistries.init(bus);
    }

    @Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
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
