package laz.tirphycraft.util;

import laz.tirphycraft.api.soulfactor.ISoulFactor;
import laz.tirphycraft.api.soulfactor.SoulFactor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class CapHandler {

    public static void init() {
        //Soul Factor Cap
        CapabilityManager.INSTANCE.register(ISoulFactor.class, new Capability.IStorage<ISoulFactor>() {
            @Nullable
            @Override
            public INBT writeNBT(Capability<ISoulFactor> capability, ISoulFactor instance, Direction side) {
                return instance.serializeNBT();
            }

            @Override
            public void readNBT(Capability<ISoulFactor> capability, ISoulFactor instance, Direction side, INBT nbt) {
                instance.deserializeNBT((CompoundNBT) nbt);
            }
        }, SoulFactor::new);

    }

}
