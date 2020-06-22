package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BlackCrystalFeature extends Feature<IFeatureConfig>{

	public BlackCrystalFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, IFeatureConfig config) {
		{
			while (worldIn.isAirBlock(position) && position.getY() > 2) {
				position = position.down(2);
			}

			if (worldIn.getBlockState(position).getBlock() != TirphycraftBlocks.POWDER_SNOW.get()) {
				return false;
			} else {
				position = position.up(rand.nextInt(4));
				int i = rand.nextInt(4) + 7;
				int j = i / 4 + rand.nextInt(2);

				if (j > 1 && rand.nextInt(60) == 0) {
					position = position.up(10 + rand.nextInt(30));
				}
				
				for (int k = 0; k < i; ++k) {
					float f = (1.0F - (float) k / (float) i) * (float) j;
					int l = MathHelper.ceil(f);

					for (int i1 = -l; i1 <= l; ++i1) {
						float f1 = (float) MathHelper.abs(i1) - 0.25F;

						for (int j1 = -l; j1 <= l; ++j1) {
							float f2 = (float) MathHelper.abs(j1) - 0.25F;

							if ((i1 == 0 && j1 == 0 || f1 * f1 + f2 * f2 <= f * f)
									&& (i1 != -l && i1 != l && j1 != -l && j1 != l || rand.nextFloat() <= 0.75F)) {
								BlockState iblockstate = worldIn.getBlockState(position.add(i1, k, j1));
								Block block = iblockstate.getBlock();

								if (iblockstate.getBlock().isAir(iblockstate, worldIn, position.add(i1, k, j1))
										|| block == TirphycraftBlocks.POWDER_SNOW_LAYER.get() || block == TirphycraftBlocks.FROZ_DIRT.get() || block == TirphycraftBlocks.POWDER_SNOW.get()) {
									 this.setBlockState(worldIn, position.add(i1, k, j1),
											TirphycraftBlocks.BLACK_CRYSTAL.get().getDefaultState());
								}

								if (k != 0 && l > 1) {
									iblockstate = worldIn.getBlockState(position.add(i1, -k, j1));
									block = iblockstate.getBlock();

									if (iblockstate.getBlock().isAir(iblockstate, worldIn, position.add(i1, -k, j1))
											|| block == TirphycraftBlocks.FROZ_DIRT.get() || block == TirphycraftBlocks.POWDER_SNOW_LAYER.get() || block == TirphycraftBlocks.POWDER_SNOW.get()) {
										this.setBlockState(worldIn, position.add(i1, -k, j1),
												TirphycraftBlocks.BLACK_CRYSTAL.get().getDefaultState());
									}
								}
							}
						}
					}
				}

				int k1 = j - 1;

				if (k1 < 0) {
					k1 = 0;
				} else if (k1 > 1) {
					k1 = 1;
				}

				for (int l1 = -k1; l1 <= k1; ++l1) {
					for (int i2 = -k1; i2 <= k1; ++i2) {
						BlockPos blockpos = position.add(l1, -1, i2);
						int j2 = 50;

						if (Math.abs(l1) == 1 && Math.abs(i2) == 1) {
							j2 = rand.nextInt(5);
						}

						while (blockpos.getY() > 50) {
							BlockState iblockstate1 = worldIn.getBlockState(blockpos);
							Block block1 = iblockstate1.getBlock();

							if (!iblockstate1.getBlock().isAir(iblockstate1, worldIn, blockpos) && block1 != TirphycraftBlocks.FROZ_DIRT.get()
									&& block1 != TirphycraftBlocks.POWDER_SNOW_LAYER.get() && block1 != TirphycraftBlocks.POWDER_SNOW.get() && block1 != TirphycraftBlocks.BLACK_CRYSTAL.get()) {
								break;
							}

							this.setBlockState(worldIn, blockpos, TirphycraftBlocks.BLACK_CRYSTAL.get().getDefaultState());
							blockpos = blockpos.down();
							--j2;

							if (j2 <= 0) {
								blockpos = blockpos.down(rand.nextInt(5) + 1);
								j2 = rand.nextInt(5);
							}
						}
					}
				}

				return true;
			}
		}
	}

}
