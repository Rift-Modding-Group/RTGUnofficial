package rtg.world.gen;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import java.util.Map;


/**
 * @author Zeno410
 */
public class MesaBiomeCombiner {

    public final int mesa = Biome.getIdForBiome(Biomes.MESA);
    public final int mesaPlateau = Biome.getIdForBiome(Biomes.MESA_CLEAR_ROCK);
    public final int mesaPlateauF = Biome.getIdForBiome(Biomes.MESA_ROCK);
    public final int mesaPlateauM = Biome.getIdForBiome(Biomes.MUTATED_MESA_CLEAR_ROCK);
    public final int mesaPlateauFM = Biome.getIdForBiome(Biomes.MUTATED_MESA_ROCK);

//    public void adjust(float[] result) {
    public void adjust(final Map<Integer, Float> result) {
//        float mesaBorder = result[mesa];
//        float plateauBorder = result[mesaPlateau] + result[mesaPlateauM];
//        float plateauFBorder = result[mesaPlateauF] + result[mesaPlateauFM];
//        result[mesa] = 0;
//        result[mesaPlateauM] = 0;
//        result[mesaPlateauFM] = 0;
//        if (plateauBorder > plateauFBorder) {
//            result[mesaPlateau] = mesaBorder + plateauBorder + plateauFBorder;
//            result[mesaPlateauF] = 0;
//        }
//        else {
//            result[mesaPlateau] = 0;
//            result[mesaPlateauF] = mesaBorder + plateauBorder + plateauFBorder;
//        }

        final float
                mesaBorder = result.get(mesa),
                plateauBorder = result.get(mesaPlateau) + result.get(mesaPlateauM),
                plateauFBorder = result.get(mesaPlateauF) + result.get(mesaPlateauFM);
        result.put(mesa, 0F);
        result.put(mesaPlateauM, 0F);
        result.put(mesaPlateauFM, 0F);
        if (plateauBorder > plateauFBorder) {
            result.put(mesaPlateau, mesaBorder + plateauBorder + plateauFBorder);
            result.put(mesaPlateauF, 0F);
        } else {
            result.put(mesaPlateau, 0F);
            result.put(mesaPlateauF, mesaBorder + plateauBorder + plateauFBorder);
        }
    }
}
