package laz.tirphycraft.client.model.entity.laputa;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class ModelDragonFly extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer HEAD;
	private final ModelRenderer Body;
	private final ModelRenderer tail;
	private final ModelRenderer left_top;
	private final ModelRenderer left_back;
	private final ModelRenderer right_back;
	private final ModelRenderer left_top_1;

	public ModelDragonFly() {
		textureWidth = 128;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		HEAD = new ModelRenderer(this);
		HEAD.setRotationPoint(3.0F, -7.0F, -4.0F);
		main.addChild(HEAD);
		setRotationAngle(HEAD, 0.6109F, 0.0F, 0.0F);
		HEAD.setTextureOffset(0, 0).addBox(-6.0F, -5.0F, -5.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -7.0F, -2.0F);
		main.addChild(Body);
		Body.setTextureOffset(30, 0).addBox(-5.0F, -4.0F, -4.0F, 10.0F, 6.0F, 9.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -6.0F, 2.0F);
		main.addChild(tail);
		setRotationAngle(tail, -0.192F, 0.0F, 0.0F);
		tail.setTextureOffset(0, 20).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 3.0F, 25.0F, 0.0F, false);

		left_top = new ModelRenderer(this);
		left_top.setRotationPoint(5.0F, -9.0F, -2.0F);
		main.addChild(left_top);
		left_top.setTextureOffset(80, 20).addBox(0.0F, 0.0F, -4.0F, 20.0F, 0.0F, 5.0F, 0.0F, false);

		left_back = new ModelRenderer(this);
		left_back.setRotationPoint(-5.0F, -9.0F, 4.0F);
		main.addChild(left_back);
		left_back.setTextureOffset(80, 0).addBox(-20.0F, 0.0F, -4.0F, 20.0F, 0.0F, 5.0F, 0.0F, false);

		right_back = new ModelRenderer(this);
		right_back.setRotationPoint(5.0F, -9.0F, 4.0F);
		main.addChild(right_back);
		right_back.setTextureOffset(80, 30).addBox(0.0F, 0.0F, -4.0F, 20.0F, 0.0F, 5.0F, 0.0F, false);

		left_top_1 = new ModelRenderer(this);
		left_top_1.setRotationPoint(-5.0F, -9.0F, -2.0F);
		main.addChild(left_top_1);
		left_top_1.setTextureOffset(80, 10).addBox(-20.0F, 0.0F, -4.0F, 20.0F, 0.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}