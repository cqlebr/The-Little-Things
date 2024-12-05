package project.thelittlethings.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent MAPLE_CREME_BRULEE = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build();
    public static final FoodComponent PANCAKES = new FoodComponent.Builder().hunger(7).saturationModifier(0.3f).build();
    public static final FoodComponent MAPLE_SYRUP_BOTTLE = new FoodComponent.Builder().hunger(1).saturationModifier(0).build();
}
