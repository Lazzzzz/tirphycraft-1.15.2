package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityEskimo;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

public class EskimoRender extends MobRenderer<EntityEskimo, BipedModel<EntityEskimo>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/froz/eskimo.png");

	
	public EskimoRender(EntityRendererManager manager) {
		super(manager, new BipedModel<EntityEskimo>(0.5f), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityEskimo entity) {
		return TEXTURE;
	}
	
}
