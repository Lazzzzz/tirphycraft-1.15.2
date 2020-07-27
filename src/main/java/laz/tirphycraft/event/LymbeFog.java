package laz.tirphycraft.event;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LymbeFog {

	public LymbeFog() {
	}

	@SubscribeEvent
	public void render(RenderWorldLastEvent event) {
		
		IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
		IVertexBuilder builder = Tessellator.getInstance().getBuffer();
		MatrixStack matrixStack = event.getMatrixStack();

		PlayerEntity player = Minecraft.getInstance().player;
		double x = player.lastTickPosX + (player.getPosX() - player.lastTickPosX) * event.getPartialTicks();
		double y = player.lastTickPosY + (player.getPosY() - player.lastTickPosY) * event.getPartialTicks();
		double z = player.lastTickPosZ + (player.getPosZ() - player.lastTickPosZ) * event.getPartialTicks();

		matrixStack.push();
		matrixStack.translate(-x, -y, -z);
		Matrix4f matrix = matrixStack.getLast().getMatrix();

		builder.pos(matrix, 0, 0, 0).color(1f, 0, 0, 1f).tex(0, 0).lightmap(0,0).endVertex();
		builder.pos(matrix, 0, 256, 0).color(1f, 0, 0, 1f).tex(0, 0).lightmap(0,0).endVertex();

		matrixStack.pop();
		RenderSystem.disableDepthTest();
	}

}
