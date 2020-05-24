package laz.tirphycraft.content.items.other;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class itemFuel extends Item {

	int fuel = 0;
	
    public itemFuel(int f) {
        super(new Item.Properties().group(ITEM_GROUP).maxStackSize(64));
    	this.fuel = f;
    }
    
    @Override
    public int getBurnTime(ItemStack itemStack) {
    	return this.fuel;
    }

}