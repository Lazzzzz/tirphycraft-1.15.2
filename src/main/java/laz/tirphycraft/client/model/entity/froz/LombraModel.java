package laz.tirphycraft.client.model.entity.froz;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.froz.EntityLombra;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.5.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class LombraModel extends EntityModel<EntityLombra> {
	private final ModelRenderer Main;
	private final ModelRenderer RightArmWhole;
	private final ModelRenderer RightArmBot;
	private final ModelRenderer LeftArmWhole;
	private final ModelRenderer LeftArmBot;
	private final ModelRenderer Head;
	private final ModelRenderer HeadJawBot;
	private final ModelRenderer HeadjawTop;
	private final ModelRenderer Body;
	private final ModelRenderer BodyEnd;

	public LombraModel() {
		textureWidth = 128;
		textureHeight = 128;

		Main = new ModelRenderer(this);
		Main.setRotationPoint(0.0F, 24.0F, 0.0F);

		RightArmWhole = new ModelRenderer(this);
		RightArmWhole.setRotationPoint(3.0F, -14.0F, 0.0F);
		Main.addChild(RightArmWhole);
		setRotationAngle(RightArmWhole, 0.0F, -0.0873F, 0.1745F);
		RightArmWhole.setTextureOffset(34, 16).addBox(-1.3839F, -9.8785F, -2.8789F, 17.0F, 3.0F, 3.0F, 0.0F, false);

		RightArmBot = new ModelRenderer(this);
		RightArmBot.setRotationPoint(15.3696F, 0.7538F, -2.4924F);
		RightArmWhole.addChild(RightArmBot);
		setRotationAngle(RightArmBot, 0.0F, -0.1745F, -1.5708F);
		RightArmBot.setTextureOffset(27, 34).addBox(-9.1215F, -2.8839F, -1.3789F, 17.0F, 3.0F, 3.0F, 0.0F, false);

		LeftArmWhole = new ModelRenderer(this);
		LeftArmWhole.setRotationPoint(-4.0F, -14.0F, -1.0F);
		Main.addChild(LeftArmWhole);
		setRotationAngle(LeftArmWhole, 0.0F, 0.0873F, -0.1745F);
		LeftArmWhole.setTextureOffset(40, 40).addBox(-15.6161F, -9.8785F, -1.8789F, 17.0F, 3.0F, 3.0F, 0.0F, false);

		LeftArmBot = new ModelRenderer(this);
		LeftArmBot.setRotationPoint(-15.3911F, 1.0F, -1.7452F);
		LeftArmWhole.addChild(LeftArmBot);
		setRotationAngle(LeftArmBot, 0.0F, -0.1745F, -1.5708F);
		LeftArmBot.setTextureOffset(27, 28).addBox(-9.1215F, -0.1161F, -1.3789F, 17.0F, 3.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.5F, -17.75F, -4.0F);
		Main.addChild(Head);

		HeadJawBot = new ModelRenderer(this);
		HeadJawBot.setRotationPoint(0.0F, 3.0F, 0.0F);
		Head.addChild(HeadJawBot);
		setRotationAngle(HeadJawBot, 0.5236F, 0.0F, 0.0F);
		HeadJawBot.setTextureOffset(0, 48).addBox(-5.0F, -6.9282F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);

		HeadjawTop = new ModelRenderer(this);
		HeadjawTop.setRotationPoint(0.0F, -7.0F, 0.0F);
		Head.addChild(HeadjawTop);
		HeadjawTop.setTextureOffset(32, 46).addBox(-5.0F, 2.0F, -8.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		HeadjawTop.setTextureOffset(34, 0).addBox(-5.0F, -6.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, -5.0F);
		Main.addChild(Body);
		setRotationAngle(Body, -0.4363F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 28).addBox(-4.0F, -3.8052F, -0.5691F, 7.0F, 7.0F, 13.0F, 0.0F, false);

		BodyEnd = new ModelRenderer(this);
		BodyEnd.setRotationPoint(0.0F, 0.3684F, 11.4024F);
		Body.addChild(BodyEnd);
		setRotationAngle(BodyEnd, -0.4363F, 0.0F, 0.0F);
		BodyEnd.setTextureOffset(0, 0).addBox(-3.5F, -3.7694F, -1.7182F, 6.0F, 6.0F, 22.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityLombra entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

		if (entity.getRoof()) {
			Main.rotateAngleX = (float) Math.PI;
			Main.rotationPointY = -1;

		} else {
			Main.rotationPointY = 24;
			Main.rotateAngleX = 0;
		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}