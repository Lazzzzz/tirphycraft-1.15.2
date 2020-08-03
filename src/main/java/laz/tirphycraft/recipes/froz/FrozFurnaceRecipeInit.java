package laz.tirphycraft.recipes.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import laz.tirphycraft.registry.init.TirphycraftItems;

public class FrozFurnaceRecipeInit {

	public static void init() {
	     Tirphycraft.FROZ_RECIPES.add(new FrozFurnaceRecipe(TirphycraftBlocks.ORE_NIXIUM.get(), TirphycraftItems.NIXIUM_INGOT.get()));
	     Tirphycraft.FROZ_RECIPES.add(new FrozFurnaceRecipe(TirphycraftBlocks.ORE_PICITE.get(), TirphycraftItems.PICITE_INGOT.get()));
	     Tirphycraft.FROZ_RECIPES.add(new FrozFurnaceRecipe(TirphycraftBlocks.ORE_TENIUM.get(), TirphycraftItems.TENIUM_INGOT.get()));
	     Tirphycraft.FROZ_RECIPES.add(new FrozFurnaceRecipe(TirphycraftItems.FROZEN_BOARCHOP_RAW.get(), TirphycraftItems.FROZEN_BOARCHOP.get()));
	 	
	}
	
}
