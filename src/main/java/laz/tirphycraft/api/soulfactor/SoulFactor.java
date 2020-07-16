package laz.tirphycraft.api.soulfactor;

import net.minecraft.nbt.CompoundNBT;

public class SoulFactor implements ISoulFactor {

    private int soulFactor;

    public SoulFactor() {

    }

    @Override
    public int getSoulFactor() {
        return soulFactor;
    }

    @Override
    public int addSoulFactor() {
        this.soulFactor = Math.min(soulFactor++, 100);
        return soulFactor;
    }

    @Override
    public int removeSoulFactor() {
        this.soulFactor = Math.max(soulFactor--, -100);
        return soulFactor;
    }

    @Override
    public int addSpecificSoulFactor(int soulFactor) {
        this.soulFactor = Math.max(this.soulFactor + soulFactor, 100);
        return soulFactor;
    }

    @Override
    public int removeSpecificSoulFactor(int soulFactor) {
        this.soulFactor = Math.max(this.soulFactor - soulFactor, -100);
        return soulFactor;
    }

    @Override
    public void setSoulFactor(int soulFactor) {
        this.soulFactor = soulFactor;
    }

    @Override
    public void resetSoulFactor() {
        this.setSoulFactor(0);
    }

    public boolean activateBadEffect(){
        return soulFactor == 100;
    }

    public boolean activateGoodEffect(){
        return soulFactor == -100;
    }

    @Override
    public void goodSoulFactorEffect() {

    }

    @Override
    public void badSoulFactorEffect() {

    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("soulFactor",soulFactor);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        setSoulFactor(nbt.getInt("soulFactor"));
    }
}
