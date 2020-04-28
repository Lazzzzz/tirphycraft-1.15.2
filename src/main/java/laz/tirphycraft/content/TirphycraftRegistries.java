package laz.tirphycraft.content;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;

import java.util.function.Function;
import java.util.function.Supplier;

import laz.tirphycraft.content.blocks.saplings.TirphycraftSapling;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.trees.Tree;
import net.minecraft.entity.EntityType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TirphycraftRegistries {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(ForgeRegistries.PARTICLE_TYPES, MOD_ID);
    public static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = new DeferredRegister<>(ForgeRegistries.ENTITIES, MOD_ID);
    public static final DeferredRegister<Biome> TIRPH_BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, MOD_ID);

    public static int SIMPLE_INT = 0;
    public static int ITEMLIST_INT = 0;
    public static int BIOMES_INT = 0;
    public static int TILE_INT = 0;

    public static final BlockRegistryObjectGroup<Block, BlockItem, ?>[] SIMPLE = new BlockRegistryObjectGroup[2000];
    public static final RegistryObject<Item>[] ITEMLIST = new RegistryObject[1000];
    public static final RegistryObject<Biome>[] BIOMELIST = new RegistryObject[150];
    public static final BlockRegistryObjectGroup<Block, BlockItem, TileEntity>[] TILES = new BlockRegistryObjectGroup[500];

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        TILE_ENTITIES.register(eventBus);
        FEATURES.register(eventBus);
        PARTICLE_TYPES.register(eventBus);
        ENTITY_TYPE.register(eventBus);
        TIRPH_BIOMES.register(eventBus);
        DIMENSIONS.register(eventBus);
    }

    public static void init(IEventBus eventBus){
        TirphycraftBlocks.init();
        TirphycraftItems.init();
        TirphycraftDimensions.init();
        TirphycraftBiomes.init();

        register(eventBus);
    }

    public static BlockRegistryObjectGroup<Block, BlockItem, ?> addCubedBlock(String name, Block.Properties properties) {
        SIMPLE_INT = ++SIMPLE_INT;
        return SIMPLE[SIMPLE_INT - 1] = new BlockRegistryObjectGroup<>(name,
                () -> new Block(properties), blockItemCreator())
                .register(BLOCKS, ITEMS);
    }
    
    public static BlockRegistryObjectGroup<Block, BlockItem, ?> addBlockClass(String name, Supplier<Block> blockSupplier) {
        SIMPLE_INT = ++SIMPLE_INT;
        return SIMPLE[SIMPLE_INT - 1] = new BlockRegistryObjectGroup<>(name,
                blockSupplier, blockItemCreator())
                .register(BLOCKS, ITEMS);
    }
    
    private static <B extends Block> Function<B, BlockItem> blockItemCreator() {
        return block -> new BlockItem(block, new Item.Properties().group(ITEM_GROUP));
    }

    public static RegistryObject<Item> addItemClass(String name, Supplier<Item> itemSupplier) {
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name, itemSupplier);
    }

    public static RegistryObject<Item> addSimpleItem(String name, int size) {
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name, () -> new Item(new Item.Properties().group(ITEM_GROUP).maxStackSize(size)));
    }
    
    public static RegistryObject<Item> addSimpleFood(String name, int food) {
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name, () -> new Item(new Item.Properties().group(ITEM_GROUP).food(new Food.Builder().hunger(food).saturation(food).build())));
    }
    
    public static void addTools(String name, IItemTier tier) {
        ITEMLIST_INT = ++ITEMLIST_INT;
        ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_axe", () -> new AxeItem(tier, 5.0F, -3.0F, (new Item.Properties()).group(ITEM_GROUP)));
        ITEMLIST_INT = ++ITEMLIST_INT;
        ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_pickaxe", () -> new PickaxeItem(tier, 1, -2.8F, (new Item.Properties()).group(ITEM_GROUP)));
        ITEMLIST_INT = ++ITEMLIST_INT;
        ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_sword", () -> new SwordItem(tier, 3, -2.4F, (new Item.Properties()).group(ITEM_GROUP)));
        ITEMLIST_INT = ++ITEMLIST_INT;
        ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_shovel", () -> new ShovelItem(tier, 1.5F, -3.0F, (new Item.Properties()).group(ITEM_GROUP)));
        ITEMLIST_INT = ++ITEMLIST_INT;
        ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_hoe", () -> new HoeItem(tier, -1F, (new Item.Properties()).group(ITEM_GROUP)));
    }

    public static RegistryObject<Item> addFeet(String name, Item item){
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_boots", () -> item);
    }
    
    public static RegistryObject<Item> addLegs(String name, Item item){
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_leggings", () -> item);
    }
    
    public static RegistryObject<Item> addChest(String name, Item item){
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_chestplate", () -> item);
    }
    
    public static RegistryObject<Item> addHead(String name, Item item){
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_helmet", () -> item);
    }
    
    public static void addArmor(String name, Item feet, Item legs, Item chest, Item head){
        addFeet(name, feet);
        addLegs(name, legs);
        addChest(name, chest);
        addHead(name, head);
    }
    
    public static RegistryObject<Biome> addBiome(String name, Supplier<Biome> biomeSupplier){
        BIOMES_INT = ++BIOMES_INT;
        return BIOMELIST[BIOMES_INT] = TIRPH_BIOMES.register(name, biomeSupplier);
    }

    public static BlockRegistryObjectGroup<Block,BlockItem, TileEntity> addTileEntity(String name, Supplier<Block> blockSupplier, Supplier<TileEntity> tileSupplier){
        TILE_INT = ++TILE_INT;
        return TILES[TILE_INT - 1] = new BlockRegistryObjectGroup<>(name,blockSupplier,tileItemCreator(1),tileSupplier).register(BLOCKS,ITEMS,TILE_ENTITIES);
    }

    public static BlockRegistryObjectGroup<Block,BlockItem, TileEntity> addTileEntityWStackSize(String name, int size,Supplier<Block> blockSupplier, Supplier<TileEntity> tileSupplier){
        TILE_INT = ++TILE_INT;
        return TILES[TILE_INT - 1] = new BlockRegistryObjectGroup<>(name,blockSupplier,tileItemCreator(size),tileSupplier).register(BLOCKS,ITEMS,TILE_ENTITIES);
    }

    private static <B extends Block> Function<B, BlockItem> tileItemCreator(int size) {
        return block -> new BlockItem(block, new Item.Properties().maxStackSize(size).group(ITEM_GROUP));
    }

}
