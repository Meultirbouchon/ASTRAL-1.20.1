package fr.astralteam.astral.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SPACE_RATION_MEAT = new FoodProperties.Builder().meat().nutrition(9).saturationMod(1.1f).build();
    public static final FoodProperties SPACE_RATION_VEGETABLE = new FoodProperties.Builder().meat().nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties SPACE_RATION_FISH = new FoodProperties.Builder().meat().nutrition(7).saturationMod(0.9f).build();

}
