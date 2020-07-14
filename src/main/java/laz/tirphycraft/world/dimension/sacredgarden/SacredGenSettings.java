package laz.tirphycraft.world.dimension.sacredgarden;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.OverworldGenSettings;

public class SacredGenSettings extends OverworldGenSettings {

	private final int field_202215_m = 0;
	
	public SacredGenSettings(){
        this.defaultBlock = TirphycraftBlocks.SACRED_DIRT.get().getDefaultState();
        this.defaultFluid = TirphycraftBlocks.SACRED_DIRT.get().getDefaultState();
    }
	
	public int getBiomeSize() {
		return 4;
	}

	public int getRiverSize() {
		return 4;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
	
}
