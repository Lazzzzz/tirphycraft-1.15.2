package laz.tirphycraft.client.model.entity.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class DraugrirFeetModel extends BipedModel<LivingEntity> {
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public DraugrirFeetModel() {
		super(1.0F, 0, 64, 64);
		textureWidth = 128;
		textureHeight = 128;

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(38, 40);
		RightLeg.addBox(-3.0F, 6.0F, -3.0F, 5, 6, 6, 0.0F, false);

		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(16, 40);
		LeftLeg.addBox(-1.8F, 6.0F, -3.0F, 5, 6, 6, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		RightLeg.rotateAngleX = this.bipedRightLeg.rotateAngleX;
		RightLeg.rotateAngleY = this.bipedRightLeg.rotateAngleY;
		RightLeg.rotateAngleZ = this.bipedRightLeg.rotateAngleZ;
		RightLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		LeftLeg.rotateAngleX = this.bipedLeftLeg.rotateAngleX;
		LeftLeg.rotateAngleY = this.bipedLeftLeg.rotateAngleY;
		LeftLeg.rotateAngleZ = this.bipedLeftLeg.rotateAngleZ;
		LeftLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}