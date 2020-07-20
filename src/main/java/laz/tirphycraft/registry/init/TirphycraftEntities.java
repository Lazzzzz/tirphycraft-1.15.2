package laz.tirphycraft.registry.init;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityCrococasse;
import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import laz.tirphycraft.content.entities.froz.EntityKretun;
import laz.tirphycraft.content.entities.froz.EntityLombra;
import laz.tirphycraft.content.entities.froz.EntityMissileBat;
import laz.tirphycraft.content.entities.froz.EntityNecromancer;
import laz.tirphycraft.content.entities.laputa.EntityButterfly;
import laz.tirphycraft.content.entities.laputa.EntityDragonFly;
import laz.tirphycraft.content.entities.laputa.EntitySpiritHeart;
import laz.tirphycraft.content.entities.laputa.EntitySpiritMinion;
import laz.tirphycraft.content.entities.laputa.EntityTreeSpirit;
import laz.tirphycraft.registry.TirphycraftRegistries;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class TirphycraftEntities {

	public static EntityType<EntityKretun> ENTITY_KRETUN;
	public static EntityType<EntityFrozenSoldier> ENTITY_FROZEN_SOLDIER;
	public static EntityType<EntityNecromancer> ENTITY_NECROMANCER;
	public static EntityType<EntityMissileBat> ENTITY_MISSILE_BAT;
	public static EntityType<EntityCrococasse> ENTITY_CROCROCASSE;
	public static EntityType<EntityLombra> ENTITY_LOMBRA;
	
	public static EntityType<EntityButterfly> ENTITY_BUTTERFLY;
	public static EntityType<EntityDragonFly> ENTITY_DRAGON_FLY;
	public static EntityType<EntityTreeSpirit> ENTITY_SPIRIT_TREE;
	public static EntityType<EntitySpiritMinion> ENTITY_SPIRIT_MINION;
	public static EntityType<EntitySpiritHeart> ENTITY_SPIRIT_HEART;
	

	public static void init() {
		
		ENTITY_KRETUN = EntityType.Builder.<EntityKretun>create(EntityKretun::new, EntityClassification.MONSTER)
				.size(0.3f, 0.3f).build(Tirphycraft.MOD_ID + ":kretun_entity");
		
		ENTITY_FROZEN_SOLDIER = EntityType.Builder.<EntityFrozenSoldier>create(EntityFrozenSoldier::new, EntityClassification.MONSTER)
				.size(0.8f, 2f).build(Tirphycraft.MOD_ID + ":frozen_soldier_entity");
		
		ENTITY_NECROMANCER = EntityType.Builder.<EntityNecromancer>create(EntityNecromancer::new, EntityClassification.MONSTER)
				.size(0.8f, 2f).build(Tirphycraft.MOD_ID + ":necromancer");
		
		ENTITY_MISSILE_BAT = EntityType.Builder.<EntityMissileBat>create(EntityMissileBat::new, EntityClassification.AMBIENT)
				.size(0.5f, 0.5f).build(Tirphycraft.MOD_ID + ":missile_bat");
		
		ENTITY_CROCROCASSE = EntityType.Builder.<EntityCrococasse>create(EntityCrococasse::new, EntityClassification.MONSTER)
				.size(1f, 1f).build(Tirphycraft.MOD_ID + ":crocrocasse");
		
		ENTITY_LOMBRA = EntityType.Builder.<EntityLombra>create(EntityLombra::new, EntityClassification.MONSTER)
				.size(1f, 1.5f).build(Tirphycraft.MOD_ID + ":lombra");
		
		
		ENTITY_BUTTERFLY = EntityType.Builder.<EntityButterfly>create(EntityButterfly::new, EntityClassification.AMBIENT)
				.size(0.5f, 0.5f).build(Tirphycraft.MOD_ID + ":butterfly");
		
		ENTITY_DRAGON_FLY = EntityType.Builder.<EntityDragonFly>create(EntityDragonFly::new, EntityClassification.AMBIENT)
				.size(1f, 1f).build(Tirphycraft.MOD_ID + ":dragon_fly");
		
		ENTITY_SPIRIT_TREE = EntityType.Builder.<EntityTreeSpirit>create(EntityTreeSpirit::new, EntityClassification.MONSTER)
				.size(0.8f, 3f).build(Tirphycraft.MOD_ID + ":spirit_tree");
		
		ENTITY_SPIRIT_MINION = EntityType.Builder.<EntitySpiritMinion>create(EntitySpiritMinion::new, EntityClassification.MONSTER)
				.size(0.5f, 0.5f).build(Tirphycraft.MOD_ID + ":spirit_minion");
		
		ENTITY_SPIRIT_HEART = EntityType.Builder.<EntitySpiritHeart>create(EntitySpiritHeart::new, EntityClassification.MONSTER)
				.size(1f, 1f).build(Tirphycraft.MOD_ID + ":spirit_heart");
		
		TirphycraftRegistries.ENTITY_TYPE.register("kretun_entity", 		() -> ENTITY_KRETUN);
		TirphycraftRegistries.ENTITY_TYPE.register("frozen_soldier_entity", () -> ENTITY_FROZEN_SOLDIER);
		TirphycraftRegistries.ENTITY_TYPE.register("necromancer", 			() -> ENTITY_NECROMANCER);
		TirphycraftRegistries.ENTITY_TYPE.register("missile_bat", 			() -> ENTITY_MISSILE_BAT);
		TirphycraftRegistries.ENTITY_TYPE.register("crocrocasse", 			() -> ENTITY_CROCROCASSE);
		TirphycraftRegistries.ENTITY_TYPE.register("lombra", 				() -> ENTITY_LOMBRA);
		TirphycraftRegistries.ENTITY_TYPE.register("butterfly", 			() -> ENTITY_BUTTERFLY);
		TirphycraftRegistries.ENTITY_TYPE.register("spirit_tree", 			() -> ENTITY_SPIRIT_TREE);
		TirphycraftRegistries.ENTITY_TYPE.register("spirit_minion",			() -> ENTITY_SPIRIT_MINION);
		TirphycraftRegistries.ENTITY_TYPE.register("spirit_heart",			() -> ENTITY_SPIRIT_HEART);
		TirphycraftRegistries.ENTITY_TYPE.register("dragon_fly",			() -> ENTITY_DRAGON_FLY);
	}
}
