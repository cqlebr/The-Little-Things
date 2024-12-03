package project.thelittlethings.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SignItem;
import net.minecraft.item.SpawnEggItem;
import project.thelittlethings.TheLittleThings;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.entity.ModBoats;
import project.thelittlethings.entity.ModEntities;

public class ModItems {
    public static final Item MAPLE_CREME_BRULEE = registerItem("maple_creme_brulee", new Item(new FabricItemSettings().food(ModFoodComponents.MAPLE_CREME_BRULEE)));
    public static final Item MAPLE_SIGN = registerItem("maple_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.STANDING_MAPLE_SIGN, ModBlocks.WALL_MAPLE_SIGN));
    public static final Item HANGING_MAPLE_SIGN = registerItem("maple_hanging_sign",
            new HangingSignItem(ModBlocks.HANGING_MAPLE_SIGN, ModBlocks.WALL_HANGING_MAPLE_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item MAPLE_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAPLE_BOAT_ID, ModBoats.MAPLE_BOAT_KEY, false);
    public static final Item MAPLE_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAPLE_CHEST_BOAT_ID, ModBoats.MAPLE_BOAT_KEY, true);


    public static final Item SQUIRREL_SPAWN_EGG = registerItem("squirrel_spawn_egg",
       new SpawnEggItem(ModEntities.SQUIRREL, 0xa86518, 0x3b260f, new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TheLittleThings.MOD_ID, name), item);
    }

    public static final Item GRAPPLING_HOOK = registerItem("grappling_hook",
            new Item(new FabricItemSettings().maxCount(1)));

    public static void registerModItems() {
        TheLittleThings.LOGGER.info("Registering Mod Items " + TheLittleThings.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
