package laz.tirphycraft.util.book;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BookItemInfo {
	private final int maxSizeX = 32;
	private final int maxSizeY = 10;
	private final Item item;
	private int lines = 0;
	
	public final String info[];

	public BookItemInfo(Item item, String text) {
		this.info = new String[maxSizeY];
		this.item = item;
		setText(text);
	}
	
	public BookItemInfo(Block block, String text) {
		this.info = new String[maxSizeY];
		this.item = block.asItem();
		setText(text);
	}

	public boolean setText(String text) {
		
		for (int i = 0; i < maxSizeY; i++) {
			info[i] = "";
		}	
		
		int size = getNbLine(text.length());
		String word [] = text.split(" ");
		int index = 0;;
		
		while (true) {
			if (info[lines].length() + word[index].length() + 1 <= maxSizeX) {
				info[lines] = info[lines] + word[index] + " ";
				index ++;
				if (index >= word.length) break;
			}else {
				lines++;
			}
		}
		
		return true;
	}

	public int getNbLine(int s) {
		int i = 0;
		int b = s;
		while (b > maxSizeX) {
			b -= maxSizeX;
			i++;
		}
		return i;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getLines() {
		return this.lines;
	}
	
	private int getMaxSize() {
		return maxSizeX * maxSizeY;
	}
	
}
