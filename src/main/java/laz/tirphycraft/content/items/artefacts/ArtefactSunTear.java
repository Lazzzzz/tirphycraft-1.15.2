package laz.tirphycraft.content.items.artefacts;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;

public class ArtefactSunTear extends Item {

	public ArtefactSunTear() {
		super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public void inventoryTick(ItemStack stack, net.minecraft.world.World worldIn, Entity living, int itemSlot,
			boolean isSelected) {
		BlockPos pos = living.getPosition();

		if (living.onGround) {
			BlockState blockstate = Blocks.MAGMA_BLOCK.getDefaultState();
			float f = (float) Math.min(16, 5);
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

			for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add((double) (-f), -1.0D, (double) (-f)),
					pos.add((double) f, -1.0D, (double) f))) {
				if (blockpos.withinDistance(living.getPositionVec(), (double) f)) {
					blockpos$mutable.setPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
					BlockState blockstate1 = worldIn.getBlockState(blockpos$mutable);
					if (blockstate1.isAir(worldIn, blockpos$mutable)) {
						BlockState blockstate2 = worldIn.getBlockState(blockpos);
						boolean isFull = blockstate2.getBlock() == Blocks.LAVA
								&& blockstate2.get(FlowingFluidBlock.LEVEL) == 0; // TODO: Forge, modded waters?
						if (blockstate2.getMaterial() == Material.LAVA && isFull
								&& blockstate.isValidPosition(worldIn, blockpos)
								&& worldIn.func_226663_a_(blockstate, blockpos, ISelectionContext.dummy())
								&& !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(living,
										new net.minecraftforge.common.util.BlockSnapshot(worldIn, blockpos,
												blockstate2),
										net.minecraft.util.Direction.UP)) {
							worldIn.setBlockState(blockpos, blockstate);
						}
					}
				}
			}

		}
	}
}
