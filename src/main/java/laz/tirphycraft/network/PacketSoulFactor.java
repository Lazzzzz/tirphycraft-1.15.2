package laz.tirphycraft.network;

import java.util.function.Supplier;

import laz.tirphycraft.api.SoulFactorCap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketSoulFactor {

	private int factor;

	public PacketSoulFactor(int factor) {
		this.factor = factor;
	}

	public static PacketSoulFactor decode(PacketBuffer buf) {
		return new PacketSoulFactor(buf.readInt());
	}

	public static void encode(PacketSoulFactor packet, PacketBuffer buf) {
		buf.writeInt(packet.factor);
	}

	public static void handle(PacketSoulFactor packet, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
//				PlayerEntity player = Minecraft.getInstance().player;
//				SoulFactorCap.setSoulFactor(player, packet.factor);
			});
		});
		ctx.get().setPacketHandled(true);
	}

}