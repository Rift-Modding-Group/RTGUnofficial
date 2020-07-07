package rtg.world.gen;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import java.util.List;

/**
 * @author Zeno410
 */
public class MesaBiomeCombiner {

    public final int mesa = Biome.getIdForBiome(Biomes.MESA);
    public final int mesaPlateau = Biome.getIdForBiome(Biomes.MESA_CLEAR_ROCK);
    public final int mesaPlateauF = Biome.getIdForBiome(Biomes.MESA_ROCK);
    public final int mesaPlateauM = Biome.getIdForBiome(Biomes.MUTATED_MESA_CLEAR_ROCK);
    public final int mesaPlateauFM = Biome.getIdForBiome(Biomes.MUTATED_MESA_ROCK);

    public void adjust(final List<Float> result) {
        final float
                mesaBorder = result.get(mesa),
                plateauBorder = result.get(mesaPlateau) + result.get(mesaPlateauM),
                plateauFBorder = result.get(mesaPlateauF) + result.get(mesaPlateauFM);
        result.set(mesa, 0F);
        result.set(mesaPlateauM, 0F);
        result.set(mesaPlateauFM, 0F);
        if (plateauBorder > plateauFBorder) {
            result.set(mesaPlateau, mesaBorder + plateauBorder + plateauFBorder);
            result.set(mesaPlateauF, 0F);
        } else {
            result.set(mesaPlateau, 0F);
            result.set(mesaPlateauF, mesaBorder + plateauBorder + plateauFBorder);
        }
    }
}
