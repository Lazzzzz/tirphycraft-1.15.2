package laz.tirphycraft.content.blocks.froz.dungeon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SpikeBlock extends Block { 

	public SpikeBlock() {
		super(Block.Properties.from(Blocks.BONE_BLOCK));
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return true;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		return Block.makeCuboidShape(0,0,0,0,0,0);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof PlayerEntity) {	
			entityIn.attackEntityFrom(DamageSource.MAGIC, 2.0F); 
		}
		super.onEntityCollision(state, worldIn, pos, entityIn);
	}
	
}
