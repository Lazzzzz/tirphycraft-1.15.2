package laz.tirphycraft.world.dimension.froz;

import laz.tirphycraft.client.render.weather.BlizzardRendering;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IRenderHandler;

public class FrozDimension extends Dimension {

	public FrozDimension(World world, DimensionType type) {
		super(world, type, 0.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return ChunkGeneratorType.SURFACE.create(this.world, new FrozBiomeProvider(this.getWorld()),
				new FrozGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		if (f1 < 0.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@OnlyIn(Dist.CLIENT)
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		float f = MathHelper.cos(celestialAngle * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		float f1 = 0.7529412F;
		float f2 = 0.84705883F;
		float f3 = 1.0F;
		f1 = f1 * (f * 0.94F + 0.06F);
		f2 = f2 * (f * 0.94F + 0.06F);
		f3 = f3 * (f * 0.91F + 0.09F);
		return new Vec3d(0,0,0);
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.BED_EXPLODES;
	}

	@Override
	public int getActualHeight() {
		return 256;
	}

	@Override
	public int getSeaLevel() {
		return 1;
	}
	
	
    @Override
    public IRenderHandler getSkyRenderer() {
		return super.getSkyRenderer();
    }
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public IRenderHandler getWeatherRenderer() {
		if (super.getWeatherRenderer() == null) {
			this.setWeatherRenderer(new BlizzardRendering());
		}
		return super.getWeatherRenderer();
	}
}