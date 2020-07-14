package laz.tirphycraft.content.tiles.laputaActivator;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class LaputaActivator extends Block {

	public LaputaActivator() {
		super(Block.Properties.from(Blocks.BEDROCK));
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new LaputaActivatorTE();
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
}
