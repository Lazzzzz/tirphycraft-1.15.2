package laz.tirphycraft.api;

import laz.tirphycraft.api.soulfactor.ISoulFactor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.util.LazyOptional;

public class SoulFactorCap {

    @CapabilityInject(ISoulFactor.class)
    public static Capability<ISoulFactor> SOUL_FACTOR_CAPABILITY;

    public static final Direction DEFAULT_FACING = null;

    public static LazyOptional<ISoulFactor> getPlayerSoulFactor(final PlayerEntity player) {
        return player.getCapability(SOUL_FACTOR_CAPABILITY, DEFAULT_FACING);
    }

    public static int addSoulFactor(final PlayerEntity player){
        return getPlayerSoulFactor(player).map(ISoulFactor::addSoulFactor).orElse(0);
    }

    public static int removeSoulFactor(final PlayerEntity player){
        return getPlayerSoulFactor(player).map(ISoulFactor::removeSoulFactor).orElse(0);
    }

}
