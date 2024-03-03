package fr.astralteam.astral.compat;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.recipe.ElectrolyserRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ElectrolyserCategory implements IRecipeCategory<ElectrolyserRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(ASTRAL.MODID, "electrolyser");
    public static final ResourceLocation TEXTURE = new ResourceLocation(ASTRAL.MODID, "textures/jei/gui/electrolyser_gui.png");

    public static final RecipeType<ElectrolyserRecipe> ELECTROLYSER_TYPE = new RecipeType<>(UID, ElectrolyserRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ElectrolyserCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ELECTROLYSER.get()));
    }


    @Override
    public RecipeType<ElectrolyserRecipe> getRecipeType() {
        return ELECTROLYSER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.astral.electrolyser");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ElectrolyserRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 39, 35).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 65, 35).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 121, 18).addItemStack(recipe.getOutput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 121, 52).addItemStack(recipe.getOutput2());
    }
}