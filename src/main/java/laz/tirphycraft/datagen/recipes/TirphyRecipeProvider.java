package laz.tirphycraft.datagen.recipes;

import java.util.function.Consumer;

import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.TirphycraftItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class TirphyRecipeProvider extends RecipeProvider {

	public TirphyRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		compress(TirphycraftBlocks.BLOCK_NIXIUM.getItem(), TirphycraftItems.NIXIUM_INGOT.get(), consumer);
		compress(TirphycraftBlocks.BLOCK_COAL_ON_COKE.getItem(), TirphycraftItems.COAL_ON_COKE.get(), consumer);
		compress(TirphycraftBlocks.BLOCK_HEAVY.getItem(), TirphycraftItems.HEAVY_INGOT.get(), consumer);
		compress(TirphycraftBlocks.BLOCK_PYRODES.getItem(), TirphycraftItems.CRYSTAL_PYRODES.get(), consumer);
		
		uncompress(TirphycraftItems.NIXIUM_INGOT.get(), TirphycraftBlocks.BLOCK_NIXIUM.getItem(), consumer);
		uncompress(TirphycraftItems.COAL_ON_COKE.get(), TirphycraftBlocks.BLOCK_COAL_ON_COKE.getItem(), consumer);
		uncompress(TirphycraftItems.HEAVY_INGOT.get(), TirphycraftBlocks.BLOCK_HEAVY.getItem(), consumer);
		uncompress(TirphycraftItems.CRYSTAL_PYRODES.get(), TirphycraftBlocks.BLOCK_PYRODES.getItem(), consumer);
		
		bricks(TirphycraftBlocks.BRICKS_METEORITE.getItem(), TirphycraftBlocks.BLOCK_METEORITE.getItem(), consumer);
		bricks(TirphycraftBlocks.BRICKS_LAPUTA.getItem(), TirphycraftBlocks.LAPUTA_STONE.getItem(), consumer);
		bricks(TirphycraftBlocks.BRICKS_NOXIS.getItem(), TirphycraftBlocks.NOXIS_STONE.getItem(), consumer);

		single(TirphycraftBlocks.PLANKS_COPPIR.getItem(), TirphycraftBlocks.LOG_COPPIR.getItem(), 4, consumer);
		single(TirphycraftBlocks.PLANKS_SILVIR.getItem(), TirphycraftBlocks.LOG_SILVIR.getItem(), 4, consumer);
		single(TirphycraftBlocks.PLANKS_GOLDIR.getItem(), TirphycraftBlocks.LOG_GOLDIR.getItem(), 4, consumer);
		single(TirphycraftBlocks.PLANKS_FROZ.getItem(), TirphycraftBlocks.LOG_FROZ.getItem(), 4, consumer);
		single(TirphycraftBlocks.PLANKS_SKY.getItem(), TirphycraftBlocks.LOG_SKY.getItem(), 4, consumer);
		single(TirphycraftBlocks.BRICKS_FROZ.getItem(), TirphycraftBlocks.FROZ_STONE.getItem(), 4, consumer);
		
		stairs(TirphycraftBlocks.STAIRS_COPPIR.getItem(), TirphycraftBlocks.PLANKS_COPPIR.getItem(), consumer);
		stairs(TirphycraftBlocks.STAIRS_GOLDIR.getItem(), TirphycraftBlocks.PLANKS_GOLDIR.getItem(), consumer);
		stairs(TirphycraftBlocks.STAIRS_SILIR.getItem(), TirphycraftBlocks.PLANKS_SILVIR.getItem(), consumer);
		stairs(TirphycraftBlocks.STAIRS_FROZ.getItem(), TirphycraftBlocks.PLANKS_FROZ.getItem(), consumer);

		stick(TirphycraftItems.STICK_CRYSTAL.get(), TirphycraftItems.CRYSTAL.get(), consumer);
		stick(TirphycraftItems.STICK_COPPIR.get(), TirphycraftBlocks.PLANKS_COPPIR.getItem(), consumer);
		stick(TirphycraftItems.STICK_SILVIR.get(), TirphycraftBlocks.PLANKS_SILVIR.getItem(), consumer);
		stick(TirphycraftItems.STICK_GOLDIR.get(), TirphycraftBlocks.PLANKS_GOLDIR.getItem(), consumer);

		registerSmeltingRecipes(consumer, 0.1F, 200, TirphycraftBlocks.FROZ_COBBLESTONE.getItem(),
				TirphycraftBlocks.FROZ_STONE.getItem());
		registerSmeltingRecipes(consumer, 0.1F, 200, TirphycraftBlocks.LAPUTA_COBBLESTONE.getItem(),
				TirphycraftBlocks.LAPUTA_STONE.getItem());
		registerSmeltingRecipes(consumer, 0.1F, 200, TirphycraftItems.CRYSTAL_PYRODES.get(),
				TirphycraftItems.CRYSTAL_PURODES.get());
		
		registerSmeltingRecipes(consumer, 0.1F, 200, TirphycraftBlocks.ORE_NIXIUM.getItem(),
				TirphycraftItems.NIXIUM_INGOT.get());
		
		registerSmeltingRecipes(consumer, 0.1F, 200, TirphycraftBlocks.ORE_TENIUM.getItem(),
				TirphycraftItems.TENIUM_INGOT.get());
		
		registerSmeltingRecipes(consumer, 0.1F, 200, TirphycraftItems.CRYSTAL_PURODES.get(),
				TirphycraftItems.CRYSTAL_PYRODES.get());

		armor(TirphycraftItems.PYRODES_FEET, 
			  TirphycraftItems.PYRODES_LEGS, 
			  TirphycraftItems.PYRODES_CHEST, 
			  TirphycraftItems.PYRODES_HEAD, 
			  TirphycraftItems.CRYSTAL_PYRODES.get(), consumer);
		
		armor(TirphycraftItems.HEAVY_FEET, 
				  TirphycraftItems.HEAVY_LEGS, 
				  TirphycraftItems.HEAVY_CHEST, 
				  TirphycraftItems.HEAVY_HEAD, 
				  TirphycraftItems.HEAVY_INGOT.get(), consumer);	
		
		armor(TirphycraftItems.NIXIUM_FEET, 
				  TirphycraftItems.NIXIUM_LEGS, 
				  TirphycraftItems.NIXIUM_CHEST, 
				  TirphycraftItems.NIXIUM_HEAD, 
				  TirphycraftItems.NIXIUM_INGOT.get(), consumer);	
		
		armor(TirphycraftItems.TENIUM_FEET, 
				  TirphycraftItems.TENIUM_LEGS, 
				  TirphycraftItems.TENIUM_CHEST, 
				  TirphycraftItems.TENIUM_HEAD, 
				  TirphycraftItems.TENIUM_INGOT.get(), consumer);	
		
		tools(TirphycraftItems.PYRODES_AXE.get(), 
			  TirphycraftItems.PYRODES_PICKAXE.get(), 
			  TirphycraftItems.PYRODES_SWORD.get(), 
			  TirphycraftItems.PYRODES_SHOVEL.get(), 
			  TirphycraftItems.PYRODES_HOE.get(), TirphycraftItems.CRYSTAL_PYRODES.get(), TirphycraftItems.STICK_CRYSTAL.get(), consumer);
	
		tools(TirphycraftItems.HEAVY_AXE.get(), 
				  TirphycraftItems.HEAVY_PICKAXE.get(), 
				  TirphycraftItems.HEAVY_SWORD.get(), 
				  TirphycraftItems.HEAVY_SHOVEL.get(), 
				  TirphycraftItems.HEAVY_HOE.get(), TirphycraftItems.HEAVY_INGOT.get(), TirphycraftItems.STICK_CRYSTAL.get(), consumer);
		
		tools(TirphycraftItems.NIXIUM_AXE.get(), 
				  TirphycraftItems.NIXIUM_PICKAXE.get(), 
				  TirphycraftItems.NIXIUM_SWORD.get(), 
				  TirphycraftItems.NIXIUM_SHOVEL.get(), 
				  TirphycraftItems.NIXIUM_HOE.get(), TirphycraftItems.NIXIUM_INGOT.get(), TirphycraftItems.STICK_CRYSTAL.get(), consumer);
		
		tools(TirphycraftItems.TENIUM_AXE.get(), 
				  TirphycraftItems.TENIUM_PICKAXE.get(), 
				  TirphycraftItems.TENIUM_SWORD.get(), 
				  TirphycraftItems.TENIUM_SHOVEL.get(), 
				  TirphycraftItems.TENIUM_HOE.get(), TirphycraftItems.TENIUM_INGOT.get(), TirphycraftItems.STICK_CRYSTAL.get(), consumer);
		
		staff(TirphycraftItems.STAFF_1_EXPLOSION.get(), TirphycraftItems.EXPLOSION_CORE.get(), TirphycraftItems.STICK_COPPIR.get(), consumer);
		staff(TirphycraftItems.STAFF_1_HEAL.get(), TirphycraftItems.LIFE_CORE.get(), TirphycraftItems.STICK_COPPIR.get(), consumer);
		staff(TirphycraftItems.STAFF_1_TELEPORTATION.get(), TirphycraftItems.SEA_CORE.get(), TirphycraftItems.STICK_COPPIR.get(), consumer);
		//staff(TirphycraftItems.STAFF_1_FIREBALL.get(), TirphycraftItems.EXPLOSION_CORE.get(), TirphycraftItems.STICK_COPPIR.get(), consumer);
		
		staff(TirphycraftItems.STAFF_2_EXPLOSION.get(), TirphycraftItems.EXPLOSION_CORE.get(), TirphycraftItems.STICK_SILVIR.get(), consumer);
		staff(TirphycraftItems.STAFF_2_HEAL.get(), TirphycraftItems.LIFE_CORE.get(), TirphycraftItems.STICK_SILVIR.get(), consumer);
		staff(TirphycraftItems.STAFF_2_TELEPORTATION.get(), TirphycraftItems.SEA_CORE.get(), TirphycraftItems.STICK_SILVIR.get(), consumer);
		//staff(TirphycraftItems.STAFF_2_FIREBALL.get(), TirphycraftItems.EXPLOSION_CORE.get(), TirphycraftItems.STICK_SILVIR.get(), consumer);
		
		staff(TirphycraftItems.STAFF_3_EXPLOSION.get(), TirphycraftItems.EXPLOSION_CORE.get(), TirphycraftItems.STICK_GOLDIR.get(), consumer);
		staff(TirphycraftItems.STAFF_3_HEAL.get(), TirphycraftItems.LIFE_CORE.get(), TirphycraftItems.STICK_GOLDIR.get(), consumer);
		staff(TirphycraftItems.STAFF_3_TELEPORTATION.get(), TirphycraftItems.SEA_CORE.get(), TirphycraftItems.STICK_GOLDIR.get(), consumer);
		//staff(TirphycraftItems.STAFF_3_FIREBALL.get(), TirphycraftItems.EXPLOSION_CORE.get(), TirphycraftItems.STICK_GOLDIR.get(), consumer);
		
		setupRecipe(consumer);
	}

	private void compress(Item result, Item ingredient, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(result)
		.key('X', ingredient)
		.patternLine("XXX")
		.patternLine("XXX")
		.patternLine("XXX")
		.setGroup("tirphycraft").addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
	}

	private void uncompress(Item result, Item ingredient, Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(result, 9)
		.addIngredient(ingredient)
		.setGroup("tirphycraft")
		.addCriterion("has_material", hasItem(ingredient)).build(consumer, new ResourceLocation(result.getRegistryName() + "_uncompress"));
	}

	private void bricks(Item result, Item ingredient, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(result, 4)
		.key('X', ingredient)
		.patternLine("XX")
		.patternLine("XX")
		.setGroup("tirphycraft").addCriterion("has_material", this.hasItem(ingredient)).build(consumer);
	}
	

	private void stick(Item result, Item ingredient, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(result, 4)
		.key('X', ingredient)
		.patternLine("X")
		.patternLine("X")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient)).build(consumer);
	}
	
	private void single(Item result, Item ingredient, int amount, Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(result, amount)
		.addIngredient(ingredient)
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
	}
	
	private void stairs(Item result, Item ingredient, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(result, 4)
		.key('X', ingredient)
		.patternLine("X  ")
		.patternLine("XX ")
		.patternLine("XXX")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
	}

	private void registerSmeltingRecipes(Consumer<IFinishedRecipe> consumer, float xp, int time, Item ingredient,
			Item finish) {
		CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ingredient), finish, xp, time, IRecipeSerializer.SMELTING)
		.addCriterion("has_material", hasItem(ingredient)).build(consumer, new ResourceLocation(finish.getRegistryName() + "_smelting"));
	}
	
	private void staff(Item result, Item ingredient, Item stick, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(result)
		.key('X', stick)
		.key('Z', ingredient)
		.patternLine(" XZ")
		.patternLine(" XX")
		.patternLine("X  ")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
	}

	private void armor(Item boots, Item legs, Item chest, Item helmet, Item ingredient, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(boots)
		.key('X', ingredient)
		.patternLine("X X")
		.patternLine("X X")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(legs)
		.key('X', ingredient)
		.patternLine("XXX")
		.patternLine("X X")
		.patternLine("X X")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(chest)
		.key('X', ingredient)
		.patternLine("X X")
		.patternLine("XXX")
		.patternLine("XXX")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(helmet)
		.key('X', ingredient)
		.patternLine("XXX")
		.patternLine("X X")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
	}
	
	private void tools(Item axe, Item pickaxe, Item sword, Item shovel, Item hoe, Item ingredient, Item stick, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(pickaxe)
		.key('X', ingredient)
		.key('|', stick)
		.patternLine("XXX")
		.patternLine(" | ")
		.patternLine(" | ")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(axe)
		.key('X', ingredient)
		.key('|', stick)
		.patternLine("XX")
		.patternLine("X|")
		.patternLine(" |")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(sword)
		.key('X', ingredient)
		.key('|', stick)
		.patternLine("X")
		.patternLine("X")
		.patternLine("|")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
	
		ShapedRecipeBuilder.shapedRecipe(shovel)
		.key('X', ingredient)
		.key('|', stick)
		.patternLine("X")
		.patternLine("|")
		.patternLine("|")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(hoe)
		.key('X', ingredient)
		.key('|', stick)
		.patternLine("XX")
		.patternLine(" |")
		.patternLine(" |")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(ingredient))
		.build(consumer);
	}
	
	private void setupRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(TirphycraftBlocks.SUN_STONE.getItem())
		.key('X', Blocks.GLOWSTONE.asItem())
		.key('Z', Blocks.STONE.asItem())
		.patternLine(" Z ")
		.patternLine("ZXZ")
		.patternLine(" Z ")
		.setGroup("tirphycraft").addCriterion("has_material", this.hasItem(Blocks.GLOWSTONE.asItem()))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(TirphycraftBlocks.POWDER_SNOW_LAYER.getItem())
		.key('X', TirphycraftBlocks.POWDER_SNOW.getItem())
		.patternLine("XXX")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(TirphycraftBlocks.POWDER_SNOW.getItem())).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(TirphycraftBlocks.NOXIS_BRICKS_CARVED.getItem(), 2)
		.key('X', TirphycraftBlocks.NOXIS_STONE.getItem())
		.patternLine("XX")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(TirphycraftBlocks.NOXIS_STONE.getItem())).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(TirphycraftBlocks.NOXIS_BRICKS_PILLAR.getItem(), 2)
		.key('X', TirphycraftBlocks.NOXIS_STONE.getItem())
		.patternLine("X")
		.patternLine("X")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(TirphycraftBlocks.NOXIS_STONE.getItem())).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(TirphycraftBlocks.ALTAR.getItem(), 1)
		.key('X', Blocks.COBBLESTONE.asItem())
		.key('Z', TirphycraftItems.CRYSTAL.get())
		.key('I', Blocks.REDSTONE_BLOCK.asItem())
		.key('U', TirphycraftBlocks.BLOCK_PYRODES.getItem())
		.patternLine("ZIZ")
		.patternLine("ZUZ")
		.patternLine("XXX")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(TirphycraftItems.CRYSTAL.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(TirphycraftItems.HEAVY_INGOT.get(), 1)
		.key('X', Items.IRON_INGOT)
		.key('Y', Blocks.OBSIDIAN.asItem())
		.patternLine("YYY")
		.patternLine("YXY")
		.patternLine("YYY")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(Items.IRON_INGOT)).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(TirphycraftItems.RETURN_CLOCK.get(), 1)
		.key('X', Items.CLOCK)
		.key('Y', Blocks.GRASS_BLOCK.asItem())
		.patternLine(" Y ")
		.patternLine("YXY")
		.patternLine(" Y ")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(Items.CLOCK)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(TirphycraftItems.NOXIS_CLOCK.get(), 1)
		.key('X', Items.CLOCK)
		.key('Y', TirphycraftItems.NIXIUM_INGOT.get())
		.patternLine(" Y ")
		.patternLine("YXY")
		.patternLine(" Y ")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(Items.CLOCK)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(TirphycraftItems.LAPUTA_CLOCK.get(), 1)
		.key('X', Items.CLOCK)
		.key('Y', TirphycraftItems.TENIUM_INGOT.get())
		.patternLine(" Y ")
		.patternLine("YXY")
		.patternLine(" Y ")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(Items.CLOCK)).build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(TirphycraftItems.FROZ_CLOCK.get(), 1)
		.key('X', Items.CLOCK)
		.key('Y', TirphycraftBlocks.FROZ_STONE.getItem())
		.patternLine(" Y ")
		.patternLine("YXY")
		.patternLine(" Y ")
		.setGroup("tirphycraft")
		.addCriterion("has_material", this.hasItem(Items.CLOCK)).build(consumer);
	
	
	}

}
