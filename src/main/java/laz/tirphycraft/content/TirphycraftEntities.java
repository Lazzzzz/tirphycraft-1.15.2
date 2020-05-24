package laz.tirphycraft.content;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityKretun;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftEntities {

	public static RegistryObject<EntityType<EntityKretun>> ENTITY_KRETUN;

	public static void init() {
		ENTITY_KRETUN = TirphycraftRegistries.ENTITY_TYPE.register("kretun_entity",
				() -> EntityType.Builder.<EntityKretun>create(EntityKretun::new, EntityClassification.CREATURE)
						.size(1f, 1f).build(new ResourceLocation(Tirphycraft.MOD_ID, "kretun_entity").toString()));
	}
}
