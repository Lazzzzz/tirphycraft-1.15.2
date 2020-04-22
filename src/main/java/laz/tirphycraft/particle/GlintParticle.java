package laz.tirphycraft.particle;

import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlintParticle extends SpriteTexturedParticle {

    protected GlintParticle(GlintData data, World world, double posX, double posY, double posZ, double speedX, double speedY, double speedZ) {
        super(world, posX, posY, posZ, speedX, speedY, speedZ);
        motionX = speedX;
        motionY = speedY;
        motionZ = speedZ;
        particleScale = 1.0f + (rand.nextFloat() * 0.6f) + (rand.nextFloat() * 0.6f);
        particleScale *= data.getMaxAge();
        particleBlue = data.getColor().getBlue();
        particleGreen = data.getColor().getGreen();
        particleRed = data.getColor().getRed();
        setMaxAge(data.getMaxAge());
        canCollide = false;
    }

    @Override
    public void renderParticle(IVertexBuilder builder, ActiveRenderInfo renderInfo, float partialTicks) {
        if (isAlive()) {
            Vec3d vec3d = renderInfo.getProjectedView();
            float f = (float)(MathHelper.lerp((double)partialTicks, this.prevPosX, this.posX) - vec3d.getX());
            float f1 = (float)(MathHelper.lerp((double)partialTicks, this.prevPosY, this.posY) - vec3d.getY());
            float f2 = (float)(MathHelper.lerp((double)partialTicks, this.prevPosZ, this.posZ) - vec3d.getZ());
            Quaternion quaternion;
            if (this.particleAngle == 0.0F) {
                quaternion = renderInfo.getRotation();
            } else {
                quaternion = new Quaternion(renderInfo.getRotation());
                float f3 = MathHelper.lerp(partialTicks, this.prevParticleAngle, this.particleAngle);
                quaternion.multiply(Vector3f.ZP.rotation(f3));
            }

            Vector3f vector3f1 = new Vector3f(-1.0F, -1.0F, 0.0F);
            vector3f1.transform(quaternion);
            Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
            float f4 = this.particleScale;

            for(int i = 0; i < 4; ++i) {
                Vector3f vector3f = avector3f[i];
                vector3f.transform(quaternion);
                vector3f.mul(f4);
                vector3f.add(f, f1, f2);
            }

            float f7 = this.getMinU();
            float f8 = this.getMaxU();
            float f5 = this.getMinV();
            float f6 = this.getMaxV();
            int j = this.getBrightnessForRender(partialTicks);
            particleAlpha = getGlowBrightness();
            builder.pos((double)avector3f[0].getX(), (double)avector3f[0].getY(), (double)avector3f[0].getZ()).tex(f8, f6).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
            builder.pos((double)avector3f[1].getX(), (double)avector3f[1].getY(), (double)avector3f[1].getZ()).tex(f8, f5).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
            builder.pos((double)avector3f[2].getX(), (double)avector3f[2].getY(), (double)avector3f[2].getZ()).tex(f7, f5).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
            builder.pos((double)avector3f[3].getX(), (double)avector3f[3].getY(), (double)avector3f[3].getZ()).tex(f7, f6).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j).endVertex();
        }
    }

    public float getGlowBrightness() {
        if (age >= maxAge) {
            return (float) age / (float) maxAge;
        } else {
            return Math.max(1.0f - (((float) age - maxAge) / maxAge), 0);
        }
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getBrightnessForRender(float partialTicks) {
        int i = super.getBrightnessForRender(partialTicks);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<GlintData> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle makeParticle(GlintData data, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            GlintParticle particle = new GlintParticle(data,worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.selectSpriteRandomly(this.spriteSet);
            return particle;
        }
    }

}
