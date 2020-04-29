package laz.tirphycraft.content.items.staff;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StaffTeleportation1 extends Item {

	public StaffTeleportation1() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(20));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d aim = playerIn.getLookVec();

		double x = (playerIn.getPosX() + aim.x * 10);
		double y = (playerIn.getPosY() + aim.y * 10);
		double z = (playerIn.getPosZ() + aim.z * 10);

		if (worldIn.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.AIR) {

			playerIn.setPosition(x, y, z);
			item.damageItem(1, playerIn, (living) -> {
				living.sendBreakAnimation(playerIn.getActiveHand());
			});

			playerIn.getCooldownTracker().setCooldown(this, 20);

			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
		}

		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}
}