package laz.tirphycraft.util.interf;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraftforge.client.IRenderHandler;

public interface SkyRenderHandler extends IRenderHandler {
    @Override
    default void render(int ticks, float partialTicks, ClientWorld world, Minecraft mc) {}

    void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc);

}