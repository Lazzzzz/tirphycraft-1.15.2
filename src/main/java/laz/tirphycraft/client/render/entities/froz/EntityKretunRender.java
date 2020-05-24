package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.EntityKretunModel;
import laz.tirphycraft.content.entities.froz.EntityKretun;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EntityKretunRender extends MobRenderer<EntityKretun, EntityKretunModel<EntityKretun>> {
	
	protected static final ResourceLocation TEXTURE =  new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/froz/kretun.png");
	
	public EntityKretunRender(EntityRendererManager manager, EntityKretunModel<EntityKretun> model) {
		super(manager, model, 0.0f);
		this.entityModel = model;
		
	}

	@Override
	public ResourceLocation getEntityTexture(EntityKretun entity) {
		return TEXTURE;
	}

	
}
