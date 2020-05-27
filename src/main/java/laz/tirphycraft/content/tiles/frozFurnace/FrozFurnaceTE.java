package laz.tirphycraft.content.tiles.frozFurnace;

import laz.tirphycraft.content.TirphycraftBlocks;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class FrozFurnaceTE extends LockableLootTileEntity implements ITickableTileEntity {

	private int inv_size = 5;

	private int burntime = 20 * 15;
	private int currentburntime = 0;
	private boolean asStart = false;

	public NonNullList<ItemStack> furnaceContent = NonNullList.withSize(inv_size, ItemStack.EMPTY);

	public FrozFurnaceTE() {
		super(TirphycraftBlocks.FROZ_FURNACE.getTileEntityType());
	}

	@Override
	public void tick() {
		if (asStart == false) canStart();
		else execute();
	}

	public void canStart() {
		if (!world.isRemote) {
			ItemStack rose = furnaceContent.get(0).getStack();
			ItemStack fuel1 = furnaceContent.get(1).getStack();
			ItemStack fuel2 = furnaceContent.get(2).getStack();
		
			if (rose.getItem() != Blocks.AIR.asItem() && fuel1.getItem() != Blocks.AIR.asItem() && fuel2.getItem() != Blocks.AIR.asItem()) {
				if (fuel1.getItem() != fuel2.getItem()) {
					if (fuel1.getCount() >= 3 && fuel2.getCount() >= 3) {
						asStart = true;
						rose.setCount(fuel1.getCount() - 1);
						fuel1.setCount(fuel1.getCount() - 3);
						fuel2.setCount(fuel2.getCount() - 3);
					}
				}
			}
		}
	}
	
	public void execute() {
		currentburntime ++;
		if (currentburntime == burntime) {
			asStart = false;
			currentburntime = 0;
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.furnaceContent);
		}
		return compound;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		this.furnaceContent = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.furnaceContent);
		}
	}

	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent("froz furnace");
	}

	@Override
	public int getSizeInventory() {
		return inv_size;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.furnaceContent;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.furnaceContent = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new StringTextComponent("slt");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new FrozFurnaceContainer(id, player, this);
	}

}
