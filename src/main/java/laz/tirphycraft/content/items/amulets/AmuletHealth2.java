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

public class AmuletHealth2 extends Item {

    public AmuletHealth2() {
        super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
    }

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote()) {
			playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32D);
			item.damageItem(2, playerIn,  (living) -> {
				living.sendBreakAnimation(playerIn.getActiveHand());
			});
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
        }
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}
}
