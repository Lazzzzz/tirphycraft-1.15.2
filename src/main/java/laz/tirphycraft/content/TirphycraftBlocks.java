package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addBlockClass;
import static laz.tirphycraft.content.TirphycraftRegistries.addCubedBlock;
import static laz.tirphycraft.content.TirphycraftRegistries.addOnlyBlockClass;
import static laz.tirphycraft.content.TirphycraftRegistries.addTileEntity;

import laz.tirphycraft.content.blocks.froz.PowderSnowBlock;
import laz.tirphycraft.content.blocks.froz.PowderSnowLayerBlock;
import laz.tirphycraft.content.blocks.froz.RosePlantsBlock;
import laz.tirphycraft.content.blocks.laputa.CrystalBlock;
import laz.tirphycraft.content.blocks.laputa.flowers.LaputaBushBlock;
import laz.tirphycraft.content.blocks.laputa.flowers.LaputaTallGrassBlock;
import laz.tirphycraft.content.blocks.noxis.NoxisThornsBlock;
import laz.tirphycraft.content.blocks.plants.TirphycraftPlants;
import laz.tirphycraft.content.blocks.plants.TirphycraftSapling;
import laz.tirphycraft.content.blocks.teleporter.froz.TeleporterFrozBlock;
import laz.tirphycraft.content.blocks.teleporter.froz.__TeleporterFrozBlock;
import laz.tirphycraft.content.blocks.teleporter.laputa.TeleporterLaputaBlock;
import laz.tirphycraft.content.blocks.teleporter.laputa.__TeleporterLaputaBlock;
import laz.tirphycraft.content.tiles.altar.AltarBlock;
import laz.tirphycraft.content.tiles.altar.AltarTE;
import laz.tirphycraft.content.tiles.frozFurnace.FrozFurnaceBlock;
import laz.tirphycraft.content.tiles.frozFurnace.FrozFurnaceTE;
import laz.tirphycraft.util.TirphyColor;
import laz.tirphycraft.world.features.trees.CoppirTreeFeature;
import laz.tirphycraft.world.features.trees.FrozTreeFeature;
import laz.tirphycraft.world.features.trees.GoldirTreeFeature;
import laz.tirphycraft.world.features.trees.SilvirTreeFeature;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ToolType;

public class TirphycraftBlocks {


public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLOCK_PYRODES;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLOCK_HEAVY;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLOCK_NIXIUM;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLOCK_PICITE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLOCK_HISTICE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLOCK_COAL_ON_COKE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLOCK_METEORITE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BRICKS_METEORITE;//

public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_STONE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_STONE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_GRASS;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_DIRT;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_DIRT;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BASALT;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BLACK_CRYSTAL;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZEN_CRYSTAL;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_BLUE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_GREEN;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_YELLOW;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_PINK;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_PURPLE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_COAL_ON_COKE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_PYRODES;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_CRYSTAL;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_NIXIUM;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_TENIUM;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_PICITE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ORE_HISTICE_ICE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_COPPIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_SILVIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_GOLDIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_FROZ;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_SKY;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_DEAD;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_MUSHROOM;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LOG_STEM;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_COPPIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_SILVIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_GOLDIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_FROZ;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PLANKS_SKY;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LEAVES_COPPIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LEAVES_SILVIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LEAVES_GOLDIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LEAVES_FROZ;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LEAVES_SKY;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> SAPLING_COPPIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> SAPLING_SILVIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> SAPLING_GOLDIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> SAPLING_FROZ;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> SUN_STONE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_COBBLESTONE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_COBBLESTONE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_FLOWER1;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_FLOWER2;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_FLOWER3;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_FLOWER4;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_FLOWER5;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_FLOWER6;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> NOXIS_FLOWER1;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_FLOWER1;
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PETAL_BLUE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PETAL_GREEN;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PETAL_PURPLE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PETAL_RED;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> PETAL_YELLOW;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> POWDER_SNOW;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> POWDER_SNOW_LAYER;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ANCIENT_BLUE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ANCIENT_RED;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ANCIENT_WHITE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ANCIENT_YELLOW;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> ANCIENT_GREEN;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> STAIRS_COPPIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> STAIRS_SILIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> STAIRS_GOLDIR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> STAIRS_FROZ;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> NOXIS_COBBLESTONE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> NOXIS_BRICKS_CARVED;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> NOXIS_BRICKS_PILLAR;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> NOXIS_ASH_LIT;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BRICKS_NOXIS;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> NOXIS_STONE;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BRICKS_LAPUTA;//
public static BlockRegistryObjectGroup<Block, BlockItem, ?> BRICKS_FROZ;//

public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_TELEPORTER;
public static BlockRegistryObjectGroup<Block, BlockItem, ?> __FROZ_TELEPORTER;
public static BlockRegistryObjectGroup<Block, BlockItem, ?> FROZ_PORTAL_BRICK;


public static BlockRegistryObjectGroup<Block, BlockItem, ?> LAPUTA_TELEPORTER;
public static BlockRegistryObjectGroup<Block, BlockItem, ?> __LAPUTA_TELEPORTER;

public static BlockRegistryObjectGroup<Block, BlockItem, TileEntity> ALTAR;//
public static BlockRegistryObjectGroup<Block, BlockItem, TileEntity> FROZ_FURNACE;//


	public static void init(){

       BLOCK_PYRODES = addCubedBlock("block_pyrodes", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       BLOCK_HEAVY = addCubedBlock("block_heavy", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       BLOCK_NIXIUM = addCubedBlock("block_nixium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       BLOCK_COAL_ON_COKE = addCubedBlock("block_coal_on_coke", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       BLOCK_PICITE = addCubedBlock("block_picite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       BLOCK_HISTICE = addCubedBlock("block_histice_ice", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.METAL).harvestLevel(2));
       
       BLOCK_METEORITE = addCubedBlock("block_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
       BRICKS_METEORITE = addCubedBlock("brick_meteorite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 100).sound(SoundType.STONE).harvestLevel(2));
       
       ORE_COAL_ON_COKE = addCubedBlock("ore_coal_on_coke", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       ORE_PYRODES      = addCubedBlock("ore_pyrodes", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(1));
       ORE_CRYSTAL 		= addCubedBlock("ore_crystal", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(1));
       ORE_NIXIUM  		= addCubedBlock("ore_nixium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(2));
       ORE_PICITE		= addCubedBlock("ore_picite", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(3));
       ORE_TENIUM		= addCubedBlock("ore_tenium", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(3));
       ORE_HISTICE_ICE  = addCubedBlock("ore_histice_ice", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(1));
              
       FROZEN_CRYSTAL = addCubedBlock("frozen_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0));//
       BLACK_CRYSTAL  = addCubedBlock("black_crystal", Block.Properties.create(Material.GLASS).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 15).sound(SoundType.GLASS).harvestLevel(0)); //      
      
       LAPUTA_BLUE 	 = addBlockClass("laputa_blue", 	() -> new CrystalBlock(TirphyColor.BLUE));
       LAPUTA_PINK 	 = addBlockClass("laputa_pink", 	() -> new CrystalBlock(TirphyColor.PINK));
       LAPUTA_PURPLE = addBlockClass("laputa_purple",	() -> new CrystalBlock(TirphyColor.PURPLE));
       LAPUTA_YELLOW = addBlockClass("laputa_yellow", 	() -> new CrystalBlock(TirphyColor.YELLOW));
       LAPUTA_GREEN  = addBlockClass("laputa_green", 	() -> new CrystalBlock(TirphyColor.GREEN));
       
       LOG_COPPIR 	= addBlockClass("log_coppir", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_SILVIR 	= addBlockClass("log_silvir", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_GOLDIR 	= addBlockClass("log_goldir", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_FROZ   	= addBlockClass("log_froz", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_SKY		= addBlockClass("log_sky", 		() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_MUSHROOM = addBlockClass("log_mushroom", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_STEM 	= addBlockClass("log_stem", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       LOG_DEAD 	= addBlockClass("log_dead", 	() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
       
       PLANKS_COPPIR = addCubedBlock("planks_coppir", 	Block.Properties.from(Blocks.OAK_PLANKS));
       PLANKS_SILVIR = addCubedBlock("planks_silvir", 	Block.Properties.from(Blocks.OAK_PLANKS));
       PLANKS_GOLDIR = addCubedBlock("planks_goldir", 	Block.Properties.from(Blocks.OAK_PLANKS));
       PLANKS_FROZ   = addCubedBlock("planks_froz",  	Block.Properties.from(Blocks.OAK_PLANKS));
       PLANKS_SKY	 = addCubedBlock("planks_sky",  	Block.Properties.from(Blocks.OAK_PLANKS));
       
       LEAVES_COPPIR = addBlockClass("leaves_coppir", 	() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
       LEAVES_SILVIR = addBlockClass("leaves_silvir", 	() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
       LEAVES_GOLDIR = addBlockClass("leaves_goldir", 	() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
       LEAVES_FROZ	 = addBlockClass("leaves_froz", 	() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
       LEAVES_SKY	 = addBlockClass("leaves_sky", 		() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

   
       SAPLING_COPPIR = addBlockClass("sapling_coppir", () ->new TirphycraftSapling(() -> new CoppirTreeFeature(), Block.Properties.from(Blocks.OAK_SAPLING)));
       SAPLING_SILVIR = addBlockClass("sapling_silvir", () ->new TirphycraftSapling(() -> new SilvirTreeFeature(), Block.Properties.from(Blocks.OAK_SAPLING)));
       SAPLING_GOLDIR = addBlockClass("sapling_goldir", () ->new TirphycraftSapling(() -> new GoldirTreeFeature(), Block.Properties.from(Blocks.OAK_SAPLING)));
       SAPLING_FROZ	  = addBlockClass("sapling_froz", 	() ->new TirphycraftSapling(() -> new FrozTreeFeature(), Block.Properties.from(Blocks.OAK_SAPLING)));
              
       LAPUTA_FLOWER1 = addBlockClass("laputa_plant_grass", () -> new TirphycraftPlants(Effects.SATURATION, 7, Block.Properties.from(Blocks.DANDELION)));
       LAPUTA_FLOWER2 = addBlockClass("laputa_plant_grass_dark", () -> new TirphycraftPlants(Effects.SATURATION, 7, Block.Properties.from(Blocks.DANDELION)));
       LAPUTA_FLOWER3 = addBlockClass("laputa_fairy_flower", () -> new TirphycraftPlants(Effects.SATURATION, 7, Block.Properties.from(Blocks.DANDELION)));
       LAPUTA_FLOWER4 = addBlockClass("laputa_hydra_flower", () -> new TirphycraftPlants(Effects.SATURATION, 7, Block.Properties.from(Blocks.DANDELION)));
       LAPUTA_FLOWER5 = addBlockClass("laputa_bush", () -> new LaputaBushBlock(Effects.SATURATION, 7, Block.Properties.from(Blocks.DANDELION)));
       LAPUTA_FLOWER6 = addBlockClass("laputa_tall_grass", () -> new LaputaTallGrassBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT).tickRandomly()));
       NOXIS_FLOWER1 = addBlockClass("noxis_thorns", () -> new NoxisThornsBlock(Effects.WITHER, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT).tickRandomly()));
       FROZ_FLOWER1 = addBlockClass("majestic_rose", () -> new RosePlantsBlock(Effects.SLOWNESS, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT).tickRandomly()));
       
       
       PETAL_BLUE = addCubedBlock("petal_block_blue", Block.Properties.from(Blocks.CACTUS));    
       PETAL_RED = addCubedBlock("petal_block_red", Block.Properties.from(Blocks.CACTUS));    
       PETAL_YELLOW = addCubedBlock("petal_block_yellow", Block.Properties.from(Blocks.CACTUS));    
       PETAL_GREEN = addCubedBlock("petal_block_green", Block.Properties.from(Blocks.CACTUS));    
       PETAL_PURPLE = addCubedBlock("petal_block_purple", Block.Properties.from(Blocks.CACTUS));    
       
       STAIRS_COPPIR = addBlockClass("stairs_coppir", 	() -> new StairsBlock(() -> PLANKS_COPPIR.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       STAIRS_SILIR = addBlockClass("stairs_silvir", 	() -> new StairsBlock(() -> PLANKS_SILVIR.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       STAIRS_GOLDIR = addBlockClass("stairs_goldir", 	() -> new StairsBlock(() -> PLANKS_GOLDIR.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       STAIRS_FROZ = addBlockClass("stairs_froz", 	() -> new StairsBlock(() -> PLANKS_FROZ.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
       
       SUN_STONE = addCubedBlock("sun_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 10).sound(SoundType.STONE).harvestLevel(0).lightValue(15));
        
   
       FROZ_COBBLESTONE   = addCubedBlock("froz_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       LAPUTA_COBBLESTONE =  addCubedBlock("laputa_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       NOXIS_COBBLESTONE = addCubedBlock("noxis_cobblestone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
        
       NOXIS_STONE  = addCubedBlock("noxis_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       LAPUTA_STONE = addCubedBlock("laputa_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       FROZ_STONE   = addCubedBlock("froz_stone", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       BASALT = addCubedBlock("basalt", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       
       NOXIS_BRICKS_CARVED = addCubedBlock("noxis_bricks_carved", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       NOXIS_BRICKS_PILLAR = addCubedBlock("noxis_bricks_pillar", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0));
       
       NOXIS_ASH_LIT = addCubedBlock("noxis_ash_lit", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15).sound(SoundType.STONE).harvestLevel(0).lightValue(4));
       
       LAPUTA_GRASS = addCubedBlock("laputa_grass", Properties.from(Blocks.GRASS_BLOCK));
       LAPUTA_DIRT  = addCubedBlock("laputa_dirt", Block.Properties.create(Material.EARTH).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f, 0).sound(SoundType.GROUND));

       ANCIENT_BLUE   = addCubedBlock("ancient_stone_blue", Block.Properties.create(Material.GLASS).notSolid().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.GLASS).harvestLevel(0).notSolid());
       ANCIENT_WHITE  = addCubedBlock("ancient_stone_white", Block.Properties.create(Material.GLASS).notSolid().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.GLASS).harvestLevel(0).notSolid());
       ANCIENT_YELLOW = addCubedBlock("ancient_stone_yellow", Block.Properties.create(Material.GLASS).notSolid().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.GLASS).harvestLevel(0).notSolid());
       ANCIENT_RED 	  = addCubedBlock("ancient_stone_red", Block.Properties.create(Material.GLASS).notSolid().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.GLASS).harvestLevel(0).notSolid());
       ANCIENT_GREEN  = addCubedBlock("ancient_stone_green", Block.Properties.create(Material.GLASS).notSolid().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.GLASS).harvestLevel(0).notSolid());
         
       BRICKS_NOXIS = addCubedBlock("brick_noxis", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       BRICKS_LAPUTA = addCubedBlock("brick_laputa", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       BRICKS_FROZ = addCubedBlock("brick_froz", Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.6f, 15).sound(SoundType.STONE).harvestLevel(0));
       
       FROZ_PORTAL_BRICK = addCubedBlock("brick_froz_portal", Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.0F, 3600000.0F).noDrops());
    	   
       POWDER_SNOW 		 = addBlockClass("powder_snow", () -> new PowderSnowBlock(Block.Properties.from(Blocks.SNOW_BLOCK)));
       POWDER_SNOW_LAYER = addBlockClass("powder_snow_layer", () -> new PowderSnowLayerBlock(Block.Properties.from(Blocks.SNOW_BLOCK)));
       FROZ_DIRT 		 = addCubedBlock("froz_dirt", Block.Properties.from(Blocks.DIRT));
    
       FROZ_TELEPORTER = addOnlyBlockClass("froz_portal", () -> new TeleporterFrozBlock());
       __FROZ_TELEPORTER = addOnlyBlockClass("froz_portal_null", () -> new __TeleporterFrozBlock());
       
       LAPUTA_TELEPORTER = addOnlyBlockClass("laputa_portal", () -> new TeleporterLaputaBlock());
       __LAPUTA_TELEPORTER = addOnlyBlockClass("laputa_portal_null", () -> new __TeleporterLaputaBlock());
       
       ALTAR 		= addTileEntity("altar", AltarBlock::new, AltarTE::new);
       FROZ_FURNACE = addTileEntity("froz_furnace", FrozFurnaceBlock::new, FrozFurnaceTE::new);
    }

}
