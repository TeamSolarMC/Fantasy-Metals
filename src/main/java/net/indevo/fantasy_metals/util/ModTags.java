package net.indevo.fantasy_metals.util;

import net.indevo.fantasy_metals.FantasyMetals;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> STORAGE_BLOCKS = forgeTag("storage_blocks");
        public static final TagKey<Block> ORES = forgeTag("ores");

        public static final TagKey<Block> NEEDS_MYTHRIL_TOOL = tag("needs_mythril_tool");
        public static final TagKey<Block> NEEDS_ADAMANT_TOOL = tag("needs_adamant_tool");
        public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = tag("needs_orichalcum_tool");
        public static final TagKey<Block> NEEDS_CARMOT_TOOL = tag("needs_carmot_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FantasyMetals.MOD_ID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> INGOTS = forgeTag("ingots");
        public static final TagKey<Item> NUGGETS = forgeTag("nuggets");
        public static final TagKey<Item> RAW_MATERIALS = forgeTag("raw_materials");
        public static final TagKey<Item> GEMS = forgeTag("gems");
        public static final TagKey<Item> SWORDS = forgeTag("swords");
        public static final TagKey<Item> PICKAXES = forgeTag("pickaxes");
        public static final TagKey<Item> AXES = forgeTag("axes");
        public static final TagKey<Item> SHOVELS = forgeTag("shovels");
        public static final TagKey<Item> HOES = forgeTag("hoes");
        public static final TagKey<Item> HELMETS = forgeTag("helmets");
        public static final TagKey<Item> CHESTPLATES = forgeTag("chestplates");
        public static final TagKey<Item> LEGGINGS = forgeTag("leggings");
        public static final TagKey<Item> BOOTS = forgeTag("boots");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FantasyMetals.MOD_ID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
