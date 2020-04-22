package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addCubedBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.ToolType;

public class TirphycraftBlocks {

	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> NOXIS_COBBLESTONE;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_COBBLESTONE;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_COBBLESTONE;
	
    public static void init(){

        addCubedBlock("block_pyrodes", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
        addCubedBlock("block_heavy", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
        addCubedBlock("block_nixium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
        addCubedBlock("block_coal_on_coke", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(0));
        addCubedBlock("block_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
        addCubedBlock("brick_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
    
        addCubedBlock("frozen_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0));//
        addCubedBlock("black_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0)); //      
        addCubedBlock("sun_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 10).sound(SoundType.STONE).harvestLevel(0).lightValue(15));
        
        addCubedBlock("histoire_ice", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(1));
        
        FROZ_COBBLESTONE   = addCubedBlock("froz_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(1));
        LAPUTA_COBBLESTONE = addCubedBlock("laputa_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(1));
        NOXIS_COBBLESTONE  = addCubedBlock("noxis_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(1));
        
       addCubedBlock("noxis_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(1).lootFrom(NOXIS_COBBLESTONE.get().getBlock()));
    }
    
}
