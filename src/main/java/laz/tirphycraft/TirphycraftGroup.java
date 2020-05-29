package laz.tirphycraft;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TirphycraftGroup extends ItemGroup {

    public TirphycraftGroup(String name) {
        super(name);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(TirphycraftBlocks.BRICKS_LAPUTA.get());
    }
}
