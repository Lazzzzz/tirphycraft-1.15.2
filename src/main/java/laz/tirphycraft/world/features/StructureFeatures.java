package laz.tirphycraft.world.features;

import java.util.Locale;

import laz.tirphycraft.Tirphycraft;
import laz.tirphycraft.world.features.froz.structures.FrozDungeonPiece;
import laz.tirphycraft.world.features.froz.structures.FrozDungeonStructure;
import laz.tirphycraft.world.features.laputa.structure.LaputaDungeonPiece;
import laz.tirphycraft.world.features.laputa.structure.LaputaDungeonStructure;
import laz.tirphycraft.world.features.laputa.structure.pieces.IslandPiece;
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
	public static IStructurePieceType LAPUTA_DUNGEON_PIECE = IslandPiece::new;

	public static void registerFeatures(Register<Feature<?>> event)
	{
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		Tirphycraft.register(registry, FROZ_DUNGEON, "froz_dungeon");
		register(FROZ_DUNGEON_PIECE, "froz_dungeon_piece");
		
		Tirphycraft.register(registry, LAPUTA_DUNGEON, "laputa_dungeon");
		register(LAPUTA_DUNGEON_PIECE, "laputa_dungeon_piece");
	}

	static IStructurePieceType register(IStructurePieceType structurePiece, String key)
	{
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}
}