package laz.tirphycraft.content.items.clocks;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.content.TirphycraftDimensions.GOSYN_DIM;
import static laz.tirphycraft.content.TirphycraftDimensions.LAPUTA_DIM;

import laz.tirphycraft.util.TirphyLaputaTeleporter;
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


	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        TirphyLaputaTeleporter.teleport(world, player);
        
        return ActionResult.resultPass(stack);
    }
}
