package laz.tirphycraft.registry.init;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import laz.tirphycraft.content.entities.froz.EntityKretun;
import laz.tirphycraft.registry.TirphycraftRegistries;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class TirphycraftEntities {

	public static EntityType<EntityKretun> ENTITY_KRETUN;
	public static EntityType<EntityFrozenSoldier> ENTITY_FROZEN_SOLDIER;

	public static void init() {
		
		ENTITY_KRETUN = EntityType.Builder.<EntityKretun>create(EntityKretun::new, EntityClassification.AMBIENT)
				.size(0.3f, 0.3f).build(Tirphycraft.MOD_ID + ":kretun_entity");
		
		ENTITY_FROZEN_SOLDIER = EntityType.Builder.<EntityFrozenSoldier>create(EntityFrozenSoldier::new, EntityClassification.MONSTER)
				.size(0.8f, 2f).build(Tirphycraft.MOD_ID + ":frozen_soldier_entity");
		
		TirphycraftRegistries.ENTITY_TYPE.register("kretun_entity", () -> ENTITY_KRETUN);
		TirphycraftRegistries.ENTITY_TYPE.register("frozen_soldier_entity", () -> ENTITY_FROZEN_SOLDIER);
	}
}
