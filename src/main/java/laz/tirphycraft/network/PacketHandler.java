package laz.tirphycraft.network;

import laz.tirphycraft.Tirphycraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {

	public static SimpleChannel INSTANCE;
	
	public static void registerMessages() {
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Tirphycraft.MOD_ID, "tirphycraft"), () -> "1.0", s -> true, s -> true);
	}
	
}
