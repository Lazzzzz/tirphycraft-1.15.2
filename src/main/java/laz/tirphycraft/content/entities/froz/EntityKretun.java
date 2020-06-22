package laz.tirphycraft.content.entities.froz;

import java.util.List;

import laz.tirphycraft.content.entities.animation.KretunAnimation;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityKretun extends CreatureEntity {

	public KretunAnimation animation = new KretunAnimation();

	public EntityKretun(EntityType<? extends EntityKretun> entityType, World world) {
		super(entityType, world);

	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
	}

	@Override
	public void livingTick() {
		BlockPos pos = this.getPosition();
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 0.25f, pos.getY(), pos.getZ() - 0.25f, pos.getX() + 0.75f,
				pos.getY() + 1, pos.getZ() + 0.75f);
		List<LivingEntity> entity = world.getEntitiesWithinAABB(LivingEntity.class, box);

		if (entity.size() > 1)
			animation.startBite();
		animation.update();

		for (int i = 0; i < entity.size(); i++) {
			if (entity.get(i) != this) {
				entity.get(i).attackEntityFrom(DamageSource.CACTUS, 10);
			}
		}
		if (!this.world.isRemote) {
			int i = MathHelper.floor(this.getPosX());
			int j = MathHelper.floor(this.getPosY());
			int k = MathHelper.floor(this.getPosZ());

			BlockState blockstate = TirphycraftBlocks.POWDER_SNOW_LAYER.get().getDefaultState().with(SnowBlock.LAYERS,
					2);

			for (int l = 0; l < 4; ++l) {
				i = MathHelper.floor(this.getPosX() + (double) ((float) (l % 2 * 2 - 1) * 0.5F));
				j = MathHelper.floor(this.getPosY());
				k = MathHelper.floor(this.getPosZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.5F));
				BlockPos blockpos = new BlockPos(i, j, k);
				if (this.world.isAirBlock(blockpos)) {
					if (blockstate.isValidPosition(this.world, blockpos)) {
						this.world.setBlockState(blockpos, blockstate);
					}
				}
			}
		}
		super.livingTick();
	}

	public KretunAnimation getAnimation() {
		return this.animation;
	}

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		if (this.getPosition().getY() > 50) {
			for (int i = -1 ; i < 2; i ++) {
				for (int j = -1 ; j < 2; j ++) {
					if (this.world.getBlockState(this.getPosition().add(i,0,j)).getBlock() != TirphycraftBlocks.POWDER_SNOW_LAYER.getBlock()) return false;
				}
			}
			return true;
		}
		return false;
	}

}
