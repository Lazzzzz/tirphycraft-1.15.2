package laz.tirphycraft.client.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;

import static laz.tirphycraft.client.draw.TirphyDrawable.EMPTY_SOUL_BAR;

public class TirphycraftMainOverlay {

    public static TirphycraftMainOverlay INSTANCE = new TirphycraftMainOverlay();

    private final Minecraft mc;
    private final PlayerEntity player;


    public TirphycraftMainOverlay(){
        mc = Minecraft.getInstance();
        player =  Minecraft.getInstance().player;
    }

    public void buildOverlay(){
        EMPTY_SOUL_BAR.draw(0,0,70,6);
    }


}
