package laz.tirphycraft.content.blocks.laputa.flowers;

import java.util.Random;

import laz.tirphycraft.content.TirphycraftItems;
import laz.tirphycraft.content.blocks.plants.TirphycraftPlants;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class LaputaBushBlock extends TirphycraftPlants {

	public LaputaBushBlock(Effect p_i49984_1_, int effectDuration, Properties properties) {
		super(p_i49984_1_, effectDuration, properties);
	}

	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
		if (!worldIn.isRemote()) {
			Random rand = worldIn.getRandom();
			for (int i = 0; i < rand.nextInt(4); i++) {
				ItemStack item = new ItemStack(TirphycraftItems.FOOD1.get(), 1);
				ItemEntity entityIn = new ItemEntity(worldIn.getWorld(), pos.getX() + rand.nextFloat(), pos.getY(), pos.getZ() + rand.nextFloat(), item);
				entityIn.setVelocity(rand.nextFloat() / 2 - .25f, Math.max(Math.min(rand.nextFloat(),0.8f), 0.4f)  , rand.nextFloat() / 2 - .25f);
				worldIn.addEntity(entityIn);
			}
		}
		super.onPlayerDestroy(worldIn, pos, state);
	}

}
