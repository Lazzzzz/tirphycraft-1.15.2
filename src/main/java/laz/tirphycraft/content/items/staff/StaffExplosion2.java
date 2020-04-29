package laz.tirphycraft.content.items.staff;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StaffExplosion2 extends Item {

	public StaffExplosion2() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(30));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			Vec3d aim = playerIn.getLookVec();
			double x = (playerIn.getPosX() + aim.x * 1.5D);
			double y = (playerIn.getPosY() + aim.y * 1.5D + 1);
			double z = (playerIn.getPosZ() + aim.z * 1.5D);

			item.damageItem(1, playerIn, (living) -> {
				living.sendBreakAnimation(playerIn.getActiveHand());
			});

			TNTEntity tnt = new TNTEntity(worldIn, x, y, z, playerIn);
			tnt.setMotion(aim.x * 1D, aim.y * 1.1D, aim.z * 1D);
			worldIn.addEntity(tnt);
			
			TNTEntity tnt2 = new TNTEntity(worldIn, x, y, z, playerIn);
			tnt2.setMotion(aim.x * 1D, aim.y * 2D, aim.z * 1D);
			worldIn.addEntity(tnt2);

			playerIn.getCooldownTracker().setCooldown(this, 40);
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
		}
		
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);

	}
}