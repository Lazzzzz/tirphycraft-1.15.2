package laz.tirphycraft.content.blocks.laputa.dungeon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LaputaDungeonBricks extends Block {

	public LaputaDungeonBricks() {
		super(Block.Properties.create(Material.ROCK).noDrops().hardnessAndResistance(-1.0F, 3600000.0F));
	}
}
