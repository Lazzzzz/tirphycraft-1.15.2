package laz.tirphycraft.recipes.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.TirphycraftBlocks;
import laz.tirphycraft.content.TirphycraftItems;

public class FrozFurnaceRecipeInit {

	public static void init() {
	     Tirphycraft.FROZ_RECIPES.add(new FrozFurnaceRecipe(TirphycraftBlocks.ORE_NIXIUM.get(), TirphycraftItems.NIXIUM_INGOT.get()));
	}
	
}
