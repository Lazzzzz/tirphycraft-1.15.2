package laz.tirphycraft.content.entities.goal.phantomguardian;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class OrbitGoal extends MoveGoal {
	
	private float field_203150_c;
    private float field_203151_d;
    private float field_203152_e;
    private float field_203153_f;

    public OrbitGoal(EntityPhantomGuardian e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
       return entity.getAttackTarget() == null || entity.attackPhase == entity.getAttackPhase(0);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
       this.field_203151_d = 5.0F + entity.world.rand.nextFloat() * 10.0F;
       this.field_203152_e = -4.0F + entity.world.rand.nextFloat() * 9.0F;
       this.field_203153_f = entity.world.rand.nextBoolean() ? 1.0F : -1.0F;
       this.func_203148_i();
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
       if (entity.world.rand.nextInt(350) == 0) {
          this.field_203152_e = -4.0F + entity.world.rand.nextFloat() * 9.0F;
       }

       if (entity.world.rand.nextInt(250) == 0) {
          ++this.field_203151_d;
          if (this.field_203151_d > 15.0F) {
             this.field_203151_d = 5.0F;
             this.field_203153_f = -this.field_203153_f;
          }
       }

       if (entity.world.rand.nextInt(450) == 0) {
          this.field_203150_c = entity.world.rand.nextFloat() * 2.0F * (float)Math.PI;
          this.func_203148_i();
       }

       if (this.func_203146_f()) {
          this.func_203148_i();
       }

       if (entity.orbitOffset.y < entity.getPosY() && !entity.world.isAirBlock((new BlockPos(entity)).down(1))) {
          this.field_203152_e = Math.max(1.0F, this.field_203152_e);
          this.func_203148_i();
       }

       if (entity.orbitOffset.y > entity.getPosY() && !entity.world.isAirBlock((new BlockPos(entity)).up(1))) {
          this.field_203152_e = Math.min(-1.0F, this.field_203152_e);
          this.func_203148_i();
       }

    }

    private void func_203148_i() {
       if (BlockPos.ZERO.equals(entity.orbitPosition)) {
          entity.orbitPosition = new BlockPos(entity);
       }

       this.field_203150_c += this.field_203153_f * 15.0F * ((float)Math.PI / 180F);
       entity.orbitOffset = (new Vec3d(entity.orbitPosition)).add((double)(this.field_203151_d * MathHelper.cos(this.field_203150_c)), (double)(-4.0F + this.field_203152_e), (double)(this.field_203151_d * MathHelper.sin(this.field_203150_c)));
    }
 }

