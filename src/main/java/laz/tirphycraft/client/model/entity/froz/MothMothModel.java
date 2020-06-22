package laz.tirphycraft.client.model.entity.froz;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.froz.EntityMothMoth;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class MothMothModel extends EntityModel<EntityMothMoth> {
	private final ModelRenderer body;
	private final ModelRenderer leg_B_R;
	private final ModelRenderer leg_B_L;
	private final ModelRenderer leg_T_L;
	private final ModelRenderer leg_T_R;
	private final ModelRenderer head2;
	private final ModelRenderer head;
	private final ModelRenderer shape2;
	private final ModelRenderer shape1;

	public MothMothModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		leg_B_R = new ModelRenderer(this);
		leg_B_R.setRotationPoint(5.0F, -21.0F, 8.0F);
		body.addChild(leg_B_R);
		leg_B_R.setTextureOffset(93, 92).addBox(0.0F, 0.0F, 0.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);

		leg_B_L = new ModelRenderer(this);
		leg_B_L.setRotationPoint(-11.0F, -21.0F, 8.0F);
		body.addChild(leg_B_L);
		leg_B_L.setTextureOffset(93, 60).addBox(0.0F, 0.0F, 0.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);

		leg_T_L = new ModelRenderer(this);
		leg_T_L.setRotationPoint(-11.0F, -21.0F, -13.0F);
		body.addChild(leg_T_L);
		leg_T_L.setTextureOffset(93, 0).addBox(0.0F, 0.0F, 0.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);

		leg_T_R = new ModelRenderer(this);
		leg_T_R.setRotationPoint(5.0F, -21.0F, -13.0F);
		body.addChild(leg_T_R);
		leg_T_R.setTextureOffset(93, 30).addBox(0.0F, 0.0F, 0.0F, 6.0F, 21.0F, 6.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, -23.0F, -14.0F);
		body.addChild(head2);
		head2.setTextureOffset(0, 108).addBox(-4.0F, -9.0F, -14.0F, 8.0F, 10.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -23.0F, -14.0F);
		body.addChild(head);
		head.setTextureOffset(0, 80).addBox(-8.0F, -17.0F, -10.0F, 16.0F, 16.0F, 10.0F, 0.0F, false);

		shape2 = new ModelRenderer(this);
		shape2.setRotationPoint(-12.0F, -39.0F, 5.0F);
		body.addChild(shape2);
		setRotationAngle(shape2, -0.3187F, 0.0F, 0.0F);
		shape2.setTextureOffset(0, 45).addBox(0.0F, 0.0F, 0.0F, 24.0F, 17.0F, 17.0F, 0.0F, false);

		shape1 = new ModelRenderer(this);
		shape1.setRotationPoint(-12.0F, -44.0F, -14.0F);
		body.addChild(shape1);
		shape1.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 24.0F, 24.0F, 19.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityMothMoth entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
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