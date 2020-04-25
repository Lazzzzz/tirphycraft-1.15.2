package laz.tirphycraft.content.items.staff;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
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

public class StaffFireBall3 extends Item {

	public StaffFireBall3() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(40));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			Vec3d aim = playerIn.getLookVec();
			
			FireballEntity entity = new FireballEntity(worldIn, playerIn, 1, 1, 1);
			
			entity.setPosition(playerIn.getPosX() + aim.x, playerIn.getPosY() + aim.y + 1, playerIn.getPosZ() + aim.z);
			entity.accelerationX = aim.x * 0.2;
			entity.accelerationY = aim.y * 0.2;
			entity.accelerationZ = aim.z * 0.2;
			
			worldIn.addEntity(entity);
			
			item.damageItem(1, playerIn, (living) -> {
				living.sendBreakAnimation(playerIn.getActiveHand());
			});
			
			playerIn.getCooldownTracker().setCooldown(this, 5);
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}
}