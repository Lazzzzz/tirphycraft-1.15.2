package laz.tirphycraft.recipes;

import laz.tirphycraft.recipes.book.BookOfKnowledgeRecipe;
import laz.tirphycraft.recipes.froz.FrozFurnaceRecipeInit;

public class RecipeInit {
	public static void init() {
		FrozFurnaceRecipeInit.init();
		BookOfKnowledgeRecipe.init();
	}
}
