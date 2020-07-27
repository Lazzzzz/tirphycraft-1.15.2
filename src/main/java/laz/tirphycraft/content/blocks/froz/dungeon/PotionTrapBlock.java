package laz.tirphycraft.content.blocks.froz.dungeon;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PotionTrapBlock extends Block {

	public PotionTrapBlock() {
		super(Block.Properties.create(Material.ROCK).doesNotBlockMovement().noDrops().hardnessAndResistance(-1.0F, 3600000.0F));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
			Potion potion = Potions.HARMING;
			PotionEntity potionentity = new PotionEntity(EntityType.POTION, worldIn);
			potionentity.setItem(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potion));
	        potionentity.setVelocity(0, 0.5, 0);
			potionentity.setPosition(pos.getX()+0.5,  pos.getY() + 1.1, pos.getZ() + 0.5);
	        worldIn.addEntity(potionentity);
	        worldIn.setBlockState(pos, TirphycraftBlocks.FROZ_DUNGEON_VARIANT0.get().getDefaultState());
			super.onEntityWalk(worldIn, pos, entityIn);
		}
	}

}
