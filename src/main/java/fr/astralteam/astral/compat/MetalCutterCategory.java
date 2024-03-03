package fr.astralteam.astral.compat;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.recipe.MetalCutterRecipe;
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

public class MetalCutterCategory implements IRecipeCategory<MetalCutterRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(ASTRAL.MODID, "metal_cutter");
    public static final ResourceLocation TEXTURE = new ResourceLocation(ASTRAL.MODID, "textures/jei/gui/metal_cutter_gui.png");

    public static final RecipeType<MetalCutterRecipe> METAL_CUTTER_TYPE = new RecipeType<>(UID, MetalCutterRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public MetalCutterCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.METAL_CUTTER.get()));
    }


    @Override
    public RecipeType<MetalCutterRecipe> getRecipeType() {
        return METAL_CUTTER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.astral.metal_cutter");
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
    public void setRecipe(IRecipeLayoutBuilder builder, MetalCutterRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 35).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 110, 35).addItemStack(recipe.getResultItem(null));
    }
}
