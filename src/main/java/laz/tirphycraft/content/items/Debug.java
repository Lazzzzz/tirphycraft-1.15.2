package laz.tirphycraft.content.items;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.Random;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.world.features.Features;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

public class Debug extends Item {

	public Debug() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			ResourceLocation LEFT_SIDE = new ResourceLocation(
					Tirphycraft.MOD_ID + ":test");

			ServerWorld serverworld = (ServerWorld) worldIn;
			TemplateManager templatemanager = serverworld.getStructureTemplateManager();
			Template maison = templatemanager.getTemplate(LEFT_SIDE);
			if (maison == null) {
				Tirphycraft.LOGGER.error(
						"Could not find structure at " + LEFT_SIDE);
			} else {
				PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
						.setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk(null);

				maison.addBlocksToWorld(worldIn, playerIn.getPosition(), placementsettings);
			}
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
	}

}
