package project.thelittlethings.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import project.thelittlethings.TheLittleThings;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.item.ModItems;

public class ModBoats {
    public static final Identifier MAPLE_BOAT_ID = new Identifier(TheLittleThings.MOD_ID,"maple_boat");
    public static final Identifier MAPLE_CHEST_BOAT_ID = new Identifier(TheLittleThings.MOD_ID,"maple_chest_boat");

    public static final RegistryKey<TerraformBoatType> MAPLE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(MAPLE_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType mapleBoat = new TerraformBoatType.Builder()
                .item(ModItems.MAPLE_BOAT)
                .chestItem(ModItems.MAPLE_CHEST_BOAT)
                .planks(ModBlocks.MAPLE_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, MAPLE_BOAT_ID, mapleBoat);
    }
}
