package laz.tirphycraft.util;

import static laz.tirphycraft.Tirphycraft.MOD_ID;
import static laz.tirphycraft.registry.init.TirphycraftDimensions.LAPUTA_DIM;

import laz.tirphycraft.world.features.Features;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.DarkForestBiome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class TirphyLaputaTeleporter {

	public static void teleport(World world, PlayerEntity player) {
		if (!world.isRemote() && player.dimension != DimensionManager
				.registerOrGetDimension(new ResourceLocation(MOD_ID, "laputa_dim"), LAPUTA_DIM.get(), null, true)) {
			ServerPlayerEntity playerEntity = (ServerPlayerEntity) player;
			DimensionType dimensionType = DimensionManager
					.registerOrGetDimension(new ResourceLocation(MOD_ID, "laputa_dim"), LAPUTA_DIM.get(), null, true);
			ServerWorld targetWorld = playerEntity.getServer().getWorld(dimensionType);
			boolean flag = false;

			for (int i = -5; i < 5; i++) {
				for (int j = -5; j < 5; j++) {
					BlockPos spawn = getSurface(targetWorld,
							new BlockPos(player.getPosX() + (i * 16), player.getPosY(), player.getPosZ() + (j * 16)));

					if (spawn != null) {
						playerEntity.teleport(targetWorld, spawn.getX() + 0.5f, spawn.getY() + 3, spawn.getZ()+ 0.5f,
								player.rotationYaw, player.rotationPitch);
						flag = true;
					}

					if (flag)
						break;
				}
				if (flag)
					break;
			}
		}
	}

	private static BlockPos getSurface(World world, BlockPos pos) {
		BlockPos p = pos;

		for (int i = 80; i > 30; i--) {
			p = new BlockPos(pos.getX(), i, pos.getZ());
			if (world.getBlockState(p).isSolid())
				return p;

		}

		return null;
	}
}
