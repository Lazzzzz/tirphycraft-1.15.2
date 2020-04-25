package laz.tirphycraft.content.items.artefacts;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArtefactFeatherOfLight extends Item {

	public ArtefactFeatherOfLight() {
		super(new Item.Properties().group(ITEM_GROUP).maxStackSize(1));
	}
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void inventoryTick(ItemStack stack, net.minecraft.world.World worldIn, Entity living, int itemSlot,
			boolean isSelected) {
		living.fallDistance = 0;
	}
}
