package rtg.api.world.deco.collection;

import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.world.gen.feature.WorldGenTrees;
import rtg.api.config.BiomeConfig;
import rtg.api.util.BlockUtil;
import rtg.api.world.deco.*;
import rtg.api.world.deco.helper.DecoHelperRandomSplit;
import rtg.api.world.gen.feature.tree.rtg.TreeRTG;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGBetulaPapyrifera;

import static net.minecraft.block.BlockFlower.EnumFlowerType.HOUSTONIA;
import static net.minecraft.block.BlockFlower.EnumFlowerType.WHITE_TULIP;
import static rtg.api.world.deco.DecoFallenTree.LogCondition.RANDOM_CHANCE;


/**
 * @author WhichOnesPink
 */
public class DecoCollectionBirchForest extends DecoCollectionBase {

    public DecoCollectionBirchForest(BiomeConfig config) {

        super(config);

        this
                .addDeco(tallBirchTrees())
                .addDeco(randomTrees())
                .addDeco(logs(), config.ALLOW_LOGS.get()) // Add some fallen birch trees.
                .addDeco(shrubsOak()) // Oak shrubs to fill in the blanks.
                .addDeco(flowers()) // Only 1-block tall flowers so we can see the trees better.
        ;
    }

    private DecoHelperRandomSplit randomTrees() {
        return new DecoHelperRandomSplit()
                .setDecos(new DecoBase[]{tallBirchTrees(), vanillaTrees()})
                .setChances(new int[]{10, 4});
    }

    private DecoTree tallBirchTrees() {

        TreeRTG birchTree = new TreeRTGBetulaPapyrifera()
                .setLogBlock(BlockUtil.getStateLog(EnumType.BIRCH))
                .setLeavesBlock(BlockUtil.getStateLeaf(EnumType.BIRCH))
                .setMinTrunkSize(4)
                .setMaxTrunkSize(10)
                .setMinCrownSize(8)
                .setMaxCrownSize(19);

        this.addTree(birchTree);

        return new DecoTree(birchTree)
                .setStrengthFactorForLoops(3f)
                .setTreeType(DecoTree.TreeType.RTG_TREE)
                .setTreeCondition(DecoTree.TreeCondition.ALWAYS_GENERATE)
                .setMaxY(100);
    }

    private DecoTree vanillaTrees() {
        return new DecoTree(new WorldGenTrees(false))
                .setTreeType(DecoTree.TreeType.WORLDGEN)
                .setStrengthFactorForLoops(3f)
                .setTreeCondition(DecoTree.TreeCondition.ALWAYS_GENERATE)
                .setMaxY(100);
    }

    private DecoFallenTree logs() {
        return new DecoFallenTree()
                .setLogCondition(RANDOM_CHANCE)
                .setLogConditionChance(8)
                .setLogBlock(BlockUtil.getStateLog(EnumType.BIRCH))
                .setLeavesBlock(BlockUtil.getStateLeaf(EnumType.BIRCH))
                .setMinSize(3)
                .setMaxSize(6);
    }

    private DecoShrub shrubsOak() {
        return new DecoShrub()
                .setMaxY(120)
                .setLoopMultiplier(3f);
    }

    private DecoFlowersRTG flowers() {
        return new DecoFlowersRTG()
                .addFlowers(HOUSTONIA, WHITE_TULIP)
                .setMaxY(128)
                .setStrengthFactor(12f);
    }
}
