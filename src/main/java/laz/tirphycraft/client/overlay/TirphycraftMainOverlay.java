package laz.tirphycraft.client.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;

import static laz.tirphycraft.api.SoulFactorCap.getSoulFactor;
import static laz.tirphycraft.client.draw.TirphyDrawable.*;

public class TirphycraftMainOverlay {

    public static TirphycraftMainOverlay INSTANCE = new TirphycraftMainOverlay();

    private final Minecraft mc;
    private final PlayerEntity player;

    private int barX = 10;
    private int barY = 10;

    public TirphycraftMainOverlay() {
        mc = Minecraft.getInstance();
        player = Minecraft.getInstance().player;
    }

    public void buildOverlay() {
        EMPTY_SOUL_BAR.draw(barX, barY, 70, 6);
        int soulFactor = getSoulFactor(player);
        if (soulFactor > 0) {
            int sections = 70 / 100;
            int x = sections * soulFactor;
            getSoulBarBad(x).draw(barX, barY,x,6);
        } else if (soulFactor < 0) {
            int sections = 70 / 100;
            int x = sections * soulFactor;
            getSoulBarGood(x).draw(barX, barY,x,6);
        }
    }


}
