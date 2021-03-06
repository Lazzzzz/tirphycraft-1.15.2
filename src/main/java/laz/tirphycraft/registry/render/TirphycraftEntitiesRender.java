package laz.tirphycraft.registry.render;

import laz.tirphycraft.client.render.entities.froz.BoarRender;
import laz.tirphycraft.client.render.entities.froz.CrococasseRender;
import laz.tirphycraft.client.render.entities.froz.FrozenSoldierRender;
import laz.tirphycraft.client.render.entities.froz.KretunRender;
import laz.tirphycraft.client.render.entities.froz.LombraRender;
import laz.tirphycraft.client.render.entities.froz.MissileBatRender;
import laz.tirphycraft.client.render.entities.froz.NecromancerRender;
import laz.tirphycraft.client.render.entities.froz.PhantomGuardianRender;
import laz.tirphycraft.client.render.entities.laputa.BluppyRender;
import laz.tirphycraft.client.render.entities.laputa.ButterFlyRender;
import laz.tirphycraft.client.render.entities.laputa.DragonFlyRender;
import laz.tirphycraft.client.render.entities.laputa.ShieldyRender;
import laz.tirphycraft.client.render.entities.laputa.SpiritHeartRender;
import laz.tirphycraft.client.render.entities.laputa.SpiritMinionRender;
import laz.tirphycraft.client.render.entities.laputa.SpiritTreeRender;
import laz.tirphycraft.client.render.entities.projectiles.BluppySplitRender;
import laz.tirphycraft.registry.init.TirphycraftEntities;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class TirphycraftEntitiesRender {
	public static void init() {
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_KRETUN, KretunRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_FROZEN_SOLDIER, FrozenSoldierRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_NECROMANCER, NecromancerRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_MISSILE_BAT, MissileBatRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_CROCROCASSE, CrococasseRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_LOMBRA, LombraRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_PHANTOM_GUARDIAN, PhantomGuardianRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_BOAR, BoarRender::new);

//		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_ESKIMO, EskimoRender::new);
//		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_ESKIMO_KING, EskimoKingRender::new);
//		
		
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_BUTTERFLY, ButterFlyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_SPIRIT_TREE, SpiritTreeRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_SPIRIT_MINION, SpiritMinionRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_SPIRIT_HEART, SpiritHeartRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_DRAGON_FLY, DragonFlyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_SHIELDY, ShieldyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_BLUPPY, BluppyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(TirphycraftEntities.ENTITY_BLUPPY_SPLIT, BluppySplitRender::new);
		
	}
	
}
