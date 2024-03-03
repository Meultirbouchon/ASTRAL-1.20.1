package fr.astralteam.astral.recipe;

import fr.astralteam.astral.ASTRAL;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ASTRAL.MODID);

    public static final RegistryObject<RecipeSerializer<MetalCutterRecipe>> METAL_CUTTER_SERIALIZER = SERIALIZERS.register("metal_cutter", () -> MetalCutterRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<RefineryRecipe>> REFINERY_SERIALIZER = SERIALIZERS.register("refinery", () -> RefineryRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<ElectrolyserRecipe>> ELECTROLYSER_SERIALIZER = SERIALIZERS.register("electrolyser", () -> ElectrolyserRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
