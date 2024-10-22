package com.example.grapplinghook;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GrapplingHookItem extends Item {
    public GrapplingHookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            GrappleEntity grapple = new GrappleEntity(world, player);
            grapple.setProperties(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(grapple);
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}