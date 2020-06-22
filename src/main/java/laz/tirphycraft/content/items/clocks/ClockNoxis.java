package laz.tirphycraft.content.items.clocks;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.content.TirphycraftDimensions.NOXIS_DIM;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class ClockNoxis extends Item {


    public ClockNoxis() {
        super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if(!world.isRemote()){
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) player;
            DimensionType dimensionType = DimensionManager.registerOrGetDimension(new ResourceLocation(MOD_ID, "noxis_dim"), NOXIS_DIM.get(), null, true);
            ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
            playerEntity.teleport(targetWorld, 0,255,0, player.rotationYaw, player.rotationPitch);
			BlockPos p = player.world.getHeight(Type.WORLD_SURFACE, player.getPosition());
			player.setPositionAndUpdate(p.getX(), p.getY(), p.getZ());
        }
        return ActionResult.resultPass(stack);
    }
}
