package fr.astralteam.astral.compat;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.recipe.RefineryRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class RefineryCategory implements IRecipeCategory<RefineryRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(ASTRAL.MODID, "refinery");
    public static final ResourceLocation TEXTURE = new ResourceLocation(ASTRAL.MODID, "textures/jei/gui/refinery_gui.png");

    public static final RecipeType<RefineryRecipe> REFINERY_TYPE = new RecipeType<>(UID, RefineryRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public RefineryCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.REFINERY.get()));
    }


    @Override
    public RecipeType<RefineryRecipe> getRecipeType() {
        return REFINERY_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.astral.refinery");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RefineryRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 117, 17).addItemStack(recipe.getResultItem(null));
    }
}
