package laz.tirphycraft.client.model.entity.projectile;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import laz.tirphycraft.content.entities.projectile.EntityBluppySplit;
import net.minecraft.client.renderer.entity.model.EntityModel;

public class BluppySplitModel extends EntityModel<EntityBluppySplit>{

	@Override
	public void setRotationAngles(EntityBluppySplit entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {		
	}

}
