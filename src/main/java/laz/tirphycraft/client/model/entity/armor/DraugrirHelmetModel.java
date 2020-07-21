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
public class DraugrirHelmetModel extends BipedModel<LivingEntity> {
	private final ModelRenderer Head;
	private final ModelRenderer bone5;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone7;
	private final ModelRenderer bone6;

	public DraugrirHelmetModel() {
		super(1.0F, 0, 64, 64);
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(8, 51).addBox(4.0F, -8.0F, -2.0F, 1.0F, 8.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(0, 43).addBox(-5.0F, -8.0F, -2.0F, 1.0F, 8.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -5.5F, 8.0F, 1.0F, 9.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(bone5);
		setRotationAngle(bone5, -0.0873F, 0.0F, 0.0F);
		bone5.setTextureOffset(22, 52).addBox(-4.0F, -32.314F, 1.192F, 8.0F, 8.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, -1.0F);
		Head.addChild(bone);
		setRotationAngle(bone, 0.0F, -0.1745F, 0.0F);
		bone.setTextureOffset(48, 52).addBox(-5.0977F, -32.0F, -3.1166F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.1745F, 0.0F);
		bone2.setTextureOffset(40, 52).addBox(4.0977F, -32.0F, -3.1166F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(bone3);
		setRotationAngle(bone3, 0.1745F, 0.0F, 0.0F);
		bone3.setTextureOffset(48, 25).addBox(-4.0209F, -32.3742F, 0.6776F, 8.0F, 4.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 23.0F, 5.5F);
		Head.addChild(bone4);
		setRotationAngle(bone4, 0.1745F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 0).addBox(-1.75F, -32.3742F, -5.3224F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(2.0F, 0.0F, 0.0F);
		Head.addChild(bone7);
		setRotationAngle(bone7, -0.0873F, 0.1745F, 0.0F);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-8.0F, 0.0F, 0.0F);
		Head.addChild(bone6);
		setRotationAngle(bone6, -0.0873F, -0.1745F, 0.0F);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		Head.rotateAngleX = this.bipedHead.rotateAngleX;
		Head.rotateAngleY = this.bipedHead.rotateAngleY;
		Head.rotateAngleZ = this.bipedHead.rotateAngleZ;
		Head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}