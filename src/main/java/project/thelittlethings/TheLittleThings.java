package project.thelittlethings;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.entity.ModEntities;
import project.thelittlethings.entity.custom.SquirrelEntity;
import project.thelittlethings.entity.custom.RobinEntity;
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

		// FURNACE FUEL ITEMS
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_WOOD, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MAPLE_PLANKS, 300);

		// mob attributes
		FabricDefaultAttributeRegistry.register(ModEntities.SQUIRREL, SquirrelEntity.createSquirrelAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ROBIN, RobinEntity.createRobinAttributes());

	}
}