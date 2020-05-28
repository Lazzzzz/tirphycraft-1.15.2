package laz.tirphycraft.client.draw;

import org.lwjgl.opengl.GL11;

import laz.tirphycraft.util.interf.IDrawable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class UiTexture {
	private final ResourceLocation TEXTURE;
	private final float x;
	private final float y;

	public UiTexture(ResourceLocation texture, float x, float y) {
		TEXTURE = texture;
		this.x = x;
		this.y = y;
	}

	public void bindTexture() {
		Minecraft.getInstance().textureManager.bindTexture(TEXTURE);
	}
	
	public IDrawable getFullArea() {
		return new Area(0, 0, 1, 1);
	}
	
	public IDrawable getArea(int x, int y, int w, int h) {
		return new Area(x / w, y / h, w / this.x, h / this.y);
		
	}

	private class Area implements IDrawable {

		private final float v, u;
		private final float dv, du;

		public Area(float u, float v, float du, float dv) {
			this.v = v;
			this.u = u;
			this.du = du;
			this.dv = dv;
		}

		@Override
		public void drawPartial(double x, double y, double width, double height, float x1, float y1, float x2,
				float y2) {
			bindTexture();
			double xi = x + width * x1; 
			double xf = x + width * x2;
			double yi = y + height * y1;
			double yf = y + height * y2;
			float ui = u + du * x1;
			float uf = u + du * x2;
			float vi = v + dv * y1;
			float vf = v + dv * y2;
			
			Tessellator tesselator = Tessellator.getInstance();
			BufferBuilder buffbuilder = tesselator.getBuffer();
			buffbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			buffbuilder.pos(xi, yi, 0D).tex(ui, vi).endVertex();
			buffbuilder.pos(xi, yf, 0D).tex(ui, vf).endVertex();
			buffbuilder.pos(xf, yf, 0D).tex(uf, vf).endVertex();
			buffbuilder.pos(xf, yi, 0D).tex(uf, vi).endVertex();
			tesselator.draw();

		}

	}
}
