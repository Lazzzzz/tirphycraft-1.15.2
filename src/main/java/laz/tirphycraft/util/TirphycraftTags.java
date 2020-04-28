package laz.tirphycraft.util;

import laz.tirphycraft.Tirphycraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class TirphycraftTags {

	public static class Items {
		public static final Tag<Item> LAPUTA_GRASS = tag("laputa_grass");
		
		private static Tag<Item> tag(String name){
			return new ItemTags.Wrapper(new ResourceLocation(Tirphycraft.MOD_ID, name));
		}
	}
	
	public static class Blocks {
		public static final Tag<Block> LAPUTA_GRASS = tag("laputa_grass");
		
		private static Tag<Block> tag(String name){
			return new BlockTags.Wrapper(new ResourceLocation(Tirphycraft.MOD_ID, name));
		}
	}
	
}
