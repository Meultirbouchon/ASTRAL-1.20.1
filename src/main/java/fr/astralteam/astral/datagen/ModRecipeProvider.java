package fr.astralteam.astral.datagen;

import com.google.common.collect.ImmutableList;
import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> TITANIUM_SMELTABLES = List.of(ModItems.RAW_TITANIUM.get(),
            ModBlocks.TITANIUM_ORE.get(),
            ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),
            ModBlocks.LUNARIAN_TITANIUM_ORE.get());

    public static final List<ItemLike> TUNGSTEN_SMELTABLES = List.of(ModItems.RAW_TUNGSTEN.get(),
            ModBlocks.TUNGSTEN_ORE.get(),
            ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
            ModBlocks.LUNARIAN_TUNGSTEN_ORE.get());

    public static final List<ItemLike> PLATINIUM_SMELTABLES = List.of(ModItems.RAW_PLATINIUM.get(),
            ModBlocks.PLATINIUM_ORE.get(),
            ModBlocks.DEEPSLATE_PLATINIUM_ORE.get(),
            ModBlocks.LUNARIAN_PLATINIUM_ORE.get());

    public static final List<ItemLike> LUNARIAN_COBBLESTONE = List.of(ModBlocks.LUNARIAN_COBBLESTONE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.7f, 200, "titanium");
        oreBlasting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.7f, 100, "titanium");

        oreSmelting(pWriter, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 0.7f, 200, "tungsten");
        oreBlasting(pWriter, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 0.7f, 100, "tungsten");

        oreSmelting(pWriter, PLATINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINIUM_INGOT.get(), 0.7f, 200, "platinium");
        oreBlasting(pWriter, PLATINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINIUM_INGOT.get(), 0.7f, 100, "platinium");

        oreSmelting(pWriter, LUNARIAN_COBBLESTONE, RecipeCategory.MISC, ModBlocks.LUNARIAN_STONE.get(), 0.25f, 100, "lunarian_stone");

        // TITANIUM
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TITANIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_TITANIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_TITANIUM.get()), has(ModItems.RAW_TITANIUM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TITANIUM.get(), 9)
                .requires(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_TITANIUM_BLOCK.get()), has(ModBlocks.RAW_TITANIUM_BLOCK.get()))
                .save(pWriter);

        // TUNGSTEN
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TUNGSTEN_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT.get()), has(ModItems.TUNGSTEN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TUNGSTEN_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_TUNGSTEN.get())
                .unlockedBy(getHasName(ModItems.RAW_TUNGSTEN.get()), has(ModItems.RAW_TUNGSTEN.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 9)
                .requires(ModBlocks.TUNGSTEN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TUNGSTEN_BLOCK.get()), has(ModBlocks.TUNGSTEN_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TUNGSTEN.get(), 9)
                .requires(ModBlocks.RAW_TUNGSTEN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_TUNGSTEN_BLOCK.get()), has(ModBlocks.RAW_TUNGSTEN_BLOCK.get()))
                .save(pWriter);

        // PLATINIUM
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLATINIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_PLATINIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_PLATINIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_PLATINIUM.get()), has(ModItems.RAW_PLATINIUM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINIUM_INGOT.get(), 9)
                .requires(ModBlocks.PLATINIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PLATINIUM_BLOCK.get()), has(ModBlocks.PLATINIUM_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_PLATINIUM.get(), 9)
                .requires(ModBlocks.RAW_PLATINIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_PLATINIUM_BLOCK.get()), has(ModBlocks.RAW_PLATINIUM_BLOCK.get()))
                .save(pWriter);

        // TITANIUM -> ARMOR
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_BOOTS.get())
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        // TUNGSTEN -> ARMOR
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TUNGSTEN_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT.get()), has(ModItems.TUNGSTEN_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TUNGSTEN_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT.get()), has(ModItems.TUNGSTEN_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TUNGSTEN_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT.get()), has(ModItems.TUNGSTEN_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TUNGSTEN_BOOTS.get())
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT.get()), has(ModItems.TUNGSTEN_INGOT.get()))
                .save(pWriter);

        // CANISTER
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CANISTER.get(), 4)
                .pattern(" # ")
                .pattern("# #")
                .pattern("###")
                .define('#', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(pWriter);

        // FOOD
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SPACE_RATION_FISH.get(), 1)
                .requires(ModItems.CAN.get())
                .requires(Ingredient.of(ItemTags.FISHES))
                .unlockedBy(getHasName(ModItems.CAN.get()), has(ModItems.CAN.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SPACE_RATION_VEGETABLE.get(), 1)
                .requires(ModItems.CAN.get())
                .requires(Ingredient.of(Items.CARROT, Items.POTATO, Items.BEETROOT,Items.BAKED_POTATO))
                .unlockedBy(getHasName(ModItems.CAN.get()), has(ModItems.CAN.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SPACE_RATION_MEAT.get(), 1)
                .requires(ModItems.CAN.get())
                .requires(Ingredient.of(Items.COOKED_BEEF, Items.COOKED_PORKCHOP, Items.COOKED_MUTTON, Items.COOKED_CHICKEN, Items.COOKED_RABBIT))
                .unlockedBy(getHasName(ModItems.CAN.get()), has(ModItems.CAN.get()))
                .save(pWriter);

        // COKE
        oreBlasting(pWriter, ImmutableList.of(Items.COAL), RecipeCategory.MISC, ModItems.COKE.get(), 0.25f, 200, "coke");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COKE_ROD.get())
                .pattern("  S")
                .pattern(" S ")
                .pattern("S  ")
                .define('S', ModItems.COKE_ROD_SCRAP.get())
                .unlockedBy(getHasName(ModItems.COKE_ROD_SCRAP.get()), has(ModItems.COKE_ROD_SCRAP.get()))
                .save(pWriter);
        // TANK
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TANK.get(), 1)
                .pattern("   ")
                .pattern("NN ")
                .pattern("BB ")
                .define('N', Items.IRON_NUGGET)
                .define('B', Items.BUCKET)
                .unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET))
                .save(pWriter);
        // PLATINIUM ROD
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINIUM_ROD.get(), 1)
                .requires(ModItems.COKE_ROD.get())
                .requires(ModItems.PLATINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINIUM_INGOT.get()), has(ModItems.PLATINIUM_INGOT.get()))
                .save(pWriter);
        // ELECTROLYSER
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ELECTROLYSER.get(), 1)
                .pattern("PBP")
                .pattern("TFT")
                .pattern("III")
                .define('P', ModItems.PLATINIUM_ROD.get())
                .define('B', Items.BUCKET)
                .define('T', ModItems.TANK.get())
                .define('F', Items.BLAST_FURNACE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.PLATINIUM_ROD.get()), has(ModItems.PLATINIUM_ROD.get()))
                .save(pWriter);
        // METAL CUTTER
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.METAL_CUTTER.get(), 1)
                .pattern("ISI")
                .pattern("IBI")
                .pattern("RRR")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STONE_PRESSURE_PLATE)
                .define('B', Items.IRON_BLOCK)
                .define('R', Items.STONE)
                .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                .save(pWriter);

        // CIRCUIT BOARD + CRAFTING ITEM NEEDED
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONNECTOR.get(), 2)
                .pattern(" RR")
                .pattern(" GR")
                .pattern("   ")
                .define('G', Items.GOLD_NUGGET)
                .define('R', ModItems.RESIN.get())
                .unlockedBy(getHasName(ModItems.RESIN.get()), has(ModItems.RESIN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CIRCUIT_BOARD.get(), 1)
                .pattern("CRC")
                .pattern("RGR")
                .pattern("CRC")
                .define('C', ModItems.CONNECTOR.get())
                .define('R', ModItems.RESIN.get())
                .define('G', ModItems.GLASS_FIBER.get())
                .unlockedBy(getHasName(ModItems.RESIN.get()), has(ModItems.RESIN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSISTOR.get(), 3)
                .pattern("RRR")
                .pattern("N N")
                .pattern("WWW")
                .define('N', Items.IRON_NUGGET)
                .define('R', ModItems.RESIN.get())
                .define('W', ModItems.IRON_WIRE.get())
                .unlockedBy(getHasName(ModItems.RESIN.get()), has(ModItems.RESIN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CAPACITOR.get(), 3)
                .pattern("NNN")
                .pattern("RNR")
                .pattern("W W")
                .define('N', Items.IRON_NUGGET)
                .define('R', ModItems.RESIN.get())
                .define('W', ModItems.IRON_WIRE.get())
                .unlockedBy(getHasName(ModItems.RESIN.get()), has(ModItems.RESIN.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEN_K_RESISTOR.get(), 2)
                .pattern(" R ")
                .pattern("WWW")
                .pattern(" R ")
                .define('R', ModItems.RESIN.get())
                .define('W', ModItems.IRON_WIRE.get())
                .unlockedBy(getHasName(ModItems.RESIN.get()), has(ModItems.RESIN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ONE_K_RESISTOR.get(), 2)
                .pattern(" T ")
                .pattern("WRW")
                .pattern(" T ")
                .define('R', ModItems.RESIN.get())
                .define('T', ModItems.TEN_K_RESISTOR.get())
                .define('W', ModItems.IRON_WIRE.get())
                .unlockedBy(getHasName(ModItems.RESIN.get()), has(ModItems.RESIN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HUNDRED_RESISTOR.get(), 2)
                .pattern(" O ")
                .pattern("WRW")
                .pattern(" O ")
                .define('R', ModItems.RESIN.get())
                .define('O', ModItems.ONE_K_RESISTOR.get())
                .define('W', ModItems.IRON_WIRE.get())
                .unlockedBy(getHasName(ModItems.RESIN.get()), has(ModItems.RESIN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BASIC_CIRCUIT_BOARD.get(), 1)
                .pattern("   ")
                .pattern("CBW")
                .pattern("TRG")
                .define('C', ModItems.CAPACITOR.get())
                .define('B', ModItems.CIRCUIT_BOARD.get())
                .define('W', ModItems.IRON_WIRE.get())
                .define('T', ModItems.TRANSISTOR.get())
                .define('R', ModItems.TEN_K_RESISTOR.get())
                .define('G', Items.GREEN_DYE)
                .unlockedBy(getHasName(ModItems.CIRCUIT_BOARD.get()), has(ModItems.CIRCUIT_BOARD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RED_CIRCUIT_BOARD.get(), 1)
                .pattern("CBW")
                .pattern("RTW")
                .pattern("RDW")
                .define('C', ModItems.CAPACITOR.get())
                .define('B', ModItems.BASIC_CIRCUIT_BOARD.get())
                .define('W', ModItems.IRON_WIRE.get())
                .define('T', ModItems.TRANSISTOR.get())
                .define('R', ModItems.ONE_K_RESISTOR.get())
                .define('D', Items.RED_DYE)
                .unlockedBy(getHasName(ModItems.CIRCUIT_BOARD.get()), has(ModItems.CIRCUIT_BOARD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADVANCED_CIRCUIT_BOARD.get(), 1)
                .pattern("CTC")
                .pattern("WRW")
                .pattern("HBH")
                .define('C', ModItems.CAPACITOR.get())
                .define('W', ModItems.COPPER_WIRE.get())
                .define('T', ModItems.TRANSISTOR.get())
                .define('R', ModItems.RED_CIRCUIT_BOARD.get())
                .define('H', ModItems.HUNDRED_RESISTOR.get())
                .define('B', Items.BLUE_DYE)
                .unlockedBy(getHasName(ModItems.CIRCUIT_BOARD.get()), has(ModItems.CIRCUIT_BOARD.get()))
                .save(pWriter);


        // PLIERS + LINKED CRAFT
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_WIRE.get(), 2)
                .requires(Items.COPPER_INGOT)
                .requires(ModItems.PLIERS.get())
                .unlockedBy(getHasName(ModItems.PLIERS.get()), has(ModItems.PLIERS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IRON_WIRE.get(), 2)
                .requires(Items.IRON_INGOT)
                .requires(ModItems.PLIERS.get())
                .unlockedBy(getHasName(ModItems.PLIERS.get()), has(ModItems.PLIERS.get()))
                .save(pWriter);

        // SPROUT SEEDS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SPROUT_SEEDS.get(), 6)
                .requires(Ingredient.of(ItemTags.SAPLINGS))
                .unlockedBy(getHasName(Items.OAK_SAPLING), has(Items.OAK_SAPLING))
                .save(pWriter);

        // REFINERY
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.REFINERY.get())
                .pattern("CCC")
                .pattern("TBT")
                .pattern("III")
                .define('C', ModItems.COPPER_PIPE.get())
                .define('T', ModItems.TANK.get())
                .define('B', Items.BLAST_FURNACE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, ASTRAL.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
