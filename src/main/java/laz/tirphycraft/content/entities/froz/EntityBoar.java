package laz.tirphycraft.content.entities.froz;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBoar extends CowEntity {

	public EntityBoar(EntityType<? extends EntityBoar> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		return (worldIn.getBlockState(getPosition().down()) != Blocks.AIR.getDefaultState()
				&& worldIn.canSeeSky(getPosition().up()));
	}

	@Override
	public EntityBoar createChild(AgeableEntity ageable) {
		return null;
	}

	protected SoundEvent getAmbientSound() {
		return null;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return null;
	}

	protected SoundEvent getDeathSound() {
		return null;
	}

}
