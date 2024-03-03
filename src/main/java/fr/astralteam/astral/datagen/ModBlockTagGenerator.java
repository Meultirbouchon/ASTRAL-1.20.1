package fr.astralteam.astral.datagen;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ASTRAL.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.TITANIUM_BLOCK.get(),
                        ModBlocks.RAW_TITANIUM_BLOCK.get(),
                        ModBlocks.TITANIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),

                        ModBlocks.RAW_TUNGSTEN_BLOCK.get(),
                        ModBlocks.TUNGSTEN_BLOCK.get(),
                        ModBlocks.TUNGSTEN_ORE.get(),
                        ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),

                        ModBlocks.PLATINIUM_BLOCK.get(),
                        ModBlocks.RAW_PLATINIUM_BLOCK.get(),
                        ModBlocks.PLATINIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_PLATINIUM_ORE.get(),

                        ModBlocks.LUNARIAN_COBBLESTONE.get(),
                        ModBlocks.LUNARIAN_STONE.get(),
                        ModBlocks.LUNARIAN_REGOLITH.get(),
                        ModBlocks.LUNARIAN_TITANIUM_ORE.get(),
                        ModBlocks.LUNARIAN_TUNGSTEN_ORE.get(),
                        ModBlocks.LUNARIAN_HELIUM_ORE.get(),
                        ModBlocks.LUNARIAN_PLATINIUM_ORE.get(),

                        ModBlocks.ELECTROLYSER.get(),

                        ModBlocks.METAL_CUTTER.get(),

                        ModBlocks.REFINERY.get()
                );
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.TITANIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),

                        ModBlocks.TUNGSTEN_ORE.get(),
                        ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),

                        ModBlocks.PLATINIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_PLATINIUM_ORE.get(),

                        ModBlocks.LUNARIAN_TITANIUM_ORE.get(),
                        ModBlocks.LUNARIAN_TUNGSTEN_ORE.get(),
                        ModBlocks.LUNARIAN_PLATINIUM_ORE.get()
                );
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LUNARIAN_HELIUM_ORE.get());
    }
}
