package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.LombraModel;
import laz.tirphycraft.content.entities.froz.EntityLombra;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LombraRender extends MobRenderer<EntityLombra, LombraModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID,
			"textures/entity/froz/lombra.png");

	public LombraRender(EntityRendererManager manager) {
		super(manager, new LombraModel(), 0.5f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityLombra entity) {
		return TEXTURE;
	}

}
