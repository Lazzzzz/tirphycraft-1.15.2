package laz.tirphycraft.content.items.clocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.content.TirphycraftDimensions.FROZ_DIM;

public class ClockReturn extends Item {


    public ClockReturn() {
        super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if(!world.isRemote()){
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) player;
            @SuppressWarnings("deprecation")
			DimensionType dimensionType = DimensionManager.getRegistry().getByValue(0);
            ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
            playerEntity.teleport(targetWorld, player.getPosX(),64, player.getPosY(), player.rotationYaw, player.rotationPitch);
        }
        return ActionResult.resultPass(stack);
    }
}
