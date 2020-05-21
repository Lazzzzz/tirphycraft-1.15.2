package laz.tirphycraft.world.dimension.noxis;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

public class NoxisGenSettings extends GenerationSettings {

	public NoxisGenSettings() {
        this.defaultBlock = Blocks.STONE.getDefaultState();
        this.defaultFluid = Blocks.AIR.getDefaultState();
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
