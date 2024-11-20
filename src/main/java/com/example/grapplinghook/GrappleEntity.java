package com.example.grapplinghook;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class GrappleEntity extends FishingBobberEntity {

    public GrappleEntity(EntityType<? extends FishingBobberEntity> type, World world, PlayerEntity owner) {
        super(type, owner, world, 0, 0);  // Adjust for lure and luck levels
    }

    public GrappleEntity(World world, PlayerEntity owner) {
        this(GrapplingHookMod.GRAPPLE_ENTITY, world, owner);  // Call the other constructor
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHit = (EntityHitResult) hitResult;
            if (entityHit.getEntity() instanceof PlayerEntity player) {
                player.addVelocity(this.getVelocity().x, this.getVelocity().y, this.getVelocity().z);
                player.velocityModified = true;
            }
        }
        this.remove(RemovalReason.DISCARDED);
    }
}

