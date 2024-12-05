package project.thelittlethings;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.datagen.ModWorldGenerator;
import project.thelittlethings.entity.ModBoats;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.entity.ModEntities;
import project.thelittlethings.entity.custom.RobinEntity;
import project.thelittlethings.entity.custom.SquirrelEntity;
import project.thelittlethings.item.ModItemGroups;
import project.thelittlethings.item.ModItems;
import project.thelittlethings.world.gen.ModWorldGeneration;
import project.thelittlethings.world.tree.ModFoliagePlacerTypes;
import project.thelittlethings.world.tree.ModTrunkPlacerTypes;


import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class TheLittleThings implements ModInitializer {
	public static final String MOD_ID = "the-little-things";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final long GRAPPLE_COOLDOWN = 750;
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

		ModWorldGeneration.generateModWorldGen();
		ModBoats.registerBoats();
		ModTrunkPlacerTypes.register();
		ModFoliagePlacerTypes.register();
		// mob attributes
		FabricDefaultAttributeRegistry.register(ModEntities.SQUIRREL, SquirrelEntity.createSquirrelAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ROBIN, RobinEntity.createRobinAttributes());
		ModifyFishingRod.setupFishingRodInteraction();

	}

	public static class ModifyFishingRod {
		// Store last grapple time for each player
		public static final Map<UUID, Long> playerGrappleCooldowns = new HashMap<>();

		public static void setupFishingRodInteraction() {
			// Modify the fishing rod's use action
			UseItemCallback.EVENT.register((player, world, hand) -> {
				ItemStack itemStack = player.getStackInHand(hand);

				if (itemStack.isOf(Items.FISHING_ROD)|| (itemStack.isOf(ModItems.GRAPPLING_HOOK))) {
					ActionResult grappleResult = grappleAction(player, world, hand);
					//return grappleAction(player, world, hand);
					return new TypedActionResult<>(grappleResult,itemStack);
				}
				return TypedActionResult.pass(itemStack);
				//return ActionResult.PASS;
			});
		}

		public static ActionResult grappleAction(PlayerEntity player, World world, Hand hand) {
			if (!world.isClient) {
				// Check cooldown
				long currentTime = System.currentTimeMillis();
				UUID playerUUID = player.getUuid();
				Long lastGrappleTime = playerGrappleCooldowns.get(playerUUID);

				// If player hasn't grappled before or enough time has passed
				if (lastGrappleTime == null || currentTime - lastGrappleTime >= GRAPPLE_COOLDOWN) {
					// Calculate grappling direction
					Vec3d lookVector = player.getRotationVector();
					double range = 1000.0; // Maximum grappling distance

					// Perform raycast to find grapple target
					HitResult hitResult = player.raycast(range, 1.0F, false);

					if (hitResult.getType() != HitResult.Type.MISS) {
						// Calculate destination vector
						Vec3d targetPos = hitResult.getPos();
						Vec3d playerPos = player.getPos();

						// Calculate pull vector
						Vec3d pullVector = targetPos.subtract(playerPos).normalize().multiply(3);

						// Apply velocity to player
						player.setVelocity(pullVector.x, pullVector.y, pullVector.z);
						player.velocityModified = true;

						// Record the time of this grapple
						playerGrappleCooldowns.put(playerUUID, currentTime);

						return ActionResult.SUCCESS;
					}
				}
			}

			return ActionResult.PASS;
		}
	}
}
