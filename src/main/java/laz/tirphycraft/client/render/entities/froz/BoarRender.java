package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.BoarModel;
import laz.tirphycraft.content.entities.froz.EntityBoar;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BoarRender extends MobRenderer<EntityBoar, BoarModel> {
	
	protected static final ResourceLocation TEXTURE =  new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/froz/boar.png");
	
	public BoarRender(EntityRendererManager manager) {
		super(manager, new BoarModel(), 0.0f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityBoar entity) {
		return TEXTURE;
	}
	
}
