package laz.tirphycraft.world.features;

import java.util.Locale;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.world.features.froz.structures.TestPiece;
import laz.tirphycraft.world.features.froz.structures.TestPiece.Piece;
import laz.tirphycraft.world.features.froz.structures.TestStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class StructureFeatures {
	//Static instance of our structure so we can reference it and add it to biomes easily.
	public static Structure<NoFeatureConfig> RUN_DOWN_HOUSE = new TestStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType RDHP = TestPiece.Piece::new;


	/*
	 * Registers the features and structures. Normal Features will be registered here too.
	 */
	public static void registerFeatures(Register<Feature<?>> event)
	{
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		/* Registers the structure itself and sets what its path is. In this case,
		 * the structure will have the resourcelocation of structure_tutorial:run_down_house .
		 * 
		 * It is always a good idea to register your regular features too so that other mods
		 * can use them too directly from the Forge Registry. It great for mod compatibility.
		 */
		Tirphycraft.register(registry, RUN_DOWN_HOUSE, "run_down_house");
		register(RDHP, "RDHP");
	}


	/*
	 * Registers the structures pieces themselves. If you don't do this part, Forge will complain to you in the Console.
	 */
	static IStructurePieceType register(IStructurePieceType structurePiece, String key)
	{
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}
}