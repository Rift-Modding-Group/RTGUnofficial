package rtg.world.biome.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.config.BiomeConfig;
import rtg.api.world.RTGWorld;
import rtg.api.world.biome.RealisticBiomeBase;
import rtg.api.world.deco.DecoTree;
import rtg.api.world.gen.feature.tree.rtg.TreeRTG;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGCocosNucifera;
import rtg.api.world.surface.SurfaceBase;
import rtg.api.world.terrain.TerrainBase;

import java.util.Random;


public class RealisticBiomeVanillaBeach extends RealisticBiomeBase {

    public static Biome biome = Biomes.BEACH;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeVanillaBeach() {

        super(biome);
    }

    @Override
    public void initConfig() {
        this.getConfig().SURFACE_BLEED_IN.set(true);
        this.getConfig().SURFACE_BLEED_OUT.set(true);
        this.getConfig().addProperty(this.getConfig().ALLOW_PALM_TREES).set(true);
        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_FILLER_BLOCK).set("");
    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainVanillaBeach();
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceVanillaBeach(getConfig(), biome.topBlock, biome.fillerBlock);
    }

    @Override
    public void initDecos() {

        // Scattered palm trees.

        TreeRTG nuciferaTree = new TreeRTGCocosNucifera();
        nuciferaTree.setMinTrunkSize(7);
        nuciferaTree.setMaxTrunkSize(9);
        nuciferaTree.setMinCrownSize(6);
        nuciferaTree.setMaxCrownSize(8);
        nuciferaTree.getValidGroundBlocks().clear();
        nuciferaTree.getValidGroundBlocks().add(Blocks.SAND.getDefaultState());
        this.addTree(nuciferaTree);

        DecoTree palmTrees = new DecoTree(nuciferaTree);
        palmTrees.setTreeType(DecoTree.TreeType.RTG_TREE);
        palmTrees.setTreeCondition(DecoTree.TreeCondition.NOISE_GREATER_AND_RANDOM_CHANCE);
        palmTrees.setTreeConditionNoise(-0.2f);
        palmTrees.setTreeConditionChance(12);
        palmTrees.setMaxY(68);
        this.addDeco(palmTrees, this.getConfig().ALLOW_PALM_TREES.get());
    }

    public static class TerrainVanillaBeach extends TerrainBase {

        public TerrainVanillaBeach() {

        }

        @Override
        public float generateNoise(RTGWorld rtgWorld, int x, int y, float border, float river) {
            return terrainBeach(x, y, rtgWorld, river, 63f);
        }
    }

    public static class SurfaceVanillaBeach extends SurfaceBase {

        private final IBlockState mixBlockFill;

        public SurfaceVanillaBeach(BiomeConfig config, IBlockState top, IBlockState filler) {

            super(config, top, filler);

            mixBlockFill = this.getConfigBlock(config.SURFACE_MIX_FILLER_BLOCK.get(), Blocks.SANDSTONE.getDefaultState());
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, RTGWorld rtgWorld, float[] noise, float river, Biome[] base) {

            Random rand = rtgWorld.rand();

            for (int k = 255; k > -1; k--) {
                Block b = primer.getBlockState(x, k, z).getBlock();

                if (b == Blocks.AIR) {
                    depth = -1;
                } else if (b == Blocks.STONE) {
                    depth++;

                    if (depth == 0 && k > 61) {
                        primer.setBlockState(x, k, z, topBlock);
                    } else if (k > 63 && depth > 3 && depth < 6) {
                        primer.setBlockState(x, k, z, mixBlockFill);
                    } else if (depth < 4) {
                        primer.setBlockState(x, k, z, fillerBlock);
                    }
                }
            }
        }
    }
}
