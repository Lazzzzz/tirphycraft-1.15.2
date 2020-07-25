package laz.tirphycraft.content.entities.froz;

import java.util.UUID;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

public class EntityEskimo extends AmbientEntity {

	private UUID king = null;
	
	public EntityEskimo(EntityType<? extends EntityEskimo> type, World world) {
		super(type, world);
	}

	public EntityEskimo(EntityType<? extends EntityEskimo> type, World world, UUID king) {
		super(type, world);
		
		this.king = king;
		
	}
	
	@Override
	public void read(CompoundNBT compound) {
		king = compound.getUniqueId("kingUUID");
		super.read(compound);
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound) {
		compound.putUniqueId("kingUUID", king);
		super.writeAdditional(compound);
	}
	
}
