package project.thelittlethings.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import project.thelittlethings.TheLittleThings;
import project.thelittlethings.entity.custom.SquirrelEntity;
import project.thelittlethings.entity.custom.RobinEntity;

public class ModEntities {
    public static final EntityType<SquirrelEntity> SQUIRREL = Registry.register(Registries.ENTITY_TYPE,
          new Identifier(TheLittleThings.MOD_ID, "squirrel"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SquirrelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<RobinEntity> ROBIN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TheLittleThings.MOD_ID, "robin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RobinEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());


}
