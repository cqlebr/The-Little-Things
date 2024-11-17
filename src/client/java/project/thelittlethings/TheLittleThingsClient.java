package project.thelittlethings;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.entity.ModEntities;


public class TheLittleThingsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());

		EntityRendererRegistry.register(ModEntities.SQUIRREL, SquirrelRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SQUIRREL, SquirrelModel::getTexturedModelData);
	}
}