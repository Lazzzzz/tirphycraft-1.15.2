package laz.tirphycraft.api.soulfactor;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISoulFactor extends INBTSerializable<CompoundNBT> {


    int getSoulFactor();

    int addSoulFactor();

    int removeSoulFactor();

    int addSpecificSoulFactor(int soulFactor);

    int removeSpecificSoulFactor(int soulFactor);

    void setSoulFactor(int soulFactor);

    void resetSoulFactor();

    void goodSoulFactorEffect();

    void badSoulFactorEffect();

    boolean activateGoodEffect();

    boolean activateBadEffect();
}
