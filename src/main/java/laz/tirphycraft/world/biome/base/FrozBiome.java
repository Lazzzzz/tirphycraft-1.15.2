package laz.tirphycraft.world.biome.base;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class FrozBiome extends Biome {

    protected FrozBiome() {
        super(new Biome.Builder()
        		.precipitation(RainType.SNOW)
        		.scale(1.2f)
        		.temperature(-10f)
        		.waterColor(3093151)
        		.waterFogColor(3093151)
        		.category(Category.PLAINS)
        		.downfall(0)
        		.depth(1.2f)
        		.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
        		Blocks.DIRT.getDefaultState(), Blocks.ICE.getDefaultState()))
        	);
    }

    @Override
    public int getGrassColor(double posX, double posZ) {
    	return 3093151;
    }
    
}
