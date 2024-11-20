package com.example.grapplinghook;

import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    Identifier itemID = Identifier.of(FabricDocsReference.MOD_ID, id);

    Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

    return registeredItem;
}
