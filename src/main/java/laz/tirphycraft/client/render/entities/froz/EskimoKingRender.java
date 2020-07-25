package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.content.entities.froz.EntityEskimoKing;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

public class EskimoKingRender extends MobRenderer<EntityEskimoKing, BipedModel<EntityEskimoKing>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/froz/eskimo_king.png");

	
	public EskimoKingRender(EntityRendererManager manager) {
		super(manager, new BipedModel<EntityEskimoKing>(0.5f), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityEskimoKing entity) {
		return TEXTURE;
	}
	
}

