package laz.tirphycraft.client.render.entities.laputa;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.laputa.SpiritTreeModel;
import laz.tirphycraft.content.entities.laputa.EntityTreeSpirit;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpiritTreeRender extends MobRenderer<EntityTreeSpirit, SpiritTreeModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/spirit_tree.png"); 

	public SpiritTreeRender(EntityRendererManager manager) {
		super(manager, new SpiritTreeModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityTreeSpirit entity) {
		return TEXTURE;
	}

}
