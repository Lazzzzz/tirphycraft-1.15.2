package laz.tirphycraft.content.blocks.froz.dungeon;

import java.util.Random;

import laz.tirphycraft.particle.GlintData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FrozDungeonBricks extends Block {

	public FrozDungeonBricks() {
		super(Block.Properties.from(Blocks.BEDROCK));
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		spawnParticles(worldIn, pos, rand);
	}

	private void spawnParticles(World worldIn, BlockPos pos, Random random) {
		if (worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState()) {
			if (random.nextInt(100) == 0) {
				int i = pos.getX();
				int j = pos.getY();
				int k = pos.getZ();
				worldIn.addParticle(ParticleTypes.FALLING_WATER, i + random.nextFloat(), j - 0.01, k + random.nextFloat(), 0, 0, 0);
			}
		}
	}
}
