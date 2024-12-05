package project.thelittlethings.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import project.thelittlethings.world.tree.ModFoliagePlacerTypes;

public class MapleFoliagePlacer extends FoliagePlacer {
    public static final Codec<MapleFoliagePlacer> CODEC = RecordCodecBuilder.create(mapleFoliagePlacerInstance ->
            fillFoliagePlacerFields(mapleFoliagePlacerInstance).and(Codec.intRange(0,12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(mapleFoliagePlacerInstance, MapleFoliagePlacer::new));
    private final int height;

    public MapleFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.MAPLE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        // generateSquare(world, placer, random, config, treeNode.getCenter());
        // radius on how many blocks it extends into x and z direction
        // y how much offset in the y direction from treeNode.getCenter()
        // y if it is dependent on i, also offsets each new layer in the y direction
        //generateSquareWithHangingLeaves(world, placer, random, config , treeNode.getCenter().up(0), 2, -3, treeNode.isGiantTrunk(), 0.4f, 0.1f);
        //Layer 1
        generateSquare(world, placer, random, config, treeNode.getCenter().east(1), 1, -5, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().west(1), 1, -5, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().north(1), 1, -5, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().south(1), 1, -5, treeNode.isGiantTrunk());
        //Layer 2
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0),1, -4, treeNode.isGiantTrunk());
        //Layer 3
        generateSquare(world, placer, random, config, treeNode.getCenter().east(1), 1, -3, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().west(1), 1, -3, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().north(1), 1, -3, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().south(1), 1, -3, treeNode.isGiantTrunk());
        //Layer 4
        generateSquare(world, placer, random, config, treeNode.getCenter().east(1), 0, -2, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().west(1), 0, -2, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().north(1), 0, -2, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().south(1), 0, -2, treeNode.isGiantTrunk());
        //Layer 5
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0), 1, -1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().east(2), 0, -1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().west(2), 0, -1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().north(2), 0, -1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().south(2), 0, -1, treeNode.isGiantTrunk());
        //Layer 6
        generateSquare(world, placer, random, config, treeNode.getCenter().east(1), 0, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().west(1), 0, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().north(1), 0, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().south(1), 0, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0), 0, 0, treeNode.isGiantTrunk());

        //Layer 7
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0), 0, 1, treeNode.isGiantTrunk());

    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
