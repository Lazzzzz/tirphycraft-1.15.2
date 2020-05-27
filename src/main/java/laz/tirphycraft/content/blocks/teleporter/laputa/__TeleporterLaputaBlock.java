package laz.tirphycraft.content.blocks.teleporter.laputa;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class __TeleporterLaputaBlock extends TeleporterLaputaBlock {

	protected static final VoxelShape NULL_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0D, 0, 0, 0D);

	public __TeleporterLaputaBlock() {

	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.INVISIBLE;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return NULL_AABB;
	}

	
	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
	}

}
