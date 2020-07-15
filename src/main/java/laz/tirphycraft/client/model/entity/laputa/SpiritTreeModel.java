package laz.tirphycraft.client.model.entity.laputa;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.laputa.EntityTreeSpirit;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class SpiritTreeModel extends EntityModel<EntityTreeSpirit> {
	private final ModelRenderer body;
	private final ModelRenderer rotTop4;
	private final ModelRenderer rotTop3;
	private final ModelRenderer rotTop2;
	private final ModelRenderer rotTop1;
	private final ModelRenderer Body1;
	private final ModelRenderer Body2;
	private final ModelRenderer Body3;
	private final ModelRenderer rotBu1;
	private final ModelRenderer rotBu2;
	private final ModelRenderer rotBu3;
	private final ModelRenderer rotBu4;
	private final ModelRenderer rotMid1;
	private final ModelRenderer rotMid2;
	private final ModelRenderer rotMid3;
	private final ModelRenderer rotMid4;
	private boolean [] shields = new boolean [12];

	public SpiritTreeModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);	

		rotTop4 = new ModelRenderer(this);
		rotTop4.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotTop4);
		rotTop4.setTextureOffset(102, 82).addBox(-4.0F, -12.0F, 10.0F, 8.0F, 10.0F, 2.0F, 0.0F, false);

		rotTop3 = new ModelRenderer(this);
		rotTop3.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotTop3);
		rotTop3.setTextureOffset(102, 66).addBox(-4.0F, -12.0F, -12.0F, 8.0F, 10.0F, 2.0F, 0.0F, false);

		rotTop2 = new ModelRenderer(this);
		rotTop2.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotTop2);
		rotTop2.setTextureOffset(78, 55).addBox(-12.0F, -12.0F, -4.0F, 2.0F, 10.0F, 8.0F, 0.0F, false);

		rotTop1 = new ModelRenderer(this);
		rotTop1.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotTop1);
		rotTop1.setTextureOffset(55, 55).addBox(10.0F, -12.0F, -4.0F, 2.0F, 10.0F, 8.0F, 0.0F, false);

		Body1 = new ModelRenderer(this);
		Body1.setRotationPoint(-5.0F, -16.0F, -5.0F);
		body.addChild(Body1);
		Body1.setTextureOffset(0, 0).addBox(0.0F, 8.0F, 0.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(-7.0F, -30.0F, -7.0F);
		body.addChild(Body2);
		Body2.setTextureOffset(0, 29).addBox(0.0F, 8.0F, 0.0F, 14.0F, 16.0F, 14.0F, 0.0F, false);

		Body3 = new ModelRenderer(this);
		Body3.setRotationPoint(-5.0F, -46.0F, -5.0F);
		body.addChild(Body3);
		Body3.setTextureOffset(0, 60).addBox(0.0F, 8.0F, 0.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		rotBu1 = new ModelRenderer(this);
		rotBu1.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotBu1);
		rotBu1.setTextureOffset(55, 0).addBox(10.0F, 20.0F, -4.0F, 2.0F, 10.0F, 8.0F, 0.0F, false);

		rotBu2 = new ModelRenderer(this);
		rotBu2.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotBu2);
		rotBu2.setTextureOffset(78, 0).addBox(-12.0F, 20.0F, -4.0F, 2.0F, 10.0F, 8.0F, 0.0F, false);

		rotBu3 = new ModelRenderer(this);
		rotBu3.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotBu3);
		rotBu3.setTextureOffset(102, 0).addBox(-4.0F, 20.0F, -12.0F, 8.0F, 10.0F, 2.0F, 0.0F, false);

		rotBu4 = new ModelRenderer(this);
		rotBu4.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotBu4);
		rotBu4.setTextureOffset(102, 14).addBox(-4.0F, 20.0F, 10.0F, 8.0F, 10.0F, 2.0F, 0.0F, false);

		rotMid1 = new ModelRenderer(this);
		rotMid1.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotMid1);
		rotMid1.setTextureOffset(55, 20).addBox(14.0F, 4.0F, -4.0F, 2.0F, 12.0F, 8.0F, 0.0F, false);

		rotMid2 = new ModelRenderer(this);
		rotMid2.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotMid2);
		rotMid2.setTextureOffset(78, 20).addBox(-16.0F, 4.0F, -4.0F, 2.0F, 12.0F, 8.0F, 0.0F, false);

		rotMid3 = new ModelRenderer(this);
		rotMid3.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotMid3);
		rotMid3.setTextureOffset(102, 30).addBox(-4.0F, 4.0F, -16.0F, 8.0F, 12.0F, 2.0F, 0.0F, false);

		rotMid4 = new ModelRenderer(this);
		rotMid4.setRotationPoint(0.0F, -24.0F, 0.0F);
		body.addChild(rotMid4);
		rotMid4.setTextureOffset(102, 47).addBox(-4.0F, 4.0F, 14.0F, 8.0F, 12.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityTreeSpirit entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
		for (int i = 0; i < 12; i++) {
			shields[i] = false;
		}

		for (int i = 0; i < entity.getShield(); i++) {
			shields[i] = true;
		}

		this.rotTop1.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
		this.rotTop2.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
		this.rotTop3.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
		this.rotTop4.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;

		this.rotBu1.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
		this.rotBu2.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
		this.rotBu3.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
		this.rotBu4.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;

		this.rotMid1.rotateAngleY -= MathHelper.cos(0.6662f) * 0.03f;
		this.rotMid2.rotateAngleY -= MathHelper.cos(0.6662f) * 0.03f;
		this.rotMid3.rotateAngleY -= MathHelper.cos(0.6662f) * 0.03f;
		this.rotMid4.rotateAngleY -= MathHelper.cos(0.6662f) * 0.03f;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		
		if (shields[0])  rotTop2.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[1])	 rotMid2.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[2])	 rotBu4.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[3])	 rotMid4.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[4])	 rotBu1.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[5])	 rotBu2.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[6])	 rotBu3.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[7])	 rotMid1.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[8])	 rotTop1.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[9])	 rotTop3.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[10]) rotTop4.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[11]) rotMid3.render(matrixStack, buffer, packedLight, packedOverlay);
		
		Body3.render(matrixStack, buffer, packedLight, packedOverlay);
		Body1.render(matrixStack, buffer, packedLight, packedOverlay);
		Body2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}