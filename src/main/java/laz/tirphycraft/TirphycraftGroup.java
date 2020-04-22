package laz.tirphycraft;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TirphycraftGroup extends ItemGroup {

    public TirphycraftGroup(String name) {
        super(name);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Blocks.BRICKS);
    }
}
