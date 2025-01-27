package rtg.world.biome.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.config.BiomeConfig;
import rtg.api.util.BlockUtil;
import rtg.api.world.RTGWorld;
import rtg.api.world.biome.RealisticBiomeBase;
import rtg.api.world.deco.DecoFallenTree;
import rtg.api.world.deco.DecoPumpkin;
import rtg.api.world.deco.DecoShrub;
import rtg.api.world.deco.DecoTree;
import rtg.api.world.gen.feature.tree.rtg.TreeRTG;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGPinusPonderosa;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGSalixMyrtilloides;
import rtg.api.world.surface.SurfaceBase;
import rtg.api.world.terrain.TerrainBase;

import java.util.Random;


public class RealisticBiomeVanillaSwamplandM extends RealisticBiomeBase {

    public static Biome biome = Biomes.MUTATED_SWAMPLAND;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeVanillaSwamplandM() {

        super(biome);
    }

    @Override
    public Biome preferredBeach() {
        return biome;
    }

    @Override
    public void initConfig() {
        this.getConfig().addProperty(this.getConfig().ALLOW_LOGS).set(true);
        this.getConfig().addProperty(this.getConfig().FALLEN_LOG_DENSITY_MULTIPLIER);
    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainVanillaSwamplandM(50f, 25f, 60f);
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceVanillaSwamplandM(getConfig(), biome.topBlock, biome.fillerBlock);
    }

    @Override
    public void initDecos() {

        TreeRTG myrtilloidesTree = new TreeRTGSalixMyrtilloides();
        myrtilloidesTree.setLogBlock(Blocks.LOG.getDefaultState());
        myrtilloidesTree.setLeavesBlock(Blocks.LEAVES.getDefaultState());
        this.addTree(myrtilloidesTree);

        DecoTree decoTrees = new DecoTree(myrtilloidesTree);
        decoTrees.setStrengthNoiseFactorXForLoops(true);
        decoTrees.setStrengthFactorForLoops(1f);
        decoTrees.getDistribution().setNoiseDivisor(80f);
        decoTrees.getDistribution().setNoiseFactor(60f);
        decoTrees.getDistribution().setNoiseAddend(-15f);
        decoTrees.setTreeType(DecoTree.TreeType.RTG_TREE);
        decoTrees.setTreeCondition(DecoTree.TreeCondition.RANDOM_CHANCE);
        decoTrees.setTreeConditionChance(12);
        decoTrees.setMaxY(100);
        this.addDeco(decoTrees);

        TreeRTG ponderosaTree = new TreeRTGPinusPonderosa();
        ponderosaTree.setLogBlock(Blocks.LOG.getDefaultState());
        ponderosaTree.setLeavesBlock(Blocks.LEAVES.getDefaultState());
        ponderosaTree.setMinTrunkSize(3);
        ponderosaTree.setMaxTrunkSize(6);
        ponderosaTree.setMinCrownSize(6);
        ponderosaTree.setMaxCrownSize(14);
        ponderosaTree.setNoLeaves(true);
        this.addTree(ponderosaTree);

        DecoTree deadPineTree = new DecoTree(ponderosaTree);
        deadPineTree.setTreeType(DecoTree.TreeType.RTG_TREE);
        deadPineTree.setTreeCondition(DecoTree.TreeCondition.RANDOM_CHANCE);
        deadPineTree.setTreeConditionChance(18);
        deadPineTree.setMaxY(100);
        this.addDeco(deadPineTree);

        DecoShrub decoShrub = new DecoShrub();
        decoShrub.setMaxY(100);
        decoShrub.setLoopMultiplier(3f);
        this.addDeco(decoShrub);

        DecoFallenTree decoFallenTree = new DecoFallenTree();
        decoFallenTree.getDistribution().setNoiseDivisor(80f);
        decoFallenTree.getDistribution().setNoiseFactor(60f);
        decoFallenTree.getDistribution().setNoiseAddend(-15f);
        decoFallenTree.setLogConditionChance(6);
        decoFallenTree.setLogBlock(BlockUtil.getStateLog(EnumType.DARK_OAK));
        decoFallenTree.setLeavesBlock(BlockUtil.getStateLeaf(EnumType.DARK_OAK));
        decoFallenTree.setMinSize(3);
        decoFallenTree.setMaxSize(6);
        this.addDeco(decoFallenTree, this.getConfig().ALLOW_LOGS.get());

        DecoPumpkin decoPumpkin = new DecoPumpkin();
        decoPumpkin.setMaxY(90);
        decoPumpkin.setRandomFloat(50f);
        this.addDeco(decoPumpkin);
    }

    public static class TerrainVanillaSwamplandM extends TerrainBase {

        private final float width;
        private final float strength;
        private final float terrainHeight;

        public TerrainVanillaSwamplandM(float mountainWidth, float mountainStrength, float height) {

            width = mountainWidth;
            strength = mountainStrength;
            terrainHeight = height;
        }

        @Override
        public float generateNoise(RTGWorld rtgWorld, int x, int y, float border, float river) {

            return terrainLonelyMountain(x, y, rtgWorld, river, strength, width, terrainHeight);
        }
    }

    public static class SurfaceVanillaSwamplandM extends SurfaceBase {

        public SurfaceVanillaSwamplandM(BiomeConfig config, IBlockState top, IBlockState filler) {

            super(config, top, filler);
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, RTGWorld rtgWorld, float[] noise, float river, Biome[] base) {

            Random rand = rtgWorld.rand();
            float c = TerrainBase.calcCliff(x, z, noise);
            boolean cliff = c > 1.4f;

            for (int k = 255; k > -1; k--) {
                Block b = primer.getBlockState(x, k, z).getBlock();
                if (b == Blocks.AIR) {
                    depth = -1;
                } else if (b == Blocks.STONE) {
                    depth++;

                    if (cliff && k > 64) {
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
                            primer.setBlockState(x, k, z, topBlock);
                        } else if (depth < 4) {
                            primer.setBlockState(x, k, z, fillerBlock);
                        }
                    }
                }
            }
        }
    }
}
