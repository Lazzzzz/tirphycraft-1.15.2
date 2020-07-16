package laz.tirphycraft.api.soulfactor;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static laz.tirphycraft.api.SoulFactorCap.SOUL_FACTOR_CAPABILITY;

public class SoulFactorStorageProvider implements ICapabilitySerializable<CompoundNBT> {

    private final ISoulFactor soulFactor;
    private final LazyOptional<ISoulFactor> soulFactorStorage;

    public SoulFactorStorageProvider() {
        this(new SoulFactor());
    }

    public SoulFactorStorageProvider(ISoulFactor sf) {
        this.soulFactor = sf;
        this.soulFactorStorage = LazyOptional.of(() -> sf);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == SOUL_FACTOR_CAPABILITY ? soulFactorStorage.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        return soulFactor.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        soulFactor.deserializeNBT(nbt);
    }
}
