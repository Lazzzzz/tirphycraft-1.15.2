package laz.tirphycraft.content.tileEntities.altar;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.tileEntities.InventoryTile;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class AltarTE extends InventoryTile implements ITickableTileEntity {

	public AltarTE() {
		super(TirphycraftBlocks.ALTAR.getTileEntityType(),1);
	}

	@Override
	public void tick() {
		
	}
	
}
