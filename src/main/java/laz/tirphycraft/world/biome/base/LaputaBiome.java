package laz.tirphycraft.world.biome.base;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.world.features.Features;
import laz.tirphycraft.world.features.trees.CoppirTreeFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class LaputaBiome extends Biome {

	static public CoppirTreeFeature COPPIR_TREE = new CoppirTreeFeature();
	
    protected LaputaBiome() {
        super(new Biome.Builder()
        		.precipitation(RainType.NONE)
        		.scale(1.2f)
        		.temperature(5f)
        		.waterColor(3093151)
        		.waterFogColor(3093151)
        		.category(Category.PLAINS)
        		.downfall(0)
        		.depth(1.2f)
        		.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(TirphycraftBlocks.LAPUTA_GRASS.get().getDefaultState(),
        		TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState(), TirphycraftBlocks.LAPUTA_DIRT.get().getDefaultState())));
    
        addFeature(Decoration.SURFACE_STRUCTURES, Features.GIANT_ICE_PICK.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
    }
    
}
