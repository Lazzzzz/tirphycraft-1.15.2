package laz.tirphycraft.content.blocks.froz.dungeon;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;

public class FrozDungeonBricks extends Block {

	public FrozDungeonBricks() {
		super(Block.Properties.create(Material.ROCK).doesNotBlockMovement().noDrops().hardnessAndResistance(-1.0F, 3600000.0F));
	}
}
