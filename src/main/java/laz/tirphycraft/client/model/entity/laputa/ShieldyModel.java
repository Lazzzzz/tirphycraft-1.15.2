package laz.tirphycraft.client.model.entity.laputa;
// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.laputa.EntityShieldy;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ShieldyModel extends EntityModel<EntityShieldy> {
	private final ModelRenderer shield4;
	private final ModelRenderer shield3;
	private final ModelRenderer shield2;
	private final ModelRenderer shield1;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer main;
	
	private boolean [] shields = new boolean [4];

	public ShieldyModel() {
		textureWidth = 128;
		textureHeight = 128;

		shield4 = new ModelRenderer(this);
		shield4.setRotationPoint(0.0F, -3.0F, 0.0F);
		shield4.setTextureOffset(0, 48).addBox(-5.0F, 4.0F, -10.0F, 10.0F, 19.0F, 1.0F, 0.0F, false);

		shield3 = new ModelRenderer(this);
		shield3.setRotationPoint(0.0F, -3.0F, 0.0F);
		shield3.setTextureOffset(34, 34).addBox(-5.0F, 4.0F, 9.0F, 10.0F, 19.0F, 1.0F, 0.0F, false);

		shield2 = new ModelRenderer(this);
		shield2.setRotationPoint(0.0F, -3.0F, 0.0F);
		shield2.setTextureOffset(12, 19).addBox(9.0F, 4.0F, -5.0F, 1.0F, 19.0F, 10.0F, 0.0F, false);

		shield1 = new ModelRenderer(this);
		shield1.setRotationPoint(0.0F, -3.0F, 0.0F);
		shield1.setTextureOffset(0, 0).addBox(-10.0F, 4.0F, -5.0F, 1.0F, 19.0F, 10.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -32.0F, 1.0F);
		body.addChild(head);
		head.setTextureOffset(22, 0).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, -16.0F, 1.0F);
		body.addChild(main);
		main.setTextureOffset(22, 50).addBox(-2.0F, -5.0F, -3.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);
		main.setTextureOffset(34, 25).addBox(-3.0F, -8.0F, -4.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		main.setTextureOffset(24, 16).addBox(-3.0F, 13.0F, -4.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityShieldy entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				
		for (int i = 0; i < 4; i++) {
			shields[i] = false;
		}

		for (int i = 0; i < entity.getShield(); i++) {
			shields[i] = true;
		}
		
		body.rotationPointY = 20 - MathHelper.sin(ageInTicks * 0.1f) * 4;
		
		shield1.rotationPointY = - 10 - MathHelper.cos(ageInTicks * 0.101f) * 5;
		shield2.rotationPointY = - 10 - MathHelper.cos(ageInTicks * 0.101f) * 5;
		shield3.rotationPointY = - 10 - MathHelper.cos(ageInTicks * 0.101f) * 5;
		shield4.rotationPointY = - 10 - MathHelper.cos(ageInTicks * 0.101f) * 5;
		
		shield4.rotateAngleX = -Math.abs(MathHelper.cos(ageInTicks * 0.0505f) / 4);
		shield3.rotateAngleX = Math.abs(MathHelper.cos(ageInTicks * 0.0505f) / 4);
		shield1.rotateAngleZ = Math.abs(MathHelper.cos(ageInTicks * 0.0505f) / 4);
		shield2.rotateAngleZ = -Math.abs(MathHelper.cos(ageInTicks * 0.0505f) / 4);
		
		head.rotateAngleY = 0.0f;
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		if (shields[0]) shield4.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[1]) shield3.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[2]) shield2.render(matrixStack, buffer, packedLight, packedOverlay);
		if (shields[3]) shield1.render(matrixStack, buffer, packedLight, packedOverlay);
		
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}