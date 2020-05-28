package laz.tirphycraft.recipes.froz;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class FrozFurnaceRecipe {
	public final Item in;
	public final Item out;
	
	public FrozFurnaceRecipe(Item in, Item out) {
		this.in  = in;
		this.out = out;
	}
	
	public FrozFurnaceRecipe(Block in, Item out) {
		this.in  = in.asItem();
		this.out = out;
	}
	
	public FrozFurnaceRecipe(Item in, Block out) {
		this.in  = in;
		this.out = out.asItem();
	}
	
	public FrozFurnaceRecipe(Block in, Block out) {
		this.in  = in.asItem();
		this.out = out.asItem();
	}
	
}
