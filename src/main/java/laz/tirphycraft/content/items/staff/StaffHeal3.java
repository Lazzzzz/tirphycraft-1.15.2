package laz.tirphycraft.content.items.staff;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class StaffHeal3 extends Item {

	public StaffHeal3() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(20));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			if (playerIn.getHealth() < playerIn.getMaxHealth()) {
				playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, 2, false, false));
				item.damageItem(1, playerIn, (living) -> {
					living.sendBreakAnimation(playerIn.getActiveHand());
				});

				return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
			}

			playerIn.getCooldownTracker().setCooldown(this, 100);
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);

	}
}