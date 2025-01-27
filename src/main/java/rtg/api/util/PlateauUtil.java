package rtg.api.util;

import com.google.common.collect.Maps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMesa;
import rtg.api.RTGAPI;
import rtg.api.config.BiomeConfig;
import rtg.api.world.RTGWorld;
import rtg.api.world.biome.IRealisticBiome;

import java.util.*;
import java.util.stream.Collectors;


/**
 * A Utility for storing and retrieving plateau band configurations for specific biomes.
 *
 * @author WhichOnesPink 2017-01-07
 * @author srs-bsns 2018-03-21
 * @since 1.0.0
 */
@UtilityClass
public final class PlateauUtil {

    private static final HashMap<IRealisticBiome, List<IBlockState>> BIOME_PLATEAU_BANDS = Maps.newHashMap();
    private static final IBlockState DEFAULT_PLATEAU_BLOCK = Blocks.HARDENED_CLAY.getDefaultState();
    private static final Collection<Biome> PLATEAU_BIOMES;
    private static final Collection<String> MESA_PLATEAU_BLOCKS;
    private static final Collection<String> SAVANNA_PLATEAU_BLOCKS;

    static {
        PLATEAU_BIOMES = Collections.unmodifiableCollection(Arrays.asList(
                Biomes.MESA,
                Biomes.MUTATED_MESA,
                Biomes.MESA_ROCK,
                Biomes.MUTATED_MESA_ROCK,
                Biomes.MESA_CLEAR_ROCK,
                Biomes.MUTATED_MESA_CLEAR_ROCK,
                Biomes.SAVANNA_PLATEAU,
                Biomes.MUTATED_SAVANNA_ROCK
        ));

        MESA_PLATEAU_BLOCKS = Collections.unmodifiableCollection(Arrays.asList(
                "minecraft:stained_hardened_clay[color=yellow]",
                "minecraft:stained_hardened_clay[color=yellow]",
                "minecraft:stained_hardened_clay[color=yellow]",
                "minecraft:hardened_clay",
                "minecraft:hardened_clay",
                "minecraft:stained_hardened_clay[color=orange]",
                "minecraft:stained_hardened_clay[color=red]",
                "minecraft:stained_hardened_clay[color=red]",
                "minecraft:hardened_clay",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:hardened_clay",
                "minecraft:hardened_clay",
                "minecraft:hardened_clay",
                "minecraft:stained_hardened_clay[color=orange]",
                "minecraft:hardened_clay",
                "minecraft:hardened_clay",
                "minecraft:hardened_clay",
                "minecraft:stained_hardened_clay[color=orange]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:hardened_clay",
                "minecraft:stained_hardened_clay[color=orange]",
                "minecraft:hardened_clay",
                "minecraft:stained_hardened_clay[color=orange]",
                "minecraft:hardened_clay",
                "minecraft:stained_hardened_clay[color=orange]",
                "minecraft:hardened_clay",
                "minecraft:hardened_clay",
                "minecraft:hardened_clay"
        ));
        SAVANNA_PLATEAU_BLOCKS = Collections.unmodifiableCollection(Arrays.asList(
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=white]",
                "minecraft:stained_hardened_clay[color=silver]",
                "minecraft:stained_hardened_clay[color=brown]",
                "minecraft:stained_hardened_clay[color=brown]"
        ));
    }

    private PlateauUtil() {
    }

    public static String[] getMesaPlateauBlocks() {
        return MESA_PLATEAU_BLOCKS.toArray(new String[0]);
    }

    public static String[] getSavannaPlateauBlocks() {
        return SAVANNA_PLATEAU_BLOCKS.toArray(new String[0]);
    }

    private static Collection<String> getConfigBlocks(IRealisticBiome rtgBiome) {
        BiomeConfig config = rtgBiome.getConfig();
        return (config.hasProperty(config.PLATEAU_GRADIENT_BLOCK_LIST) && config.PLATEAU_GRADIENT_BLOCK_LIST.getValues().length > 0)
                ? config.PLATEAU_GRADIENT_BLOCK_LIST.getAsCollection()
                : (rtgBiome.baseBiome() instanceof BiomeMesa) ? MESA_PLATEAU_BLOCKS : SAVANNA_PLATEAU_BLOCKS;
    }

    public static void init() {
        PLATEAU_BIOMES.stream()
                .map(b -> RTGAPI.RTG_BIOMES.get(Biome.getIdForBiome(b)))
                .filter(Objects::nonNull)
                .forEach(rtgBiome -> {
                    final IRealisticBiome realisticBiome = rtgBiome.getValue();
                    Collection<String> blocks = getConfigBlocks(realisticBiome);
                    List<IBlockState> bands = blocks.stream()
                            .map(BlockUtil::getBlockStateFromCfgString)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
                    if (bands.isEmpty()) {
                        bands.add(DEFAULT_PLATEAU_BLOCK);
                    }
                    BIOME_PLATEAU_BANDS.put(realisticBiome, bands);
                });
    }

    public static IBlockState getPlateauBand(final RTGWorld rtgWorld, final IRealisticBiome rBiome, final int x, final int y, final int z) {
        return getBand(rBiome, y);
    }

    public static float stepIncrease(final float simplexVal, final float start, final float finish, final float height) {
        return (simplexVal <= start) ? 0 : (simplexVal >= finish) ? height : ((simplexVal - start) / (finish - start)) * height;
    }

    private static IBlockState getBand(IRealisticBiome rBiome, int index) {
        List<IBlockState> bands = BIOME_PLATEAU_BANDS.get(rBiome);
        return bands != null ? bands.get(index % bands.size()) : DEFAULT_PLATEAU_BLOCK;
    }
}
