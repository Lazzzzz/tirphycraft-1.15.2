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

//	@Override
//	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
//		TileEntity tile = world.getTileEntity(pos);
//		ItemStack stack = player.getHeldItem(hand);
//		if(tile instanceof AltarTE){
//			if (stack.getItem() == TirphycraftItems.FRAGMENT_BLUE.get()) ((AltarTE) tile).insertItem(0, stack);
//			if (stack.getItem() == TirphycraftItems.FRAGMENT_RED.get()) ((AltarTE) tile).insertItem(1, stack);
//			if (stack.getItem() == TirphycraftItems.FRAGMENT_GREEN.get()) ((AltarTE) tile).insertItem(2, stack);
//			if (stack.getItem() == TirphycraftItems.FRAGMENT_YELLOW.get()) ((AltarTE) tile).insertItem(3, stack);
//			if (stack.getItem() == TirphycraftItems.FRAGMENT_WHITE.get()) ((AltarTE) tile).insertItem(4, stack);
//			return ActionResultType.SUCCESS;
//		}
//		return ActionResultType.FAIL;
//	}

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
