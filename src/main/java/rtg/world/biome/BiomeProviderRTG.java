package rtg.world.biome;

import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import rtg.api.util.Logger;
import rtg.api.world.RTGWorld;


public class BiomeProviderRTG extends BiomeProvider {

    public BiomeProviderRTG(RTGWorld rtgWorld) {
        super(rtgWorld.world().getWorldInfo());

        ChunkGeneratorSettings settings = ChunkGeneratorSettings.Factory.jsonToFactory("{}").build();
        GenLayer[] genLayers = GenLayer.initializeAllBiomeGenerators(rtgWorld.seed(), rtgWorld.world().getWorldType(), settings);

        this.genBiomes = genLayers[0];
        this.biomeIndexLayer = genLayers[1];

        maybeRemoveRivers();
    }

    private void maybeRemoveRivers() {
        GenLayer layer = this.genBiomes;
        while (layer != null) {
            Logger.warn("Trying layer with name: {}", layer.getClass().getName());
            if (layer instanceof GenLayerRiverMix) {
                Logger.warn("Removing vanilla river layer: {}", layer.getClass().getName());

                // Overwrite the river layer with the biome layer to kill vanilla rivers.
                ((GenLayerRiverMix) layer).riverPatternGeneratorChain = ((GenLayerRiverMix) layer).biomePatternGeneratorChain;
                return;
            }
            layer = layer.parent;
        }
        Logger.error("Could not find the vanilla river layer for removal.");
    }
}
