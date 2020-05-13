package laz.tirphycraft.content.blocks.froz;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PowderSnowBlock extends Block {

	public PowderSnowBlock(Properties properties) {
		super(properties);
	}


	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		worldIn.setBlockState(pos, TirphycraftBlocks.POWDER_SNOW_LAYER.get().getDefaultState().with(SnowBlock.LAYERS, 7));
		super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		worldIn.setBlockState(pos, TirphycraftBlocks.POWDER_SNOW_LAYER.get().getDefaultState().with(SnowBlock.LAYERS, 7));
		super.onEntityWalk(worldIn, pos, entityIn);
	}

}
