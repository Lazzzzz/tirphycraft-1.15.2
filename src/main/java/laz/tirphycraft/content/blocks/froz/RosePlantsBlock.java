package laz.tirphycraft.content.blocks.froz;

import java.util.Random;

import laz.tirphycraft.content.blocks.plants.TirphycraftPlants;
import laz.tirphycraft.particle.GlintData;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.util.TirphyColor;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.potion.Effect;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RosePlantsBlock extends TirphycraftPlants {

	public RosePlantsBlock(Effect p_i49984_1_, int effectDuration, Properties properties) {
		super(p_i49984_1_, effectDuration, properties);
	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state == TirphycraftBlocks.POWDER_SNOW.get().getDefaultState();
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState()
				: super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		if (state.getBlock() == this)
			return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
		return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		spawnParticles(worldIn, pos, rand);
	}

	private void spawnParticles(World worldIn, BlockPos pos, Random random) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		if (random.nextInt(3) == 0) {
			double d0 = (double) ((float) i + random.nextFloat());
			double d1 = (double) ((float) j + random.nextFloat());
			double d2 = (double) ((float) k + random.nextFloat());
			worldIn.addParticle(GlintData.glintParticle(TirphyColor.BLUE, random.nextInt(100) + 100), false, d0, d1, d2,
					0.0D, 0.08D, 0.0D);
		}
	}

}
