package project.thelittlethings;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import project.thelittlethings.entity.custom.RobinEntity;

public class RobinRenderer extends MobEntityRenderer<RobinEntity, RobinModel<RobinEntity>> {

    public static final Identifier TEXTURE = new Identifier(TheLittleThings.MOD_ID, "textures/entity/robin.png");

    public RobinRenderer(EntityRendererFactory.Context context) {
        super(context, new RobinModel<>(context.getPart(ModModelLayers.ROBIN)), 0.2f); // size of shadow
    }

    @Override
    public Identifier getTexture(RobinEntity entity) {
        return TEXTURE;
    }


    @Override
    public void render(RobinEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.4f, 0.4f, 0.4f);// ensure xyz is same all  around
            mobEntity.setMovementSpeed(0.1f);
        }
        else
        {
            matrixStack.scale(0.6f, 0.6f, 0.6f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

