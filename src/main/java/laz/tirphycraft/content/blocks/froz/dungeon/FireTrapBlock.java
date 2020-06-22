package laz.tirphycraft.content.blocks.froz.dungeon;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireTrapBlock extends Block {

	public FireTrapBlock() {
		super(Block.Properties.from(Blocks.BEDROCK));
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof PlayerEntity) {
			if (!worldIn.isRemote) {
				entityIn.setFire(8);
				worldIn.setBlockState(pos, TirphycraftBlocks.FROZ_DUNGEON_VARIANT0.get().getDefaultState());
				super.onEntityWalk(worldIn, pos, entityIn);
			} else {
				for (int i = 0; i < 50; i++) {
					worldIn.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5f, pos.getY() + 1, pos.getZ() + 0.5f,
							(0.5f - worldIn.rand.nextFloat()) / 40, worldIn.rand.nextFloat() / 3,
							(0.5f - worldIn.rand.nextFloat()) / 40);
				}
			}
		}
	}

}
