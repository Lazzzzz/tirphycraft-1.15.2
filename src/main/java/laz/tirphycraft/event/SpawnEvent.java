package laz.tirphycraft.event;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import laz.tirphycraft.content.entities.froz.EntityLombra;
import laz.tirphycraft.registry.init.TirphycraftDimensions;
import laz.tirphycraft.registry.init.TirphycraftItems;
import laz.tirphycraft.world.features.StructureFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Tirphycraft.MOD_ID)
public class SpawnEvent {

	@SubscribeEvent
	public static void spawnInDungeon(LivingSpawnEvent.CheckSpawn event) {
		LivingEntity entity = event.getEntityLiving();
		World world = entity.getEntityWorld();
		if (!world.getBlockState(entity.getPosition().down()).isSolid() && !(entity instanceof EntityLombra)) {
			for (int i = 0; i < 40; i++) {
				BlockPos pos = new BlockPos(entity.getPosX(), i, entity.getPosZ());
				if (world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
					entity.setPositionAndUpdate(entity.getPosX(), i, entity.getPosZ());
					break;
				}
			}
		}
		if (!world.isRemote) {

			if (world.getDimension().getType().getModType() == TirphycraftDimensions.FROZ_DIM.get()) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				BlockPos pos = ((ServerWorld) world).findNearestStructure(
						StructureFeatures.FROZ_DUNGEON.getStructureName(), entity.getPosition(), 40, false);
				if (x > pos.getX() && x < pos.getX() + 136 && z > pos.getZ() && z < pos.getZ() + 136 && y < 18) {
					if (entity instanceof EntityFrozenSoldier) {

						entity.setHealth(entity.getMaxHealth() / 2);
						entity.setItemStackToSlot(EquipmentSlotType.LEGS,
								new ItemStack(TirphycraftItems.DRAUGRIR_LEGS));
						entity.setItemStackToSlot(EquipmentSlotType.FEET,
								new ItemStack(TirphycraftItems.DRAUGRIR_FEET));
						entity.setItemStackToSlot(EquipmentSlotType.CHEST,
								new ItemStack(TirphycraftItems.DRAUGRIR_CHEST));
						entity.setItemStackToSlot(EquipmentSlotType.HEAD,
								new ItemStack(TirphycraftItems.DRAUGRIR_HEAD));
					}
					
				}
			}
		}
	}

}
