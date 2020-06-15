package laz.tirphycraft.content.blocks.froz.dungeon;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SpikeTrapBlock extends Block {

	public SpikeTrapBlock() {
		super(Block.Properties.from(Blocks.BEDROCK));
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof PlayerEntity) {
			worldIn.setBlockState(pos.up(), TirphycraftBlocks.FROZ_DUNGEON_SPIKE.get().getDefaultState());
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}

}
