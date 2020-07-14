package laz.tirphycraft.content.tiles.altar;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class AltarBlock extends Block {

	public AltarBlock() {
		super(Block.Properties.from(Blocks.STONE));
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new AltarTE();
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
}
