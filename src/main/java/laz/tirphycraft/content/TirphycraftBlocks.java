package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addCubedBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TirphycraftBlocks {

    public static void init(){

        addCubedBlock("random_log", Block.Properties.create(Material.WOOD));

    }

}
