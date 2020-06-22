package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.NecromancerModel;
import laz.tirphycraft.content.entities.froz.EntityNecromancer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class NecromancerRender extends MobRenderer<EntityNecromancer, NecromancerModel<EntityNecromancer>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID,
			"textures/entity/froz/necromancer.png");

	public NecromancerRender(EntityRendererManager manager) {
		super(manager, new NecromancerModel<>(), 0.5f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityNecromancer entity) {
		return TEXTURE;
	}

}
