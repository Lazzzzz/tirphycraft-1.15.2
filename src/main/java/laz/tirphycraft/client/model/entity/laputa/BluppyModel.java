package laz.tirphycraft.client.model.entity.laputa;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.laputa.EntityBluppy;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BluppyModel extends EntityModel<EntityBluppy> {
	private final ModelRenderer bone;
	private final ModelRenderer body;
	private final ModelRenderer tentacle1;
	private final ModelRenderer tentacle2;
	private final ModelRenderer tentacle3;
	private final ModelRenderer tentacle4;

	public BluppyModel() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 0.0F, -3.1416F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -31.0F, 0.0F);
		bone.addChild(body);
		body.setTextureOffset(0, 0).addBox(-8.0F, 15.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(32, 32).addBox(-5.0F, 18.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		tentacle1 = new ModelRenderer(this);
		tentacle1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(tentacle1);
		tentacle1.setTextureOffset(32, 52).addBox(-8.0F, 0.0F, 8.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		tentacle2 = new ModelRenderer(this);
		tentacle2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(tentacle2);
		tentacle2.setTextureOffset(48, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		tentacle3 = new ModelRenderer(this);
		tentacle3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(tentacle3);
		tentacle3.setTextureOffset(0, 32).addBox(8.0F, 0.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);

		tentacle4 = new ModelRenderer(this);
		tentacle4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(tentacle4);
		tentacle4.setTextureOffset(0, 16).addBox(-8.0F, 0.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityBluppy entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		bone.rotateAngleY = (float) Math.cos(ageInTicks * 0.1f);
		if (entity.getHovering()) {
			tentacle3.rotateAngleZ = -0.4f;
			tentacle4.rotateAngleZ =  0.4f;
			tentacle1.rotateAngleX =  0.4f;
			tentacle2.rotateAngleX = -0.4f;
		} else {
			tentacle3.rotateAngleZ = -(Math.min(1 - entity.getSize(), 0.4f));
			tentacle4.rotateAngleZ = (Math.min(1 - entity.getSize(), 0.4f));
			tentacle1.rotateAngleX = (Math.min(1 - entity.getSize(), 0.4f));
			tentacle2.rotateAngleX = -(Math.min(1 - entity.getSize(), 0.4f));
		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}