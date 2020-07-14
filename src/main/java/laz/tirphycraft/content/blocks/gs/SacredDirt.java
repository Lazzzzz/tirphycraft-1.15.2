package laz.tirphycraft.content.blocks.gs;

import laz.tirphycraft.content.items.seed.SeedT1;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class SacredDirt extends Block {

	public SacredDirt() {
		super(Block.Properties.from(Blocks.DIRT));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack item = player.getHeldItem(handIn);

		boolean asExtractor1 = false;
		boolean asExtractor2 = false;
		boolean asExtractor3 = false;

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				BlockPos p = pos.add(i, 1, j);
				if (worldIn.getBlockState(p) == TirphycraftBlocks.EXTRACTOR1.get().getDefaultState())
					asExtractor1 = true;
			}
		}

		if (!worldIn.isRemote) {
			if (item.getItem() instanceof SeedT1 && asExtractor1) {
				worldIn.setBlockState(pos, TirphycraftBlocks.SEEDT11.get().getDefaultState());
				item.shrink(1);
				return ActionResultType.SUCCESS;
			}
		}

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

}
