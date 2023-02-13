package rtg.world.gen;

import rtg.api.util.storage.SparseList;
import rtg.api.world.biome.IRealisticBiome;

import java.util.List;


/**
 * @author Zeno410
 */
public class ChunkLandscape {

    public float[] noise = new float[256];
    public List<IRealisticBiome> biome = new SparseList<>();
    public float[] river = new float[256];
}
