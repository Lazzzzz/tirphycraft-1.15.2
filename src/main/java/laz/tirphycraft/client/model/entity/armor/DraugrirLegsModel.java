package laz.tirphycraft.client.model.entity.armor;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
public class DraugrirLegsModel extends BipedModel<LivingEntity> {
	private final ModelRenderer Pants;

	public DraugrirLegsModel() {
		super(1.0F, 0, 64, 64);
		textureWidth = 128;
		textureHeight = 128;

		Pants = new ModelRenderer(this);
		Pants.setRotationPoint(0.0F, 24.0F, 0.0F);
		Pants.setTextureOffset(0, 20).addBox(-4.5F, -16.5F, -3.75F, 9.0F, 3.0F, 7.0F, 0.0F, false);
		Pants.setTextureOffset(0, 10).addBox(-4.5F, -13.0F, -3.75F, 9.0F, 3.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		
		Pants.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}