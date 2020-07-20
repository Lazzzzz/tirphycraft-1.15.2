package laz.tirphycraft.network;

import java.util.UUID;
import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketSoulFactor {
 
    private UUID entityID;
    private int changeTo;
    private int changeFrom;
 
    public PacketSoulFactor(UUID entityID, int changeTo, int changeFrom) {
        this.entityID = entityID;
        this.changeTo = changeTo;
        this.changeFrom = changeFrom;
    }
 
    public static PacketSoulFactor decode(PacketBuffer buf) {
        return new PacketSoulFactor(buf.readUniqueId(), buf.readInt(), buf.readInt());
    }
 
    public static void encode(PacketSoulFactor packet, PacketBuffer buf) {
        buf.writeUniqueId(packet.entityID);
        buf.writeInt(packet.changeTo);
        buf.writeInt(packet.changeFrom);
    }
 
    public static void handle(PacketSoulFactor packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
        	
        });
        ctx.get().setPacketHandled(true);
    }
 
}