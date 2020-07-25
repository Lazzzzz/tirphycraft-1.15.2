package laz.tirphycraft.content.entities.froz;

import laz.tirphycraft.content.entities.animation.WinterSoldierAnimation;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityFrozenSoldier extends MonsterEntity {

	public WinterSoldierAnimation animation = new WinterSoldierAnimation(); 
	public boolean dungeon;
	
	public EntityFrozenSoldier(EntityType<? extends EntityFrozenSoldier> entityType, World world) {
		super(entityType, world);
		this.dungeon = false;
		for (int k = 0; k < 4; k++) {
			this.inventoryArmorDropChances[k] = 0;
		}
		this.inventoryHandsDropChances[0] = 0;
		this.inventoryHandsDropChances[1] = 0;
	}
	
	public EntityFrozenSoldier(EntityType<? extends EntityFrozenSoldier> entityType, World world, boolean dungeon) {
		super(entityType, world);
		this.dungeon = dungeon;
		for (int k = 0; k < 4; k++) {
			this.inventoryArmorDropChances[k] = 0;
		}
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.20F);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double) 3F);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();
	}
	
	protected void applyEntityAI() {
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2f, true));
	}
	
	
	@Override
	public void livingTick() {
		animation.update();
		super.livingTick();
	}
	
	public WinterSoldierAnimation getAnimation() {
		return this.animation;
	}
	
	@Override
	public void onKillEntity(LivingEntity entityLivingIn) {
		super.onKillEntity(entityLivingIn);
	}
	
	@Override
	public void read(CompoundNBT compound) {
		this.dungeon = compound.getBoolean("dungeon");
		super.read(compound);
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound) {
		compound.putBoolean("dungeon", this.dungeon);
		super.writeAdditional(compound);
	}
	
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		return worldIn.getBlockState(getPosition().down()).isSolid();
	}
	
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		if (rand.nextInt(10) == 0) this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(TirphycraftItems.DRAUGRIR_LEGS));
		if (rand.nextInt(10) == 0) this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(TirphycraftItems.DRAUGRIR_FEET));
		if (rand.nextInt(10) == 0) this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(TirphycraftItems.DRAUGRIR_CHEST));
		if (rand.nextInt(10) == 0) this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(TirphycraftItems.DRAUGRIR_HEAD));

		
		int r = worldIn.getRandom().nextInt(20);
		if (r == 0) this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TirphycraftItems.HISTICE_SWORD.get()));
		else if (r > 0 && r <= 3) this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TirphycraftItems.PICITE_SWORD.get()));
		else if (r > 3 && r <= 9) {
			if (worldIn.getRandom().nextBoolean()) this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TirphycraftItems.FROZ_WOODEN_SWORD.get()));
			else this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TirphycraftItems.FROZ_STONE_SWORD.get()));
		}
		
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
}
