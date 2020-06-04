package laz.tirphycraft.registry.render;

import laz.tirphycraft.client.render.entities.froz.FrozenSoldierRender;
import laz.tirphycraft.client.render.entities.froz.KretunRender;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class TirphycraftEntitiesRender {
	public static void init() {
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_KRETUN, KretunRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_FROZEN_SOLDIER, FrozenSoldierRender::new);
	}
	
}
