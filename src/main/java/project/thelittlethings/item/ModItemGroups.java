package project.thelittlethings.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import project.thelittlethings.TheLittleThings;
import project.thelittlethings.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MAPLE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLittleThings.MOD_ID, "maple"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.maple"))
                    .icon(() -> new ItemStack(ModBlocks.MAPLE_PLANKS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MAPLE_CREME_BRULEE);
                        entries.add(ModBlocks.BLUEBELL);
                        entries.add(ModBlocks.COLUMBINE);
                        entries.add(ModBlocks.TROUT_LILY);

                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
                        entries.add(ModBlocks.MAPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_LEAVES_RED);
                        entries.add(ModBlocks.MAPLE_LEAVES_YELLOW);
                        entries.add(ModBlocks.MAPLE_LEAVES_ORANGE);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_SLAB);
                        entries.add(ModBlocks.MAPLE_BUTTON);
                        entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks.MAPLE_FENCE);
                        entries.add(ModBlocks.MAPLE_FENCE_GATE);
                        entries.add(ModBlocks.MAPLE_DOOR);
                        entries.add(ModBlocks.MAPLE_TRAPDOOR);
                        entries.add(ModItems.MAPLE_SIGN);
                        entries.add(ModItems.HANGING_MAPLE_SIGN);
                        entries.add(ModItems.MAPLE_BOAT);
                        entries.add(ModItems.MAPLE_CHEST_BOAT);
                        entries.add(ModBlocks.MAPLE_SAPLING);

                    }).build());

    public static void registerItemGroups() {
        TheLittleThings.LOGGER.info("Registering Mod Item Groups " + TheLittleThings.MOD_ID);
    }
}
