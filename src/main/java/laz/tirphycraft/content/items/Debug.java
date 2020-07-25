package laz.tirphycraft.content.items;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.registry.init.TirphycraftDimensions.SG_DIM;

import org.jline.terminal.impl.jna.freebsd.CLibrary.winsize;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import laz.tirphycraft.registry.init.TirphycraftEntities;
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
        	BlockPos pos =  playerIn.getPosition();
        	EntityPhantomGuardian e = new EntityPhantomGuardian(TirphycraftEntities.ENTITY_PHANTOM_GUARDIAN, worldIn);
        	e.setTowerPos(pos);
        	e.setPositionAndUpdate(pos.getX() + 10, pos.getY(), pos.getZ());
        	
        	worldIn.addEntity(e);
        }
		return new ActionResult<ItemStack>(ActionResultType.PASS, stack);
	}

}
