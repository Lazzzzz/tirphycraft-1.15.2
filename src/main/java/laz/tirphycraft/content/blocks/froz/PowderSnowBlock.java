package laz.tirphycraft.content.blocks.froz;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.TirphycraftEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
		if (entityIn.getType() != TirphycraftEntities.ENTITY_KRETUN) {

			if (worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.down()) == TirphycraftBlocks.POWDER_SNOW.get().getDefaultState())
				worldIn.destroyBlock(pos, false);
			else
				worldIn.setBlockState(pos,
						TirphycraftBlocks.POWDER_SNOW_LAYER.get().getDefaultState().with(SnowBlock.LAYERS, 7));
		}
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn.getType() != TirphycraftEntities.ENTITY_KRETUN) {
			if (worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.down()) == TirphycraftBlocks.POWDER_SNOW.get().getDefaultState())
				worldIn.destroyBlock(pos, false);
			else
				worldIn.setBlockState(pos,
						TirphycraftBlocks.POWDER_SNOW_LAYER.get().getDefaultState().with(SnowBlock.LAYERS, 7));
		}
	}

}
