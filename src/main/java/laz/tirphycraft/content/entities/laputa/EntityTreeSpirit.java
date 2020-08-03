package laz.tirphycraft.content.entities.laputa;

import java.util.Collection;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.goal.spirittree.BreakingBlockGoal;
import laz.tirphycraft.content.entities.goal.spirittree.SumonHeartGoal;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class EntityTreeSpirit extends MonsterEntity {

	private ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN,
			BossInfo.Overlay.PROGRESS);
	
	private static final DataParameter<Integer> SHIELD = EntityDataManager.createKey(EntityTreeSpirit.class,
			DataSerializers.VARINT);

	public EntityTreeSpirit(EntityType<? extends EntityTreeSpirit> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new BreakingBlockGoal(this));
		this.targetSelector.addGoal(1, new SumonHeartGoal(this));
//		this.targetSelector.addGoal(1, new ThunderLineGoal(this));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.0F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100D);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent("Spirit Tree  SHIELD : " + this.getShield());
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(SHIELD, 12);
	}

	public int getShield() {
		return this.dataManager.get(SHIELD);
	}

	public void hitShield() {
		if (getShield() > 0)
			this.dataManager.set(SHIELD, getShield() - 1);
	}
	
	public void setShield(int shields) {
		this.dataManager.set(SHIELD, shields);
	}

	@Override
	public boolean isNonBoss() {
		return false;
	}

	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void updateAITasks() {
		super.updateAITasks();
		this.bossInfo.setName(this.getDisplayName());
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public void livingTick() {
		Collection<EffectInstance> potions = getActivePotionEffects();

		for (EffectInstance effect : potions) {
			removePotionEffect(effect.getPotion());
		}
		
		this.setMotion(0, getMotion().y ,0);
		if (!world.isRemote) {
			if (this.getAttackTarget() == null && world.getClosestPlayer(this, 50) == null) {
				world.setBlockState(getPosition().up(29), TirphycraftBlocks.LAPUTA_ACTIVATOR_OFF.get().getDefaultState());
				this.remove();
			}

			spawnThing();
		}
		
		super.livingTick();

	}
	
	@Override
	protected void collideWithNearbyEntities() {
	}
	
	public void spawnThing() {
		if (this.ticksExisted % 75 == 0 && this.getAttackTarget() != null) {
			EntitySpiritMinion m = new EntitySpiritMinion(TirphycraftEntities.ENTITY_SPIRIT_MINION, world, this.getAttackTarget(), this);
			double x = 0;
			double z = 0;
			boolean flag = true;
			while (flag) {
				x = rand.nextInt(60) - 30;
				z = rand.nextInt(60) - 30;
				if (x != 0 || z != 0 || x * x + z * z <= 15 * 15) flag = false;
			}
			m.setPositionAndUpdate(this.getPosX() + x + 0.5, this.getPosY(), this.getPosZ() + z + 0.5);
			world.addEntity(m);
		}
	}
	
	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getImmediateSource() instanceof AbstractArrowEntity || source.getImmediateSource() instanceof ShulkerBulletEntity) {
			return false;
		}
		return super.attackEntityFrom(source, amount);
	}
	
	@Override
	public void read(CompoundNBT compound) {
		setShield(compound.getInt("shields"));
		super.read(compound);
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound) {
		compound.putInt("shields", getShield());
		super.writeAdditional(compound);
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
//		if (entityIn instanceof PlayerEntity) {
//			PlayerEntity player = (PlayerEntity) entityIn;
//			return !player.isCreative();
//		}
		return true;
	}
	
	public void damageIt() {
		if (this.getShield() > 0) this.hitShield();
		else this.setHealth(this.getHealth() - (rand.nextInt(4) + 1) * 5);
		
		if (this.getHealth() <= 0) {
			world.setBlockState(getPosition().up(29), TirphycraftBlocks.LAPUTA_DUNGEON_VARIANT0.get().getDefaultState());
			spawnChest();
			world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(),
					new ItemStack(TirphycraftItems.TREE_CORE.get(), 4)));
			for (int i = 0; i < rand.nextInt(5)+1; i++) {
			world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(),
					new ItemStack(TirphycraftBlocks.ORE_TENIUM.get(), 1)));
			}
		}
	}
	
	private void spawnChest() {
		int number = rand.nextInt(10) + 3;
		ResourceLocation LOOT = new ResourceLocation(Tirphycraft.MOD_ID + ":chests/laputa_dungeon");
		for (int i = 0; i < number; i++) {
			BlockPos pos = setChestPos();
			world.setBlockState(pos, Blocks.CHEST.getDefaultState().rotate(Rotation.randomRotation(rand)),
					3);
			TileEntity tileentity = world.getTileEntity(pos);
			if (tileentity instanceof ChestTileEntity) {
				((ChestTileEntity) tileentity).setLootTable(LOOT, rand.nextLong());
			}
		}
	}
	
	private BlockPos setChestPos() {
		double x = 0;
		double z = 0;
		boolean flag = true;
		while (flag) {
			x = rand.nextInt(20) - 10;
			z = rand.nextInt(20) - 10;
			if (x != 0 || z != 0 || x * x + z * z <= 15 * 15) flag = false;
		}
		
		return new BlockPos(this.getPosX() + x, this.getPosY(), this.getPosZ() + z);
	}
	
}
