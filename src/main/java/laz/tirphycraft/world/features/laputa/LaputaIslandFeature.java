package laz.tirphycraft.world.features.laputa;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class LaputaIslandFeature extends Feature<NoFeatureConfig> {
	   
	public LaputaIslandFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49880_1_) {
	      super(p_i49880_1_);
	   }

	   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos p, NoFeatureConfig config) {
		   if (rand.nextInt(20) > 0) return false;
	      float f = (float)(rand.nextInt(3) + 4);
	      BlockPos pos;
	      if (p.getY() == 0) pos = new BlockPos(p.getX(), rand.nextInt(50) + 40, p.getZ());
	      else return false;
	      for(int i = 0; f > 0.5F; --i) {
	         for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
	            for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
	               if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
	            	   if (i == 0) this.setBlockState(worldIn, pos.add(j, i, k), TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState());
	            	   else if (i == -1) this.setBlockState(worldIn, pos.add(j, i, k), TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState());
	            	   else this.setBlockState(worldIn, pos.add(j, i, k), TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState());
	               }
	            }
	         }

	         f = (float)((double)f - ((double)rand.nextInt(2) + 0.5D));
	      }

	      return true;
	   }
	}