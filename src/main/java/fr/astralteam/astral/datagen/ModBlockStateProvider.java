package fr.astralteam.astral.datagen;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.block.custom.SapSproutBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ASTRAL.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_TITANIUM_BLOCK);
        blockWithItem(ModBlocks.TITANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TITANIUM_ORE);

        blockWithItem(ModBlocks.RAW_TUNGSTEN_BLOCK);
        blockWithItem(ModBlocks.TUNGSTEN_BLOCK);
        blockWithItem(ModBlocks.TUNGSTEN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);

        blockWithItem(ModBlocks.RAW_PLATINIUM_BLOCK);
        blockWithItem(ModBlocks.PLATINIUM_BLOCK);
        blockWithItem(ModBlocks.PLATINIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PLATINIUM_ORE);

        blockWithItem(ModBlocks.LUNARIAN_COBBLESTONE);
        blockWithItem(ModBlocks.LUNARIAN_STONE);
        blockWithItem(ModBlocks.LUNARIAN_REGOLITH);
        blockWithItem(ModBlocks.LUNARIAN_TITANIUM_ORE);
        blockWithItem(ModBlocks.LUNARIAN_TUNGSTEN_ORE);
        blockWithItem(ModBlocks.LUNARIAN_HELIUM_ORE);
        blockWithItem(ModBlocks.LUNARIAN_PLATINIUM_ORE);

        simpleBlockWithItem(ModBlocks.ELECTROLYSER.get(), new ModelFile.UncheckedModelFile(modLoc("block/electrolyser")));

        simpleBlockWithItem(ModBlocks.METAL_CUTTER.get(), new ModelFile.UncheckedModelFile(modLoc("block/metal_cutter")));

        simpleBlockWithItem(ModBlocks.REFINERY.get(), new ModelFile.UncheckedModelFile(modLoc("block/refinery")));

        makeSproutCrop((CropBlock) ModBlocks.SAP_SPROUT.get(), "sprout_stage", "sprout_stage");
    }

    public void makeSproutCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> sproutStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] sproutStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SapSproutBlock) block).getAgeProperty()),
                new ResourceLocation(ASTRAL.MODID, "block/" + textureName + state.getValue(((SapSproutBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
