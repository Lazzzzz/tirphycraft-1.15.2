package laz.tirphycraft.content.blocks.froz.dungeon;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpikeTrapBlock extends Block {

	public SpikeTrapBlock() {
		super(Block.Properties.from(Blocks.BEDROCK));
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof PlayerEntity) {
			worldIn.setBlockState(pos.up(), TirphycraftBlocks.FROZ_DUNGEON_SPIKE.get().getDefaultState());
	        worldIn.setBlockState(pos, TirphycraftBlocks.FROZ_DUNGEON_VARIANT0.get().getDefaultState());
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}

}
