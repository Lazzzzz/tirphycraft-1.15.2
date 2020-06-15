package laz.tirphycraft.client.model.entity.froz;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.froz.EntityCrococasse;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class CrococasseModel extends EntityModel<EntityCrococasse> {
	private final ModelRenderer body;
	private final ModelRenderer leg0;
	private final ModelRenderer head2;
	private final ModelRenderer Head;
	private final ModelRenderer jawTop;
	private final ModelRenderer JawBot;
	private final ModelRenderer bone4;
	private final ModelRenderer TailEnd;
	private final ModelRenderer TailStart;
	private final ModelRenderer leg3;
	private final ModelRenderer leg2;
	private final ModelRenderer leg1;
	private final ModelRenderer BodyMain;

	public CrococasseModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-3.0F, -6.0F, 7.0F);
		body.addChild(leg0);
		leg0.setTextureOffset(55, 37).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, -9.25F, -6.0F);
		body.addChild(head2);
		head2.setTextureOffset(0, 38).addBox(-4.0F, -4.5F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 6.0019F, 5.0436F);
		head2.addChild(Head);

		jawTop = new ModelRenderer(this);
		jawTop.setRotationPoint(2.25F, -8.25F, -13.0F);
		Head.addChild(jawTop);
		jawTop.setTextureOffset(25, 13).addBox(-5.75F, 0.75F, -11.0F, 7.0F, 2.0F, 11.0F, 0.0F, false);
		jawTop.setTextureOffset(0, 24).addBox(-5.75F, -2.25F, -11.0F, 7.0F, 3.0F, 11.0F, 0.0F, false);

		JawBot = new ModelRenderer(this);
		JawBot.setRotationPoint(0.0F, -5.0F, -13.0F);
		Head.addChild(JawBot);
		setRotationAngle(JawBot, 0.1745F, 0.0F, 0.0F);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(2.0F, -0.5F, 0.0F);
		JawBot.addChild(bone4);
		bone4.setTextureOffset(25, 27).addBox(-5.0F, -0.077F, -10.9836F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		bone4.setTextureOffset(58, 49).addBox(-5.0F, 2.923F, -10.9836F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		bone4.setTextureOffset(36, 0).addBox(-5.0F, -2.077F, -10.9836F, 6.0F, 2.0F, 11.0F, 0.0F, false);

		TailEnd = new ModelRenderer(this);
		TailEnd.setRotationPoint(0.0F, -10.0F, 24.0F);
		body.addChild(TailEnd);
		setRotationAngle(TailEnd, 1.5708F, 0.0F, 0.0F);
		TailEnd.setTextureOffset(0, 48).addBox(0.0F, 0.0F, -3.0F, 0.0F, 16.0F, 6.0F, 0.0F, false);

		TailStart = new ModelRenderer(this);
		TailStart.setRotationPoint(0.0F, -10.0F, 8.0F);
		body.addChild(TailStart);
		setRotationAngle(TailStart, 1.5708F, 0.0F, 0.0F);
		TailStart.setTextureOffset(32, 41).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(3.0F, -6.0F, -5.0F);
		body.addChild(leg3);
		leg3.setTextureOffset(48, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-3.0F, -6.0F, -5.0F);
		body.addChild(leg2);
		leg2.setTextureOffset(50, 13).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(3.0F, -6.0F, 7.0F);
		body.addChild(leg1);
		leg1.setTextureOffset(12, 54).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		BodyMain = new ModelRenderer(this);
		BodyMain.setRotationPoint(0.0F, -9.0F, 0.0F);
		body.addChild(BodyMain);
		setRotationAngle(BodyMain, 1.5708F, 0.0F, 0.0F);
		BodyMain.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, -3.0F, 10.0F, 16.0F, 8.0F, 0.0F, false);

	}

	@Override
	public void setRotationAngles(EntityCrococasse entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
	      this.head2.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      this.head2.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	      this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	      this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	      this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}