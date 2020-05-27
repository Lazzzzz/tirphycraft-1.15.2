package laz.tirphycraft.content.items.clocks;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import laz.tirphycraft.util.TirphyLaputaTeleporter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ClockLaputa extends Item {


    public ClockLaputa() {
        super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
    }


	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        TirphyLaputaTeleporter.teleport(world, player);
        
        return ActionResult.resultPass(stack);
    }
}
