package laz.tirphycraft.client.render.entities.laputa;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.laputa.DragonFlyModel;
import laz.tirphycraft.content.entities.laputa.EntityDragonFly;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DragonFlyRender extends MobRenderer<EntityDragonFly, DragonFlyModel> {

	protected static final ResourceLocation[] TEXTURE = new ResourceLocation[] {
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/dragonfly/0.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/dragonfly/1.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/dragonfly/2.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/dragonfly/3.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/dragonfly/4.png"),
			new ResourceLocation(Tirphycraft.MOD_ID, "textures/entity/laputa/dragonfly/5.png")
	};

	public DragonFlyRender(EntityRendererManager manager) {
		super(manager, new DragonFlyModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDragonFly entity) {
		return TEXTURE[entity.getColor()];
	}

}
