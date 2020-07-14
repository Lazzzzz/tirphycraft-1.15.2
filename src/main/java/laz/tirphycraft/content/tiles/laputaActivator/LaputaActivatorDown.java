package laz.tirphycraft.content.tiles.laputaActivator;

import javax.annotation.Nullable;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LaputaActivatorDown extends Block {

	public LaputaActivatorDown() {
		super(Block.Properties.from(Blocks.BEDROCK));
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new LaputaActivatorDownTE();
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			LaputaActivatorDownTE tile = (LaputaActivatorDownTE) worldIn.getTileEntity(pos);
			BlockPos center = tile.getCenter();
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_ACTIVATOR.get().getDefaultState());
			LaputaActivatorTE t = (LaputaActivatorTE) worldIn.getTileEntity(pos);
			t.setCenter(center);
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
}
