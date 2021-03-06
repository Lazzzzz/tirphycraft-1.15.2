package laz.tirphycraft.registry;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;

import java.util.function.Function;
import java.util.function.Supplier;

import laz.tirphycraft.content.blocks.fluids.CO2Fluid;
import laz.tirphycraft.registry.init.TirphycraftBiomes;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftContainer;
import laz.tirphycraft.registry.init.TirphycraftDimensions;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.fixes.ItemSpawnEggSplit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TirphycraftRegistries {

	public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, MOD_ID);
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(
			ForgeRegistries.PARTICLE_TYPES, MOD_ID);
	public static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(
			ForgeRegistries.MOD_DIMENSIONS, MOD_ID);
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES,
			MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			MOD_ID);
	public static final DeferredRegister<Biome> TIRPH_BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, MOD_ID);
	
	public static final DeferredRegister<ContainerType<?>> TIRPHY_CONTAINER = new DeferredRegister<>(ForgeRegistries.CONTAINERS, MOD_ID);

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
		FLUIDS.register(eventBus);
		TIRPHY_CONTAINER.register(eventBus);

	}

	public static void init(IEventBus eventBus) {
		TirphycraftBlocks.init();
		TirphycraftItems.init();
		TirphycraftEntities.init();
		TirphycraftDimensions.init();
		TirphycraftContainer.init();
		TirphycraftBiomes.init();
		register(eventBus);

	}

	public static final FluidRegistryObjectGroup<ForgeFlowingFluid.Source, ForgeFlowingFluid.Flowing> CO2 = new FluidRegistryObjectGroup<>(
			"co2", () -> new ForgeFlowingFluid.Source(TirphycraftRegistries.CO2_PROPERTIES),
			() -> new ForgeFlowingFluid.Flowing(TirphycraftRegistries.CO2_PROPERTIES),
			() -> new CO2Fluid(Block.Properties.from(Blocks.WATER))).register(FLUIDS, BLOCKS, ITEMS);

	public static final ForgeFlowingFluid.Properties CO2_PROPERTIES = new ForgeFlowingFluid.Properties(CO2,
			CO2::getFlowing,
			FluidAttributes
					.builder(new ResourceLocation("minecraft", "block/water_still"),
							new ResourceLocation("minecraft", "block/water_flow"))
					.overlay(new ResourceLocation("minecraft", "block/water_overlay")).color(6251102))
							.block(CO2::getBlock).bucket(CO2::getBucket);

	public static BlockRegistryObjectGroup<Block, BlockItem, ?> addCubedBlock(String name,
			Block.Properties properties) {
		SIMPLE_INT = ++SIMPLE_INT;
		return SIMPLE[SIMPLE_INT - 1] = new BlockRegistryObjectGroup<>(name, () -> new Block(properties),
				blockItemCreator()).register(BLOCKS, ITEMS);
	}

	public static BlockRegistryObjectGroup<Block, BlockItem, ?> addBlockClass(String name,
			Supplier<Block> blockSupplier) {
		SIMPLE_INT = ++SIMPLE_INT;
		return SIMPLE[SIMPLE_INT - 1] = new BlockRegistryObjectGroup<>(name, blockSupplier, blockItemCreator())
				.register(BLOCKS, ITEMS);
	}
	
	public static BlockRegistryObjectGroup<Block, BlockItem, ?> addOnlyBlockClass(String name,	Supplier<Block> blockSupplier) {
		SIMPLE_INT = ++SIMPLE_INT;
		return SIMPLE[SIMPLE_INT - 1] = new BlockRegistryObjectGroup<>(name, blockSupplier, blockItemCreatorNoTab())
				.register(BLOCKS, ITEMS);
	}	
	
	private static <B extends Block> Function<B, BlockItem> blockItemCreator() {
		return block -> new BlockItem(block, new Item.Properties().group(ITEM_GROUP));
	}

	private static <B extends Block> Function<B, BlockItem> blockItemCreatorNoTab() {
		return block -> new BlockItem(block, new Item.Properties());
	}
	
	public static RegistryObject<Item> addItemClass(String name, Supplier<Item> itemSupplier) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name, itemSupplier);
	}

	public static RegistryObject<Item> addSimpleItem(String name, int size) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name,
				() -> new Item(new Item.Properties().group(ITEM_GROUP).maxStackSize(size)));
	}
	
	public static RegistryObject<Item> addSpawnEggs(EntityType<?> type, int color1, int color2, String name) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name,
				() -> new SpawnEggItem(type, color1, color2, new Item.Properties().group(ITEM_GROUP).maxStackSize(1)));
	}

	public static RegistryObject<Item> addSimpleFood(String name, int food) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name, () -> new Item(new Item.Properties().group(ITEM_GROUP)
				.food(new Food.Builder().hunger(food).saturation(food).build())));
	}

	public static RegistryObject<Item> addAxe(String name, IItemTier tier) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_axe",
				() -> new AxeItem(tier, 5.0F, -3.0F, (new Item.Properties()).group(ITEM_GROUP)));
	}
	public static RegistryObject<Item> addPickaxe(String name, IItemTier tier) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_pickaxe",
				() -> new PickaxeItem(tier, 1, -2.8F, (new Item.Properties()).group(ITEM_GROUP)));
	}
	public static RegistryObject<Item> addSword(String name, IItemTier tier) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_sword",
				() -> new SwordItem(tier, 3, -2.4F, (new Item.Properties()).group(ITEM_GROUP)));
	}
	public static RegistryObject<Item> addShovel(String name, IItemTier tier) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_shovel",
				() -> new ShovelItem(tier, 1.5F, -3.0F, (new Item.Properties()).group(ITEM_GROUP)));
	}
	
	public static RegistryObject<Item> addHoe(String name, IItemTier tier) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_hoe",
				() -> new HoeItem(tier, -1F, (new Item.Properties()).group(ITEM_GROUP)));
	}

	
	
	public static RegistryObject<Item> addFeet(String name, Item item) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_boots", () -> item);
	}

	public static RegistryObject<Item> addLegs(String name, Item item) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_leggings", () -> item);
	}

	public static RegistryObject<Item> addChest(String name, Item item) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_chestplate", () -> item);
	}

	public static RegistryObject<Item> addHead(String name, Item item) {
		ITEMLIST_INT = ++ITEMLIST_INT;
		return ITEMLIST[ITEMLIST_INT - 1] = ITEMS.register(name + "_helmet", () -> item);
	}

	public static void addArmor(String name, Item feet, Item legs, Item chest, Item head) {
		addFeet(name, feet);
		addLegs(name, legs);
		addChest(name, chest);
		addHead(name, head);
	}

	public static RegistryObject<Biome> addBiome(String name, Supplier<Biome> biomeSupplier) {
		BIOMES_INT = ++BIOMES_INT;
		return BIOMELIST[BIOMES_INT] = TIRPH_BIOMES.register(name, biomeSupplier);
	}
	
	public static BlockRegistryObjectGroup<Block, BlockItem, TileEntity> addTileEntity(String name,
			Supplier<Block> blockSupplier, Supplier<TileEntity> tileSupplier) {
		TILE_INT = ++TILE_INT;
		return TILES[TILE_INT - 1] = new BlockRegistryObjectGroup<>(name, blockSupplier, tileItemCreator(1),
				tileSupplier).register(BLOCKS, ITEMS, TILE_ENTITIES);
	}

	public static BlockRegistryObjectGroup<Block, BlockItem, TileEntity> addTileEntityWStackSize(String name, int size,
			Supplier<Block> blockSupplier, Supplier<TileEntity> tileSupplier) {
		TILE_INT = ++TILE_INT;
		return TILES[TILE_INT - 1] = new BlockRegistryObjectGroup<>(name, blockSupplier, tileItemCreator(size),
				tileSupplier).register(BLOCKS, ITEMS, TILE_ENTITIES);
	}

	private static <B extends Block> Function<B, BlockItem> tileItemCreator(int size) {
		return block -> new BlockItem(block, new Item.Properties().maxStackSize(size).group(ITEM_GROUP));
	}
	
}
