package laz.tirphycraft.world.features.froz.underground;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class SnowTrapFeature extends Feature<NoFeatureConfig> {

	public SnowTrapFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
		ArrayList<Integer> list = new ArrayList<Integer>();

	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		
		if (pos.getY() > 70 || worldIn.getBlockState(pos.down(3)) != TirphycraftBlocks.FROZ_DIRT.get().getDefaultState()) return false;
		
		BlockPos p = pos;
		for (int i = 20; i < 48; i++) {
			p = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(p) == Blocks.AIR.getDefaultState()) break;
			if (i == 47) return false;
		}
		
		int dy = pos.getY() - p.getY();
		makeHole(worldIn, rand, pos.up(2), dy);

		return false;
	}

	public void makeHole(IWorld worldIn, Random rand, BlockPos pos, int size) {
		int kk = 3;
		int ll = rand.nextInt(kk)+1;
		for (float j = -kk; j <= kk; j++) {
			for (int i = -size; i <= size+2; i++) {
				for (float k = -kk; k <= kk; k++) {
					if (j * j + k * k + i/2 <= ll) {
						
						BlockPos p = new BlockPos(pos.getX() + j, pos.getY() + i, pos.getZ() + k);
						if (p.getY() < pos.getY() - 3 && p.getY() > pos.getY() - 6)	setBlockState(worldIn, p, TirphycraftBlocks.POWDER_SNOW.get().getDefaultState());
						else setBlockState(worldIn, p, Blocks.AIR.getDefaultState());
					}
				}
			}
		}

	}

}