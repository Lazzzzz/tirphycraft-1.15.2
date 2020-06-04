package laz.tirphycraft.world.dimension.froz;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.OverworldGenSettings;

public class FrozGenSettings extends OverworldGenSettings {

	private final int field_202215_m = 0;
	
	public FrozGenSettings(){
        this.defaultBlock = TirphycraftBlocks.FROZ_STONE.get().getDefaultState();
        this.defaultFluid = Blocks.ICE.getDefaultState();
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
