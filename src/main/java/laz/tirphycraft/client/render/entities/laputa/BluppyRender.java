package laz.tirphycraft.client.render.entities.laputa;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.laputa.BluppyModel;
import laz.tirphycraft.content.entities.laputa.EntityBluppy;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BluppyRender extends MobRenderer<EntityBluppy, BluppyModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID,
			"textures/entity/laputa/bluppy.png");

	public BluppyRender(EntityRendererManager manager) {
		super(manager, new BluppyModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityBluppy entity) {
		return TEXTURE;
	}

	@Override
	public void render(EntityBluppy entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		this.entityModel.setRotationAngles(entityIn, 0, 0, entityIn.ticksExisted, 0, 0);
		
		float width  = 0.7f + Math.max(0.3f, 1 - entityIn.getSize()); 
		float height = entityIn.getSize();		
		
		matrixStackIn.scale(width, height, width);

		IVertexBuilder buf = bufferIn.getBuffer(RenderType.getEntityTranslucent(this.getEntityTexture(entityIn)));
		int overlay = LivingRenderer.getPackedOverlay(entityIn, 0F);
		
		float red = (float) -Math.cos(entityIn.getPosX() * entityIn.getPosY() * 0.001f);
		float green = (float) Math.sin(entityIn.getPosY() * 0.005f);
		float blue = (float) Math.cos(entityIn.getPosZ() * entityIn.getPosY() * 0.0007f);
		
		this.entityModel.render(matrixStackIn, buf, packedLightIn, overlay , Math.abs(red), Math.abs(green), Math.abs(blue), 1);
	}

}
