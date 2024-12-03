package project.thelittlethings.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.item.ModItems;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool maple_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);
        maple_pool.family(ModBlocks.MAPLE_FAMILY);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.HANGING_MAPLE_SIGN, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAPLE_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAPLE_CHEST_BOAT, Models.GENERATED);
    }
}
