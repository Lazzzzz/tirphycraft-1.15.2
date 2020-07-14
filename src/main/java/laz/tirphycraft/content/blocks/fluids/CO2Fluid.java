package laz.tirphycraft.content.blocks.fluids;

import laz.tirphycraft.registry.TirphycraftRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CO2Fluid extends FlowingFluidBlock{

	public CO2Fluid(Properties p_i48368_1_) {
		super(TirphycraftRegistries.CO2, p_i48368_1_);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity)
			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 20 * 10, 3, false, false));
		super.onEntityCollision(state, worldIn, pos, entityIn);
	}

}
