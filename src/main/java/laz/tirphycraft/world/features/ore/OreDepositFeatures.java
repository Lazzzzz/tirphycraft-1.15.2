package laz.tirphycraft.world.features.ore;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class OreDepositFeatures extends Feature<NoFeatureConfig> {

	private BlockState STONE;
	private BlockState BLOCK;
	private int MIN;
	private int MAX;
	private int SIZE;
	private int LUCK;

	public OreDepositFeatures(BlockState stone, BlockState ore, int min, int max, int size, int luck,
			Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);

		STONE = stone;
		BLOCK = ore;
		MIN = min;
		MAX = max;
		SIZE = size;
		LUCK = luck;
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos p, NoFeatureConfig config) {
		if (rand.nextInt(LUCK+1) > 0) return false;
		int y = rand.nextInt(Math.min(MAX, 255 - MIN)) + MIN;
		BlockPos pos = new BlockPos(p.getX(), y, p.getZ());
		generateChunk(worldIn, pos, rand);			
		return false;
	}

	public void generateChunk(IWorld worldIn, BlockPos pos, Random rand) {
		int size = rand.nextInt(SIZE) + 3;
		float modx = 1f + rand.nextFloat();
		float modz = 1f + rand.nextFloat();
		float mody = .2f + rand.nextFloat();

		for (int i = -size * 2; i < size * 2; i++) {
			for (int j = -size / 2; j < size; j++) {
				for (int k = -size * 2; k < size * 2; k++) {
					double dx = i * modx;
					double dz = k * modz;
					double dy = j * mody;
					BlockPos p = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
					if (dx * dx + dy * dy + dz * dz <= size * size * 4 && p.getY() > 0) {
						if (worldIn.getBlockState(p) == STONE && rand.nextInt(10) == 0) {
							setBlockState(worldIn, p, BLOCK);
						}
					}
				}
			}
		}
	}
}
