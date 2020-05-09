package laz.tirphycraft.content.tileEntities.altar;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class AltarBlock extends Block {

	public AltarBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new AltarTE();
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
}
