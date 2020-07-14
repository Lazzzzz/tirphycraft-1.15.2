package laz.tirphycraft.content.items;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.registry.init.TirphycraftDimensions.SG_DIM;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class Debug extends Item {

	public Debug() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote()){
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) playerIn;
            DimensionType dimensionType = DimensionManager.registerOrGetDimension(new ResourceLocation(MOD_ID, "gs_dim"), SG_DIM.get(), null, true);
            ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
            playerEntity.teleport(targetWorld, 0,255,0, playerIn.rotationYaw,playerIn.rotationPitch);
			BlockPos p = playerIn.world.getHeight(Type.WORLD_SURFACE, playerIn.getPosition());
			playerIn.setPositionAndUpdate(p.getX(), p.getY(), p.getZ());
        }
		return new ActionResult<ItemStack>(ActionResultType.PASS, stack);
	}

}
