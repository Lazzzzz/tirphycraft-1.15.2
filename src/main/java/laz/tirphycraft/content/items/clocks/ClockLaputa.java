package laz.tirphycraft.content.items.clocks;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.content.TirphycraftDimensions.LAPUTA_DIM;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class ClockLaputa extends Item {


    public ClockLaputa() {
        super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
    }


    @SuppressWarnings("deprecation")
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if(!world.isRemote()){
        	DimensionType t = player.dimension;
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) player;
            DimensionType dimensionType = DimensionManager.registerOrGetDimension(new ResourceLocation(MOD_ID, "laputa_dim"), LAPUTA_DIM.get(), null, true);
            ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
            playerEntity.teleport(targetWorld, player.getPosX(), player.getPosY() ,player.getPosZ(), player.rotationYaw, player.rotationPitch);
			BlockPos p = player.world.getHeight(Type.WORLD_SURFACE, player.getPosition());
			if (p.getY() < 2) {
				dimensionType = t;
	            targetWorld = playerEntity.getServer().getWorld(dimensionType);
	            playerEntity.teleport(targetWorld, player.getPosX() ,player.getPosY(), player.getPosZ(), player.rotationYaw, player.rotationPitch);
			} else player.setPositionAndUpdate(p.getX(), p.getY(), p.getZ());
        }
        return ActionResult.resultPass(stack);
    }
}
