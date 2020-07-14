package laz.tirphycraft.registry.init;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;
import static laz.tirphycraft.registry.TirphycraftRegistries.addArmor;
import static laz.tirphycraft.registry.TirphycraftRegistries.addAxe;
import static laz.tirphycraft.registry.TirphycraftRegistries.addHoe;
import static laz.tirphycraft.registry.TirphycraftRegistries.addItemClass;
import static laz.tirphycraft.registry.TirphycraftRegistries.addPickaxe;
import static laz.tirphycraft.registry.TirphycraftRegistries.addShovel;
import static laz.tirphycraft.registry.TirphycraftRegistries.addSimpleFood;
import static laz.tirphycraft.registry.TirphycraftRegistries.addSimpleItem;
import static laz.tirphycraft.registry.TirphycraftRegistries.addSword;

import laz.tirphycraft.content.items.Debug;
import laz.tirphycraft.content.items.amulets.AmuletAnti;
import laz.tirphycraft.content.items.amulets.AmuletAttack1;
import laz.tirphycraft.content.items.amulets.AmuletAttack2;
import laz.tirphycraft.content.items.amulets.AmuletAttack3;
import laz.tirphycraft.content.items.amulets.AmuletHealth1;
import laz.tirphycraft.content.items.amulets.AmuletHealth2;
import laz.tirphycraft.content.items.amulets.AmuletHealth3;
import laz.tirphycraft.content.items.amulets.AmuletSpeed1;
import laz.tirphycraft.content.items.amulets.AmuletSpeed2;
import laz.tirphycraft.content.items.amulets.AmuletSpeed3;
import laz.tirphycraft.content.items.armor.ArmorDraugrir;
import laz.tirphycraft.content.items.armor.ArmorHeavy;
import laz.tirphycraft.content.items.armor.ArmorNixium;
import laz.tirphycraft.content.items.armor.ArmorOrigin;
import laz.tirphycraft.content.items.armor.ArmorPyrodes;
import laz.tirphycraft.content.items.armor.ArmorRose;
import laz.tirphycraft.content.items.armor.ArmorTenium;
import laz.tirphycraft.content.items.artefacts.ArtefactFeatherOfLight;
import laz.tirphycraft.content.items.artefacts.ArtefactSunTear;
import laz.tirphycraft.content.items.clocks.ClockFroz;
import laz.tirphycraft.content.items.clocks.ClockGosyn;
import laz.tirphycraft.content.items.clocks.ClockLaputa;
import laz.tirphycraft.content.items.clocks.ClockNoxis;
import laz.tirphycraft.content.items.clocks.ClockReturn;
import laz.tirphycraft.content.items.other.ItemShiny;
import laz.tirphycraft.content.items.other.itemFuel;
import laz.tirphycraft.content.items.other.book.BookOfKnowledge;
import laz.tirphycraft.content.items.seed.SeedT1;
import laz.tirphycraft.content.items.staff.StaffExplosion1;
import laz.tirphycraft.content.items.staff.StaffExplosion2;
import laz.tirphycraft.content.items.staff.StaffExplosion3;
import laz.tirphycraft.content.items.staff.StaffFireBall1;
import laz.tirphycraft.content.items.staff.StaffFireBall2;
import laz.tirphycraft.content.items.staff.StaffFireBall3;
import laz.tirphycraft.content.items.staff.StaffHeal1;
import laz.tirphycraft.content.items.staff.StaffHeal2;
import laz.tirphycraft.content.items.staff.StaffHeal3;
import laz.tirphycraft.content.items.staff.StaffTeleportation1;
import laz.tirphycraft.content.items.staff.StaffTeleportation2;
import laz.tirphycraft.content.items.staff.StaffTeleportation3;
import laz.tirphycraft.content.items.tiers.TirphycraftArmorTiers;
import laz.tirphycraft.content.items.tiers.TirphycraftToolTiers;
import laz.tirphycraft.content.items.totems.TotemLevitation;
import laz.tirphycraft.content.items.totems.TotemThunder;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftItems {

	public static RegistryObject<Item> BOOK_OF_KNOWLEDGE;//
	
	public static RegistryObject<Item> CRYSTAL_PYRODES;//
	public static RegistryObject<Item> HEAVY_INGOT;//
	public static RegistryObject<Item> NIXIUM_INGOT;//
	public static RegistryObject<Item> TENIUM_INGOT;//
	public static RegistryObject<Item> HISTICE_GEM;///
	public static RegistryObject<Item> PICITE_INGOT;///
	public static RegistryObject<Item> ROSE_SHARD;///
	public static RegistryObject<Item> ORIGIN_INGOT;///
	
	
	public static RegistryObject<Item> FRAGMENT_BLUE;///
	public static RegistryObject<Item> FRAGMENT_RED;///
	public static RegistryObject<Item> FRAGMENT_YELLOW;///
	public static RegistryObject<Item> FRAGMENT_WHITE;///
	public static RegistryObject<Item> FRAGMENT_GREEN;///

	public static RegistryObject<Item> AMULET_ANTI;//
	public static RegistryObject<Item> AMULET_HEALTH_2;//
	public static RegistryObject<Item> AMULET_HEALTH_3;//
	public static RegistryObject<Item> AMULET_HEALTH_1;//
	public static RegistryObject<Item> AMULET_ATTACK_2;//
	public static RegistryObject<Item> AMULET_ATTACK_3;//
	public static RegistryObject<Item> AMULET_ATTACK_1;//
	public static RegistryObject<Item> AMULET_SPEED_2;//
	public static RegistryObject<Item> AMULET_SPEED_3;//
	public static RegistryObject<Item> AMULET_SPEED_1;//
	public static RegistryObject<Item> TOTEM_LEVITATION;//
	public static RegistryObject<Item> TOTEM_THUNDER;//

	public static RegistryObject<Item> COAL_ON_COKE;//
	public static RegistryObject<Item> DIAMOND_NUGGET;///
	public static RegistryObject<Item> MUMMY_WRAPS;///
	public static RegistryObject<Item> EMPTY_SYRINGE;///
	public static RegistryObject<Item> BLUE_ROSE_PETAL;///
	public static RegistryObject<Item> FROZ_KEY;///
	public static RegistryObject<Item> ORIGIN_MATTER;///
	public static RegistryObject<Item> EXPLOSION_CORE;///
	public static RegistryObject<Item> SEA_CORE;///
	public static RegistryObject<Item> LIFE_CORE;///
	public static RegistryObject<Item> STICK_CRYSTAL;//
	public static RegistryObject<Item> STICK_COPPIR;//
	public static RegistryObject<Item> STICK_SILVIR;//
	public static RegistryObject<Item> STICK_GOLDIR;//
	public static RegistryObject<Item> STICK_FROZ;//
	
	public static RegistryObject<Item> FROZEN_BUFFALO_RAW;///
	public static RegistryObject<Item> FROZEN_BUFFALO;///
	public static RegistryObject<Item> FROZEN_BOARCHOP_RAW;///
	public static RegistryObject<Item> FROZEN_BOARCHOP;///
	public static RegistryObject<Item> FRUIT_BALL_RED;//
	public static RegistryObject<Item> FRUIT_BALL_BLUE;//
	public static RegistryObject<Item> FRUIT_BALL_GREEN;//
	public static RegistryObject<Item> KIWI;///

	public static RegistryObject<Item> QUEEN_HEART;//
	public static RegistryObject<Item> ANKH;///
	public static RegistryObject<Item> POSEIDON_EYE;///

	public static RegistryObject<Item> STAFF_1_HEAL;//
	public static RegistryObject<Item> STAFF_2_HEAL;//
	public static RegistryObject<Item> STAFF_3_HEAL;//
	public static RegistryObject<Item> STAFF_1_TELEPORTATION;//
	public static RegistryObject<Item> STAFF_2_TELEPORTATION;//
	public static RegistryObject<Item> STAFF_3_TELEPORTATION;//
	public static RegistryObject<Item> STAFF_1_EXPLOSION;//
	public static RegistryObject<Item> STAFF_2_EXPLOSION;//
	public static RegistryObject<Item> STAFF_3_EXPLOSION;//
	public static RegistryObject<Item> STAFF_1_FIREBALL;//
	public static RegistryObject<Item> STAFF_2_FIREBALL;//
	public static RegistryObject<Item> STAFF_3_FIREBALL;//

	public static RegistryObject<Item> RETURN_CLOCK;//
	public static RegistryObject<Item> NOXIS_CLOCK;//
	public static RegistryObject<Item> LAPUTA_CLOCK;//
	public static RegistryObject<Item> GOSYN_CLOCK;//
	public static RegistryObject<Item> FROZ_CLOCK;//

	public static RegistryObject<Item> SUN_TEAR;//
	public static RegistryObject<Item> FEATHER_OF_LIGHT;//		
	
	public static RegistryObject<Item> CRYSTAL;//
	public static RegistryObject<Item> CRYSTAL_PURODES;//
	public static RegistryObject<Item> DEBUG;//

	public static RegistryObject<Item> SEED_T1_1;
	public static RegistryObject<Item> SEED_T1_2;
	public static RegistryObject<Item> SEED_T1_3;
	
	public static Item PYRODES_FEET;//
	public static Item PYRODES_LEGS;
	public static Item PYRODES_CHEST;
	public static Item PYRODES_HEAD;

	public static Item HEAVY_FEET;//
	public static Item HEAVY_LEGS;
	public static Item HEAVY_CHEST;
	public static Item HEAVY_HEAD;	
	
	public static Item NIXIUM_FEET;//
	public static Item NIXIUM_LEGS;
	public static Item NIXIUM_CHEST;
	public static Item NIXIUM_HEAD;

	public static Item TENIUM_FEET;//
	public static Item TENIUM_LEGS;
	public static Item TENIUM_CHEST;
	public static Item TENIUM_HEAD;
	
	public static Item DRAUGRIR_FEET;//
	public static Item DRAUGRIR_LEGS;
	public static Item DRAUGRIR_CHEST;
	public static Item DRAUGRIR_HEAD;

	public static Item ROSE_FEET;//
	public static Item ROSE_LEGS;
	public static Item ROSE_CHEST;
	public static Item ROSE_HEAD;

	public static Item ORIGIN_FEET;//
	public static Item ORIGIN_LEGS;
	public static Item ORIGIN_CHEST;
	public static Item ORIGIN_HEAD;
	
	public static RegistryObject<Item> PYRODES_AXE;//
	public static RegistryObject<Item> PYRODES_PICKAXE;
	public static RegistryObject<Item> PYRODES_SWORD;
	public static RegistryObject<Item> PYRODES_SHOVEL;
	public static RegistryObject<Item> PYRODES_HOE;

	public static RegistryObject<Item> HEAVY_AXE;//
	public static RegistryObject<Item> HEAVY_PICKAXE;
	public static RegistryObject<Item> HEAVY_SWORD;
	public static RegistryObject<Item> HEAVY_SHOVEL;
	public static RegistryObject<Item> HEAVY_HOE;
	
	public static RegistryObject<Item> FROZ_WOODEN_AXE;//
	public static RegistryObject<Item> FROZ_WOODEN_PICKAXE;
	public static RegistryObject<Item> FROZ_WOODEN_SWORD;
	public static RegistryObject<Item> FROZ_WOODEN_SHOVEL;
	public static RegistryObject<Item> FROZ_WOODEN_HOE;
	
	public static RegistryObject<Item> FROZ_STONE_AXE;//
	public static RegistryObject<Item> FROZ_STONE_PICKAXE;
	public static RegistryObject<Item> FROZ_STONE_SWORD;
	public static RegistryObject<Item> FROZ_STONE_SHOVEL;
	public static RegistryObject<Item> FROZ_STONE_HOE;
	
	public static RegistryObject<Item> HISTICE_AXE;//
	public static RegistryObject<Item> HISTICE_PICKAXE;
	public static RegistryObject<Item> HISTICE_SWORD;
	public static RegistryObject<Item> HISTICE_SHOVEL;
	public static RegistryObject<Item> HISTICE_HOE;
	
	public static RegistryObject<Item> PICITE_AXE;//
	public static RegistryObject<Item> PICITE_PICKAXE;
	public static RegistryObject<Item> PICITE_SWORD;
	public static RegistryObject<Item> PICITE_SHOVEL;
	public static RegistryObject<Item> PICITE_HOE;	

	public static RegistryObject<Item> NIXIUM_AXE;//
	public static RegistryObject<Item> NIXIUM_PICKAXE;
	public static RegistryObject<Item> NIXIUM_SWORD;
	public static RegistryObject<Item> NIXIUM_SHOVEL;
	public static RegistryObject<Item> NIXIUM_HOE;

	public static RegistryObject<Item> TENIUM_AXE;//
	public static RegistryObject<Item> TENIUM_PICKAXE;
	public static RegistryObject<Item> TENIUM_SWORD;
	public static RegistryObject<Item> TENIUM_SHOVEL;
	public static RegistryObject<Item> TENIUM_HOE;
	
	public static RegistryObject<Item> FOOD1;//	
	
	public static void init() {

		PYRODES_FEET 	= new ArmorPyrodes(TirphycraftArmorTiers.PYRODES, EquipmentSlotType.FEET);
		PYRODES_LEGS 	= new ArmorPyrodes(TirphycraftArmorTiers.PYRODES, EquipmentSlotType.LEGS);
		PYRODES_CHEST	= new ArmorPyrodes(TirphycraftArmorTiers.PYRODES, EquipmentSlotType.CHEST);
		PYRODES_HEAD 	= new ArmorPyrodes(TirphycraftArmorTiers.PYRODES, EquipmentSlotType.HEAD);
		
		HEAVY_FEET		= new ArmorHeavy(TirphycraftArmorTiers.HEAVY, EquipmentSlotType.FEET);
		HEAVY_LEGS		= new ArmorHeavy(TirphycraftArmorTiers.HEAVY, EquipmentSlotType.LEGS);
		HEAVY_CHEST		= new ArmorHeavy(TirphycraftArmorTiers.HEAVY, EquipmentSlotType.CHEST);
		HEAVY_HEAD		= new ArmorHeavy(TirphycraftArmorTiers.HEAVY, EquipmentSlotType.HEAD);
		
		NIXIUM_FEET		= new ArmorNixium(TirphycraftArmorTiers.NIXIUM, EquipmentSlotType.FEET);
		NIXIUM_LEGS		= new ArmorNixium(TirphycraftArmorTiers.NIXIUM, EquipmentSlotType.LEGS);
		NIXIUM_CHEST	= new ArmorNixium(TirphycraftArmorTiers.NIXIUM, EquipmentSlotType.CHEST);
		NIXIUM_HEAD		= new ArmorNixium(TirphycraftArmorTiers.NIXIUM, EquipmentSlotType.HEAD);
	
		DRAUGRIR_FEET   = new ArmorDraugrir(TirphycraftArmorTiers.DRAUGRIR, EquipmentSlotType.FEET);
		DRAUGRIR_LEGS   = new ArmorDraugrir(TirphycraftArmorTiers.DRAUGRIR, EquipmentSlotType.LEGS);
		DRAUGRIR_CHEST  = new ArmorDraugrir(TirphycraftArmorTiers.DRAUGRIR, EquipmentSlotType.CHEST);
		DRAUGRIR_HEAD   = new ArmorDraugrir(TirphycraftArmorTiers.DRAUGRIR, EquipmentSlotType.HEAD);
		
		TENIUM_FEET		= new ArmorTenium(TirphycraftArmorTiers.TENIUM, EquipmentSlotType.FEET);
		TENIUM_LEGS		= new ArmorTenium(TirphycraftArmorTiers.TENIUM, EquipmentSlotType.LEGS);
		TENIUM_CHEST	= new ArmorTenium(TirphycraftArmorTiers.TENIUM, EquipmentSlotType.CHEST);
		TENIUM_HEAD		= new ArmorTenium(TirphycraftArmorTiers.TENIUM, EquipmentSlotType.HEAD);
		
		ROSE_FEET		= new ArmorRose(TirphycraftArmorTiers.ROSE, EquipmentSlotType.FEET);
		ROSE_LEGS		= new ArmorRose(TirphycraftArmorTiers.ROSE, EquipmentSlotType.LEGS);
		ROSE_CHEST		= new ArmorRose(TirphycraftArmorTiers.ROSE, EquipmentSlotType.CHEST);
		ROSE_HEAD		= new ArmorRose(TirphycraftArmorTiers.ROSE, EquipmentSlotType.HEAD);
		
		ORIGIN_FEET		= new ArmorOrigin(TirphycraftArmorTiers.ORIGIN, EquipmentSlotType.FEET);
		ORIGIN_LEGS		= new ArmorOrigin(TirphycraftArmorTiers.ORIGIN, EquipmentSlotType.LEGS);
		ORIGIN_CHEST	= new ArmorOrigin(TirphycraftArmorTiers.ORIGIN, EquipmentSlotType.CHEST);
		ORIGIN_HEAD		= new ArmorOrigin(TirphycraftArmorTiers.ORIGIN, EquipmentSlotType.HEAD);
	
		
		BOOK_OF_KNOWLEDGE = addItemClass("book_of_knowledge", BookOfKnowledge::new);
		
		AMULET_ANTI = addItemClass("anti_amulet", AmuletAnti::new);

		AMULET_HEALTH_1 = addItemClass("amulet_1_health", AmuletHealth1::new);
		AMULET_HEALTH_2 = addItemClass("amulet_2_health", AmuletHealth2::new);
		AMULET_HEALTH_3 = addItemClass("amulet_3_health", AmuletHealth3::new);

		AMULET_ATTACK_1 = addItemClass("amulet_1_attack", AmuletAttack1::new);
		AMULET_ATTACK_2 = addItemClass("amulet_2_attack", AmuletAttack2::new);
		AMULET_ATTACK_3 = addItemClass("amulet_3_attack", AmuletAttack3::new);

		AMULET_SPEED_1 = addItemClass("amulet_1_speed", AmuletSpeed1::new);
		AMULET_SPEED_2 = addItemClass("amulet_2_speed", AmuletSpeed2::new);
		AMULET_SPEED_3 = addItemClass("amulet_3_speed", AmuletSpeed3::new);

		DEBUG = addItemClass("debug", Debug::new);
		
		TOTEM_LEVITATION = addItemClass("totem_levitation", TotemLevitation::new);
		TOTEM_THUNDER = addItemClass("totem_thunder", TotemThunder::new);

		TENIUM_INGOT = addItemClass("tenium_ingot", ItemShiny::new);
		

		QUEEN_HEART = addItemClass("queen_heart", ItemShiny::new);
		ANKH = addItemClass("ankh", ItemShiny::new);
		POSEIDON_EYE = addItemClass("poseidon_eye", ItemShiny::new);

		STAFF_1_HEAL = addItemClass("staff_1_heal", StaffHeal1::new);
		STAFF_2_HEAL = addItemClass("staff_2_heal", StaffHeal2::new);
		STAFF_3_HEAL = addItemClass("staff_3_heal", StaffHeal3::new);
		STAFF_1_TELEPORTATION = addItemClass("staff_1_teleportation", StaffTeleportation1::new);
		STAFF_2_TELEPORTATION = addItemClass("staff_2_teleportation", StaffTeleportation2::new);
		STAFF_3_TELEPORTATION = addItemClass("staff_3_teleportation", StaffTeleportation3::new);
		STAFF_1_EXPLOSION = addItemClass("staff_1_explosion", StaffExplosion1::new);
		STAFF_2_EXPLOSION = addItemClass("staff_2_explosion", StaffExplosion2::new);
		STAFF_3_EXPLOSION = addItemClass("staff_3_explosion", StaffExplosion3::new);
		STAFF_1_FIREBALL = addItemClass("staff_1_fireball", StaffFireBall1::new);
		STAFF_2_FIREBALL = addItemClass("staff_2_fireball", StaffFireBall2::new);
		STAFF_3_FIREBALL = addItemClass("staff_3_fireball", StaffFireBall3::new);
		
		SEED_T1_1 = addItemClass("seed_t1_1", SeedT1::new);
		SEED_T1_2 = addItemClass("seed_t1_2", SeedT1::new);
		SEED_T1_3 = addItemClass("seed_t1_3", SeedT1::new);
		
		RETURN_CLOCK = addItemClass("return_clock",ClockReturn::new);
		NOXIS_CLOCK = addItemClass("noxis_clock",ClockNoxis::new);
		LAPUTA_CLOCK = addItemClass("laputa_clock", ClockLaputa::new);
		GOSYN_CLOCK = addItemClass("gosyn_clock",ClockGosyn::new);
		FROZ_CLOCK = addItemClass("froz_clock",ClockFroz::new);

		SUN_TEAR = addItemClass("sun_tear", ArtefactSunTear::new);
		FEATHER_OF_LIGHT = addItemClass("feather_of_light", ArtefactFeatherOfLight::new);
		
		PYRODES_AXE = addAxe("pyrodes", TirphycraftToolTiers.PYRODES_TOOL);
		PYRODES_PICKAXE = addPickaxe("pyrodes", TirphycraftToolTiers.PYRODES_TOOL);
		PYRODES_SWORD = addSword("pyrodes", TirphycraftToolTiers.PYRODES_TOOL);
		PYRODES_SHOVEL = addShovel("pyrodes", TirphycraftToolTiers.PYRODES_TOOL);
		PYRODES_HOE = addHoe("pyrodes", TirphycraftToolTiers.PYRODES_TOOL);
		
		HEAVY_AXE = addAxe("heavy", TirphycraftToolTiers.HEAVY_TOOL);
		HEAVY_PICKAXE = addPickaxe("heavy", TirphycraftToolTiers.HEAVY_TOOL);
		HEAVY_SWORD = addSword("heavy", TirphycraftToolTiers.HEAVY_TOOL);
		HEAVY_SHOVEL = addShovel("heavy", TirphycraftToolTiers.HEAVY_TOOL);
		HEAVY_HOE = addHoe("heavy", TirphycraftToolTiers.HEAVY_TOOL);

		FROZ_WOODEN_AXE = addAxe("froz_wooden", ItemTier.WOOD);
		FROZ_WOODEN_PICKAXE = addPickaxe("froz_wooden",ItemTier.WOOD);
		FROZ_WOODEN_SWORD = addSword("froz_wooden", ItemTier.WOOD);
		FROZ_WOODEN_SHOVEL = addShovel("froz_wooden", ItemTier.WOOD);
		FROZ_WOODEN_HOE = addHoe("froz_wooden", ItemTier.WOOD);
		
		FROZ_STONE_AXE = addAxe("froz_stone", ItemTier.STONE);
		FROZ_STONE_PICKAXE = addPickaxe("froz_stone",ItemTier.STONE);
		FROZ_STONE_SWORD = addSword("froz_stone", ItemTier.STONE);
		FROZ_STONE_SHOVEL = addShovel("froz_stone", ItemTier.STONE);
		FROZ_STONE_HOE = addHoe("froz_stone", ItemTier.STONE);
		
		HISTICE_AXE = addAxe("histice", TirphycraftToolTiers.HISTICE_TOOL);
		HISTICE_PICKAXE = addPickaxe("histice",TirphycraftToolTiers.HISTICE_TOOL);
		HISTICE_SWORD = addSword("histice", TirphycraftToolTiers.HISTICE_TOOL);
		HISTICE_SHOVEL = addShovel("histice", TirphycraftToolTiers.HISTICE_TOOL);
		HISTICE_HOE = addHoe("histice", TirphycraftToolTiers.HISTICE_TOOL);
		
		PICITE_AXE = addAxe("picite", TirphycraftToolTiers.PICITE_TOOL);
		PICITE_PICKAXE = addPickaxe("picite", TirphycraftToolTiers.PICITE_TOOL);
		PICITE_SWORD = addSword("picite", TirphycraftToolTiers.PICITE_TOOL);
		PICITE_SHOVEL = addShovel("picite", TirphycraftToolTiers.PICITE_TOOL);
		PICITE_HOE = addHoe("picite", TirphycraftToolTiers.PICITE_TOOL);
				
		NIXIUM_AXE = addAxe("nixium", TirphycraftToolTiers.NIXIUM_TOOL);
		NIXIUM_PICKAXE = addPickaxe("nixium", TirphycraftToolTiers.NIXIUM_TOOL);
		NIXIUM_SWORD = addSword("nixium", TirphycraftToolTiers.NIXIUM_TOOL);
		NIXIUM_SHOVEL = addShovel("nixium", TirphycraftToolTiers.NIXIUM_TOOL);
		NIXIUM_HOE = addHoe("nixium", TirphycraftToolTiers.NIXIUM_TOOL);

		TENIUM_AXE = addAxe("tenium", TirphycraftToolTiers.TENIUM_TOOL);
		TENIUM_PICKAXE = addPickaxe("tenium", TirphycraftToolTiers.TENIUM_TOOL);
		TENIUM_SWORD = addSword("tenium", TirphycraftToolTiers.TENIUM_TOOL);
		TENIUM_SHOVEL = addShovel("tenium", TirphycraftToolTiers.TENIUM_TOOL);
		TENIUM_HOE = addHoe("tenium", TirphycraftToolTiers.TENIUM_TOOL);

		addArmor("pyrodes", PYRODES_FEET, PYRODES_LEGS, PYRODES_CHEST, PYRODES_HEAD);
		addArmor("heavy", HEAVY_FEET, HEAVY_LEGS, HEAVY_CHEST, HEAVY_HEAD);
		addArmor("nixium", NIXIUM_FEET, NIXIUM_LEGS, NIXIUM_CHEST, NIXIUM_HEAD);
		addArmor("draugrir", DRAUGRIR_FEET, DRAUGRIR_LEGS, DRAUGRIR_CHEST, DRAUGRIR_HEAD);
		addArmor("tenium", TENIUM_FEET, TENIUM_LEGS, TENIUM_CHEST, TENIUM_HEAD);
		addArmor("rose", ROSE_FEET, ROSE_LEGS, ROSE_CHEST, ROSE_HEAD);
		addArmor("origin", ORIGIN_FEET, ORIGIN_LEGS, ORIGIN_CHEST, ORIGIN_HEAD);
						
		FRAGMENT_BLUE 	= addSimpleItem("fragment_blue", 1);
		FRAGMENT_GREEN 	= addSimpleItem("fragment_green", 1);
		FRAGMENT_RED 	= addSimpleItem("fragment_red", 1);
		FRAGMENT_WHITE	= addSimpleItem("fragment_white", 1);
		FRAGMENT_YELLOW	= addSimpleItem("fragment_yellow", 1);
		
		// ITEMS
		CRYSTAL = addSimpleItem("crystal", 64);
		CRYSTAL_PURODES = addSimpleItem("crystal_purodes", 64);
		
		HEAVY_INGOT  = addSimpleItem("heavy_ingot", 64);
		NIXIUM_INGOT = addSimpleItem("nixium_ingot", 64);
		ROSE_SHARD   = addSimpleItem("blue_rose_shard", 64);
		CRYSTAL_PYRODES = addSimpleItem("poly_crystal_pyrodes", 64);
		HISTICE_GEM = addSimpleItem("histice_gem", 64);
		PICITE_INGOT = addSimpleItem("picite_ingot", 64);
		
		COAL_ON_COKE = addItemClass("coal_on_coke", () -> new itemFuel(2400));
		DIAMOND_NUGGET = addSimpleItem("diamond_nugget", 64);
		MUMMY_WRAPS = addSimpleItem("mummy_wraps", 16);
		EMPTY_SYRINGE = addSimpleItem("empty_syringe", 64);
		BLUE_ROSE_PETAL = addSimpleItem("blue_rose_petal", 64);
		FROZ_KEY = addSimpleItem("froz_key", 3);
		ORIGIN_MATTER = addSimpleItem("origin_matter", 64);
		EXPLOSION_CORE = addSimpleItem("explosion_core", 64);
		SEA_CORE = addSimpleItem("sea_core", 64);
		LIFE_CORE = addSimpleItem("life_core", 64);
		STICK_CRYSTAL = addSimpleItem("stick_crystal", 64);
		STICK_COPPIR = addSimpleItem("stick_coppir", 64);
		STICK_SILVIR = addSimpleItem("stick_silvir", 64);
		STICK_GOLDIR = addSimpleItem("stick_goldir", 64);
		STICK_FROZ  = addSimpleItem("stick_froz", 64);
		FROZEN_BUFFALO_RAW = addSimpleFood("frozen_buffalo_raw", 2);
		FROZEN_BUFFALO = addSimpleFood("frozen_buffalo", 9);
		FROZEN_BOARCHOP_RAW = addSimpleFood("frozen_boarchop_raw", 2);
		FROZEN_BOARCHOP = addSimpleFood("frozen_boarchop", 9);
		FRUIT_BALL_RED = addSimpleFood("fruit_ball_red", 1);
		FRUIT_BALL_BLUE = addSimpleFood("fruit_ball_blue", 1);
		FRUIT_BALL_GREEN = addSimpleFood("fruit_ball_green", 1);
		KIWI = addSimpleFood("kiwi", 1);
		
		FOOD1 = addSimpleFood("donangoblu_fruit", 2);
		ORIGIN_INGOT = addSimpleItem("origin_ingot", 64);
	}

}
