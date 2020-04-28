package laz.tirphycraft.content.items.totems;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.List;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TotemThunder extends Item {

    public TotemThunder() {
        super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
    }

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
			BlockPos pos = playerIn.getPosition();
			AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 10, pos.getY() - 10, pos.getZ() - 10, pos.getX() + 10,
					pos.getY() + 10, pos.getZ() + 10);
		
			List<LivingEntity> list = worldIn.getEntitiesWithinAABB(LivingEntity.class, box);
			if (!list.isEmpty()) {
		
				for (int i = 0; i <= list.size() - 1; i++) {
					if (!(list.get(i) instanceof PlayerEntity)) {
						BlockPos p = ((LivingEntity) list.get(i)).getPosition();
						for (int j = 0; j < 2; j++) {
							LightningBoltEntity m = new LightningBoltEntity(worldIn, p.getX(), p.getY(), p.getZ(), false);
							worldIn.addEntity(m);
					        if(worldIn.isRemote()) {
					            ClientWorld c = (ClientWorld) playerIn.world;
					            c.addLightning(m);
					        }
						}
					}
				}
				item.damageItem(2, playerIn,  (living) -> {
					living.sendBreakAnimation(playerIn.getActiveHand());
				});
				playerIn.getCooldownTracker().setCooldown(this, 20 * 20);
				return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
			}
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}
}
