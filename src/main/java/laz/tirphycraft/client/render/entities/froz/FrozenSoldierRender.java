package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.FrozenSoldierModel;
import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

public class FrozenSoldierRender extends MobRenderer<EntityFrozenSoldier, FrozenSoldierModel<EntityFrozenSoldier>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID,
			"textures/entity/froz/frozen_soldier.png");

	public FrozenSoldierRender(EntityRendererManager manager) {
		super(manager, new FrozenSoldierModel<>(0f), 0.5f);
	    this.addLayer(new HeldItemLayer<>(this));
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<>(0.1F), new BipedModel<>(0.1F)));
	
	}

	@Override
	public ResourceLocation getEntityTexture(EntityFrozenSoldier entity) {
		return TEXTURE;
	}

}
