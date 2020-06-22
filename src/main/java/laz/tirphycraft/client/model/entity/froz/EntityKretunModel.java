package laz.tirphycraft.client.model.entity.froz;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.animation.KretunAnimation;
import laz.tirphycraft.content.entities.froz.EntityKretun;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class EntityKretunModel<T extends EntityKretun> extends EntityModel<EntityKretun> {
	private final ModelRenderer Body;
	private final ModelRenderer Leaf1;
	private final ModelRenderer Leaf2;
	private final ModelRenderer leaf3;
	private final ModelRenderer leaf4;

	public EntityKretunModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 23.0F, 0.0F);
		Body.setTextureOffset(28, 37).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		Leaf1 = new ModelRenderer(this);
		Leaf1.setRotationPoint(0.0F, 0.0F, 2.0F);
		Body.addChild(Leaf1);
		Leaf1.setTextureOffset(19, 2).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 11.0F, 0.0F, false);
		Leaf1.setTextureOffset(0, 13).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 11.0F, 0.0F, false);

		Leaf2 = new ModelRenderer(this);
		Leaf2.setRotationPoint(2.0F, 0.0F, 0.0F);
		Body.addChild(Leaf2);
		Leaf2.setTextureOffset(19, 14).addBox(0.0F, 0.0F, -2.0F, 10.0F, 1.0F, 4.0F, 0.0F, false);
		Leaf2.setTextureOffset(28, 31).addBox(0.0F, -2.0F, -2.0F, 10.0F, 2.0F, 4.0F, 0.0F, false);

		leaf3 = new ModelRenderer(this);
		leaf3.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Body.addChild(leaf3);
		leaf3.setTextureOffset(0, 37).addBox(-10.0F, 0.0F, -2.0F, 10.0F, 1.0F, 4.0F, 0.0F, false);
		leaf3.setTextureOffset(0, 31).addBox(-10.0F, -2.0F, -2.0F, 10.0F, 2.0F, 4.0F, 0.0F, false);

		leaf4 = new ModelRenderer(this);
		leaf4.setRotationPoint(0.0F, 0.0F, -2.0F);
		Body.addChild(leaf4);
		leaf4.setTextureOffset(19, 19).addBox(-2.0F, 0.0F, -11.0F, 4.0F, 1.0F, 11.0F, 0.0F, false);
		leaf4.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -11.0F, 4.0F, 2.0F, 11.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityKretun entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		KretunAnimation a = entity.getAnimation();
		Leaf1.rotateAngleX = a.getPart();
		Leaf2.rotateAngleZ = -a.getPart();
		leaf3.rotateAngleZ = a.getPart();
		leaf4.rotateAngleX = -a.getPart();
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public ModelRenderer getLeaf1() {
		return this.Leaf1;
	}

	public ModelRenderer getLeaf2() {
		return this.Leaf2;
	}

	public ModelRenderer getLeaf3() {
		return this.leaf3;
	}

	public ModelRenderer getLeaf4() {
		return this.leaf4;
	}

}
