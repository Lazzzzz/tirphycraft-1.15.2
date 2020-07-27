package laz.tirphycraft.client.render.entities.froz;

import com.mojang.blaze3d.matrix.MatrixStack;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.PhantomGuardianModel;
import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PhantomGuardianRender extends MobRenderer<EntityPhantomGuardian, PhantomGuardianModel> {
	
	protected static final ResourceLocation TEXTURE =  new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/froz/phantom_guardian.png");
	
	public PhantomGuardianRender(EntityRendererManager manager) {
		super(manager, new PhantomGuardianModel(), 0.0f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityPhantomGuardian entity) {
		return TEXTURE;
	}
	
	@Override
	public void render(EntityPhantomGuardian entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
}
