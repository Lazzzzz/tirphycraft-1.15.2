package laz.tirphycraft.content.items;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
<<<<<<< HEAD
=======
import net.minecraftforge.fml.network.NetworkHooks;
>>>>>>> parent of 2669fca... structure

public class Debug extends Item {

	public Debug() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
<<<<<<< HEAD
//			FrozDungeonHelper maze = new FrozDungeonHelper(40, new Random());
=======
			NetworkHooks.openGui((ServerPlayerEntity) playerIn, null);
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
>>>>>>> parent of 2669fca... structure
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}

}
