package com.example.grapplinghook;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GrapplingHookMod {
    public static final EntityType<GrappleEntity> GRAPPLE_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("grapplinghook", "grapple_entity"),
            EntityType.Builder.create(GrappleEntity::new, SpawnGroup.MISC)
                    .setDimensions(0.25F, 0.25F)
                    .build("grapple_entity")
    );

    public static void registerItems() {
        // Register items if needed
    }
}
