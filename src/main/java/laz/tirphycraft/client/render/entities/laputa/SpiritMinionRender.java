package laz.tirphycraft.client.render.entities.laputa;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.laputa.SpiritMinionModel;
import laz.tirphycraft.content.entities.laputa.EntitySpiritMinion;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpiritMinionRender extends MobRenderer<EntitySpiritMinion, SpiritMinionModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/spirit_minion.png"); 

	public SpiritMinionRender(EntityRendererManager manager) {
		super(manager, new SpiritMinionModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntitySpiritMinion entity) {
		return TEXTURE;
	}

}
