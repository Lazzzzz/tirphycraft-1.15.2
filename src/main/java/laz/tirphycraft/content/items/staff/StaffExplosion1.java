package laz.tirphycraft.content.items.staff;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StaffExplosion1 extends Item {

	public StaffExplosion1() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(20));
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
			tnt.setMotion(aim.x * 1D, aim.y * 1D, aim.z * 1D);
			worldIn.addEntity(tnt);

			playerIn.getCooldownTracker().setCooldown(this, 40);
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
		}
		
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);

	}
}