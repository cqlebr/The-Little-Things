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
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.MAPLE_CREME_BRULEE);

                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_LEAVES_RED);
                        entries.add(ModBlocks.MAPLE_LEAVES_YELLOW);
                        entries.add(ModBlocks.MAPLE_LEAVES_ORANGE);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_SLAB);

                    }).build());

    public static void registerItemGroups() {
        TheLittleThings.LOGGER.info("Registering Mod Item Groups" + TheLittleThings.MOD_ID);
    }
}
