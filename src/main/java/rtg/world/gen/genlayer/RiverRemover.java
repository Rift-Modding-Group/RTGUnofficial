
package rtg.world.gen.genlayer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import rtg.util.Accessor;

/**
 *
 * @author Zeno410
 */
public class RiverRemover {
        private Accessor<GenLayerRiverMix,GenLayer> riverMixBiome =
            new Accessor<GenLayerRiverMix,GenLayer>("field_75910_b");

    public GenLayer [] riverLess(GenLayer [] vanilla) {
        GenLayer riverMixParent = this.riverMixBiome.get((GenLayerRiverMix)vanilla[0]);
        GenLayer withoutRivers = new GenLayerNoRivers(100L,riverMixParent);
        GenLayerVoronoiZoom genlayervoronoizoom = new GenLayerVoronoiZoom(10L, withoutRivers);
        return new GenLayer[] {withoutRivers, genlayervoronoizoom, withoutRivers};
    }
}
