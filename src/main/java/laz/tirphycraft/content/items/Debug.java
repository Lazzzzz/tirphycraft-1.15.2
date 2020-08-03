package laz.tirphycraft.content.items;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import laz.tirphycraft.particle.GlintData;
import laz.tirphycraft.particle.GlintParticle;
import laz.tirphycraft.util.TirphyColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Debug extends Item {

	public Debug() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		for (int i = 0; i < 20; i++) {
			worldIn.addParticle(GlintData.glintParticle(TirphyColor.BLUE, random.nextInt(100) + 100), false,
					playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 0.0D, 0.01D, 0.0D);
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, stack);
	}

}
