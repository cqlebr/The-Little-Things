package project.thelittlethings.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import project.thelittlethings.TheLittleThings;
import project.thelittlethings.mixin.FoliagePlacerTypeInvoker;
import project.thelittlethings.world.tree.custom.MapleFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> MAPLE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("maple_foliage_placer", MapleFoliagePlacer.CODEC);

    public static void register() {
        TheLittleThings.LOGGER.info("Registering ModFoliagePlacerTypes " + TheLittleThings.MOD_ID);
    }
}
