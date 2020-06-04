package laz.tirphycraft.client.render.armor;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.FrozenSoldierModel;
import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import laz.tirphycraft.registry.init.TirphycraftItems;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.layers.ArmorLayer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HeldBlockLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.ArmorStandArmorModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.ElytraModel;
import net.minecraft.client.renderer.entity.model.EndermanModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.util.ResourceLocation;

public class Armor extends MobRenderer<EntityFrozenSoldier, FrozenSoldierModel<EntityFrozenSoldier>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID,
			"textures/entity/froz/frozen_soldier.png");

	public Armor(EntityRendererManager manager) {
		super(manager, new FrozenSoldierModel<>(0f), 0.5f);
	    this.addLayer(new HeldItemLayer<>(this));
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<>(0.1F), new BipedModel<>(0.1F)));
	
	}

	@Override
	public ResourceLocation getEntityTexture(EntityFrozenSoldier entity) {
		return TEXTURE;
	}

}
