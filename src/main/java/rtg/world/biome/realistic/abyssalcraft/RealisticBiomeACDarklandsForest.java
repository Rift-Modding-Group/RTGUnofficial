package rtg.world.biome.realistic.abyssalcraft;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.config.BiomeConfig;
import rtg.api.util.BlockUtil;
import rtg.api.util.noise.SimplexNoise;
import rtg.api.world.RTGWorld;
import rtg.api.world.biome.RealisticBiomeBase;
import rtg.api.world.deco.DecoFallenTree;
import rtg.api.world.deco.DecoShrub;
import rtg.api.world.surface.SurfaceBase;
import rtg.api.world.terrain.TerrainBase;
import rtg.compat.ModCompat.Mods;

import java.util.Random;


public class RealisticBiomeACDarklandsForest extends RealisticBiomeBase {

    public RealisticBiomeACDarklandsForest(final Biome biome) {
        super(biome);
    }

    @Override
    public void initConfig() {
        this.getConfig().SURFACE_CLIFF_STONE_BLOCK.set("abyssalcraft:stone");
        this.getConfig().SURFACE_CLIFF_COBBLE_BLOCK.set("abyssalcraft:cobblestone");
        this.getConfig().addProperty(this.getConfig().ALLOW_LOGS).set(true);
        this.getConfig().addProperty(this.getConfig().FALLEN_LOG_DENSITY_MULTIPLIER);
        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_BLOCK).set("");
    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainACDarklandsForest();
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceACDarklandsForest(getConfig(), baseBiome().topBlock, baseBiome().fillerBlock, 0f, 1.5f, 60f, 65f, 1.5f, baseBiome().topBlock, 0.10f);
    }

    @Override
    public void initDecos() {

        DecoFallenTree decoFallenTree = new DecoFallenTree();
        decoFallenTree.setLogConditionChance(12);
        decoFallenTree.setLogBlock(BlockUtil.getBlock(Mods.abyssalcraft.getResourceLocation("dltlog"), Blocks.LOG).getDefaultState());
        decoFallenTree.setLeavesBlock(BlockUtil.getBlock(Mods.abyssalcraft.getResourceLocation("dltleaves"), Blocks.LEAVES).getDefaultState());
        decoFallenTree.setMinSize(2);
        decoFallenTree.setMaxSize(3);
        this.addDeco(decoFallenTree, this.getConfig().ALLOW_LOGS.get());

        DecoShrub decoShrubCustom = new DecoShrub();
        decoShrubCustom.setLogBlock(BlockUtil.getBlock(Mods.abyssalcraft.getResourceLocation("dltlog"), Blocks.LOG).getDefaultState());
        decoShrubCustom.setLeavesBlock(BlockUtil.getBlock(Mods.abyssalcraft.getResourceLocation("dltleaves"), Blocks.LEAVES).getDefaultState());
        decoShrubCustom.setMaxY(110);
        decoShrubCustom.setNotEqualsZeroChance(3);
        decoShrubCustom.setLoopMultiplier(3f);
        this.addDeco(decoShrubCustom);
    }

    public static class TerrainACDarklandsForest extends TerrainBase {

        private final float hillStrength = 10f;// this needs to be linked to the

        public TerrainACDarklandsForest() {

        }

        @Override
        public float generateNoise(RTGWorld rtgWorld, int x, int y, float border, float river) {

            groundNoise = groundNoise(x, y, groundVariation, rtgWorld);

            float m = hills(x, y, hillStrength, rtgWorld);

            float floNoise = 65f + groundNoise + m;

            return riverized(floNoise, river);
        }
    }

    public static class SurfaceACDarklandsForest extends SurfaceBase {

        private final float min;

        private float sCliff = 1.5f;
        private float sHeight = 60f;
        private float sStrength = 65f;
        private float cCliff = 1.5f;

        private final IBlockState mixBlock;
        private final float mixHeight;

        public SurfaceACDarklandsForest(BiomeConfig config, IBlockState top, IBlockState fill, float minCliff, float stoneCliff,
                                        float stoneHeight, float stoneStrength, float clayCliff, IBlockState mix, float mixSize) {

            super(config, top, fill);
            min = minCliff;

            sCliff = stoneCliff;
            sHeight = stoneHeight;
            sStrength = stoneStrength;
            cCliff = clayCliff;

            mixBlock = this.getConfigBlock(config.SURFACE_MIX_BLOCK.get(), mix);
            mixHeight = mixSize;
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, RTGWorld rtgWorld, float[] noise, float river, Biome[] base) {

            Random rand = rtgWorld.rand();
            SimplexNoise simplex = rtgWorld.simplexInstance(0);
            float c = TerrainBase.calcCliff(x, z, noise);
            int cliff = 0;
            boolean m = false;

            Block b;
            for (int k = 255; k > -1; k--) {
                b = primer.getBlockState(x, k, z).getBlock();
                if (b == Blocks.AIR) {
                    depth = -1;
                } else if (b == Blocks.STONE) {
                    depth++;

                    if (depth == 0) {

                        float p = simplex.noise3f(i / 8f, j / 8f, k / 8f) * 0.5f;
                        if (c > min && c > sCliff - ((k - sHeight) / sStrength) + p) {
                            cliff = 1;
                        }
                        if (c > cCliff) {
                            cliff = 2;
                        }

                        if (cliff == 1) {
                            if (rand.nextInt(3) == 0) {

                                primer.setBlockState(x, k, z, hcCobble());
                            } else {

                                primer.setBlockState(x, k, z, hcStone());
                            }
                        } else if (cliff == 2) {
                            primer.setBlockState(x, k, z, getShadowStoneBlock());
                        } else if (k < 63) {
                            if (k < 62) {
                                primer.setBlockState(x, k, z, fillerBlock);
                            } else {
                                primer.setBlockState(x, k, z, topBlock);
                            }
                        } else if (simplex.noise2f(i / 12f, j / 12f) > mixHeight) {
                            primer.setBlockState(x, k, z, mixBlock);
                            m = true;
                        } else {
                            primer.setBlockState(x, k, z, topBlock);
                        }
                    } else if (depth < 6) {
                        if (cliff == 1) {
                            primer.setBlockState(x, k, z, hcStone());
                        } else if (cliff == 2) {
                            primer.setBlockState(x, k, z, getShadowStoneBlock());
                        } else {
                            primer.setBlockState(x, k, z, fillerBlock);
                        }
                    }
                }
            }
        }
    }
}
