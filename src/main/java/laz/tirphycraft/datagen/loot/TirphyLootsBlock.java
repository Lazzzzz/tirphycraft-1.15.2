package laz.tirphycraft.datagen.loot;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.TirphycraftRegistries;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

public class TirphyLootsBlock extends BlockLootTables {

	@Override
	@Nonnull
	protected Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream()
				.filter(block -> Optional.ofNullable(block.getRegistryName())
						.filter(registryName -> registryName.getNamespace().equals(Tirphycraft.MOD_ID)).isPresent())
				.collect(Collectors.toList());
	}

	@Override
	protected void addTables() {

		this.registerLootTable(TirphycraftBlocks.FROZ_STONE.getBlock(), (p_218490_0_) -> {
			return droppingWithSilkTouch(p_218490_0_, TirphycraftBlocks.FROZ_COBBLESTONE.getBlock());
		});

		this.registerLootTable(TirphycraftBlocks.NOXIS_FIRE.getBlock(), (p_218490_0_) -> {
			return droppingWithSilkTouch(p_218490_0_, TirphycraftBlocks.NOXIS_COBBLESTONE.getBlock());
		});

		this.registerLootTable(TirphycraftBlocks.LOG_DEAD.getBlock(), (p_218490_0_) -> {
			return droppingWithSilkTouch(p_218490_0_, TirphycraftBlocks.LOG_DEAD.getBlock());
		});
		this.registerLootTable(TirphycraftBlocks.LAPUTA_STONE.getBlock(), (p_218490_0_) -> {
			return droppingWithSilkTouch(p_218490_0_, TirphycraftBlocks.LAPUTA_COBBLESTONE.getBlock());
		});
		this.registerLootTable(TirphycraftBlocks.LAPUTA_GRASS.getBlock(), (p_218490_0_) -> {
			return droppingWithSilkTouch(p_218490_0_, TirphycraftBlocks.LAPUTA_DIRT.getBlock());
		});
		this.registerLootTable(TirphycraftBlocks.NOXIS_STONE.getBlock(), (p_218490_0_) -> {
			return droppingWithSilkTouch(p_218490_0_, TirphycraftBlocks.NOXIS_COBBLESTONE.getBlock());
		});
		this.registerLootTable(TirphycraftBlocks.NOXIS_ASH_LIT.getBlock(), (p_218490_0_) -> {
			return droppingWithSilkTouch(p_218490_0_, TirphycraftBlocks.NOXIS_COBBLESTONE.getBlock());
		});

		this.registerLootTable(TirphycraftBlocks.ORE_COAL_ON_COKE.getBlock(), (p_218548_0_) -> {
			return droppingItemWithFortune(p_218548_0_, TirphycraftItems.COAL_ON_COKE.get());
		});

		this.registerLootTable(TirphycraftBlocks.ORE_PYRODES.getBlock(), (p_218548_0_) -> {
			return droppingItemWithFortune(p_218548_0_, TirphycraftItems.CRYSTAL_PURODES.get());
		});

		this.registerLootTable(TirphycraftBlocks.ORE_CRYSTAL.getBlock(), (p_218548_0_) -> {
			return droppingItemWithFortune(p_218548_0_, TirphycraftItems.CRYSTAL.get());
		});

		this.registerLootTable(TirphycraftBlocks.FROZ_FLOWER1.getBlock(), (p_218548_0_) -> {
			return droppingItemWithFortune(p_218548_0_, TirphycraftItems.BLUE_ROSE_PETAL.get());
		});

		this.registerLootTable(TirphycraftBlocks.ORE_HISTICE_ICE.getBlock(), (p_218548_0_) -> {
			return droppingItemWithFortune(p_218548_0_, TirphycraftItems.HISTICE_GEM.get());
		});

		this.registerLootTable(TirphycraftBlocks.FROZ_DUNGEON_SPIKE.getBlock(), (p_218548_0_) -> {
			return droppingItemWithFortune(p_218548_0_, Items.BONE);
		});

		this.registerDropSelfLootTable(TirphycraftBlocks.BLOCK_PYRODES.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BLOCK_HEAVY.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BLOCK_NIXIUM.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BLOCK_COAL_ON_COKE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BLOCK_PICITE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BLOCK_HISTICE.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.BASALT.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.FROZ_FURNACE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BOSS_SPAWNER_0.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.BLOCK_METEORITE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BRICKS_METEORITE.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.LAPUTA_DIRT.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.FROZ_DIRT.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.ORE_NIXIUM.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.ORE_TENIUM.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.LOG_COPPIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LOG_SILVIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LOG_GOLDIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LOG_FROZ.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LOG_SKY.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LOG_MUSHROOM.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LOG_STEM.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.PLANKS_COPPIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.PLANKS_SILVIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.PLANKS_GOLDIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.PLANKS_FROZ.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.PLANKS_SKY.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.LEAVES_COPPIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LEAVES_SILVIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LEAVES_GOLDIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LEAVES_FROZ.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LEAVES_SKY.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.SAPLING_COPPIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.SAPLING_SILVIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.SAPLING_GOLDIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.SAPLING_FROZ.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.SUN_STONE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.LAPUTA_COBBLESTONE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.FROZ_COBBLESTONE.getBlock());

		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_FLOWER1.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_FLOWER2.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_FLOWER3.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_FLOWER4.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_FLOWER5.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_FLOWER6.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.NOXIS_FLOWER1.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.PETAL_BLUE.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.PETAL_GREEN.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.PETAL_PURPLE.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.PETAL_RED.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.PETAL_YELLOW.getBlock());

		this.registerSilkTouch(TirphycraftBlocks.POWDER_SNOW.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.POWDER_SNOW_LAYER.getBlock());

		this.registerSilkTouch(TirphycraftBlocks.BLACK_CRYSTAL.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.FROZEN_CRYSTAL.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_BLUE.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_GREEN.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_YELLOW.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_PINK.getBlock());
		this.registerSilkTouch(TirphycraftBlocks.LAPUTA_PURPLE.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.ANCIENT_BLUE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.ANCIENT_RED.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.ANCIENT_WHITE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.ANCIENT_YELLOW.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.ANCIENT_GREEN.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.STAIRS_COPPIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.STAIRS_SILIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.STAIRS_GOLDIR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.STAIRS_FROZ.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.ORE_PICITE.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.NOXIS_COBBLESTONE.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.NOXIS_BRICKS_CARVED.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.NOXIS_BRICKS_PILLAR.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BRICKS_NOXIS.getBlock());

		this.registerDropSelfLootTable(TirphycraftBlocks.BRICKS_LAPUTA.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.BRICKS_FROZ.getBlock());
		this.registerDropSelfLootTable(TirphycraftBlocks.ALTAR.getBlock());

		this.registerDropSelfLootTable(TirphycraftRegistries.CO2.getBlock());
	}
}