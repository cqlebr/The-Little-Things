package project.thelittlethings.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import project.thelittlethings.TheLittleThings;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item MAPLE_CREME_BRULEE = registerItem("maple_creme_brulee", new Item(new FabricItemSettings().food(ModFoodComponents.MAPLE_CREME_BRULEE)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TheLittleThings.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheLittleThings.LOGGER.info("Registering Mod Items" + TheLittleThings.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}