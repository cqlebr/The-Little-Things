package project.thelittlethings;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.entity.ModEntities;
import project.thelittlethings.entity.custom.SquirrelEntity;
import project.thelittlethings.item.ModItemGroups;
import project.thelittlethings.item.ModItems;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheLittleThings implements ModInitializer {
	public static final String MOD_ID = "the-little-things";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final long GRAPPLE_COOLDOWN = 1000;

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
		ModifyFishingRod.setupFishingRodInteraction();
	}

	public static class ModifyFishingRod {
		// Store last grapple time for each player
		public static final Map<UUID, Long> playerGrappleCooldowns = new HashMap<>();

		public static void setupFishingRodInteraction() {
			// Modify the fishing rod's use action
			UseItemCallback.EVENT.register((player, world, hand) -> {
				ItemStack itemStack = player.getStackInHand(hand);

				if (itemStack.isOf(Items.FISHING_ROD)) {
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
						Vec3d pullVector = targetPos.subtract(playerPos).normalize().multiply(2.0);

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