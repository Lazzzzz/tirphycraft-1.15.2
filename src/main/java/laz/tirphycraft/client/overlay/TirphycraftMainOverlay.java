package laz.tirphycraft.client.overlay;

import static laz.tirphycraft.api.SoulFactorCap.getSoulFactor;
import static laz.tirphycraft.client.draw.TirphyDrawable.EMPTY_SOUL_BAR;
import static laz.tirphycraft.client.draw.TirphyDrawable.getSoulBarBad;
import static laz.tirphycraft.client.draw.TirphyDrawable.getSoulBarGood;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;

public class TirphycraftMainOverlay {

    public static TirphycraftMainOverlay INSTANCE = new TirphycraftMainOverlay();

    private final PlayerEntity player;

    private int barX = 10;
    private int barY = 10;

    public TirphycraftMainOverlay() {
        player = Minecraft.getInstance().player;
    }

    public void buildOverlay() {
    	
        EMPTY_SOUL_BAR.draw(barX, barY, 70, 6);
        float soulFactor = getSoulFactor(player);
        
        if (soulFactor > 0) getSoulBarGood(70).drawPartial(barX, barY, 70, 6, 0, 0, soulFactor/100, 1);
        else if (soulFactor < 0) getSoulBarBad(70).drawPartial(barX, barY, 70, 6, 0, 0, -soulFactor/100, 1);
    }


}
