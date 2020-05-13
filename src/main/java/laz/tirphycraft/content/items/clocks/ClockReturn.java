package laz.tirphycraft.content.items.clocks;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

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
			DimensionType dimensionType = DimensionManager.getRegistry().getByValue(1);
            ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
            playerEntity.teleport(targetWorld, player.getPosX() ,255, player.getPosZ(), player.rotationYaw, player.rotationPitch);
			BlockPos p = player.world.getHeight(Type.WORLD_SURFACE, player.getPosition());
			player.setPositionAndUpdate(p.getX(), p.getY(), p.getZ());
        }
        return ActionResult.resultPass(stack);
    }
}
