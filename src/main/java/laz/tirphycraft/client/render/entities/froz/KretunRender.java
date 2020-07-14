package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.KretunModel;
import laz.tirphycraft.content.entities.froz.EntityKretun;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KretunRender extends MobRenderer<EntityKretun, KretunModel<EntityKretun>> {
	
	protected static final ResourceLocation TEXTURE =  new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/froz/kretun.png");
	
	public KretunRender(EntityRendererManager manager) {
		super(manager, new KretunModel<>(), 0.0f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityKretun entity) {
		return TEXTURE;
	}
	
}
