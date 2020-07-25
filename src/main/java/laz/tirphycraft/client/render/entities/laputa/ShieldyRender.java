package laz.tirphycraft.client.render.entities.laputa;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.laputa.ShieldyModel;
import laz.tirphycraft.content.entities.laputa.EntityShieldy;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ShieldyRender extends MobRenderer<EntityShieldy, ShieldyModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/shieldy.png");

	public ShieldyRender(EntityRendererManager manager) {
		super(manager, new ShieldyModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityShieldy entity) {
		return TEXTURE;
	}

}
