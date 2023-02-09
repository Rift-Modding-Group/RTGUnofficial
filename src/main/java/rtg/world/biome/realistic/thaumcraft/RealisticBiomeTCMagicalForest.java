package rtg.world.biome.realistic.thaumcraft;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.config.BiomeConfig;
import rtg.api.world.RTGWorld;
import rtg.api.world.biome.RealisticBiomeBase;
import rtg.api.world.surface.SurfaceBase;
import rtg.api.world.terrain.TerrainBase;

public class RealisticBiomeTCMagicalForest extends RealisticBiomeBase {
    public RealisticBiomeTCMagicalForest(Biome biome) {
        super(biome);
    }

    @Override
    public void initConfig() {

    }

    @Override
    public TerrainBase initTerrain() {
        return new TerrainTCMagicalForest();
    }

    @Override
    public SurfaceBase initSurface() {
        return new SurfaceTCMagicalForest(getConfig(), baseBiome().topBlock, baseBiome().fillerBlock);
    }

    @Override
    public void initDecos() {
    }

    public static final class TerrainTCMagicalForest extends TerrainBase {

        private TerrainTCMagicalForest() {
        }

        @Override
        public float generateNoise(RTGWorld rtgWorld, int x, int y, float border, float river) {
            return terrainForest(x, y, rtgWorld, river, 70f);
        }
    }

    public static final class SurfaceTCMagicalForest extends SurfaceBase {

        private SurfaceTCMagicalForest(BiomeConfig config, IBlockState top, IBlockState filler) {
            super(config, top, filler);
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, RTGWorld rtgWorld, float[] noise, float river, Biome[] base) {

            IBlockState bs;
            for (int y = 255; y >= 0; y--) {

                bs = primer.getBlockState(x, y, z);
                if (bs == Blocks.AIR.getDefaultState()) {
                    depth = -1;
                } else if (bs == Blocks.STONE.getDefaultState()) {

                    depth++;
                    if (TerrainBase.calcCliff(x, z, noise) > 1.4f) {
                        if (depth > -1 && depth < 2) {
                            if (rtgWorld.rand().nextInt(3) == 0) {
                                primer.setBlockState(x, y, z, this.hcCobble());
                            } else {
                                primer.setBlockState(x, y, z, this.hcStone());
                            }
                        } else if (depth < 10) {
                            primer.setBlockState(x, y, z, this.hcStone());
                        }
                    } else {
                        if (depth == 0 && y > 61) {
                            primer.setBlockState(x, y, z, this.topBlock);
                        } else if (depth < 4) {
                            primer.setBlockState(x, y, z, this.fillerBlock);
                        }
                    }
                }
            }
        }
    }
}
