package rtg.world.biome;

import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import rtg.api.util.Logger;
import rtg.api.world.RTGWorld;


public class BiomeProviderRTG extends BiomeProvider {

    public BiomeProviderRTG(RTGWorld rtgWorld) {
        super(rtgWorld.world().getWorldInfo());
        maybeRemoveRivers();
    }

    private void maybeRemoveRivers() {
        GenLayer layer = genBiomes;
        while (layer != null) {
            if (layer instanceof GenLayerRiverMix) {
                Logger.debug("Removing vanilla river layer");
                ((GenLayerRiverMix)layer).riverPatternGeneratorChain = ((GenLayerRiverMix)layer).biomePatternGeneratorChain;
                return;
            }
            layer = layer.parent;
        }
        Logger.error("Could not find the vanilla river layer for removal.");
    }
}
