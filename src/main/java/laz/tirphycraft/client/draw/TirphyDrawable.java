package laz.tirphycraft.client.draw;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.util.interf.IDrawable;
import net.minecraft.util.ResourceLocation;

public class TirphyDrawable {

	public static final UiTexture FROZ_FURNACE_ATLAS  = new UiTexture(new ResourceLocation(Tirphycraft.MOD_ID, "textures/gui/froz_furnace.png"), 256, 256);
	
	public static final IDrawable FROZ_FURNACE 		  = FROZ_FURNACE_ATLAS.getArea(0, 0, 176, 166);
	public static final IDrawable FROZ_FURNACE_UPDATE = FROZ_FURNACE_ATLAS.getArea(176, 14, 24, 17);
	
}
