package laz.tirphycraft.client.model.entity.laputa;
// Made with Blockbench 3.5.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.laputa.EntityButterfly;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ButterflyModel extends EntityModel<EntityButterfly> {
	private final ModelRenderer Wing1;
	private final ModelRenderer Wing2;

	public ButterflyModel() {
		textureWidth = 16;
		textureHeight = 16;

		Wing1 = new ModelRenderer(this);
		Wing1.setRotationPoint(0.0F, 24.0F, 1.5F);
		setRotationAngle(Wing1, 0.0F, 0.0F, -0.4363F);
		Wing1.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -1.5F, 4.0F, 0.0F, 4.0F, 0.0F, false);

		Wing2 = new ModelRenderer(this);
		Wing2.setRotationPoint(0.0F, 24.0F, 1.5F);
		setRotationAngle(Wing2, 0.0F, 0.0F, 0.4363F);
		Wing2.setTextureOffset(0, 4).addBox(-4.0F, 0.0F, -1.5F, 4.0F, 0.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityButterfly entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Wing1.render(matrixStack, buffer, packedLight, packedOverlay);
		Wing2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}