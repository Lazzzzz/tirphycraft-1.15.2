package laz.tirphycraft.world.features.froz;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class SmallRockPickFeature extends Feature<IFeatureConfig>{
	
	
	public SmallRockPickFeature(Function<Dynamic<?>, ? extends IFeatureConfig> configFactoryIn) {
		super(configFactoryIn);

	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos position, IFeatureConfig config) {
		
		if (position.getY() == 0 || worldIn.getBlockState(position.down(2)) != TirphycraftBlocks.POWDER_SNOW.get().getDefaultState() || rand.nextInt(3) == 0) return false;
		
		int r1 = rand.nextInt(3) + 4;
		generatePick(worldIn, position, r1);
		
		int r2 = rand.nextInt(5) + 1;
		int r3 = rand.nextInt(5) + 1;
		int r4 = rand.nextInt(5) + 1;
		int r5 = rand.nextInt(5) + 1;
		generatePick(worldIn, position.add(1,0,0), r2);
		generatePick(worldIn, position.add(-1,0,0), r3);
		generatePick(worldIn, position.add(0,0,-1), r4);
		generatePick(worldIn, position.add(0,0,1), r5);
		return true;
		
		
	}
	
	public void generatePick(IWorld worldIn, BlockPos pos, int size) {
		for (int i = size + pos.getY(); i > 0; i--) {
			BlockPos p = new BlockPos(pos.getX(), i, pos.getZ()); 
			if (worldIn.getBlockState(p).getMaterial() != Material.ROCK) 
				setBlockState(worldIn, p, TirphycraftBlocks.FROZ_STONE.get().getDefaultState());
			else break;
		}
	}

}
