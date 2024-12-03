package project.thelittlethings.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import project.thelittlethings.world.ModPlacedFeatures;
import project.thelittlethings.world.biome.ModBiomes;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.MAPLE_FOREST_BIOME),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MAPLE_PLACED_KEY);
    }
}
