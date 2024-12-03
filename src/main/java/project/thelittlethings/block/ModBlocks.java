package project.thelittlethings.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import project.thelittlethings.TheLittleThings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import project.thelittlethings.world.tree.MapleSaplingGenerator;


public class ModBlocks {
    // MAPLE WOOD BLOCKS
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));
    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
    public static final Block MAPLE_LEAVES_RED = registerBlock("maple_leaves_red",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque()));
    public static final Block MAPLE_LEAVES_YELLOW = registerBlock("maple_leaves_yellow",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque()));
    public static final Block MAPLE_LEAVES_ORANGE = registerBlock("maple_leaves_orange",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque()));
    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            new StairsBlock(ModBlocks.MAPLE_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.CHERRY_STAIRS)));
    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_SLAB)));
    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_BUTTON), BlockSetType.CHERRY, 15, true));
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,FabricBlockSettings.copyOf(Blocks.CHERRY_SLAB),
                    BlockSetType.CHERRY));
    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE)));
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE_GATE), WoodType.CHERRY));
    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_DOOR), BlockSetType.CHERRY));
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_TRAPDOOR), BlockSetType.CHERRY));
    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            new SaplingBlock(new MapleSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.CHERRY_SAPLING)));
    //SIGN AND BOAT WITH TERRAFORM API
    public static final Identifier MAPLE_SIGN_TEXTURE = new Identifier(TheLittleThings.MOD_ID, "entity/signs/maple");
    public static final Identifier MAPLE_HANGING_SIGN_TEXTURE = new Identifier(TheLittleThings.MOD_ID, "entity/signs/hanging/maple");
    public static final Identifier MAPLE_HANGING_GUI_SIGN_TEXTURE = new Identifier(TheLittleThings.MOD_ID, "textures/gui/hanging_signs/maple");

   public static final Block STANDING_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID,"maple_standing_sign"),
            new TerraformSignBlock(MAPLE_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.CHERRY_SIGN)));
    public static final Block WALL_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID,"maple_wall_sign"),
            new TerraformWallSignBlock(MAPLE_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.CHERRY_WALL_SIGN)));
    public static final Block HANGING_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID,"maple_hanging_sign"),
            new TerraformHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE,MAPLE_HANGING_GUI_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.CHERRY_HANGING_SIGN)));
    public static final Block WALL_HANGING_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID,"maple_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE, MAPLE_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.CHERRY_WALL_HANGING_SIGN)));

    public static final BlockFamily MAPLE_FAMILY = BlockFamilies.register(ModBlocks.MAPLE_PLANKS)
            .sign(ModBlocks.STANDING_MAPLE_SIGN, ModBlocks.WALL_MAPLE_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    //ADDITIONAL FOREST ITEMS
    public static final Block BLUEBELL = registerBlock("bluebell",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 10,
                    FabricBlockSettings.copyOf(Blocks.AZURE_BLUET).nonOpaque().noCollision()));
    public static final Block POTTED_BLUEBELL = Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID,"potted_bluebell"),
            new FlowerPotBlock(BLUEBELL,FabricBlockSettings.copyOf(Blocks.POTTED_AZURE_BLUET).nonOpaque()));
    public static final Block COLUMBINE = registerBlock("columbine",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 10,
                    FabricBlockSettings.copyOf(Blocks.AZURE_BLUET).nonOpaque().noCollision()));
    public static final Block POTTED_COLUMBINE = Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID,"potted_columbine"),
            new FlowerPotBlock(COLUMBINE,FabricBlockSettings.copyOf(Blocks.POTTED_AZURE_BLUET).nonOpaque()));
    public static final Block TROUT_LILY = registerBlock("trout_lily",
            new FlowerBlock(StatusEffects.ABSORPTION, 10,
                    FabricBlockSettings.copyOf(Blocks.AZURE_BLUET).nonOpaque().noCollision()));
    public static final Block POTTED_TROUT_LILY = Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID,"potted_trout_lily"),
            new FlowerPotBlock(TROUT_LILY,FabricBlockSettings.copyOf(Blocks.POTTED_AZURE_BLUET).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TheLittleThings.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TheLittleThings.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }

    public static void registerModBlocks() {
        TheLittleThings.LOGGER.info("Registering Mod Blocks " + TheLittleThings.MOD_ID);
    }
}
