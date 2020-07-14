package laz.tirphycraft.client.draw;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.util.interf.IDrawable;
import net.minecraft.util.ResourceLocation;

public class TirphyDrawable {

	public static final UiTexture FROZ_FURNACE_GUI   = new UiTexture(new ResourceLocation(Tirphycraft.MOD_ID, "textures/gui/froz_furnace.png"), 256, 256);
	public static final UiTexture FROZ_FURNACE_ARROW = new UiTexture(new ResourceLocation(Tirphycraft.MOD_ID, "textures/gui/froz_furnace_arrow.png"), 24, 17);
	public static final UiTexture FROZ_FURNACE_BURN  = new UiTexture(new ResourceLocation(Tirphycraft.MOD_ID, "textures/gui/froz_furnace_burn.png"), 14, 14);
	
	public static final UiTexture BOOK_OF_KNOWLEDGE  = new UiTexture(new ResourceLocation(Tirphycraft.MOD_ID, "textures/gui/book_of_knowledge.png"), 256, 256);
	
	
	public static final IDrawable FROZ_FURNACE_0 = FROZ_FURNACE_GUI.getArea(0, 0, 176, 166);
	public static final IDrawable FROZ_FURNACE_1 = FROZ_FURNACE_ARROW.getArea(0, 0, 24, 17);
	public static final IDrawable FROZ_FURNACE_2 = FROZ_FURNACE_BURN.getArea(0, 0, 14, 14);
	
	public static final IDrawable BOOK_OF_KNOWLEDGE_0 = BOOK_OF_KNOWLEDGE.getArea(0, 0, 240, 160);
	
}
