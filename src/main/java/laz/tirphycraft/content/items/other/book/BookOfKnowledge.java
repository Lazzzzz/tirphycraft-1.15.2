package laz.tirphycraft.content.items.other.book;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BookOfKnowledge extends Item {

	public BookOfKnowledge() {
		super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			NetworkHooks.openGui((ServerPlayerEntity) playerIn, new BookOfKnowledgeProvider());
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}

}
