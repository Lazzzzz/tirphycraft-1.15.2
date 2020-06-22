package laz.tirphycraft.datagen.lang;

import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.content.TirphycraftRegistries.BIOMELIST;
import static laz.tirphycraft.content.TirphycraftRegistries.ITEMLIST;
import static laz.tirphycraft.content.TirphycraftRegistries.SIMPLE;
import static laz.tirphycraft.content.TirphycraftRegistries.TILES;

import org.apache.commons.lang3.text.WordUtils;

import laz.tirphycraft.content.BlockRegistryObjectGroup;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public class TirphyLang extends LanguageProvider {

    public TirphyLang(DataGenerator gen) {
        super(gen, MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (BlockRegistryObjectGroup simple : SIMPLE) {
            if (simple != null) {
                this.addItem(simple::getItem, WordUtils.capitalizeFully(simple.getName().replace("_", " ")));
            }
        }
        for (BlockRegistryObjectGroup tiles : TILES) {
            if (tiles != null) {
                this.addItem(tiles::getItem, WordUtils.capitalizeFully(tiles.getName().replace("_", " ")));
            }
        }
        for (RegistryObject<Item> item : ITEMLIST) {
            if (item != null) {
                this.addItem(item, WordUtils.capitalizeFully(item.getId().getPath().replace("_", " ")));
            }
        }
        for (RegistryObject<Biome> biome : BIOMELIST) {
            if (biome != null) {
                this.addBiome(biome, WordUtils.capitalizeFully(biome.getId().getPath().replace("_", " ")));
            }
        }
    }
}
