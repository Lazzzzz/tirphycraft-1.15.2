package laz.tirphycraft.content;

import static laz.tirphycraft.content.TirphycraftRegistries.addItemClass;
import static laz.tirphycraft.content.TirphycraftRegistries.addSimpleFood;
import static laz.tirphycraft.content.TirphycraftRegistries.addSimpleItem;
import static laz.tirphycraft.content.TirphycraftRegistries.addTools;
import static laz.tirphycraft.content.TirphycraftRegistries.addArmor;

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
import net.minecraftforge.fml.RegistryObject;

public class TirphycraftItems {

	public static RegistryObject<Item> CRYSTAL_PYRODES;
	public static RegistryObject<Item> HEAVY_INGOT;
	public static RegistryObject<Item> NIXIUM_INGOT;
	public static RegistryObject<Item> TENIUM_INGOT;
	public static RegistryObject<Item> ROSE_SHARD;
	public static RegistryObject<Item> ORIGIN_INGOT;
	
	public static Item PYRODES_FEET;
	public static Item PYRODES_LEGS;
	public static Item PYRODES_CHEST;
	public static Item PYRODES_HEAD;

	public static Item HEAVY_FEET;
	public static Item HEAVY_LEGS;
	public static Item HEAVY_CHEST;
	public static Item HEAVY_HEAD;	
	
	public static Item NIXIUM_FEET;
	public static Item NIXIUM_LEGS;
	public static Item NIXIUM_CHEST;
	public static Item NIXIUM_HEAD;

	public static Item TENIUM_FEET;
	public static Item TENIUM_LEGS;
	public static Item TENIUM_CHEST;
	public static Item TENIUM_HEAD;

	public static Item ROSE_FEET;
	public static Item ROSE_LEGS;
	public static Item ROSE_CHEST;
	public static Item ROSE_HEAD;

	public static Item ORIGIN_FEET;
	public static Item ORIGIN_LEGS;
	public static Item ORIGIN_CHEST;
	public static Item ORIGIN_HEAD;

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
		
		addItemClass("anti_amulet", AmuletAnti::new);

		addItemClass("amulet_1_health", AmuletHealth1::new);
		addItemClass("amulet_2_health", AmuletHealth2::new);
		addItemClass("amulet_3_health", AmuletHealth3::new);

		addItemClass("amulet_1_attack", AmuletAttack1::new);
		addItemClass("amulet_2_attack", AmuletAttack2::new);
		addItemClass("amulet_3_attack", AmuletAttack3::new);

		addItemClass("amulet_1_speed", AmuletSpeed1::new);
		addItemClass("amulet_2_speed", AmuletSpeed2::new);
		addItemClass("amulet_3_speed", AmuletSpeed3::new);

		addItemClass("totem_levitation", TotemLevitation::new);
		addItemClass("totem_thunder", TotemThunder::new);

		TENIUM_INGOT = addItemClass("tenium_ingot", ItemShiny::new);
		
		addItemClass("queen_heart", ItemShiny::new);
		addItemClass("ankh", ItemShiny::new);
		addItemClass("poseidon_eye", ItemShiny::new);

		addItemClass("staff_1_heal", StaffHeal1::new);
		addItemClass("staff_2_heal", StaffHeal2::new);
		addItemClass("staff_3_heal", StaffHeal3::new);
		addItemClass("staff_1_teleportation", StaffTeleportation1::new);
		addItemClass("staff_2_teleportation", StaffTeleportation2::new);
		addItemClass("staff_3_teleportation", StaffTeleportation3::new);
		addItemClass("staff_1_explosion", StaffExplosion1::new);
		addItemClass("staff_2_explosion", StaffExplosion2::new);
		addItemClass("staff_3_explosion", StaffExplosion3::new);
		addItemClass("staff_1_fireball", StaffFireBall1::new);
		addItemClass("staff_2_fireball", StaffFireBall2::new);
		addItemClass("staff_3_fireball", StaffFireBall3::new);
		
		addItemClass("return_clock",ClockReturn::new);
		addItemClass("noxis_clock",ClockNoxis::new);
		addItemClass("laputa_clock", ClockLaputa::new);
		addItemClass("gosyn_clock",ClockGosyn::new);
		addItemClass("froz_clock",ClockFroz::new);

		addItemClass("sun_tear", ArtefactSunTear::new);
		addItemClass("feather_of_light", ArtefactFeatherOfLight::new);
		
		
		addTools("pyrodes", TirphycraftToolTiers.PYRODES_TOOL);
		addTools("heavy", TirphycraftToolTiers.HEAVY_TOOL);
		addTools("nixium", TirphycraftToolTiers.NIXIUM_TOOL);
		addTools("tenium", TirphycraftToolTiers.TENIUM_TOOL);

		addArmor("pyrodes", PYRODES_FEET, PYRODES_LEGS, PYRODES_CHEST, PYRODES_HEAD);
		addArmor("heavy", HEAVY_FEET, HEAVY_LEGS, HEAVY_CHEST, HEAVY_HEAD);
		addArmor("nixium", NIXIUM_FEET, NIXIUM_LEGS, NIXIUM_CHEST, NIXIUM_HEAD);
		addArmor("tenium", TENIUM_FEET, TENIUM_LEGS, TENIUM_CHEST, TENIUM_HEAD);
		addArmor("rose", ROSE_FEET, ROSE_LEGS, ROSE_CHEST, ROSE_HEAD);
		addArmor("origin", ORIGIN_FEET, ORIGIN_LEGS, ORIGIN_CHEST, ORIGIN_HEAD);
						
		addSimpleItem("fragment_blue", 16);
		addSimpleItem("fragment_green", 16);
		addSimpleItem("fragment_red", 16);
		addSimpleItem("fragment_white", 16);
		addSimpleItem("fragment_yellow", 16);
		
		// ITEMS
		addSimpleItem("crystal", 64);
		addSimpleItem("crystal_purodes", 64);
		
		CRYSTAL_PYRODES = addSimpleItem("poly_crystal_pyrodes", 64);
		addSimpleItem("coal_on_coke", 64);
		HEAVY_INGOT  = addSimpleItem("heavy_ingot", 64);
		NIXIUM_INGOT = addSimpleItem("nixium_ingot", 64);
		ROSE_SHARD   = addSimpleItem("blue_rose_shard", 64);
		addSimpleItem("diamond_nugget", 64);
		addSimpleItem("mummy_wraps", 16);
		addSimpleItem("empty_syringe", 64);
		addSimpleItem("blue_rose_petal", 64);
		addSimpleItem("froz_key", 3);
		addSimpleItem("origin_matter", 64);
		ORIGIN_INGOT = addSimpleItem("origin_ingot", 64);
		addSimpleItem("explosion_core", 64);
		addSimpleItem("sea_core", 64);
		addSimpleItem("life_core", 64);

		addSimpleItem("stick_crystal", 64);
		addSimpleItem("stick_coppir", 64);
		addSimpleItem("stick_silvir", 64);
		addSimpleItem("stick_goldir", 64);

		addSimpleFood("frozen_buffalo_raw", 2);
		addSimpleFood("frozen_buffalo", 9);
		addSimpleFood("frozen_boarchop_raw", 2);
		addSimpleFood("frozen_boarchop", 9);
		addSimpleFood("fruit_ball_red", 1);
		addSimpleFood("fruit_ball_blue", 1);
		addSimpleFood("fruit_ball_green", 1);
		addSimpleFood("donangoblu_fruit", 2);
		addSimpleFood("kiwi", 1);
	}

}
