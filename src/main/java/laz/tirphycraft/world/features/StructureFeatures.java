package laz.tirphycraft.world.features;

import java.util.Locale;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.world.features.froz.structures.FrozDungeonPiece;
import laz.tirphycraft.world.features.froz.structures.FrozDungeonStructure;
import laz.tirphycraft.world.features.laputa.structure.IslandPiece;
import laz.tirphycraft.world.features.laputa.structure.LaputaDungeonStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class StructureFeatures {
	//Static instance of our structure so we can reference it and add it to biomes easily.
	public static Structure<NoFeatureConfig> FROZ_DUNGEON = new FrozDungeonStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType FROZ_DUNGEON_PIECE = FrozDungeonPiece.Piece::new;
	
	public static Structure<NoFeatureConfig> LAPUTA_DUNGEON = new LaputaDungeonStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType LAPUTA_DUNGEON_ISLAND = IslandPiece::new;


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
		Tirphycraft.register(registry, FROZ_DUNGEON, "froz_dungeon");
		register(FROZ_DUNGEON_PIECE, "froz_dungeon_piece");
		
		Tirphycraft.register(registry, LAPUTA_DUNGEON, "laputa_dungeon");
		register(LAPUTA_DUNGEON_ISLAND, "laputa_dungeon_island");
	}


	/*
	 * Registers the structures pieces themselves. If you don't do this part, Forge will complain to you in the Console.
	 */
	static IStructurePieceType register(IStructurePieceType structurePiece, String key)
	{
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}
}