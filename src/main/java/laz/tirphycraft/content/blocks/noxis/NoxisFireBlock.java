package laz.tirphycraft.content.blocks.noxis;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class NoxisFireBlock extends Block {

	public NoxisFireBlock() {
		super(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 15)
				.sound(SoundType.STONE).harvestLevel(0).lightValue(4).tickRandomly());

	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(10) == 0) spawnParticles(worldIn, pos, rand);
	}

	private void spawnParticles(World worldIn, BlockPos pos, Random random) {
		for (int i = 0; i < 50; i++) {
			worldIn.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5f, pos.getY() + 1, pos.getZ() + 0.5f,
					(0.5f - random.nextFloat()) / 40, random.nextFloat() / 3, (0.5f - random.nextFloat()) / 40);
		}
	}

}
