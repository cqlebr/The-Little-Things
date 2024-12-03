package project.thelittlethings;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import project.thelittlethings.block.ModBlocks;
import project.thelittlethings.entity.ModBoats;

public class TheLittleThingsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBELL, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BLUEBELL, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COLUMBINE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_COLUMBINE, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TROUT_LILY, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_TROUT_LILY, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_SAPLING, RenderLayer.getCutout());

		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.MAPLE_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.MAPLE_HANGING_SIGN_TEXTURE));

		TerraformBoatClientHelper.registerModelLayers(ModBoats.MAPLE_BOAT_ID, false);

	}
}