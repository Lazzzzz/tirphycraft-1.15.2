package laz.tirphycraft.client.render.world;

import java.util.Random;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.client.IRenderHandler;

public class BlizzardRendering implements IRenderHandler {

	private static final ResourceLocation SNOW_TEXTURES = new ResourceLocation("textures/environment/snow.png");

	private final float[] rainxs = new float[16384];
	private final float[] rainys = new float[16384];

	private int rendererUpdateCount;

	public BlizzardRendering() {
		for (int i = 0; i < 128; ++i) {
			for (int j = 0; j < 128; ++j) {
				float f = (float) (j - 64);
				float f1 = (float) (i - 64);
				float f2 = MathHelper.sqrt(f * f + f1 * f1);
				this.rainxs[i << 7 | j] = -f1 / f2;
				this.rainys[i << 7 | j] = f / f2;
			}
		}
	}

	public void tick() {
		this.rendererUpdateCount += 60;
	}

	@Override
	public void render(int ticks, float partialTicks, ClientWorld world, Minecraft mc) {
		tick();
		renderNormalWeather(partialTicks, mc);

	}

	private void renderNormalWeather(float partialTicks, Minecraft mc) {
		float f = mc.world.getRainStrength(partialTicks);
		Vec3d vec3d = mc.gameRenderer.getActiveRenderInfo().getProjectedView();
		double xIn = vec3d.getX();
		double yIn = vec3d.getY();
		double zIn = vec3d.getZ();

		if (!(f <= 0.0F)) {
			mc.gameRenderer.getLightTexture().enableLightmap();
			World world = mc.world;
			int i = MathHelper.floor(xIn);
			int j = MathHelper.floor(yIn);
			int k = MathHelper.floor(zIn);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferbuilder = tessellator.getBuffer();
			RenderSystem.disableCull();
			RenderSystem.normal3f(0.0F, 1.0F, 0.0F);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.defaultAlphaFunc();

			int l = 15;
			if (mc.gameSettings.fancyGraphics) {
				l = 30;
			}

			int i1 = -1;
			float f1 = (float) this.rendererUpdateCount + partialTicks;
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

			for (int j1 = k - l; j1 <= k + l; ++j1) {
				for (int k1 = i - l; k1 <= i + l; ++k1) {
					int l1 = (j1 - k + 64) * 128 + k1 - i + 64;
					double d0 = (double) this.rainxs[l1] * 0.5D;
					double d1 = (double) this.rainys[l1] * 0.5D;
					blockpos$mutableblockpos.setPos(k1, 0, j1);
					Biome biome = world.getBiome(blockpos$mutableblockpos);
					if (biome.getPrecipitation() != Biome.RainType.NONE) {
						int i2 = world.getHeight(Heightmap.Type.MOTION_BLOCKING, blockpos$mutableblockpos).getY() - 1;
						int j2 = j - l;
						int k2 = j + l;
						if (j2 < i2) {
							j2 = i2;
						}

						if (k2 < i2) {
							k2 = i2;
						}

						int l2 = i2;
						if (i2 < j) {
							l2 = j;
						}

						if (j2 != k2) {
							Random random = new Random(
									(long) (k1 * k1 * 3121 + k1 * 45238971 ^ j1 * j1 * 418711 + j1 * 13761));
							blockpos$mutableblockpos.setPos(k1, j2, j1);

							if (i1 != 1) {
								if (i1 >= 0) {
									tessellator.draw();
								}

								i1 = 1;
								mc.getTextureManager().bindTexture(SNOW_TEXTURES);
								bufferbuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
							}

							float f6 = -((float) (this.rendererUpdateCount & 511) + partialTicks) / 512.0F;
							float f7 = (float) (random.nextDouble()
									+ (double) f1 * 0.01D * (double) ((float) random.nextGaussian()));
							float f8 = (float) (random.nextDouble()
									+ (double) (f1 * (float) random.nextGaussian()) * 0.001D);
							double d3 = (double) ((float) k1 + 0.5F) - xIn;
							double d5 = (double) ((float) j1 + 0.5F) - zIn;
							float f9 = MathHelper.sqrt(d3 * d3 + d5 * d5) / (float) l;
							float f10 = ((1.0F - f9 * f9) * 0.3F + 0.5F) * f;
							blockpos$mutableblockpos.setPos(k1, l2, j1);
							int k3 = WorldRenderer.getCombinedLight(world, blockpos$mutableblockpos);
							int l3 = k3 >> 16 & '\uffff';
							int i4 = (k3 & '\uffff') * 3;
							int j4 = (l3 * 3 + 240) / 4;
							int k4 = (i4 * 3 + 240) / 4;
							bufferbuilder
									.pos((double) k1 - xIn - d0 + 0.5D, (double) k2 - yIn,
											(double) j1 - zIn - d1 + 0.5D)
									.tex(0.0F + f7, (float) j2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10)
									.lightmap(k4, j4).endVertex();
							bufferbuilder
									.pos((double) k1 - xIn + d0 + 0.5D, (double) k2 - yIn,
											(double) j1 - zIn + d1 + 0.5D)
									.tex(1.0F + f7, (float) j2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10)
									.lightmap(k4, j4).endVertex();
							bufferbuilder
									.pos((double) k1 - xIn + d0 + 0.5D, (double) j2 - yIn,
											(double) j1 - zIn + d1 + 0.5D)
									.tex(1.0F + f7, (float) k2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10)
									.lightmap(k4, j4).endVertex();
							bufferbuilder
									.pos((double) k1 - xIn - d0 + 0.5D, (double) j2 - yIn,
											(double) j1 - zIn - d1 + 0.5D)
									.tex(0.0F + f7, (float) k2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10)
									.lightmap(k4, j4).endVertex();

						}
					}
				}
			}

			if (i1 >= 0) {
				tessellator.draw();
			}

			RenderSystem.enableCull();
			RenderSystem.disableBlend();
			RenderSystem.defaultAlphaFunc();
			mc.gameRenderer.getLightTexture().disableLightmap();
		}
	}

}