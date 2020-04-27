package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addCubedBlock;

import laz.tirphycraft.content.blocks.laputa.CrystalBlock;

import static laz.tirphycraft.content.TirphycraftRegistries.addBlockClass;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.ToolType;

public class TirphycraftBlocks {

	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_STONE;
	 
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_GRASS;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_DIRT;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_STONE;
	  public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLACK_CRYSTAL;
	
    public static void init(){

       addCubedBlock("block_pyrodes", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       addCubedBlock("block_heavy", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       addCubedBlock("block_nixium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       addCubedBlock("block_coal_on_coke", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(0));
       addCubedBlock("block_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
       addCubedBlock("brick_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
    
       addCubedBlock("frozen_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0));//
       BLACK_CRYSTAL = addCubedBlock("black_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0)); //      
       addBlockClass("laputa_blue", () -> new CrystalBlock());
       
       addCubedBlock("sun_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 10).sound(SoundType.STONE).harvestLevel(0).lightValue(15));
        
       addCubedBlock("histoire_ice", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(1));
        
       addCubedBlock("froz_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("laputa_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("noxis_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
        
       addCubedBlock("noxis_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       LAPUTA_STONE = addCubedBlock("laputa_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("froz_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       
       addCubedBlock("noxis_bricks_carved", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("noxis_bricks_pillar", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       
       addCubedBlock("noxis_ash_lit", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0).lightValue(4));
       
       LAPUTA_GRASS = addCubedBlock("laputa_grass", Block.Properties.create(Material.GOURD).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.6f, 0).sound(SoundType.GROUND));
       LAPUTA_DIRT  = addCubedBlock("laputa_dirt", Block.Properties.create(Material.GOURD).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f, 0).sound(SoundType.GROUND));

     
       addCubedBlock("brick_noxis", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("brick_laputa", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("brick_froz", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       
    }
    
}
