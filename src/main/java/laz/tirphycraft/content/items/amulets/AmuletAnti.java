package laz.tirphycraft.content.items.amulets;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class AmuletAnti extends Item {

    public AmuletAnti() {
        super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
    }

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote()) {
			playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			playerIn.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
			playerIn.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(4.0D);
			item.damageItem(2, playerIn, (living) -> {
				living.sendBreakAnimation(playerIn.getActiveHand());
			});
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
        }
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}
}
