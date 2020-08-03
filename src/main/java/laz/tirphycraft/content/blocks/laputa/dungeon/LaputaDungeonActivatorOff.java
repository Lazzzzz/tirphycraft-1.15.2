package laz.tirphycraft.content.blocks.laputa.dungeon;

import java.util.Random;

import laz.tirphycraft.content.entities.laputa.EntityTreeSpirit;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class LaputaDungeonActivatorOff extends Block {

	public LaputaDungeonActivatorOff() {
		super(Block.Properties.create(Material.ROCK).noDrops().hardnessAndResistance(-1.0F, 3600000.0F));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			EntityTreeSpirit e = new EntityTreeSpirit(TirphycraftEntities.ENTITY_SPIRIT_TREE, worldIn);
			e.setPositionAndUpdate(pos.getX() +0.5, pos.getY() - 29, pos.getZ() +0.5);
			worldIn.addEntity(e);
			worldIn.setBlockState(pos, TirphycraftBlocks.LAPUTA_ACTIVATOR_ON.get().getDefaultState());
			player.sendMessage(new StringTextComponent("4 doors were opened by the spirit of the tree ..."));
			makeEnter(worldIn, pos.add(43,-14,1), worldIn.rand);
			makeEnter(worldIn, pos.add(-45,-14,1), worldIn.rand);
			makeEnter(worldIn, pos.add(1,-14,43), worldIn.rand);
			makeEnter(worldIn, pos.add(1,-14,-45), worldIn.rand);
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

	
	public void makeEnter(World world, BlockPos pos, Random rand) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = -5; k < 5; k++) {
					world.removeBlock(pos.add(i,k,j), false);
				}
			}
		}
		
		for (int i = 0; i < rand.nextInt(10) + 5; i++) {
			world.setBlockState(pos.west().down(i), Blocks.VINE.getDefaultState().with(VineBlock.WEST, true));
		}
		
		for (int i = 0; i < rand.nextInt(10) + 5; i++) {
			world.setBlockState(pos.east().down(i), Blocks.VINE.getDefaultState().with(VineBlock.EAST, true));
		}
		
		for (int i = 0; i < rand.nextInt(10) + 5; i++) {
			world.setBlockState(pos.south().down(i), Blocks.VINE.getDefaultState().with(VineBlock.SOUTH, true));
		}
		
		for (int i = 0; i < rand.nextInt(10) + 5; i++) {
			world.setBlockState(pos.north().down(i), Blocks.VINE.getDefaultState().with(VineBlock.NORTH, true));
		}
	}
}
