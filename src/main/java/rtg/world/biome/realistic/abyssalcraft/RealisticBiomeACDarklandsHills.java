package rtg.world.biome.realistic.abyssalcraft;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.config.BiomeConfig;
import rtg.api.util.noise.SimplexNoise;
import rtg.api.world.RTGWorld;
import rtg.api.world.biome.RealisticBiomeBase;
import rtg.api.world.surface.SurfaceBase;
import rtg.api.world.terrain.TerrainBase;

import java.util.Random;


public class RealisticBiomeACDarklandsHills extends RealisticBiomeBase {

    public RealisticBiomeACDarklandsHills(final Biome biome) {
        super(biome);
    }

    @Override
    public void initConfig() {
        this.getConfig().ALLOW_RIVERS.set(false);
        this.getConfig().ALLOW_SCENIC_LAKES.set(false);
        this.getConfig().SURFACE_CLIFF_STONE_BLOCK.set("abyssalcraft:stone");
        this.getConfig().SURFACE_CLIFF_COBBLE_BLOCK.set("abyssalcraft:cobblestone");
        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_BLOCK).set("");
        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_FILLER_BLOCK).set("");
    }

    @Override
    public void initDecos() {
    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainACDarklandsHighland(10f, 120f, 10f, 200f);
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceACDarklandsHighland(getConfig(), baseBiome().topBlock, baseBiome().fillerBlock, baseBiome().topBlock, baseBiome().fillerBlock, 60f, -0.14f, 14f, 0.25f);
    }

    public static class TerrainACDarklandsHighland extends TerrainBase {

        private final float start;
        private final float height;
        private final float width;

        public TerrainACDarklandsHighland(float hillStart, float landHeight, float baseHeight, float hillWidth) {

            start = hillStart;
            height = landHeight;
            base = baseHeight;
            width = hillWidth;
        }

        @Override
        public float generateNoise(RTGWorld rtgWorld, int x, int y, float border, float river) {

            return terrainHighland(x, y, rtgWorld, river, start, width, height, base);
        }
    }

    public static class SurfaceACDarklandsHighland extends SurfaceBase {

        private final IBlockState mixBlockTop;
        private final IBlockState mixBlockFill;
        private final float width;
        private final float height;
        private final float smallW;
        private final float smallS;

        public SurfaceACDarklandsHighland(BiomeConfig config, IBlockState top, IBlockState filler, IBlockState mixTop, IBlockState mixFill, float mixWidth,
                                          float mixHeight, float smallWidth, float smallStrength) {

            super(config, top, filler);

            mixBlockTop = this.getConfigBlock(config.SURFACE_MIX_BLOCK.get(), mixTop);
            mixBlockFill = this.getConfigBlock(config.SURFACE_MIX_FILLER_BLOCK.get(), mixFill);

            width = mixWidth;
            height = mixHeight;
            smallW = smallWidth;
            smallS = smallStrength;
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, RTGWorld rtgWorld, float[] noise, float river, Biome[] base) {

            Random rand = rtgWorld.rand();
            SimplexNoise simplex = rtgWorld.simplexInstance(0);
            float c = TerrainBase.calcCliff(x, z, noise);
            boolean cliff = c > 1.4f;
            boolean mix = false;

            for (int k = 255; k > -1; k--) {
                Block b = primer.getBlockState(x, k, z).getBlock();
                if (b == Blocks.AIR) {
                    depth = -1;
                } else if (b == Blocks.STONE) {
                    depth++;

                    if (cliff) {
                        if (depth > -1 && depth < 2) {
                            if (rand.nextInt(3) == 0) {

                                primer.setBlockState(x, k, z, hcCobble());
                            } else {

                                primer.setBlockState(x, k, z, hcStone());
                            }
                        } else if (depth < 10) {
                            primer.setBlockState(x, k, z, hcStone());
                        }
                    } else {
                        if (depth == 0 && k > 61) {
                            if (simplex.noise2f(i / width, j / width) + simplex.noise2f(i / smallW, j / smallW) * smallS > height) {
                                primer.setBlockState(x, k, z, mixBlockTop);
                                mix = true;
                            } else {
                                primer.setBlockState(x, k, z, topBlock);
                            }
                        } else if (depth < 4) {
                            if (mix) {
                                primer.setBlockState(x, k, z, mixBlockFill);
                            } else {
                                primer.setBlockState(x, k, z, fillerBlock);
                            }
                        }
                    }
                }
            }
        }
    }
}
