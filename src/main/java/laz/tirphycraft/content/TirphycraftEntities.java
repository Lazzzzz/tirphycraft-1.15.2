package laz.tirphycraft.content;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityKretun;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class TirphycraftEntities {

	public static EntityType<EntityKretun> ENTITY_KRETUN;

	public static void init() {
		
		ENTITY_KRETUN = EntityType.Builder.<EntityKretun>create(EntityKretun::new, EntityClassification.AMBIENT)
				.size(0.3f, 0.3f).build(Tirphycraft.MOD_ID + ":kretun_entity");
		
		TirphycraftRegistries.ENTITY_TYPE.register("kretun_entity", () -> ENTITY_KRETUN);
	}
}
