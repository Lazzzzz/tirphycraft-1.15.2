package laz.tirphycraft.client.render.entities.froz;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.client.model.entity.froz.FrozenSoldierModel;
import laz.tirphycraft.client.model.entity.froz.LombraModel;
import laz.tirphycraft.client.model.entity.froz.NecromancerModel;
import laz.tirphycraft.content.entities.froz.EntityFrozenSoldier;
import laz.tirphycraft.content.entities.froz.EntityLombra;
import laz.tirphycraft.content.entities.froz.EntityNecromancer;
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

public class LombraRender extends MobRenderer<EntityLombra, LombraModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Tirphycraft.MOD_ID,
			"textures/entity/froz/lombra.png");

	public LombraRender(EntityRendererManager manager) {
		super(manager, new LombraModel(), 0.5f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityLombra entity) {
		return TEXTURE;
	}

}
