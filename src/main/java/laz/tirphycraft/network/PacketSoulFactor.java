package laz.tirphycraft.network;

import java.util.UUID;
import java.util.function.Supplier;

import laz.tirphycraft.api.SoulFactorCap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketSoulFactor {

	private UUID entityID;
	private int factor;
	
	public PacketSoulFactor(UUID id, int factor) {
		this.entityID = id;
		this.factor = factor;
	}

	public static PacketSoulFactor decode(PacketBuffer buf) {
		PacketSoulFactor packet = new PacketSoulFactor(buf.readUniqueId(), buf.readInt());
		return packet;
	}

	public static void encode(PacketSoulFactor packet, PacketBuffer buf) {
		buf.writeUniqueId(packet.entityID);
		buf.writeInt(packet.factor);
	}

	public static void handle(PacketSoulFactor packet, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
				ClientWorld world = Minecraft.getInstance().world;
				SoulFactorCap.setSoulFactor(world.getPlayerByUuid(packet.entityID), packet.factor);
		});

		ctx.get().setPacketHandled(true);
	}

}