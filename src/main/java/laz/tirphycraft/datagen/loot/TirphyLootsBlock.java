package laz.tirphycraft.datagen.loot;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Nonnull;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.registries.ForgeRegistries;

public class TirphyLootsBlock extends BlockLootTables {
    
	@Override
    @Nonnull
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> Optional.ofNullable(block.getRegistryName())
        										 .filter(registryName -> registryName.getNamespace().equals(Tirphycraft.MOD_ID))
        										 .isPresent()).collect(Collectors.toList());
    }

    @Override
    protected void addTables() {
        this.registerDropSelfLootTable(TirphycraftBlocks.BLACK_CRYSTAL.getBlock());
    }
}