package laz.tirphycraft.client.model.entity.froz;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.froz.EntityPhantomGuardian;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PhantomGuardianModel extends EntityModel<EntityPhantomGuardian> {
	private final ModelRenderer mainBody;
	private final ModelRenderer body1;
	private final ModelRenderer head;
	private final ModelRenderer body2;
	private final ModelRenderer tail;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer RightWing;
	private final ModelRenderer firstPartRight;
	private final ModelRenderer secondPartRight;
	private final ModelRenderer leftWing;
	private final ModelRenderer firstPartLeft;
	private final ModelRenderer secondPartLeft;

	public PhantomGuardianModel() {
		textureWidth = 256;
		textureHeight = 256;

		mainBody = new ModelRenderer(this);
		mainBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		body1 = new ModelRenderer(this);
		body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainBody.addChild(body1);
		body1.setTextureOffset(0, 58).addBox(-7.0F, -7.0F, -8.0F, 14.0F, 7.0F, 16.0F, 0.0F, false);
		body1.setTextureOffset(6, 6).addBox(6.5F, -5.5F, 3.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		body1.setTextureOffset(0, 6).addBox(-7.5F, -5.5F, 3.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -3.0F, -8.0F);
		body1.addChild(head);
		head.setTextureOffset(22, 81).addBox(-5.0F, -2.0F, -7.0F, 10.0F, 5.0F, 8.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(0.0F, 0.0F, 7.0F);
		body1.addChild(body2);
		body2.setTextureOffset(60, 60).addBox(-5.0F, -6.025F, 0.0F, 10.0F, 6.0F, 17.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 0.0F, 1.0F);
		body2.addChild(tail);
		

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, -1.0F, 15.0F);
		tail.addChild(tail1);
		tail1.setTextureOffset(0, 81).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 14.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, -1.0F, 13.0F);
		tail1.addChild(tail2);
		tail2.setTextureOffset(60, 18).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 22.0F, 0.0F, false);
		tail2.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, 22.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(7.0F, -4.5F, 4.5F);
		mainBody.addChild(RightWing);
		

		firstPartRight = new ModelRenderer(this);
		firstPartRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightWing.addChild(firstPartRight);
		setRotationAngle(firstPartRight, 0.0F, 0.5236F, 0.0F);
		firstPartRight.setTextureOffset(82, 6).addBox(-2.0F, -0.5F, -0.5F, 23.0F, 1.0F, 1.0F, 0.0F, false);
		firstPartRight.setTextureOffset(42, 42).addBox(0.0F, 0.2F, -0.5F, 21.0F, 0.0F, 18.0F, 0.0F, false);

		secondPartRight = new ModelRenderer(this);
		secondPartRight.setRotationPoint(19.0F, 0.0F, -11.5F);
		RightWing.addChild(secondPartRight);
		setRotationAngle(secondPartRight, 0.0F, -0.5236F, 0.0F);
		secondPartRight.setTextureOffset(82, 2).addBox(-0.65F, -0.5F, 1.05F, 32.0F, 1.0F, 1.0F, 0.0F, false);
		secondPartRight.setTextureOffset(0, 20).addBox(-0.65F, 0.0F, 1.05F, 31.0F, 0.0F, 20.0F, 0.0F, false);

		leftWing = new ModelRenderer(this);
		leftWing.setRotationPoint(-7.0F, -4.5F, 4.5F);
		mainBody.addChild(leftWing);
		

		firstPartLeft = new ModelRenderer(this);
		firstPartLeft.setRotationPoint(0.0F, -1.0F, 0.0F);
		leftWing.addChild(firstPartLeft);
		setRotationAngle(firstPartLeft, 0.0F, -0.5236F, 0.0F);
		firstPartLeft.setTextureOffset(82, 4).addBox(-21.0F, 0.5F, -0.5F, 23.0F, 1.0F, 1.0F, 0.0F, false);
		firstPartLeft.setTextureOffset(0, 40).addBox(-21.0F, 1.05F, 0.0F, 21.0F, 0.0F, 18.0F, 0.0F, false);

		secondPartLeft = new ModelRenderer(this);
		secondPartLeft.setRotationPoint(-18.0F, -1.0F, -10.0F);
		leftWing.addChild(secondPartLeft);
		setRotationAngle(secondPartLeft, 0.0F, 0.5236F, 0.0F);
		secondPartLeft.setTextureOffset(82, 0).addBox(-31.5F, 0.5F, -0.8F, 32.0F, 1.0F, 1.0F, 0.0F, false);
		secondPartLeft.setTextureOffset(0, 0).addBox(-31.0F, 1.0F, 0.0F, 31.0F, 0.0F, 20.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityPhantomGuardian entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		body2.rotateAngleX = (float) Math.cos(entity.ticksExisted * 0.1f) / 10;
		tail.rotateAngleX  = (float) Math.cos(entity.ticksExisted * 0.1f) / 20;
		tail1.rotateAngleX = (float) Math.sin(entity.ticksExisted * 0.1f) / 10;
		tail2.rotateAngleX = (float) -Math.cos(entity.ticksExisted * 0.1f) / 5;

		leftWing.rotateAngleZ  = (float) (Math.cos(entity.ticksExisted * 0.1f) / 4);
		RightWing.rotateAngleZ = (float) -(Math.cos(entity.ticksExisted * 0.1f) / 4);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		mainBody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}