package laz.tirphycraft.content.blocks.teleporter;

import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.content.TirphycraftDimensions.FROZ_DIM;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class TeleporterFrozBlock extends Block {

	public static final EnumProperty<Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AABB = Block.makeCuboidShape(0D, 0.0D, 0.5D, 1D, 1D, 0.5D);
	protected static final VoxelShape Z_AABB = Block.makeCuboidShape(0.5D, 0.0D, 0d, 0.5D, 1D, 1D);

	public TeleporterFrozBlock() {
		super(Block.Properties.create(Material.GLASS).doesNotBlockMovement().noDrops().tickRandomly().hardnessAndResistance(-1.0F));
	    this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
	}

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
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entityIn;
			if (!worldIn.isRemote()) {
				ServerPlayerEntity playerEntity = (ServerPlayerEntity) player;
				DimensionType dimensionType = DimensionManager
						.registerOrGetDimension(new ResourceLocation(MOD_ID, "froz_dim"), FROZ_DIM.get(), null, true);
				ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
				playerEntity.teleport(targetWorld, player.getPosX(), 255, player.getPosZ(), player.rotationYaw,
						player.rotationPitch);
				BlockPos p = player.world.getHeight(Type.WORLD_SURFACE, player.getPosition());
				player.setPositionAndUpdate(p.getX(), p.getY(), p.getZ());
			}

		}

		super.onEntityCollision(state, worldIn, pos, entityIn);
	}

}
