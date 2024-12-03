package project.thelittlethings.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import project.thelittlethings.TheLittleThings;
import project.thelittlethings.mixin.TrunkPlacerTypeInvoker;
import project.thelittlethings.world.tree.custom.MapleTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> MAPLE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("maple_trunk_placer", MapleTrunkPlacer.CODEC);

    public static void register() {
        TheLittleThings.LOGGER.info("Registering ModTrunkPlacerTypes " + TheLittleThings.MOD_ID);
    }
}
