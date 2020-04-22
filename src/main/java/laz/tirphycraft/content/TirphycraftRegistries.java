package laz.tirphycraft.content;

import laz.tirphycraft.Tirphycraft;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

import java.util.function.Function;
import java.util.function.Supplier;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;

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

        TirphycraftBiomes.init();

        register(eventBus);
    }

    public static BlockRegistryObjectGroup<Block, BlockItem, ?> addCubedBlock(String name, Block.Properties properties) {
        SIMPLE_INT = ++SIMPLE_INT;
        return SIMPLE[SIMPLE_INT - 1] = new BlockRegistryObjectGroup<>(name,
                () -> new Block(properties), blockItemCreator())
                .register(BLOCKS, ITEMS);
    }

    private static <B extends Block> Function<B, BlockItem> blockItemCreator() {
        return block -> new BlockItem(block, new Item.Properties().group(ITEM_GROUP));
    }

    public static RegistryObject<Item> addItemWClass(String name, Supplier<Item> itemSupplier) {
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name, itemSupplier);
    }

    public static RegistryObject<Item> addSimpleItem(String name) {
        ITEMLIST_INT = ++ITEMLIST_INT;
        return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name, () -> new Item(new Item.Properties().group(ITEM_GROUP)));
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
