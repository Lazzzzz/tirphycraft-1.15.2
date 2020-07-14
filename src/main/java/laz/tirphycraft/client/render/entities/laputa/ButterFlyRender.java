package laz.tirphycraft.client.render.entities.laputa;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.laputa.ButterflyModel;
import laz.tirphycraft.content.entities.laputa.EntityButterfly;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ButterFlyRender extends MobRenderer<EntityButterfly, ButterflyModel> {

	protected static final ResourceLocation[] TEXTURE = new ResourceLocation[] {
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/butterfly/0.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/butterfly/1.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/butterfly/2.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/butterfly/3.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/butterfly/4.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/butterfly/5.png")
	};

	public ButterFlyRender(EntityRendererManager manager) {
		super(manager, new ButterflyModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityButterfly entity) {
		return TEXTURE[entity.getColor()];
	}

}
