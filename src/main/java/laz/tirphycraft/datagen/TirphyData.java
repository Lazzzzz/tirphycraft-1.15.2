package laz.tirphycraft.datagen;

import static laz.tirphycraft.Tirphycraft.MOD_ID;

import laz.tirphycraft.content.TirphycraftRegistries;
import laz.tirphycraft.datagen.lang.TirphyLang;
import laz.tirphycraft.datagen.loot.TirphyLootsProvider;
import laz.tirphycraft.datagen.recipes.TirphyRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TirphyData {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        final DataGenerator dataGenerator = event.getGenerator();
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            dataGenerator.addProvider(new TirphyLang(dataGenerator));
            dataGenerator.addProvider(new TirphyLootsProvider(dataGenerator));
            dataGenerator.addProvider(new TirphyRecipeProvider(dataGenerator));
        }
    }

}
