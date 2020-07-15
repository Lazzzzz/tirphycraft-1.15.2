package laz.tirphycraft.content.items.seed;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SeedT3 extends Item {

	public SeedT3() {
		super(new Item.Properties().group(Tirphycraft.ITEM_GROUP).maxStackSize(64));
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof PlayerEntity && world.isRemote) {
			PlayerEntity player = (PlayerEntity) entityIn;
			ItemStack item = player.getHeldItemMainhand();
			if (item.getItem() instanceof SeedT3) {
				RayTraceResult ray = rayTrace(world, player, RayTraceContext.FluidMode.NONE);

				if (ray.getType() == RayTraceResult.Type.BLOCK) {
					BlockPos blockpos = ((BlockRayTraceResult) ray).getPos();
					if (world.getBlockState(blockpos) == TirphycraftBlocks.SACRED_DIRT.get().getDefaultState()) {
						for (int i = -1; i < 2; i++) {
							for (int j = -1; j < 2; j++) {
								BlockPos p = blockpos.add(i, 1, j);
								if (world.getBlockState(p) == TirphycraftBlocks.EXTRACTOR3.get().getDefaultState()) {
									world.addParticle(ParticleTypes.CRIT, blockpos.getX() + world.rand.nextFloat(),
											blockpos.getY() + 1, blockpos.getZ() + world.rand.nextFloat(), 0, 0.01, 0);
								}
							}
						}
					}
				}
			}
		}
	}

}
