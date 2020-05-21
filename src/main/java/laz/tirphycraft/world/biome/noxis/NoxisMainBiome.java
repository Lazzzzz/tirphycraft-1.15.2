package laz.tirphycraft.world.biome.noxis;

import laz.tirphycraft.world.biome.base.NoxisBiome;
import laz.tirphycraft.world.features.Features;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.GenerationStage.Decoration;

public class NoxisMainBiome extends NoxisBiome {

    public NoxisMainBiome() {
        super();
    }
    
    @Override
    public void decorate(Decoration stage, ChunkGenerator<? extends GenerationSettings> chunkGenerator, IWorld worldIn,
    		long seed, SharedSeedRandom random, BlockPos pos) {
    	if (pos.getX() == 16 && pos.getZ() == 16) {
    		Features.FROZ_TELEPORTER.place(worldIn, chunkGenerator, random, pos);
    	}
    	super.decorate(stage, chunkGenerator, worldIn, seed, random, pos);
    }

}
