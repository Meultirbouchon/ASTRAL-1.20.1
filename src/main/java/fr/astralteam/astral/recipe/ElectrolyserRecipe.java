package fr.astralteam.astral.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.astralteam.astral.ASTRAL;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ElectrolyserRecipe implements Recipe<SimpleContainer> {

    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ItemStack output2;
    private final ItemStack output3;
    private final ResourceLocation id;

    public ElectrolyserRecipe(NonNullList<Ingredient> inputItems, ItemStack output, ItemStack output2, ItemStack output3, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.output2 = output2;
        this.output3 = output3;
        this.id = id;
    }

    public ItemStack getOutput() {
        return output;
    }

    public ItemStack getOutput2() {
        return output2;
    }
    public ItemStack getOutput3() {
        return output3;
    }


    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0)) && inputItems.get(1).test(pContainer.getItem(1));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ElectrolyserRecipe> {
        public static final Type INSTANCE =  new Type();
        public static final String ID = "electrolyser";
    }

    public static class Serializer implements RecipeSerializer<ElectrolyserRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(ASTRAL.MODID, "electrolyser");

        @Override
        public ElectrolyserRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
            ItemStack result2 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result2"));
            ItemStack result3 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result3"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ElectrolyserRecipe(inputs, result, result2, result3, pRecipeId);
        }

        @Override
        public @Nullable ElectrolyserRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack result = pBuffer.readItem();
            ItemStack result2 = pBuffer.readItem();
            ItemStack result3 = pBuffer.readItem();
            return new ElectrolyserRecipe(inputs, result, result2, result3, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ElectrolyserRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.inputItems.size());

            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeItemStack(pRecipe.output, false);
            pBuffer.writeItemStack(pRecipe.output2, false);
        }
    }
}
