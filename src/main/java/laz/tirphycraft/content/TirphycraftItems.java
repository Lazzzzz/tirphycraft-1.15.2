package laz.tirphycraft.content;

import laz.tirphycraft.Teleporter;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

import static laz.tirphycraft.content.TirphycraftRegistries.addItemWClass;

public class TirphycraftItems {

    public static void init(){

        addItemWClass("teleporter", Teleporter::new);


    }

}
