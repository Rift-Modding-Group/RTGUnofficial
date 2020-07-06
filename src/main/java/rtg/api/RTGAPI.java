package rtg.api;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;

import rtg.api.util.Logger;
import rtg.api.util.UtilityClass;
import rtg.api.util.storage.BiomeMap;
import rtg.api.world.biome.IRealisticBiome;
import rtg.world.WorldTypeRTG;


@UtilityClass
public final class RTGAPI {

    public static final String
            RTG_API_ID       = "rtgapi",
            VERSION          = "@API_VERSION@",
            RTG_MOD_ID       = "rtg",
            RTG_WORLDTYPE_ID = "RTG";
//    public static final BiomeMap RTG_BIOMES       = new BiomeMap();
    public static final Map<Integer, Map.Entry<Biome, IRealisticBiome>> RTG_BIOMES = new HashMap<>();
    private static boolean rtgBiomesLocked = false;

    public static void lockRtgBiomes() {
        rtgBiomesLocked = true;
    }

    private static final Set<DimensionType> ALLOWED_DIMENSION_TYPES = new ObjectArraySet<>();

    private static Path            configPath;
    private static IRealisticBiome patchBiome;
    private static IBlockState
            shadowStoneBlock  = null,
            shadowDesertBlock = null;

    private RTGAPI() {}

    public static Path getConfigPath() {
        return configPath;
    }

    public static void setConfigPath(Path path) {
        if (configPath == null) {
            configPath = path;
        }
    }

    public static boolean checkWorldType(WorldType worldType) {
        return WorldTypeRTG.getInstance().equals(worldType);
    }

    public static void addAllowedDimensionType(DimensionType dimType) {
        ALLOWED_DIMENSION_TYPES.add(dimType);
    }

    public static void removeAllowedDimensionType(DimensionType dimType) {
        ALLOWED_DIMENSION_TYPES.remove(dimType);
    }

    public static boolean isAllowedDimensionType(DimensionType dimType) {
        return ALLOWED_DIMENSION_TYPES.contains(dimType);
    }

    public static boolean isAllowedDimensionType(int dimId) {
        DimensionType type = (DimensionManager.isDimensionRegistered(dimId)) ? DimensionManager.getProviderType(dimId) : null;
        return type != null && ALLOWED_DIMENSION_TYPES.contains(type);
    }

    public static IRealisticBiome getRTGBiome(@Nonnull Biome biome) {
//        IRealisticBiome rtgBiome = RTG_BIOMES.get(biome);
        final Map.Entry<Biome, IRealisticBiome> entry = RTG_BIOMES.getOrDefault(Biome.getIdForBiome(biome), null);
//        if (rtgBiome != null) {
        if (entry != null) {
            return entry.getValue();
        }
        return patchBiome;
    }

    public static IRealisticBiome getRTGBiome(int biomeId) {
//        IRealisticBiome rtgBiome = RTG_BIOMES.getValueAt(biomeId);
//        if (rtgBiome != null) {
//            return rtgBiome;
//        }
        final Map.Entry<Biome, IRealisticBiome> entry = RTG_BIOMES.getOrDefault(biomeId, null);
        if (entry != null) {
            return entry.getValue();
        }
        return patchBiome;
    }

    public static void addRTGBiomes(IRealisticBiome... biomes) {
        if (!rtgBiomesLocked) {
            RTG_BIOMES.putAll(Arrays
                            .stream(biomes)
//                .parallel()
                            .map(b -> {
                                final Integer biomeId = Biome.getIdForBiome(b.baseBiome());
                                return new AbstractMap.SimpleEntry<>(biomeId, new AbstractMap.SimpleEntry<>(b.baseBiome(), b));
                            })
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
//        for (final IRealisticBiome biome : biomes) {
//            final Biome baseBiome = biome.baseBiome();
//            RTG_BIOMES.put(Biome.getIdForBiome(baseBiome), new AbstractMap.SimpleEntry<>(baseBiome, biome));
//        }
        }
    }

    public static void initPatchBiome(Biome biome) {
//        IRealisticBiome rtgBiome = RTG_BIOMES.get(biome);
        IRealisticBiome rtgBiome = getRTGBiome(biome);
        if (rtgBiome == null) {
            Logger.error("Erroneous patch biome set in config: {} (no RTG version), Using default.", biome.getRegistryName());
//            rtgBiome = Objects.requireNonNull(RTG_BIOMES.get(Biomes.PLAINS), "Cannot find an RTG version of minecraft:plains. This should be impossible.");
            rtgBiome = Objects.requireNonNull(getRTGBiome(Biomes.PLAINS), "Cannot find an RTG version of minecraft:plains. This should be impossible.");
        }
        Logger.debug("Setting patch biome to: {}", rtgBiome.baseBiomeResLoc());
        patchBiome = rtgBiome;
    }

    public static void setShadowBlocks(@Nullable IBlockState stone, @Nullable IBlockState desert) {
        if (shadowStoneBlock  == null) { shadowStoneBlock  = stone  != null ? stone  : Blocks.STONE.getDefaultState(); }
        if (shadowDesertBlock == null) { shadowDesertBlock = desert != null ? desert : Blocks.SAND.getDefaultState(); }
    }

    public static IBlockState getShadowStoneBlock() {
        return shadowStoneBlock;
    }

    public static IBlockState getShadowDesertBlock() {
        return shadowDesertBlock;
    }
}
