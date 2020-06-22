package laz.tirphycraft.client.model.entity.froz;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;

public class FrozenSoldierModel<T extends EntityFrozenSoldier> extends BipedModel<EntityFrozenSoldier> implements IHasArm {
	private final ModelRenderer Jaw;
	private final ModelRenderer eyes;
	private boolean glow = false;

	public FrozenSoldierModel(float modelSize) {
		super(modelSize);
		this.textureWidth = 64;
		this.textureHeight= 64;

		this.bipedBody = new ModelRenderer(this);
		this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBody.setTextureOffset(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSize, false);

		this.bipedHead = new ModelRenderer(this);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBody.addChild(this.bipedHead);
		this.bipedHead.setTextureOffset(0, 18).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, modelSize, false);

		Jaw = new ModelRenderer(this);
		Jaw.setRotationPoint(0.0F, -2.0F, 3.0F);
		this.bipedHead.addChild(Jaw);
		Jaw.setTextureOffset(24, 10).addBox(-3.0F, 0.0F, -7.0F, 6.0F, 2.0F, 8.0F, modelSize, false);

		this.bipedRightArm = new ModelRenderer(this);
		this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.bipedBody.addChild(this.bipedRightArm);
		this.bipedRightArm.setTextureOffset(44, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, modelSize, false);

		this.bipedLeftArm = new ModelRenderer(this);
		this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.bipedBody.addChild(this.bipedLeftArm);
		this.bipedLeftArm.setTextureOffset(40, 44).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		this.bipedRightLeg = new ModelRenderer(this);
		this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.bipedBody.addChild(this.bipedRightLeg);
		this.bipedRightLeg.setTextureOffset(32, 44).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		this.bipedLeftLeg = new ModelRenderer(this);
		this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		this.bipedBody.addChild(this.bipedLeftLeg);
		this.bipedLeftLeg.setTextureOffset(24, 44).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		eyes = new ModelRenderer(this);
		eyes.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyes.setTextureOffset(1, 21).addBox(-3.0F, -4.0F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		eyes.setTextureOffset(1, 21).addBox(2.0F, -4.0F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityFrozenSoldier entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		
		this.glow = entity.dungeon;
		
		Jaw.rotateAngleX = entity.getAnimation().getPart();
		
		eyes.rotateAngleX = this.bipedHead.rotateAngleX;
		eyes.rotateAngleY = this.bipedHead.rotateAngleY;
		eyes.rotateAngleZ = this.bipedHead.rotateAngleZ;
		
	}

	@Override
	public void setLivingAnimations(EntityFrozenSoldier entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		if (entityIn.getEntityWorld().rand.nextInt(100) == 0) entityIn.getAnimation().startBite();
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		this.bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);
		eyes.render(matrixStack, buffer.lightmap(255), 255, packedOverlay, red, blue, green, alpha);			
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
    private ModelRenderer getArm(HandSide p_191216_1_) {
        return p_191216_1_ == HandSide.LEFT ? this.bipedLeftArm : this.bipedRightArm;
    }

	@Override
	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {

		ModelRenderer arm = this.getArm(sideIn);
		matrixStackIn.translate((double)(arm.rotationPointX / 20.0F), (double)(arm.rotationPointY / 20.0F), (double)(arm.rotationPointZ / 20.0F));
	      if (arm.rotateAngleZ != 0.0F) {
	         matrixStackIn.rotate(Vector3f.ZP.rotation(arm.rotateAngleZ));
	      }

	      if (arm.rotateAngleY != 0.0F) {
	         matrixStackIn.rotate(Vector3f.YP.rotation(arm.rotateAngleY));
	      }

	      if (arm.rotateAngleX != 0.0F) {
	         matrixStackIn.rotate(Vector3f.XP.rotation(arm.rotateAngleX));
	      }
	}
}