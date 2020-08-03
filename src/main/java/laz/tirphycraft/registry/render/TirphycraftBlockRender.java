package laz.tirphycraft.registry.render;

import laz.tirphycraft.registry.init.TirphycraftBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class TirphycraftBlockRender {
	public static void init() {

		RenderType cutout = RenderType.getCutout();
		RenderType opaque = RenderType.getTranslucent();
		
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_COPPIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_SILVIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_GOLDIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.SAPLING_FROZ.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_BLUE.get(), opaque);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_GREEN.get(), opaque);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_YELLOW.get(), opaque);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_PURPLE.get(), opaque);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_PINK.get(), opaque);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.BOSS_SPAWNER_0.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_COPPIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_SILVIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_GOLDIR.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_FROZ.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LEAVES_SKY.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER1.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER2.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER3.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER4.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER5.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.LAPUTA_FLOWER6.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.NOXIS_FLOWER1.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.FROZ_FLOWER1.get(), cutout);

		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_BLUE.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_GREEN.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_WHITE.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_RED.get(), cutout);
		RenderTypeLookup.setRenderLayer(TirphycraftBlocks.ANCIENT_YELLOW.get(), cutout);
	}
}
