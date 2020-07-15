package laz.tirphycraft.content.blocks.gs;

import java.util.ArrayList;

import laz.tirphycraft.content.tiles.essencium.EssenciumSeedTileBase;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ExtractorT2Block extends Block {

	public ExtractorT2Block() {
		super(Block.Properties.from(Blocks.STONE));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			ArrayList<BlockPos> list_m = new ArrayList<BlockPos>();
			ArrayList<BlockPos> list_r = new ArrayList<BlockPos>();

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					BlockPos p = pos.add(i, -1, j);
					TileEntity tile = worldIn.getTileEntity(p);
					if (tile instanceof EssenciumSeedTileBase) {
						EssenciumSeedTileBase seed = (EssenciumSeedTileBase) tile;
						if (seed.getTier() == 2 && seed.isMature()) {
							if (seed.isMelee())	list_m.add(p);
							else list_r.add(p);
						}
					}
				}
			}
			
			if (list_m.size() >= 5) {
				for (int i = 0; i < 5; i++) {
					int index = worldIn.rand.nextInt(list_m.size());
					BlockPos p = list_m.get(index);
					list_m.remove(index);
					worldIn.setBlockState(p, TirphycraftBlocks.SACRED_DIRT.get().getDefaultState());
				}
				ZombieEntity e = new ZombieEntity(worldIn);
				e.setPositionAndUpdate(pos.getX() + 0.5, pos.getY()+1, pos.getZ() + 0.5);
				worldIn.addEntity(e);
			}
			
			if (list_r.size() >= 5) {
				for (int i = 0; i < 5; i++) {
					int index = worldIn.rand.nextInt(list_r.size());
					BlockPos p = list_r.get(index);
					list_r.remove(index);
					worldIn.setBlockState(p, TirphycraftBlocks.SACRED_DIRT.get().getDefaultState());
				}
				SkeletonEntity e = new SkeletonEntity(EntityType.SKELETON, worldIn);
				e.setPositionAndUpdate(pos.getX() + 0.5, pos.getY()+1, pos.getZ() + 0.5);
				worldIn.addEntity(e);
			}

		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

}
