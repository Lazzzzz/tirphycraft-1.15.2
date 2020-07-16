package laz.tirphycraft.client.render.entities.laputa;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.laputa.SpiritHeartModel;
import laz.tirphycraft.content.entities.laputa.EntitySpiritHeart;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpiritHeartRender extends MobRenderer<EntitySpiritHeart, SpiritHeartModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/spirit_heart.png"); 

	public SpiritHeartRender(EntityRendererManager manager) {
		super(manager, new SpiritHeartModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntitySpiritHeart entity) {
		return TEXTURE;
	}
}
