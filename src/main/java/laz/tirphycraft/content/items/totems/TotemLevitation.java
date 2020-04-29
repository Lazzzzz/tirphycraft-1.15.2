package laz.tirphycraft.content.items.totems;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.world.World;

public class TotemLevitation extends Item {

	public TotemLevitation() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		BlockPos pos = playerIn.getPosition();
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 10, pos.getY() - 10, pos.getZ() - 10, pos.getX() + 10,
				pos.getY() + 10, pos.getZ() + 10);

		List<Entity> list = worldIn.getEntitiesInAABBexcluding(playerIn, box, EntityPredicates.NOT_SPECTATING);
		if (!list.isEmpty() && !worldIn.isRemote) {

			for (int i = 0; i <= list.size() - 1; i++) {
				if (!(list.get(i) instanceof PlayerEntity)) {
					((LivingEntity) list.get(i)).addPotionEffect(new EffectInstance(Effects.LEVITATION,
							(worldIn.rand.nextInt(15) + 15) * 20, 0, false, false));

				}
			}
			item.damageItem(2, playerIn, (living) -> {
				living.sendBreakAnimation(playerIn.getActiveHand());
			});
			playerIn.getCooldownTracker().setCooldown(this, 20 * 20);
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);

		}

		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}
}
