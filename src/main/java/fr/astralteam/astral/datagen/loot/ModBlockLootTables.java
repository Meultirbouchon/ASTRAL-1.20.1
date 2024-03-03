package fr.astralteam.astral.datagen.loot;

import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.block.custom.SapSproutBlock;
import fr.astralteam.astral.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_TITANIUM_BLOCK.get());

        this.dropSelf(ModBlocks.TUNGSTEN_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_TUNGSTEN_BLOCK.get());

        this.dropSelf(ModBlocks.PLATINIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_PLATINIUM_BLOCK.get());

        this.dropSelf(ModBlocks.LUNARIAN_REGOLITH.get());
        this.dropSelf(ModBlocks.LUNARIAN_COBBLESTONE.get());

        this.add(ModBlocks.TITANIUM_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));

        this.add(ModBlocks.TUNGSTEN_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get()));
        this.add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get()));

        this.add(ModBlocks.PLATINIUM_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.PLATINIUM_ORE.get(), ModItems.RAW_PLATINIUM.get()));
        this.add(ModBlocks.DEEPSLATE_PLATINIUM_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.DEEPSLATE_PLATINIUM_ORE.get(), ModItems.RAW_PLATINIUM.get()));

        this.add(ModBlocks.LUNARIAN_STONE.get(),
                block -> createBasicStoneDrop(ModBlocks.LUNARIAN_STONE.get(), ModBlocks.LUNARIAN_COBBLESTONE.get().asItem()));
        this.add(ModBlocks.LUNARIAN_TITANIUM_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.LUNARIAN_TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.LUNARIAN_TUNGSTEN_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.LUNARIAN_TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get()));
        this.add(ModBlocks.LUNARIAN_HELIUM_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.LUNARIAN_HELIUM_ORE.get(), ModItems.RAW_HELIUM.get()));
        this.add(ModBlocks.LUNARIAN_PLATINIUM_ORE.get(),
                block -> createBasicOreDrop(ModBlocks.LUNARIAN_PLATINIUM_ORE.get(), ModItems.RAW_PLATINIUM.get()));

        this.dropSelf(ModBlocks.ELECTROLYSER.get());

        this.dropSelf(ModBlocks.METAL_CUTTER.get());

        this.dropSelf(ModBlocks.REFINERY.get());

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SAP_SPROUT.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SapSproutBlock.AGE, 4));

        this.add(ModBlocks.SAP_SPROUT.get(), createCropDrops(ModBlocks.SAP_SPROUT.get(), ModItems.SAP.get(),
                ModItems.SPROUT_SEEDS.get(), lootitemcondition$builder));

    }

    protected LootTable.Builder createBasicOreDrop(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createBasicStoneDrop(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}