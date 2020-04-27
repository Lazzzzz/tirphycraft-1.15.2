package laz.tirphycraft.content.blocks.laputa;

import java.util.Random;

import laz.tirphycraft.particle.GlintData;
import laz.tirphycraft.util.TirphyColor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class CrystalBlock extends Block {

	public CrystalBlock() {
		super(Block.Properties.create(Material.GLASS)
				.hardnessAndResistance(2).
				tickRandomly()
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.GLASS)
				.lightValue(5)
				.notSolid());
	}
	
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		spawnParticles(worldIn, pos);
	}

	private void spawnParticles(World worldIn, BlockPos pos) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		Random random = worldIn.rand;
		if (random.nextInt(3) == 0) {
			double d0 = (double) ((float) i + (random.nextInt(20) - 10) * random.nextFloat());
			double d1 = (double) ((float) j + (random.nextInt(20) - 10) * random.nextFloat());
			double d2 = (double) ((float) k + (random.nextInt(20) - 10) * random.nextFloat());
			worldIn.addParticle(GlintData.glintParticle(TirphyColor.BLUE, 200), false, i, j, k, d0, d1, d2);
		}
	}
	
}

