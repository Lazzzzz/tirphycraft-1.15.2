package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.MothMothModel;
import laz.tirphycraft.content.entities.froz.EntityMothMoth;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MothMothRender extends MobRenderer<EntityMothMoth, MothMothModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID,
			"textures/entity/froz/mothmoth.png");

	public MothMothRender(EntityRendererManager manager) {
		super(manager, new MothMothModel(), 0f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityMothMoth entity) {
		return TEXTURE;
	}

}