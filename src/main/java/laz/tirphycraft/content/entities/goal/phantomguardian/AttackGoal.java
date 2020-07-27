package laz.tirphycraft.content.entities.goal.phantomguardian;

import java.util.List;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

public class AttackGoal extends Goal {
    private final EntityPredicate field_220842_b = (new EntityPredicate()).setDistance(64.0D);
    private int tickDelay = 20;
    EntityPhantomGuardian entity;
    
    public AttackGoal(EntityPhantomGuardian e) {
    	entity = e;
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
       if (this.tickDelay > 0) {
          --this.tickDelay;
          return false;
       } else {
          this.tickDelay = 60;
          List<PlayerEntity> list = entity.world.getTargettablePlayersWithinAABB(this.field_220842_b, entity, entity.getBoundingBox().grow(16.0D, 64.0D, 16.0D));
          if (!list.isEmpty()) {
             list.sort((p_203140_0_, p_203140_1_) -> {
                return p_203140_0_.getPosY() > p_203140_1_.getPosY() ? -1 : 1;
             });

             for(PlayerEntity playerentity : list) {
                if (entity.canAttack(playerentity, EntityPredicate.DEFAULT)) {
                   entity.setAttackTarget(playerentity);
                   return true;
                }
             }
          }

          return false;
       }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
       LivingEntity livingentity = entity.getAttackTarget();
       return livingentity != null ? entity.canAttack(livingentity, EntityPredicate.DEFAULT) : false;
    }
 }