package laz.tirphycraft.client.model.entity.laputa;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.laputa.EntitySpiritMinion;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class SpiritMinionModel extends EntityModel<EntitySpiritMinion> {
	private final ModelRenderer body;

	public SpiritMinionModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(-1.0F, 24.0F, 1.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -5.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntitySpiritMinion entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.body.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
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