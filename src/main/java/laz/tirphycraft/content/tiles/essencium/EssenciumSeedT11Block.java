package laz.tirphycraft.content.tiles.essencium;

import javax.annotation.Nullable;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class EssenciumSeedT11Block extends Block {

	public EssenciumSeedT11Block() {
		super(Block.Properties.from(TirphycraftBlocks.SACRED_DIRT.get()));
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new EssenciumSeedTileBase(3, 1, 0, TirphycraftBlocks.SEEDT11.getTileEntityType());
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

}