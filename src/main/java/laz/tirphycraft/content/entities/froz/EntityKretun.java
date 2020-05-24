package laz.tirphycraft.content.entities.froz;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EntityKretun extends CreatureEntity {
	
	public boolean bite = false; //model animation
	public float step = 0.01f;   //model animation
	
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
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		bite = true;
		entityIn.setMotion(0,0,0);
	}
	
	@Override
	public void tick() {
		bite = false;
		super.tick();
	}
}
