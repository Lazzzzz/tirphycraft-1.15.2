package laz.tirphycraft.world.features.noxis;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBiomes;
import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class NoxisDeadTreeFeature extends Feature<NoFeatureConfig> {

	private BlockState LOG = TirphycraftBlocks.LOG_DEAD.get().getDefaultState();

	public NoxisDeadTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		if (worldIn.getBiome(pos) != TirphycraftBiomes.N_THORNS.get())
			return false;

		int size = rand.nextInt(3) + 4;
		Mutable p = new BlockPos.Mutable();

		for (int i = pos.getY() + size; i > 0; i--) {
			p.setPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p).isSolid())
				break;
			setBlockState(worldIn, p, LOG);
		}

		p.setY(p.getY() + size);

		for (float i = 0; i < 1; i += 0.25f) {
			float dirx = (rand.nextFloat() * 2) - 1;
			float diry = (rand.nextFloat() * 2) - 1;
			float dirz = (rand.nextFloat() * 2) - 1;

			makeBrench(worldIn, p, rand, dirx, diry, dirz);
		}

		return true;
	}

	public void makeBrench(IWorld world, BlockPos pos, Random rand, float dirx, float diry, float dirz) {
		Mutable p = new BlockPos.Mutable();

		int size = rand.nextInt(3) + 3;
		float tempx = 0;
		float tempy = 0;
		float tempz = 0;

		for (int i = 0; i < size; i++) {
			p.setPos(pos.getX() + tempx, pos.getY() + tempy, pos.getZ() + tempz);
			if (world.getBlockState(p) == Blocks.AIR.getDefaultState())
				setBlockState(world, p, LOG);
			tempx += dirx;
			tempy += diry;
			tempz += dirz;
		}

	}

}
