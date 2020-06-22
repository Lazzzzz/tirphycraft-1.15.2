package laz.tirphycraft.client.render.entities.froz;

import com.mojang.blaze3d.matrix.MatrixStack;

import laz.tirphycraft.client.model.entity.froz.MissileBatModel;
import laz.tirphycraft.content.entities.froz.EntityMissileBat;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class MissileBatRender extends MobRenderer<EntityMissileBat, MissileBatModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/bat.png");

	public MissileBatRender(EntityRendererManager manager) {
		super(manager, new MissileBatModel(), 0f);
	}

	@Override
	protected void preRenderCallback(EntityMissileBat entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(0.35F, 0.35F, 0.35F);
	}
	
	@Override
	protected void applyRotations(EntityMissileBat entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		if (entityLiving.getIsBatHanging()) {
			matrixStackIn.translate(0.0D, (double) -0.1F, 0.0D);
		} else {
			matrixStackIn.translate(0.0D, (double) (MathHelper.cos(ageInTicks * 0.3F) * 0.1F), 0.0D);
		}

		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityMissileBat entity) {
		return TEXTURE;
	}

}