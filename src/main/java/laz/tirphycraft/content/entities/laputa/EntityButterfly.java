package laz.tirphycraft.content.entities.laputa;

import java.util.Random;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityButterfly extends BatEntity {

	private static final DataParameter<Integer> COLOR = EntityDataManager.createKey(BatEntity.class,
			DataSerializers.VARINT);

	public EntityButterfly(EntityType<? extends EntityButterfly> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(COLOR, rand.nextInt(6));
	}

	public int getColor() {
		return this.dataManager.get(COLOR);
	}

	public void setColor(int i) {
		this.dataManager.set(COLOR, i);
	}

	@Override
	public void tick() {
		super.tick();
		if (getPosY() < 50) {
			this.setMotion(this.getMotion().x, 0.1, this.getMotion().z);
		}
	}

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		return getPosY() > 50;
	}
	
	public static boolean canSpawn(EntityType<BatEntity> batIn, IWorld worldIn, SpawnReason reason, BlockPos pos,
			Random randomIn) {
		return worldIn.getBlockState(pos.down()).isSolid();
	}

}
