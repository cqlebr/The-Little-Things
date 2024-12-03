package project.thelittlethings.world.biome;

import net.minecraft.util.Identifier;
import project.thelittlethings.TheLittleThings;
import project.thelittlethings.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(TheLittleThings.MOD_ID,"oveworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, TheLittleThings.MOD_ID, ModMaterialRules.makeRules());
    }
}
