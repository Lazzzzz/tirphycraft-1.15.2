package laz.tirphycraft.content.tileEntities.altar;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class AltarBlock extends Block {

	public AltarBlock() {
		super(Block.Properties.from(Blocks.STONE));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		TileEntity tile = world.getTileEntity(pos);
		ItemStack stack = player.getHeldItem(hand);
		if(tile instanceof AltarTE){
			((AltarTE) tile).insertItem(0,stack);
			if(player.isCrouching()){
				((AltarTE) tile).extractItem(0);
			}
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
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
