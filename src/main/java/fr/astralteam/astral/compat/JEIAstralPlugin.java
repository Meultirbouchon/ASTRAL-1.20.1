package fr.astralteam.astral.compat;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.recipe.ElectrolyserRecipe;
import fr.astralteam.astral.recipe.MetalCutterRecipe;
import fr.astralteam.astral.recipe.RefineryRecipe;
import fr.astralteam.astral.screen.ElectrolyserScreen;
import fr.astralteam.astral.screen.MetalCutterScreen;
import fr.astralteam.astral.screen.RefineryScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIAstralPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ASTRAL.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MetalCutterCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new RefineryCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ElectrolyserCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<MetalCutterRecipe> metalCutterRecipes = recipeManager.getAllRecipesFor(MetalCutterRecipe.Type.INSTANCE);
        registration.addRecipes(MetalCutterCategory.METAL_CUTTER_TYPE, metalCutterRecipes);

        List<ElectrolyserRecipe> electrolyserRecipes = recipeManager.getAllRecipesFor(ElectrolyserRecipe.Type.INSTANCE);
        registration.addRecipes(ElectrolyserCategory.ELECTROLYSER_TYPE, electrolyserRecipes);

        List<RefineryRecipe> refineryRecipes = recipeManager.getAllRecipesFor(RefineryRecipe.Type.INSTANCE);
        registration.addRecipes(RefineryCategory.REFINERY_TYPE, refineryRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(MetalCutterScreen.class, 67, 23, 41, 44, MetalCutterCategory.METAL_CUTTER_TYPE);
        registration.addRecipeClickArea(ElectrolyserScreen.class, 82, 17, 37, 57, ElectrolyserCategory.ELECTROLYSER_TYPE);
        registration.addRecipeClickArea(RefineryScreen.class, 63, 15, 50, 36, RefineryCategory.REFINERY_TYPE);
    }
}
