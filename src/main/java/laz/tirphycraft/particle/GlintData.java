package laz.tirphycraft.particle;

import static laz.tirphycraft.particle.Particles.GLINT_PARTICLE;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import laz.tirphycraft.util.TirphyColor;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;

public class GlintData implements IParticleData {

    private final TirphyColor color;
    private final int maxAge;

    public static GlintData glintParticle(TirphyColor color, int maxAge) {
        return new GlintData(color, maxAge);
    }

    private GlintData(TirphyColor color, int maxAge) {
        this.color = color;
        this.maxAge = maxAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public TirphyColor getColor() {
        return color;
    }

    @Override
    public ParticleType<?> getType() {
        return GLINT_PARTICLE;
    }

    @Override
    public void write(PacketBuffer buf) {
        buf.writeInt(getMaxAge());
        buf.writeInt(getColor().getIndex());
    }

    @Override
    public String getParameters() {
        return null;
    }

    public static final IDeserializer<GlintData> DESERIALIZER = new IDeserializer<GlintData>() {
        @Override
        public GlintData deserialize(ParticleType<GlintData> particleType, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            int maxAge = reader.readInt();
            reader.expect(' ');
            int colorInt = reader.readInt();
            TirphyColor color = TirphyColor.getColorfromIndex(colorInt);
            return glintParticle(color, maxAge);
        }

        @Override
        public GlintData read(ParticleType<GlintData> particleType, PacketBuffer buf) {
            int maxAge = buf.readInt();
            int colorInt = buf.readInt();
            TirphyColor color = TirphyColor.getColorfromIndex(colorInt);
            return glintParticle(color, maxAge);
        }
    };
}
