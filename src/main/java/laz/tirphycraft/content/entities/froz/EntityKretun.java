package laz.tirphycraft.content.entities.froz;

import net.minecraft.client.renderer.entity.model.GuardianModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityKretun extends CreatureEntity {

	private static final DataParameter<Boolean> BITE = EntityDataManager.createKey(EntityKretun.class,
			DataSerializers.BOOLEAN);
	public float step = 0.01f; // model animation

	public EntityKretun(EntityType<? extends EntityKretun> entityType, World world) {
		super(entityType, world);

	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
	}

	@Override
	protected void collideWithNearbyEntities() {

	}

	@Override
	protected void registerData() {
		this.dataManager.register(BITE, false);
		super.registerData();
	}

	@Override
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		this.dataManager.set(BITE, true);
		entityIn.setMotion(0,0,0);
	}

	@Override
	public void tick() {
		this.dataManager.set(BITE, false);
		super.tick();
	}
	
	public boolean getBite() {
		return this.dataManager.get(BITE);
	}
}
