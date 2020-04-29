package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addBlockClass;
import static laz.tirphycraft.content.TirphycraftRegistries.addCubedBlock;

import laz.tirphycraft.content.blocks.laputa.CrystalBlock;
import laz.tirphycraft.content.blocks.saplings.TirphycraftSapling;
import laz.tirphycraft.util.TirphyColor;
import laz.tirphycraft.world.features.trees.CoppirTreeFeature;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.ToolType;
public class TirphycraftBlocks {

	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_STONE;
	 
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_GRASS;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_DIRT;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_STONE;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLACK_CRYSTAL;
	 
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_BLUE;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_GREEN;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_YELLOW;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_PINK;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_PURPLE;
	 
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_COAL_ON_COKE;	
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_PYRODES;	
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_CRYSTAL;	
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_NIXIUM;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_TENIUM;	
	 
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_COPPIR;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_SILVIR;	
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_GOLDIR;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_FROZ;	
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_MUSHROOM;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_STEM;

	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_COPPIR;	
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_SILVIR;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_GOLDIR;
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_FROZ;
	 
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> SAPLING_COPPIR; 
	 
	 public static BlockRegistryObjectGroup<Block, BlockItem, ?> SUN_STONE; 
	 
	 
	 
    public static void init(){

       addCubedBlock("block_pyrodes", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       addCubedBlock("block_heavy", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       addCubedBlock("block_nixium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       addCubedBlock("block_coal_on_coke", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(0));
       addCubedBlock("block_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
       addCubedBlock("brick_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
       
       ORE_COAL_ON_COKE = addCubedBlock("ore_coal_on_coke", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       ORE_PYRODES      = addCubedBlock("ore_pyrodes", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(1));
       ORE_CRYSTAL 		= addCubedBlock("ore_crystal", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(1));
       ORE_NIXIUM  		= addCubedBlock("ore_nixium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(2));
       ORE_TENIUM		= addCubedBlock("ore_tenium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(3));
       
       addCubedBlock("frozen_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0));//
       BLACK_CRYSTAL = addCubedBlock("black_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0)); //      
      
       LAPUTA_BLUE 	 = addBlockClass("laputa_blue", 	() -> new CrystalBlock(TirphyColor.BLUE));
       LAPUTA_PINK 	 = addBlockClass("laputa_pink", 	() -> new CrystalBlock(TirphyColor.PINK));
       LAPUTA_PURPLE = addBlockClass("laputa_purple",	() -> new CrystalBlock(TirphyColor.PURPLE));
       LAPUTA_YELLOW = addBlockClass("laputa_yellow", 	() -> new CrystalBlock(TirphyColor.YELLOW));
       LAPUTA_GREEN  = addBlockClass("laputa_green", 	() -> new CrystalBlock(TirphyColor.GREEN));
       
       LOG_COPPIR 	= addBlockClass("log_coppir", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_SILVIR 	= addBlockClass("log_silvir", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_GOLDIR 	= addBlockClass("log_goldir", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_FROZ   	= addBlockClass("log_froz", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_MUSHROOM = addBlockClass("log_mushroom", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_STEM 	= addBlockClass("log_stem", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       
       PLANKS_COPPIR = addCubedBlock("planks_coppir", 	Block.Properties.from(Blocks.OAK_PLANKS));
       PLANKS_SILVIR = addCubedBlock("planks_silvir", 	Block.Properties.from(Blocks.OAK_PLANKS));
       PLANKS_GOLDIR = addCubedBlock("planks_goldir", 	Block.Properties.from(Blocks.OAK_PLANKS));
       PLANKS_FROZ   = addCubedBlock("planks_froz",  	Block.Properties.from(Blocks.OAK_PLANKS));
       
       addBlockClass("stairs_coppir", 	() -> new StairsBlock(() -> PLANKS_COPPIR.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       addBlockClass("stairs_silvir", 	() -> new StairsBlock(() -> PLANKS_SILVIR.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       addBlockClass("stairs_goldir", 	() -> new StairsBlock(() -> PLANKS_GOLDIR.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       addBlockClass("stairs_froz", 	() -> new StairsBlock(() -> PLANKS_FROZ.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       
       SAPLING_COPPIR = addBlockClass("coppir_sapling", () ->new TirphycraftSapling(() -> new CoppirTreeFeature(), Block.Properties.from(Blocks.OAK_SAPLING)));
       
       SUN_STONE = addCubedBlock("sun_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 10).sound(SoundType.STONE).harvestLevel(0).lightValue(15));
        
       addCubedBlock("histoire_ice", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(1));
        
       addCubedBlock("froz_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("laputa_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("noxis_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
        
       addCubedBlock("noxis_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       LAPUTA_STONE = addCubedBlock("laputa_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       FROZ_STONE   = addCubedBlock("froz_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       
       addCubedBlock("noxis_bricks_carved", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("noxis_bricks_pillar", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       
       addCubedBlock("noxis_ash_lit", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0).lightValue(4));
       
       LAPUTA_GRASS = addCubedBlock("laputa_grass", Properties.from(Blocks.GRASS_BLOCK));
       LAPUTA_DIRT  = addCubedBlock("laputa_dirt", Block.Properties.create(Material.GOURD).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f, 0).sound(SoundType.GROUND));

     
       addCubedBlock("brick_noxis", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("brick_laputa", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       addCubedBlock("brick_froz", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       
    }
    
}
