package laz.tirphycraft.content.entities.laputa;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class EntitySpiritMinion extends MonsterEntity {

	private EntityTreeSpirit sender = null;
	private int life = 20 * 8;

	public EntitySpiritMinion(EntityType<? extends EntitySpiritMinion> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1D);
	}
	

	public EntitySpiritMinion(EntityType<? extends EntitySpiritMinion> type, World worldIn, LivingEntity target,
			EntityTreeSpirit sender) {
		super(type, worldIn);
		this.setAttackTarget(target);
		this.sender = sender;
	}


	@Override
	public void livingTick() {		
		if (!world.isRemote) {
			if (life <= 0 || this.sender == null) this.remove();
			life --;
			if (life % 40 == 0) {
				ShulkerBulletEntity e = new ShulkerBulletEntity(world, this.sender, getAttackTarget(), Direction.Axis.Y);
				e.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
				world.addEntity(e);
				
			}
			this.setMotion(0, 0.05, 0);
		}
		super.livingTick();
	}
}
