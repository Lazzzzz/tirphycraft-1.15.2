package laz.tirphycraft.world.features;

import java.util.Locale;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.world.features.froz.structures.surfaces.TowerDungeonStructure;
import laz.tirphycraft.world.features.froz.structures.surfaces.TowerPiece;
import laz.tirphycraft.world.features.froz.structures.underground.FrozDungeonPiece;
import laz.tirphycraft.world.features.froz.structures.underground.FrozDungeonStructure;
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

	public static Structure<NoFeatureConfig> FROZ_DUNGEON = new FrozDungeonStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType FROZ_DUNGEON_PIECE = FrozDungeonPiece.Piece::new;
	
	public static Structure<NoFeatureConfig> LAPUTA_DUNGEON = new LaputaDungeonStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType LAPUTA_DUNGEON_ISLAND = IslandPiece::new;
	
	public static Structure<NoFeatureConfig> FROZ_TOWER_DUNGEON = new TowerDungeonStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType FROZ_TOWER = TowerPiece::new;


	public static void registerFeatures(Register<Feature<?>> event)
	{
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		Tirphycraft.register(registry, FROZ_DUNGEON, "froz_dungeon");
		register(FROZ_DUNGEON_PIECE, "froz_dungeon_piece");
		
		Tirphycraft.register(registry, LAPUTA_DUNGEON, "laputa_dungeon");
		register(LAPUTA_DUNGEON_ISLAND, "laputa_dungeon_island");
		
		Tirphycraft.register(registry, FROZ_TOWER_DUNGEON, "froz_dungeon_tower");
		register(FROZ_TOWER, "froz_tower_dungeon");
		
	}

	static IStructurePieceType register(IStructurePieceType structurePiece, String key)
	{
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}
}