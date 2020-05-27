package laz.tirphycraft.content.tiles.frozFurnace;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FrozFurnaceBlock extends Block {

	public FrozFurnaceBlock() {
		super(Block.Properties.from(Blocks.STONE));
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new FrozFurnaceTE();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof FrozFurnaceTE) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (FrozFurnaceTE) te, pos);
			}
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);

	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
}
