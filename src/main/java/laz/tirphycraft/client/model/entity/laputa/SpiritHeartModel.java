package laz.tirphycraft.client.model.entity.laputa;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.laputa.EntitySpiritHeart;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class SpiritHeartModel extends EntityModel<EntitySpiritHeart> {
	private final ModelRenderer body;
	private final ModelRenderer cube1;
	private final ModelRenderer cube2;

	public SpiritHeartModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(64, 0).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, false);

		cube1 = new ModelRenderer(this);
		cube1.setRotationPoint(0.0F, -13.0F, 0.0F);
		body.addChild(cube1);
		cube1.setTextureOffset(40, 18).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		cube2 = new ModelRenderer(this);
		cube2.setRotationPoint(0.0F, -13.0F, 0.0F);
		body.addChild(cube2);
		cube2.setTextureOffset(0, 18).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntitySpiritHeart entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		cube1.rotationPointY = (float) (-19 + Math.cos(entity.ticksExisted * 50) * 4);
		cube2.rotationPointY = (float) (-19 + Math.sin(entity.ticksExisted * 25) * 4);
		cube1.rotateAngleX += MathHelper.cos(0.6662f) * 0.05f; 
		cube1.rotateAngleZ += MathHelper.cos(0.6662f) * 0.05f; 
		
		cube2.rotateAngleX += MathHelper.sin(0.6662f) * 0.05f; 
		cube2.rotateAngleZ += MathHelper.sin(0.6662f) * 0.05f; 
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}