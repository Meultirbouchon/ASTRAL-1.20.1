package fr.astralteam.astral.util;

import fr.astralteam.astral.ASTRAL;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TITANIUM_TOOL = tag("needs_titanium_tool");

        public static final TagKey<Block> NEEDS_TUNGSTEN_TOOL = tag("needs_tungsten_tool");

    }
    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(ASTRAL.MODID, name));
    }
}
