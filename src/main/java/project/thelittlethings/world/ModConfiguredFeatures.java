package project.thelittlethings.world;

import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import project.thelittlethings.TheLittleThings;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.world.tree.custom.MapleFoliagePlacer;
import project.thelittlethings.world.tree.custom.MapleTrunkPlacer;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TROUT_LILY_KEY = registerKey("trout_lily");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, MAPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new MapleTrunkPlacer(3,  2,  3),

                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES_RED),
                new MapleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

                new TwoLayersFeatureSize(1, 0, 2)).build());
//        register(context, TROUT_LILY_KEY, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(
//                BlockTags.FLOWERS,
//                BlockStateProvider.of(ModBlocks.TROUT_LILY),
//                PlacedFeatures.createEntry(),
//                new PlacementModifier[0],
//                VerticalSurfaceType.FLOOR,
//                ConstantIntProvider.create(1),
//                0.0f,
//                5,
//                0.8f,
//                UniformIntProvider.create(4,7), 0.3f));
//        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TheLittleThings.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
