package project.thelittlethings;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.item.ModItemGroups;
import project.thelittlethings.item.ModItems;

public class TheLittleThings implements ModInitializer {
	public static final String MOD_ID = "the-little-things";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		//STRIPPABLE WOOD
		StrippableBlockRegistry.register(ModBlocks.MAPLE_LOG, ModBlocks.STRIPPED_MAPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_WOOD);

		//FLAMMABLE BLOCKS
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MAPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MAPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LEAVES_ORANGE, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LEAVES_RED, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LEAVES_YELLOW, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUEBELL, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.COLUMBINE, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TROUT_LILY, 60, 100);

		// FURNACE FUEL ITEMS
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_WOOD, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_PLANKS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_LOG, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_MAPLE_LOG, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_MAPLE_WOOD, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_SLAB, 150);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_STAIRS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_PRESSURE_PLATE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_BUTTON, 100);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_TRAPDOOR, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_FENCE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_FENCE_GATE, 300);

	}
}