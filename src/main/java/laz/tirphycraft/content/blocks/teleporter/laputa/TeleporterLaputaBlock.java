package laz.tirphycraft.content.blocks.teleporter.laputa;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.TirphyLaputaTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TeleporterLaputaBlock extends Block {

	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	protected static final VoxelShape X_AABB = Block.makeCuboidShape(-16.0D, -16.0D, 7.5D, 32, 32, 8.5D);
	protected static final VoxelShape Z_AABB = Block.makeCuboidShape(7.5D, -16.0D, -16.0D, 8.5D, 32.0D, 32.0D);

	public TeleporterLaputaBlock() {
		super(Block.Properties.create(Material.GLASS).doesNotBlockMovement().noDrops().tickRandomly()
				.hardnessAndResistance(-1.0F, 3600000.0F));
		this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
	}

	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch ((Direction.Axis) state.get(AXIS)) {
		case Z:
			return Z_AABB;
		case X:
		default:
			return X_AABB;
		}
	}
	
	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state == this.getDefaultState()) {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (!(i == 0 && j == 0))
						worldIn.setBlockState(pos.add(i, j, 0), Blocks.AIR.getDefaultState(), 1);

				}
			}
		} else {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (!(i == 0 && j == 0))
						worldIn.setBlockState(pos.add(i, j, 0), Blocks.AIR.getDefaultState(), 1);
				}
			}

		}
		super.onPlayerDestroy(worldIn, pos, state);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(AXIS, Direction.Axis.X);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		switch (rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch ((Direction.Axis) state.get(AXIS)) {
			case Z:
				return state.with(AXIS, Direction.Axis.X);
			case X:
				return state.with(AXIS, Direction.Axis.Z);
			default:
				return state;
			}
		default:
			return state;
		}
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entityIn;
	        TirphyLaputaTeleporter.teleport(worldIn, player);
		}
		super.onEntityCollision(state, worldIn, pos, entityIn);
	}
	
	private void makePlatform(World worldIn, BlockPos pos) {
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				worldIn.setBlockState(pos.add(i, -1, j), TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState());				
			}
		}
	}

}
