package laz.tirphycraft.world.dimension.laputa;

import net.minecraft.world.gen.EndGenerationSettings;
import laz.tirphycraft.content.TirphycraftBlocks;

public class LaputaGenSettings extends EndGenerationSettings {

	public LaputaGenSettings(){
        this.defaultBlock = TirphycraftBlocks.LAPUTA_STONE.get().getDefaultState();
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
		return -10;
	}
}
