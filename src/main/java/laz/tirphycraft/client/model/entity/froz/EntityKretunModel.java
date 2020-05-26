package laz.tirphycraft.client.model.entity.froz;

import org.apache.http.util.EntityUtils;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.froz.EntityKretun;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntityKretunModel<T extends EntityKretun> extends SegmentedModel<EntityKretun> {
	
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
		Body.setTextureOffset(28, 37).addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F, false);
		
		Leaf1 = new ModelRenderer(this);
		Leaf1.setRotationPoint(0.0F, 0.0F, 2.0F);
		Body.addChild(Leaf1);
		Leaf1.setTextureOffset(19, 2).addBox(-2.0F, 0.0F, 0.0F, 4, 1, 11, 0.0F, false);
		Leaf1.setTextureOffset(0, 13).addBox(-2.0F, -2.0F, 0.0F, 4, 2, 11, 0.0F, false);

		Leaf2 = new ModelRenderer(this);
		Leaf2.setRotationPoint(2.0F, 0.0F, 0.0F);
		Body.addChild(Leaf2);
		Leaf2.setTextureOffset(19, 14).addBox(0.0F, 0.0F, -2.0F, 10, 1, 4, 0.0F, false);
		Leaf2.setTextureOffset(28, 31).addBox(0.0F, -2.0F, -2.0F, 10, 2, 4, 0.0F, false);
		
		leaf3 = new ModelRenderer(this);
		leaf3.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Body.addChild(leaf3);
		leaf3.setTextureOffset(0, 37).addBox(-10.0F, 0.0F, -2.0F, 10, 1, 4, 0.0F, false);
		leaf3.setTextureOffset(0, 31).addBox(-10.0F, -2.0F, -2.0F, 10, 2, 4, 0.0F, false);

		leaf4 = new ModelRenderer(this);
		leaf4.setRotationPoint(0.0F, 0.0F, -2.0F);
		Body.addChild(leaf4);
		leaf4.setTextureOffset(19, 19).addBox(-2.0F, 0.0F, -11.0F, 4, 1, 11, 0.0F, false);
		leaf4.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -11.0F, 4, 2, 11, 0.0F, false);		
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		this.Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		
	}

	@Override
	public void setRotationAngles(EntityKretun entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		if (entityIn.getBite() == true) {
			//System.out.println("bite");
			if (this.Leaf1.rotateAngleX < 1.6) this.Leaf1.rotateAngleX += entityIn.step * 10;
			
		} else {
			//System.out.println("not bite");
			if (this.Leaf1.rotateAngleX > 0) this.Leaf1.rotateAngleX -= entityIn.step;
		}
	}
	
	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.Body);
	}
}
