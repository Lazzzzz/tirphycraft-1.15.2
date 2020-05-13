package laz.tirphycraft.content.blocks.laputa.flowers;

import java.util.Random;

import laz.tirphycraft.content.blocks.plants.TirphycraftPlants;
import laz.tirphycraft.particle.GlintData;
import laz.tirphycraft.util.TirphyColor;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LaputaTallGrassBlock extends TirphycraftPlants {
	public LaputaTallGrassBlock(Effect p_i49984_1_, int effectDuration, Properties properties) {
		super(p_i49984_1_, effectDuration, properties);

	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos).getMaterial() == Material.ORGANIC
				|| worldIn.getBlockState(pos) == this.getDefaultState())
			return true;
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!(worldIn.getBlockState(pos.down()).getMaterial() == Material.ORGANIC
				|| worldIn.getBlockState(pos.down()) == this.getDefaultState())) worldIn.destroyBlock(pos, true);
		super.tick(state, worldIn, pos, rand);
	}
	
	@Override
	public int tickRate(IWorldReader worldIn) {
		return 1;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		spawnParticles(worldIn, pos, rand);
	}

	private void spawnParticles(World worldIn, BlockPos pos,  Random random) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		if (random.nextInt(3) == 0) {
			double d0 = (double) ((float) i + (random.nextInt(20) - 10) * random.nextFloat());
			double d1 = (double) ((float) j + (random.nextInt(20) - 10) * random.nextFloat());
			double d2 = (double) ((float) k + (random.nextInt(20) - 10) * random.nextFloat());
			worldIn.addParticle(GlintData.glintParticle(TirphyColor.WHITE, random.nextInt(100) + 100), false, d0, d1, d2, 0.0D, 0.01D, 0.0D);
		}
	}
	

}
