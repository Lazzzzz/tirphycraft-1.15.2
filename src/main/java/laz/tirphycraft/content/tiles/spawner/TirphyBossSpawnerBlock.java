package laz.tirphycraft.content.tiles.spawner;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class TirphyBossSpawnerBlock extends Block {

	public TirphyBossSpawnerBlock() {
		super(Block.Properties.from(Blocks.BEDROCK));
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TirphyBossSpawnerTE();
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof TirphyBossSpawnerTE) return Block.makeCuboidShape(0,0,0,0,0,0);
		return super.getCollisionShape(state, worldIn, pos, context);
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.INVISIBLE;
	}
	
}
