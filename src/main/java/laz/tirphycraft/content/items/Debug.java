package laz.tirphycraft.content.items;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Debug extends Item {

	public Debug() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

		return new ActionResult<ItemStack>(ActionResultType.PASS, stack);
	}

}
