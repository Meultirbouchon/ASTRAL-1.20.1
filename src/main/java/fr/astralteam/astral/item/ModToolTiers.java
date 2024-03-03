package fr.astralteam.astral.item;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier TITANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1800, 7.5f, 2f, 10,
                    ModTags.Blocks.NEEDS_TITANIUM_TOOL, () -> Ingredient.of(ModItems.TITANIUM_INGOT.get())),
            new ResourceLocation(ASTRAL.MODID, "titanium"), List.of(Tiers.DIAMOND), List.of());

    public static final Tier TUNGSTEN = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2200, 9.8f, 3f, 14,
                    ModTags.Blocks.NEEDS_TUNGSTEN_TOOL, () -> Ingredient.of(ModItems.TUNGSTEN_INGOT.get())),
            new ResourceLocation(ASTRAL.MODID, "tungsten"), List.of(Tiers.DIAMOND), List.of());
}
