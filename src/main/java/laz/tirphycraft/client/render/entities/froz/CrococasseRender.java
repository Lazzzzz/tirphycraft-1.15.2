package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.CrococasseModel;
import laz.tirphycraft.content.entities.froz.EntityCrococasse;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CrococasseRender extends MobRenderer<EntityCrococasse, CrococasseModel> {
	
	protected static final ResourceLocation TEXTURE =  new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/froz/crococasse.png");
	
	public CrococasseRender(EntityRendererManager manager) {
		super(manager, new CrococasseModel(), 0.0f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityCrococasse entity) {
		return TEXTURE;
	}
	
}
