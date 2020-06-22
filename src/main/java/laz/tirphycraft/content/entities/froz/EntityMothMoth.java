package laz.tirphycraft.content.entities.froz;

import java.util.List;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityMothMoth extends MonsterEntity {

	public EntityMothMoth(EntityType<? extends EntityMothMoth> type, World worldIn) {
		super(type, worldIn);

	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2f, true));
	}
	
	@Override
	public boolean hitByEntity(Entity entityIn) {
		if (!world.isRemote && entityIn != null) {	
			if (entityIn instanceof LivingEntity) {
				AxisAlignedBB box = new AxisAlignedBB(this.getPosition().add(-10, -10, -10), this.getPosition().add(10,10,10));
				List<EntityMothMoth> l = world.getEntitiesWithinAABB(EntityMothMoth.class, box);	
				for (int i = 0; i < l.size(); i++) {
					l.get(i).setAttackTarget((LivingEntity) entityIn);
				}
			}
		}
		return super.hitByEntity(entityIn);
	}
}
