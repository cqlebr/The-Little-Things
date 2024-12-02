package project.thelittlethings;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import project.thelittlethings.entity.custom.SquirrelEntity;

public class SquirrelRenderer extends MobEntityRenderer<SquirrelEntity, SquirrelModel<SquirrelEntity>> {

    public static final Identifier TEXTURE = new Identifier(TheLittleThings.MOD_ID, "textures/entity/squirreltexture.png");

    public SquirrelRenderer(EntityRendererFactory.Context context) {
        super(context, new SquirrelModel<>(context.getPart(ModModelLayers.SQUIRREL)), 0.2f); // size of shadow
    }

    @Override
    public Identifier getTexture(SquirrelEntity entity) {
        return TEXTURE;
    }


    @Override
    public void render(SquirrelEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);// ensure xyz is same all  around
            mobEntity.setMovementSpeed(0.1f);
        }
        else
        {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}



