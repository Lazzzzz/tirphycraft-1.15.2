package laz.tirphycraft.client.model.entity.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports
@OnlyIn(Dist.CLIENT)
public class DraugrirChestModel extends BipedModel<LivingEntity> {
	private final ModelRenderer Body;
	private final ModelRenderer bone8;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;

	public DraugrirChestModel() {
		super(1.0F, 0, 64, 64);
		textureWidth = 128;
		textureHeight = 128;
		
		this.bipedBody.showModel = true;
		this.bipedRightArm.showModel = false;
		this.bipedLeftArm.showModel = false;
		this.bipedHead.showModel = false;
		this.bipedHeadwear.showModel = false;
		this.bipedRightLeg.showModel = false;
		this.bipedLeftLeg.showModel = false;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(26, 26);
		Body.addBox(-4.0F, -0.5F, -3.0F, 8, 8, 6, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone8, 0.1745F, 0.0F, 0.0F);
		Body.addChild(bone8);
		bone8.setTextureOffset(37, 0);
		bone8.addBox(-4.0F, -24.6487F, -0.45F, 8, 8, 1, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(38, 12);
		RightArm.addBox(-4.0F, -3.0F, -3.0F, 5, 7, 6, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(0, 30);
		LeftArm.addBox(-1.0F, -3.0F, -3.0F, 5, 7, 6, 0.0F, false);
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		RightArm.rotateAngleX = this.bipedRightArm.rotateAngleX;
		RightArm.rotateAngleY = this.bipedRightArm.rotateAngleY;
		RightArm.rotateAngleZ = this.bipedRightArm.rotateAngleZ;
		RightArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		LeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX;
		LeftArm.rotateAngleY = this.bipedLeftArm.rotateAngleY;
		LeftArm.rotateAngleZ = this.bipedLeftArm.rotateAngleZ;
		LeftArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}