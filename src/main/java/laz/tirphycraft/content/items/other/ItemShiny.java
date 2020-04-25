package laz.tirphycraft.content.items.other;

import static laz.tirphycraft.Tirphycraft.ITEM_GROUP;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemShiny extends Item {

    public ItemShiny() {
        super(new Item.Properties().group(ITEM_GROUP));
    }
	
    @Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}


}
