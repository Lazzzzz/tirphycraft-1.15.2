package laz.tirphycraft.world.biome.base;

import net.minecraft.world.biome.Biome;

public class FrozBiome extends Biome {

    protected FrozBiome(Biome.Builder builder) {
        super(builder);
    }

    @Override
    public int getGrassColor(double posX, double posZ) {
    	return 3093151;
    }
    
}
