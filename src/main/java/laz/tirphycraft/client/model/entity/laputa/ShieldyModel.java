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

	public ShieldyModel() {
		textureWidth = 128;
		textureHeight = 128;

		shield4 = new ModelRenderer(this);
		shield4.setRotationPoint(0.0F, -3.0F, 0.0F);
		setRotationAngle(shield4, 0.0F, 1.5708F, 0.0F);
		shield4.setTextureOffset(0, 0).addBox(9.0F, 4.0F, -5.0F, 1.0F, 19.0F, 10.0F, 0.0F, false);

		shield3 = new ModelRenderer(this);
		shield3.setRotationPoint(0.0F, -3.0F, 0.0F);
		setRotationAngle(shield3, 0.0F, -1.5708F, 0.0F);
		shield3.setTextureOffset(12, 19).addBox(9.0F, 4.0F, -5.0F, 1.0F, 19.0F, 10.0F, 0.0F, false);

		shield2 = new ModelRenderer(this);
		shield2.setRotationPoint(0.0F, -3.0F, 0.0F);
		shield2.setTextureOffset(24, 0).addBox(9.0F, 4.0F, -5.0F, 1.0F, 19.0F, 10.0F, 0.0F, false);

		shield1 = new ModelRenderer(this);
		shield1.setRotationPoint(0.0F, -3.0F, 0.0F);
		shield1.setTextureOffset(34, 34).addBox(-10.0F, 4.0F, -5.0F, 1.0F, 19.0F, 10.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -32.0F, 1.0F);
		body.addChild(head);
		head.setTextureOffset(46, 0).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, -16.0F, 1.0F);
		body.addChild(main);
		main.setTextureOffset(0, 44).addBox(-2.0F, -5.0F, -3.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);
		main.setTextureOffset(46, 32).addBox(-3.0F, -8.0F, -4.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		main.setTextureOffset(40, 23).addBox(-3.0F, 13.0F, -4.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityShieldy entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		body.rotationPointY = 12 - MathHelper.cos(ageInTicks * 0.1f) * 10;	
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		shield4.render(matrixStack, buffer, packedLight, packedOverlay);
		shield3.render(matrixStack, buffer, packedLight, packedOverlay);
		shield2.render(matrixStack, buffer, packedLight, packedOverlay);
		shield1.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}