package laz.tirphycraft.client.render.entities.projectiles;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.projectile.BluppySplitModel;
import laz.tirphycraft.content.entities.projectile.EntityBluppySplit;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BluppySplitRender extends MobRenderer<EntityBluppySplit, BluppySplitModel> {

	private ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID + "split.png");
	
	public BluppySplitRender(EntityRendererManager manager) {
		super(manager, new BluppySplitModel(), 0f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityBluppySplit entity) {
		return TEXTURE;
	}


}
