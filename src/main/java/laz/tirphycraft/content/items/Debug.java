package laz.tirphycraft.content.items;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import java.util.Random;

import laz.tirphycraft.world.features.froz.FlatRockFeature;
import laz.tirphycraft.world.features.froz.trees.FrozBushFeature;
import laz.tirphycraft.world.features.froz.trees.FrozRootFeature;
import laz.tirphycraft.world.features.froz.underground.GiantPillarFeature;
import laz.tirphycraft.world.features.froz.underground.SnowTrapFeature;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class Debug extends Item {

	public Debug() {
		super(new Item.Properties().group(ITEM_GROUP).maxDamage(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote)
			new FlatRockFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.place(worldIn, null, new Random(), playerIn.getPosition());

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
