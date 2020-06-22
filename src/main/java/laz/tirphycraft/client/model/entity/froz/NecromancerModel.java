package laz.tirphycraft.client.model.entity.froz;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.froz.EntityNecromancer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class NecromancerModel<T extends EntityNecromancer> extends EntityModel<EntityNecromancer> {
	private final ModelRenderer Body;
	private final ModelRenderer bone2;
	private final ModelRenderer Cape;
	private final ModelRenderer bone;
	private final ModelRenderer Head;
	private final ModelRenderer RightArm;
	private final ModelRenderer StaffPlaceholder;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public NecromancerModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Body, 0.0F, 3.1416F, 0.0F);
		Body.setTextureOffset(32, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 23.5F, 2.0F);
		Body.addChild(bone2);
		setRotationAngle(bone2, -0.6981F, 0.0F, 0.0F);
		bone2.setTextureOffset(104, 44).addBox(-4.0F, -17.8201F, -14.9433F, 8.0F, 5.0F, 4.0F, 0.0F, false);

		Cape = new ModelRenderer(this);
		Cape.setRotationPoint(-16.5F, 23.0F, -2.0F);
		Body.addChild(Cape);
		setRotationAngle(Cape, -0.0873F, 0.0F, 0.0F);
		Cape.setTextureOffset(63, 92).addBox(11.0F, -24.0F, -2.0F, 11.0F, 24.0F, 0.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 21.75F, -10.25F);
		Body.addChild(bone);
		setRotationAngle(bone, -0.6981F, 0.0F, 0.0F);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(96, 110).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
		Head.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		Body.addChild(RightArm);
		RightArm.setTextureOffset(52, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		StaffPlaceholder = new ModelRenderer(this);
		StaffPlaceholder.setRotationPoint(5.0F, 22.0F, 0.0F);
		RightArm.addChild(StaffPlaceholder);
		StaffPlaceholder.setTextureOffset(52, 32).addBox(-6.0F, -12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		Body.addChild(LeftArm);
		LeftArm.setTextureOffset(48, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		Body.addChild(RightLeg);
		RightLeg.setTextureOffset(38, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		Body.addChild(LeftLeg);
		LeftLeg.setTextureOffset(22, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityNecromancer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		
		if (entity.getInvoc()) {
			this.RightArm.rotateAngleX = 2.8f + (entity.getRNG().nextFloat()/4) - 0.125f;
			this.LeftArm.rotateAngleX = 2.8f + (entity.getRNG().nextFloat()/4) - 0.125f;
			this.RightArm.rotateAngleY = -0.5F;
			this.LeftArm.rotateAngleY = 0.5F;
		} else if (entity.getBat()) {
			this.RightArm.rotateAngleX = 1.6f + (entity.getRNG().nextFloat()/4) - 0.125f;
			this.LeftArm.rotateAngleX = 1.6f + (entity.getRNG().nextFloat()/4) - 0.125f;
			this.RightArm.rotateAngleY = (entity.getRNG().nextFloat()/4) - 0.125f;
			this.LeftArm.rotateAngleY = (entity.getRNG().nextFloat()/4) - 0.125f;
		}else {
			this.RightArm.rotateAngleY = 0;
			this.LeftArm.rotateAngleY = 0;
			this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;	
		}
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}