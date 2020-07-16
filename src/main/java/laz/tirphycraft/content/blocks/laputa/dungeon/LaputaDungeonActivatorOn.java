package laz.tirphycraft.content.blocks.laputa.dungeon;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class LaputaDungeonActivatorOn extends Block {

	public LaputaDungeonActivatorOn() {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.0F, 3600000.0F).noDrops().tickRandomly());
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
	}
	
	@Override
	public int tickRate(IWorldReader worldIn) {
		return 1;
	}
	
}
