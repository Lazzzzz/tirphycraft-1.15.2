package laz.tirphycraft.content.tiles.frozFurnace;

import javax.annotation.Nullable;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class FrozFurnaceTE extends LockableLootTileEntity implements ITickableTileEntity {

	private int inv_size = 5;
	private int burntime = 20 * 15;

	public int currentburntime = 0;
	public int recipe = -1;
	public boolean asStart = false;

	public NonNullList<ItemStack> furnaceContent = NonNullList.withSize(inv_size, ItemStack.EMPTY);

	public FrozFurnaceTE() {
		super(TirphycraftBlocks.FROZ_FURNACE.getTileEntityType());

	}

	@Override
	public void tick() {
		if (asStart == false)
			canStart();
		else
			execute();

	}

	public void canStart() {
		ItemStack input = furnaceContent.get(3);
		if (!input.isEmpty()) {
			recipe = isRecipeGood(input.getItem());
			if (recipe >= 0) {
				if (isOutputGood()) {
					ItemStack rose = furnaceContent.get(0);
					ItemStack fuel1 = furnaceContent.get(1);
					ItemStack fuel2 = furnaceContent.get(2);

					if (rose.getItem() != Blocks.AIR.asItem() && fuel1.getItem() != Blocks.AIR.asItem()
							&& fuel2.getItem() != Blocks.AIR.asItem()) {
						if (fuel1.getItem() != fuel2.getItem()) {
							if (fuel1.getCount() >= 3 && fuel2.getCount() >= 3) {
								asStart = true;
								if (!world.isRemote) {
									rose.setCount(fuel1.getCount() - 1);
									fuel1.setCount(fuel1.getCount() - 3);
									fuel2.setCount(fuel2.getCount() - 3);
									input.setCount(input.getCount() - 1);
									world.setBlockState(pos, world.getBlockState(pos).getBlockState().with(FrozFurnaceBlock.LIT, true));
								}
							}
						}
					}
				}
			}
		}
	}

	public void execute() {
		currentburntime++;
		if (currentburntime == burntime) {
			asStart = false;
			currentburntime = 0;
			if (!world.isRemote) {
				if (furnaceContent.get(4).isEmpty())
					furnaceContent.set(4, new ItemStack(Tirphycraft.FROZ_RECIPES.get(recipe).out));
				else
					furnaceContent.get(4).setCount(furnaceContent.get(4).getCount() + 1);
				world.setBlockState(pos, world.getBlockState(pos).with(FrozFurnaceBlock.LIT, false));
			}
			recipe = -1;
		}
	}

	public int getBurnTime() {
		return this.burntime;
	}

	public int isRecipeGood(Item item) {
		for (int i = 0; i < Tirphycraft.FROZ_RECIPES.size(); i++) {
			if (Tirphycraft.FROZ_RECIPES.get(i).in == item)
				return i;
		}

		return -1;
	}

	public boolean isOutputGood() {
		ItemStack output = furnaceContent.get(4);
		if (output.isEmpty())
			return true;
		if (output.getItem() == Tirphycraft.FROZ_RECIPES.get(recipe).out
				&& output.getMaxStackSize() > output.getCount())
			return true;
		return false;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);

		compound.putInt("currentburntime", this.currentburntime);
		compound.putInt("recipe", this.recipe);
		compound.putBoolean("asStart", this.asStart);

		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.furnaceContent);
		}

		return compound;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);

		this.currentburntime = compound.getInt("currentburntime");
		this.recipe = compound.getInt("recipe");
		this.asStart = compound.getBoolean("asStart");

		this.furnaceContent = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.furnaceContent);
		}
	}

	@Override
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbtTagCompound = new CompoundNBT();
		write(nbtTagCompound);
		int tileEntityType = 42;
		return new SUpdateTileEntityPacket(this.pos, tileEntityType, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		read(pkt.getNbtCompound());
	}
	

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbtTagCompound = new CompoundNBT();
		write(nbtTagCompound);
		return nbtTagCompound;
	}

	@Override
	public void handleUpdateTag(CompoundNBT tag) {
		this.read(tag);
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
		return new StringTextComponent("froz furnace");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new FrozFurnaceContainer(id, player, this);
	}

}
