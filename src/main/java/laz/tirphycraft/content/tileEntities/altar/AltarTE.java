package laz.tirphycraft.content.tileEntities.altar;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class AltarTE extends TileEntity implements ITickableTileEntity {

	public AltarTE() {
		super(TirphycraftBlocks.ALTAR.getTileEntityType());
		System.out.println("bind");
	}

	@Override
	public void tick() {
		BlockPos p = this.pos;
		this.getWorld().setBlockState(p.down(), Blocks.AIR.getDefaultState());
	}
	
}
