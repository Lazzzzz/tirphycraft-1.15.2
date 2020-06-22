package laz.tirphycraft.recipes.book;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftItems;
import laz.tirphycraft.util.book.BookItemInfo;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class BookOfKnowledgeRecipe {
	public static void init() {
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ORE_COAL_ON_COKE.get(),
				"Ore than can be found in overworld between y:0 and Y:90"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ORE_CRYSTAL.get(),
				"Ore than can be found in overworld between y:0 and Y:25"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ORE_HISTICE_ICE.get(),
				"Ore than can be found in froz between y:30 and Y:48"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ORE_NIXIUM.get(),
				"Ore than can be found in froz between y:0 and Y:10, can only be smelt in froz furnace"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ORE_PICITE.get(),
				"Ore than can be found in froz between y:10 and Y:48, can only be smelt in froz furnace"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ORE_TENIUM.get(),
				"Ore than can be found in laputa between y:10 and Y:48"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ORE_PYRODES.get(),
				"Ore than can be found in overworld between y:15 and Y:90"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.FROZEN_CRYSTAL.get(),
				"Crystal than can be found in froz in biome mountain, use as fuel in froz furnace"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.BLACK_CRYSTAL.get(),
				"Crystal than can be found in froz in biome mountain, use as fuel in froz furnace"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(
				new BookItemInfo(TirphycraftBlocks.LOG_COPPIR.get(), "common log tree, can be use to craft staff"));
		Tirphycraft.BOOK_OF_KNOWLEDGE
				.add(new BookItemInfo(TirphycraftBlocks.LOG_SILVIR.get(), "Rare log tree, can be use to craft staff"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(
				new BookItemInfo(TirphycraftBlocks.LOG_GOLDIR.get(), "Very rare log tree, can be use to craft staff"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ANCIENT_BLUE.get(),
				"Crystal found in overworld, on surface, use to activate the altar"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ANCIENT_GREEN.get(),
				"Crystal found in overworld, on surface, use to activate the altar"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ANCIENT_RED.get(),
				"Crystal found in overworld, on surface, use to activate the altar"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ANCIENT_WHITE.get(),
				"Crystal found in overworld, on surface, use to activate the altar"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ANCIENT_YELLOW.get(),
				"Crystal found in overworld, on surface, use to activate the altar"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftBlocks.ALTAR.get(),
				"Place the 5 ancient stone around it to activate the ritual that will send you to noxis, your first dimension. CRAFT A RETURN CLOCK !"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_ANTI.get(),
				"Can be use only one time, remove all the other amulet effect, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_ATTACK_1.get(),
				"Can be use only one time, boost your attack of 25% until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_ATTACK_2.get(),
				"Can be use only one time, boost your attack of 50% until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_ATTACK_3.get(),
				"Can be use only one time, boost your attack of 75% until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_HEALTH_1.get(),
				"Can be use only one time, add 2 hearts until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_HEALTH_2.get(),
				"Can be use only one time, add 6 hearts until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_HEALTH_3.get(),
				"Can be use only one time, add 10 hearts until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_SPEED_1.get(),
				"Can be use only one time, boost your attack speed of 25% until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_SPEED_2.get(),
				"Can be use only one time, boost your attack speed of 50% until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.AMULET_SPEED_3.get(),
				"Can be use only one time, boost your attack speed of 75% until you die, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.TOTEM_LEVITATION.get(),
				"Set all mob in a radius of 10 blocks an effect of levitation, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.TOTEM_THUNDER.get(),
				"Strike lightning on all mob in a radius of 10 blocks, you can found it in every dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_1_EXPLOSION.get(), "Staff that fire 1 tnt"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_2_EXPLOSION.get(), "Staff that fire 2 tnt"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_3_EXPLOSION.get(), "Staff that fire 3 tnt"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_1_FIREBALL.get(), "Staff that fire 1 fireball, reload is slow"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_2_FIREBALL.get(), "Staff that fire 1 fireball, reload is normal"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_3_FIREBALL.get(), "Staff that fire 1 fireball, reload is quick"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_1_HEAL.get(), "staff that heal 2 hearts"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_2_HEAL.get(), "Staff that heal 4 hearts"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_3_HEAL.get(), "Staff that heal 8 hearts"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_1_TELEPORTATION.get(), "Staff that teleport you 10 blocks away"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_2_TELEPORTATION.get(), "Staff that teleport you 15 blocks away"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.STAFF_3_TELEPORTATION.get(), "Staff that teleport you 20 blocks away"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.RETURN_CLOCK.get(), "A clock infuse with overworld dimension aura, teleport you to the overworld"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.FROZ_CLOCK.get(), "A clock infuse with froz dimension aura, teleport you to the froz"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.LAPUTA_CLOCK.get(), "A clock infuse with laputa dimension aura, teleport you to the laputa"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.NOXIS_CLOCK.get(), "A clock infuse with noxis dimension aura, teleport you to the noxis"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.GOSYN_CLOCK.get(), "Not done"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.SUN_TEAR.get(), "Like a froz walker, but on lava... So it's a lava walker ? can be found in dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.FEATHER_OF_LIGHT.get(), "Cancel all fall damage ? can be found in dungeon"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.CRYSTAL.get(), "Result of crystal ore"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.CRYSTAL_PYRODES.get(), "Result of pyrodes ore"));	
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.HEAVY_INGOT.get(), "A mix of obsidian and iron"));	
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.NIXIUM_INGOT.get(), "Result of ore Nixium"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.BLUE_ROSE_PETAL.get(), "Can be get from majestic rose in froz, use to craft the rose shard"));
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.ROSE_SHARD.get(), "A powerful shard that is use in the froz furnace"));		
		Tirphycraft.BOOK_OF_KNOWLEDGE.add(new BookItemInfo(TirphycraftItems.COAL_ON_COKE.get(), "A powerful fuel for your furnace, 33% better than the coal"));		
		
	}

}
